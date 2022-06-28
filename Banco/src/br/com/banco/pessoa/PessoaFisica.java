package br.com.banco.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private static final String REGEXNOMEPESSOA = "[A-ZÀ-Ú][a-zà-ú]*";
    private static final String REGEXCPF = "\\d{11}";

    // Construtores
    public PessoaFisica(String nome, String cpf) {
        if(ehNomeCorreto(nome)) {
            super.nome = nome;
        }

        if(ehCpfInvalido(cpf)) {
            this.cpf = cpf;
        }
    }

    // ******************************************** Verificações
    private static boolean ehNomeCorreto(String nome) {
        return !(Pessoa.ehNomeVazio(nome) || ehUmNomeInvalido(nome));
    }

    // Não uso this, uso parâmetros... Por isso posso colocar static?
    private static boolean ehCpfCorreto(String cpf) {
        return !(ehCpfInvalido(cpf));
    }

    private static boolean ehUmNomeInvalido(String nome) {
        if(!nome.matches(PessoaFisica.REGEXNOMEPESSOA)) {
            System.err.println("Digite um primeiro nome válido.");
            return true;
        }

        return false;
    }

    private static boolean ehCpfInvalido(String cpf) {
        if(cpf == null || cpf.length() != 11) {
            System.err.println("Digite um CPF com 11 números.");
            return true;
            // indica que é inválido, que o retorno é true.
        }

        if(Pessoa.ehStringVazia(cpf)) {
            System.err.println("CPF vazio, digite algo.");
            return true;
        }

        if(!cpf.matches(PessoaFisica.REGEXCPF)) {
            System.err.println("CPF só pode conter números, não digite outra coisa.");
            return true;
        }

        return false;
    }


    // ******************************************** Getters e Setters
    public void setCpf(String cpf) {
        if(ehCpfCorreto(cpf)) {
            this.cpf = cpf;
        }
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void setNome(String nome) {
        // supostas verificações nome de pessoas físicas.
        if(ehNomeCorreto(nome)) {
            super.nome = nome;
        }
    }

    @Override
    public String getNome() {
        return super.nome;
    }

    // ******************************************** Métodos classe Object
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + super.nome + '\'' +
                '}';
    }

}