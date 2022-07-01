package br.com.banco.testes;

import br.com.banco.conta.Conta;
import br.com.banco.conta.ContaCorrente;
import br.com.banco.conta.ContaPoupanca;
import br.com.banco.pessoa.Pessoa;
import br.com.banco.pessoa.PessoaFisica;
import br.com.banco.pessoa.PessoaJuridica;

import java.math.BigDecimal;

public class Falhas {

    public static void criarPessoaFisicaComNomesIncorretos() {
        // Só aceita um único nome... Não aceita nomes compostos.
        Pessoa p1 = new PessoaFisica("arthur", "10010010010");
        Pessoa p2 = new PessoaFisica("PieTro", "10010010011");
        Pessoa p3 = new PessoaFisica("Marcos2", "10010010012");
        Pessoa z1 = new PessoaFisica("Pedro Paulo", "10010010012");
        Pessoa z4 = new PessoaFisica("", "10010010012");
        Pessoa z5 = new PessoaFisica(null, "10010010012");
    }

    public static void criarPessoaFisicaComCpfIncorreto() {
        // cpf com falha:
        // Não aceita letras, sinais, menos ou mais de 11 números.
        Pessoa p4 = new PessoaFisica("Pedro", "asb111111111");
        Pessoa p5 = new PessoaFisica("Marcos", "111");
        Pessoa p6 = new PessoaFisica("Lucas", "111111111111111111"); // mais de 11 dígitos
        Pessoa z2 = new PessoaFisica("Pedro", "");
        Pessoa z3 = new PessoaFisica("Pedro", null);
    }

    public static void criarPessoaJuridicaComNomeIncorreto() {
        Pessoa d1 = new PessoaJuridica("", "11133311133311");
        Pessoa d2 = new PessoaJuridica(null, "11133311133311");
        Pessoa d3 = new PessoaJuridica("90932190Banco", "11133311133311");
        Pessoa d4 = new PessoaJuridica("#!@Cacau", "11133311133311");
        Pessoa d5 = new PessoaJuridica("CocaaZsa123Cola", "11133311133311");
    }

    public static void criarPessoaJuridicaComCnpjIncorreto() {
        Pessoa d1 = new PessoaJuridica("Itaú", "");
        Pessoa d2 = new PessoaJuridica("Itaú", null);
        Pessoa d3 = new PessoaJuridica("Itaú", "asb12321321321");
        Pessoa d4 = new PessoaJuridica("Itaú", "123");
        Pessoa d5 = new PessoaJuridica("Itaú", "1231231232131232131321321321312");
    }

    public static void pjCriarContaPoupanca() {
        Pessoa empresa = new PessoaJuridica("Itaú", "33333333333344");
        Conta cp = new ContaPoupanca(empresa, 3000, 331_000);
    }

    public static void depositarComFalhar() {
        Pessoa pedro = new PessoaFisica("Pedro", "10010010011");
        Conta cc = new ContaCorrente(pedro, 3000, 130_000);

        cc.depositar(BigDecimal.ZERO);
        cc.depositar(BigDecimal.valueOf(-30));
        cc.depositar(BigDecimal.valueOf(-300));
    }

    public static void sacarComFalha() {
        Pessoa pedro = new PessoaFisica("Pedro", "10010010011");
        Conta cp = new ContaPoupanca(pedro, 3000, 330_000);

        cp.depositar(BigDecimal.valueOf(300.50));

        cp.sacar(BigDecimal.valueOf(400));
        cp.sacar(BigDecimal.valueOf(300.51));
        cp.sacar(null); // Acontece nada, mas também não termina o programa.
    }


    static void transferirComFalha() {

    }


}
