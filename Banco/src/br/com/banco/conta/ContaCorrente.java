package br.com.banco.conta;

import br.com.banco.pessoa.Pessoa;

public class ContaCorrente extends Conta {
    public final static String TIPODECONTA = "Conta Corrente";
    private static int totalDeContasCorrentes = 0;

    public ContaCorrente(Pessoa pessoa, int agencia, int numeroConta) {
        super(pessoa, agencia);

        if (ehNumeroContaValidoParaTipoConta(numeroConta)) {
            // Não quero que diferentes contas tenham mesmo número.
            super.numeroConta = numeroConta;
        }

        totalDeContasCorrentes++;
    }

    public static int getTotalDeContasCorrentes() {
        return totalDeContasCorrentes;
    }

    @Override
    protected boolean ehNumeroContaValidoParaTipoConta(int numeroConta) {
        if (numeroConta < 100_000 || numeroConta > 200_000) {
            System.err.println("Contas Poupanças vão de 100.000 a 200.000");
            return false;
        }

        return true;
    }

}
