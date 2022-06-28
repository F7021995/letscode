import br.com.banco.conta.Conta;
import br.com.banco.conta.ContaPoupanca;
import br.com.banco.pessoa.PessoaFisica;

import static br.com.banco.testes.Falhas.*;
import static br.com.banco.testes.Corretos.*;

import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        // Não vou usar excepions, não quero que o programe termine.
        // Vou usar return; e system.err

        resumoDasFalhas();
        resumoDosSucessos();
    }

    static void resumoDasFalhas() {
        depositarComFalhar();
        sacarComFalha();
        pjCriarContaPoupanca();
        criarPessoaFisicaComNomesIncorretos();
        criarPessoaFisicaComCpfIncorreto();
        criarPessoaJuridicaComCnpjIncorreto();
        criarPessoaJuridicaComNomeIncorreto();
    }

    static void resumoDosSucessos() {
        depositarComSucesso();
        sacarComSucesso();

        investimentoPessoaFisica();
        investimentoPessoaJuridica();
    }

}