package br.com.banco.conta;

import br.com.banco.pessoa.Pessoa;
import br.com.banco.pessoa.PessoaJuridica;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Conta implements OperacoesComunsContas {

    protected Pessoa pessoa;
    private int agencia;
    protected BigDecimal saldo;
    protected int numeroConta;
    private static int totalDeContas = 0;

    public Conta(Pessoa pessoa, int agencia) {
        // Fiz invertido essa porra... Era pra ser !Conta.ehNumeroAgenciaValido() return;
        if(Conta.ehNumeroAgenciaValido(agencia)) {
            this.agencia = agencia;
        }

        if(Conta.ehUmObjetoPessoaValido(pessoa)) {
            this.pessoa = pessoa;
        }

        this.saldo = BigDecimal.ZERO;

        totalDeContas++;
    }

    // ******************************************** Funcionalidades da Classe:
    @Override
    public void sacar(BigDecimal valorSaque) {
        if (valorSaque == null) {
            return;
        }

        // Não vai permitir: 100.1212321; vai arredondar para 100.12
        valorSaque = valorSaque.setScale(2, RoundingMode.HALF_UP);

        if (naoTemSaldoSuficiente(valorSaque)) {
            return;
        }

        if (this.pessoa instanceof PessoaJuridica) {
            subtrairDinheiroComTaxasPessoasJuridicas(valorSaque);
        }
        else {
            subtrairDinheiroPessoasFisicas(valorSaque);
        }
    }

    @Override
    public void transferir(Conta destino, BigDecimal valorTransferencia) {
        // sacar e transferir tem taxa extra para pessoa jurídica.
        if (destino == null || valorTransferencia == null) {
            return;
        }
        if (naoTemSaldoSuficiente(valorTransferencia)) {
            return;
        }

        if (estaTransferindoParaSiProprio(destino)) {
            return;
        }

        /*
         * Pensei em fazer um limite de transferência, mas desisti.
         * Teria que pensar em valores máximos para cada tipo de pessoa.
         * Teria que pensar quem transfere e quem recebe.
         */
        if (this.pessoa instanceof PessoaJuridica) {
            destino.depositar(valorTransferencia);
            subtrairDinheiroComTaxasPessoasJuridicas(valorTransferencia);
        }
        else {
            destino.depositar(valorTransferencia);
            subtrairDinheiroPessoasFisicas(valorTransferencia);
        }
    }
    @Override
    public void depositar(BigDecimal valorDeposito) {
        if (valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
            // Não posso depositar 0 nem algo negativo.
            // Compara primeiroValor com ZERO se for <= 0 é erro.
            System.err.println("Não pode depositar valores negativos nem ZERO");
            return;
        }

        this.saldo = this.saldo.add(valorDeposito);
        this.saldo = this.saldo.setScale(2, RoundingMode.HALF_UP);
    }

    // ******************************************** Métodos verificadores:

    protected abstract boolean ehNumeroContaValidoParaTipoConta(int numeroConta);

    private static boolean ehNumeroAgenciaValido(int agencia) {
        if (agencia < 1000 || agencia > 10000) {
            System.err.println("Código inválido de agência (1000 até 10000).");
            return false;
        }

        return true;
    }

    private static boolean ehUmObjetoPessoaValido(Pessoa pessoa) {
        if (pessoa == null) {
            System.err.println("Objeto pessoa não é válido.");
            return false;
        }

        return true;
    }

    private boolean estaTransferindoParaSiProprio(Conta conta) {
        if (this.equals(conta)) {
            System.err.println("Não é possível transferir para si próprio");
            return true;
        }
        return false;
    }

    private void subtrairDinheiroComTaxasPessoasJuridicas(BigDecimal valorMovimentacao) {
        BigDecimal taxaDasPJ = new BigDecimal("1.05");
        this.saldo = this.saldo.subtract(valorMovimentacao.multiply(taxaDasPJ));
        this.saldo = this.saldo.setScale(2, RoundingMode.HALF_UP);
    }

    private void subtrairDinheiroPessoasFisicas(BigDecimal valorMovimentacao) {
        this.saldo = this.saldo.subtract(valorMovimentacao);
        this.saldo = this.saldo.setScale(2, RoundingMode.HALF_UP);
    }

    private boolean naoTemSaldoSuficiente(BigDecimal valorMovimentar) {
        if (valorMovimentar.compareTo(this.saldo) <= 0) {
            return false;
        }

        System.err.println("Saldo insuficiente.");
        return true;
    }    

    // ******************************************** Getters and Setters:
    public BigDecimal consultarSaldo() {
        return this.saldo;
    }

    public void setAgencia(int agencia) {
        if(Conta.ehNumeroAgenciaValido(agencia)) {
            this.agencia = agencia;
        }
    }

    public static int getTotalDeContas() {
        return totalDeContas;
    }

    // ******************************************** Métodos da Classe Object:

    /**
     *  Usado para não permitir transferir para si próprio.
     */
    @Override
    public boolean equals(Object o) {
        // Se eu quiser ter um conjunto de contas (fazer a ideia de contas únicas ou chave primária)
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta = (Conta) o;

        return numeroConta == conta.numeroConta &&
                agencia == conta.agencia &&
                saldo.equals(conta.saldo) &&
                pessoa.equals(conta.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, saldo, pessoa);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", saldo=" + saldo +
                ", pessoa=" + pessoa +
                '}';
    }
}
