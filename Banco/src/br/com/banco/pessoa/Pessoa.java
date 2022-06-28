package br.com.banco.pessoa;

/**
 *  Abstract não tem instância, logo são métodos static.
 *  Precisa ser public para ser instanciada nos outros pacotes.
 */
public abstract class Pessoa {

    protected String nome;

    /**
     *  Não permitir inserção de nomes vazios.
     *  PF e PJ tem nome.
     */
    protected static boolean ehNomeVazio(String nome) {
        // Vou usar esse método no setNome das classes filhas.
        if(ehStringVazia(nome)) {
            System.err.println("Nome não pode estar vazio. Informe um nome válido.");
            return true;
        }

        return ehStringVazia(nome);
    }

    /**
     *  Tô reusando esse método para mudar as mensagens.
     *  Nome vazio: dá mensagem de erro sobre nome.
     *  Cnpj vazio: dá mensagem de erro sobre cnpj.
     */
    protected static boolean ehStringVazia(String valor) {
        // Tô reusando essa ideia no PessoaJurídica.
        if(valor == null) {
            return true;
        }

        // Se for vazia = true, se não for = false
        return valor.isBlank();
    }

    abstract String getNome();

    abstract void setNome(String nome);

}
