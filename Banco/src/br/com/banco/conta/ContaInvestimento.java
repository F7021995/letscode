package br.com.banco.conta;

import br.com.banco.pessoa.Pessoa;
import br.com.banco.pessoa.PessoaJuridica;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta implements OperacoesContaInvestidor {
    // Pode ser público... é final
    public final static String TIPODECONTA = "Conta Investimento";
    private static final BigDecimal PORCENTAGEM_PESSOAS = BigDecimal.valueOf(1.02);
    private static final BigDecimal PORCENTAGEM_EMPRESAS = PORCENTAGEM_PESSOAS.add(BigDecimal.valueOf(0.02));
    private static int totalDeContasInvestimentos = 0;
    private BigDecimal saldoInvestido;

    public ContaInvestimento(Pessoa pessoa, int agencia, int numeroConta) {
        super(pessoa, agencia);

        if (this.ehNumeroContaValidoParaTipoConta(numeroConta)) {
            super.numeroConta = numeroConta;
        }

        this.saldoInvestido = BigDecimal.ZERO;
        totalDeContasInvestimentos++;
    }

    public static int getTotalDeContasInvestimentos() {
        return totalDeContasInvestimentos;
    }

    @Override
    public void investir(BigDecimal valorInvestimento) {
        if (possuirSaldoSuficienteParaInvestir(valorInvestimento)) {
            // investir não é o mesmo que sacar... sacar pessoa jurídica tem taxas.
            if (pessoa instanceof PessoaJuridica) {
                super.saldo = super.saldo.subtract(valorInvestimento);
            } else {
                super.sacar(valorInvestimento);
            }
            this.saldoInvestido = valorInvestimento;
        }
    }

    // Vai resgatar tudo.
    public void resgatarInvestimento() {
        this.resgatarInvestimento(this.saldoInvestido);
    }

    public void resgatarInvestimento(BigDecimal valorResgatar) {
        if (this.saldoInvestido.compareTo(valorResgatar) > 0) {
            System.err.println("Tentando resgatar mais do que possui.");
            return;
        }

        BigDecimal valorQueSeraResgatado = valorResgatar.multiply(ContaInvestimento.PORCENTAGEM_PESSOAS);
        System.out.println("Percentual das pessoas: " + ContaInvestimento.PORCENTAGEM_PESSOAS);
        System.out.println("Percentual das empresas: " + ContaInvestimento.PORCENTAGEM_EMPRESAS);

        if (this.pessoa instanceof PessoaJuridica) {
            valorQueSeraResgatado = valorResgatar.multiply(ContaInvestimento.PORCENTAGEM_EMPRESAS);
        }

        this.saldoInvestido = this.saldoInvestido.subtract(valorResgatar);
        super.depositar(valorQueSeraResgatado);
    }

    private boolean possuirSaldoSuficienteParaInvestir(BigDecimal valorInvestimento) {
        if (super.consultarSaldo().compareTo(valorInvestimento) < 0) {
            // A pessoa pode investir tudo que tem: por isso até < 0
            System.err.println("Não é possível investir mais do que seu saldo.");
            return false;
        }

        return true;
    }

    @Override
    protected boolean ehNumeroContaValidoParaTipoConta(int numeroConta) {
        if (numeroConta < 500_000 || numeroConta > 600_000) {
            System.err.println("Contas de investimentos vão de 500.000 a 600.000");
            return false;
        }

        return true;
    }

    public BigDecimal getSaldoInvestido() {
        return saldoInvestido;
    }
}
