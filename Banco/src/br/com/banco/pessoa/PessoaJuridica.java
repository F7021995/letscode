package br.com.banco.pessoa;

public class PessoaJuridica extends Pessoa {
    private static final String REGEXNOMEFANTASIA = "[A-Z][a-zA-Zà-úÀ-Ú]*(-[A-Z][a-zA-Zà-úÀ-Ú]*)?$";
    private static final String REGEXCNPJ = "\\d{14}";
    private String cnpj;

    // ******************************************** Construtores
    public PessoaJuridica(String nome, String cnpj) {
        // Se forem nulos nem cria o construtor, dá mensagem de erro.
        if (ehNomeCorreto(nome)) {
            this.nome = nome;
        }

        if (ehCnpjCorreto(cnpj)) {
            this.cnpj = cnpj;
        }
    }

    // ******************************************** Verificações:
    private static boolean ehNomeCorreto(String nome) {
        return !(Pessoa.ehNomeVazio(nome) || PessoaJuridica.ehNomeInvalido(nome));
    }

    private static boolean ehCnpjCorreto(String cnpj) {
        return !(ehCnpjVazio(cnpj) || ehCnpjInvalido(cnpj));
    }

    private static boolean ehNomeInvalido(String nome) {
        if (!nome.matches(PessoaJuridica.REGEXNOMEFANTASIA)) {
            System.err.println("Digite um nome fantasia válido");
            return true;
        }

        // isso indica que é válido, eu busco se é inválido.
        return false;
    }

    private static boolean ehCnpjVazio(String cnpj) {
        if (Pessoa.ehStringVazia(cnpj)) {
            System.err.println("CNPJ não pode ser vazio.");
            return true;
        }

        return ehStringVazia(cnpj);
    }

    private static boolean ehCnpjInvalido(String cnpj) {
        if (cnpj.length() != 14) {
            System.err.println("CNPJ possui 14 dígitos. Digite 14 dígitos no CNPJ.");
            return true;
            // indica que é inválido, que é retorno true
        }

        if (Pessoa.ehStringVazia(cnpj)) {
            System.err.println("CNPJ não pode ser vazio.");
            return true;
        }

        if (!cnpj.matches(PessoaJuridica.REGEXCNPJ)) {
            System.err.println("CNPJ só pode conter números.");
            return true;
        }

        // Isso indica que é válido. Eu quero saber se é inválido.
        return false;
    }

    @Override
    public String getNome() {
        return nome;
    }

    // ******************************************** Getters and Setters
    @Override
    public void setNome(String nome) {
        if (PessoaJuridica.ehNomeCorreto(nome)) {
            this.nome = nome;
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if (PessoaJuridica.ehCnpjCorreto((cnpj))) {
            this.cnpj = cnpj;
        }
    }

}