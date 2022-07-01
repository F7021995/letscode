package br.com.banco.conta;

import br.com.banco.pessoa.Pessoa;
import br.com.banco.pessoa.PessoaJuridica;

public class ContaPoupanca extends Conta {
    public final static String TIPODECONTA = "Conta Poupança";
    private static int totalDeContasPoupanca = 0;

    public ContaPoupanca(Pessoa pessoa, int agencia, int numeroConta) {
        super(pessoa, agencia);

        if (pessoa instanceof PessoaJuridica) {
            System.err.println("Pessoa Jurídica não pode ter Conta Poupança.");
            return;
        }

        if (this.ehNumeroContaValidoParaTipoConta(numeroConta)) {
            super.numeroConta = numeroConta;
        }

        totalDeContasPoupanca++;
    }

    public static int getTotalDeContasPoupanca() {
        return totalDeContasPoupanca;
    }

    @Override
    protected boolean ehNumeroContaValidoParaTipoConta(int numeroConta) {
        if (numeroConta < 300_000 || numeroConta > 400_000) {
            System.err.println("Contas Poupanças vão de 300.000 a 400.000");
            return false;
        }

        return true;
    }

}
