package br.com.banco.testes;

import br.com.banco.conta.ContaCorrente;
import br.com.banco.conta.ContaInvestimento;
import br.com.banco.conta.ContaPoupanca;
import br.com.banco.pessoa.Pessoa;
import br.com.banco.pessoa.PessoaFisica;
import br.com.banco.pessoa.PessoaJuridica;

import java.math.BigDecimal;

public class Corretos {
    private static void dadosCorretos() {
        // Dados corretos:
        Pessoa pf1 = new PessoaFisica("Pedro", "11111111111");
        Pessoa pf2 = new PessoaFisica("Sérgio", "22222222222");
        Pessoa pf3 = new PessoaFisica("André", "33333333333");
        Pessoa pf4 = new PessoaFisica("João", "10010010011");

        // Nomes corretos:
        Pessoa pj1 = new PessoaJuridica("Itaú", "30030030030030");
        Pessoa pj2 = new PessoaJuridica("Coca-Cola", "09809809809813");
    }

    public static void depositarComSucesso() {
        System.out.println("**********Depositar com sucesso:");
        Pessoa joao = new PessoaFisica("João", "10010010011");
        ContaCorrente corJoao = new ContaCorrente(joao, 4000, 150000);
        ContaPoupanca pouJoao = new ContaPoupanca(joao, 4000, 350000);
        ContaInvestimento invJoao = new ContaInvestimento(joao, 4000, 550000);

        BigDecimal cem = BigDecimal.valueOf(100.00);
        corJoao.depositar(cem);
        pouJoao.depositar(cem);
        invJoao.depositar(cem);

        System.out.println("cc: " + corJoao.consultarSaldo());
        System.out.println("cp: " + pouJoao.consultarSaldo());
        System.out.println("in: " + invJoao.consultarSaldo());

        corJoao.depositar(BigDecimal.valueOf(33.33));
        pouJoao.depositar(BigDecimal.valueOf(125.50));
        invJoao.depositar(BigDecimal.valueOf(200.00));

        System.out.println("adicionando + 33.33 em cc: " + corJoao.consultarSaldo());
        System.out.println("adicionando + 125.50 em cp: " + pouJoao.consultarSaldo());
        System.out.println("adicionando + 200.00 em in " + invJoao.consultarSaldo());
        System.out.println("--------------------------------------------------------");
    }

    public static void sacarComSucesso() {
        System.out.println("**********Sacar com sucesso");
        Pessoa joao = new PessoaFisica("João", "10010010011");
        ContaCorrente corJoao = new ContaCorrente(joao, 4000, 150000);

        corJoao.depositar(BigDecimal.valueOf(500.35));
        System.out.println("Depositado: " + corJoao.consultarSaldo());

        corJoao.sacar(BigDecimal.valueOf(200.00));
        System.out.println("Saque de 200.00 em 500.35 = " + corJoao.consultarSaldo());

        corJoao.sacar(BigDecimal.valueOf(100.35));
        System.out.println("Saque de 100.35 em 300.35 = " + corJoao.consultarSaldo());

        corJoao.sacar(BigDecimal.valueOf(200.0012321));
        System.out.println("Saque de 200 em 200 = " + corJoao.consultarSaldo());
        System.out.println("--------------------------------------------------------");
    }

    public static void investimentoPessoaFisica() {
        System.out.println("**********Investimento da Pessoa Física");
        Pessoa joao = new PessoaFisica("João", "10010010011");
        ContaInvestimento inJoao = new ContaInvestimento(joao, 4000, 550000);

        System.out.println("Investimento de uma Pessoa Física (renda 2%)");
        inJoao.depositar(BigDecimal.valueOf(600));
        System.out.println("Saldo: "  + inJoao.consultarSaldo());

        inJoao.investir(BigDecimal.valueOf(600));
        System.out.println("Saldo Normal: "  + inJoao.consultarSaldo());
        System.out.println("Saldo Investido: " + inJoao.getSaldoInvestido());

        inJoao.resgatarInvestimento();
        System.out.println("Saldo investido após o resgate: " + inJoao.getSaldoInvestido());
        System.out.println("Saldo após resgate investimeto: " + inJoao.consultarSaldo());
        System.out.println("---------------------------------------------------------------");
    }

    public static void investimentoPessoaJuridica() {
        System.out.println("**********Investimento da Pessoa Jurídica");
        Pessoa joao = new PessoaJuridica("Empresa", "11111111111111");
        ContaInvestimento inJoao = new ContaInvestimento(joao, 4000, 550000);

        System.out.println("Investimento de uma Pessoa Jurídica (renda 4%)");
        inJoao.depositar(BigDecimal.valueOf(600));
        System.out.println("Saldo: "  + inJoao.consultarSaldo());

        inJoao.investir(BigDecimal.valueOf(600));
        System.out.println("Saldo Normal: "  + inJoao.consultarSaldo());
        System.out.println("Saldo Investido: " + inJoao.getSaldoInvestido());

        inJoao.resgatarInvestimento();
        System.out.println("Saldo investido após o resgate: " + inJoao.getSaldoInvestido());
        System.out.println("Saldo após resgate investimeto: " + inJoao.consultarSaldo());
        System.out.println("---------------------------------------------------------------");
    }
}
