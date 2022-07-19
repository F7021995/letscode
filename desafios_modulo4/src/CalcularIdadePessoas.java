import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CalcularIdadePessoas {

    public static void main(String[] args) {
        calcularIdadePessoasList(new CalcularIdadePessoas().generateListaPessoas());
    }


    /**
     * A partir de uma lista de pessoas (nome e data nascimento no formato dd-MM-yy),
     * calcular a idade de cada pessoa em referência a data de hoje.
     * <p>
     * A idade maxima das pessoas é de 99 anos.
     */
    private static void calcularIdadePessoasList(List<Pessoa> listPessoas) {

        // Listas utilizam a ideia de referência, logo estou alterando a lista original.
        new CalcularIdadePessoas().corrigirDatasNascimentoNaListaPessoas(listPessoas);

        // Depois que a lista original for 'corrigida' faça esse cálculo de idade.
        listPessoas.forEach(pessoa -> {
            LocalDate anoNascimento = LocalDate.parse(pessoa.dataNascimento);
            int idadePessoa = Period.between(anoNascimento, LocalDate.now()).getYears();

            System.out.print("Data nascimento: " + pessoa.dataNascimento + " ");
            if (idadePessoa > 99) {
                System.out.println(pessoa.nome + " tem mais de 99 anos...");
            } else {
                System.out.println(pessoa.nome + " tem " + idadePessoa + " anos.");
            }
        });
    }

    private void corrigirDatasNascimentoNaListaPessoas(List<Pessoa> pessoas) {
        pessoas.forEach(pessoa -> {
            LocalDate dateFormatted = convertShortDateToLongDate(pessoa.dataNascimento);

            // Se digitou yy = 36, vou considerar que é 1936.
            // Qualquer yy > ano_atual, vou considerar que é sobre 1900
            if (dateFormatted.isAfter(LocalDate.now())) {
                dateFormatted = dateFormatted.minusYears(100);
            }
            pessoa.dataNascimento = dateFormatted.toString();
        });

    }

    /**
     * Qual a ideia do DateTimeFormatter: converter meu padrão errado para o padrão do LocalDate.
     * Ele tenta converter exatamente o que vem no texto.
     * Se padrão for dd-MM-yy vai EXATAMENTE TENTAR CONVERTER ISSO DAI. 9-8-98 vai dá erro, pois não é dd-MM-yy
     * Se padrão for d-M-yy vai EXATAMENTE TENTAR CONVERTER ISSO DAI. 19-08-98 vai dá erro, pois não é d-M-yy
     * Se eu quiser converter os dois tipos? Dois padrões opcionais [dd-MM-yy] e [d-M-yy]
     */
    private LocalDate convertShortDateToLongDate(String dataText) {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder().appendPattern("[dd-MM-yy]" + "[d-M-yy]");
        DateTimeFormatter dateFormatsCommingForList = dateTimeFormatterBuilder.toFormatter();
        return LocalDate.parse(dataText, dateFormatsCommingForList);
    }

    // Ia tentar calcular isso vindo de um map, mas desisti.
    private void calcularIdadePessoasMap(List<Map<String, String>> mapPessoas) {

    }

    private String generateRandomDatas() {
        /*
         * Posso corrigir o problema do Formatter das datas facilmente aqui. [dd-MM-yy] ou [d-M-yy] ou [d-M-y]
         * Basta eu concatenar... se valor < 10, concatene 0 nesse valor para ficar 09 e não 9.
         * Mentira... Né fácil não usar o opcional não... teria que verificar se o ano é 000x ou 00xx para converter para 19xx ou 199x
         */
        int day = new SecureRandom().nextInt(28) + 1;
        int month = new SecureRandom().nextInt(12) + 1;
        int year = 10 + new SecureRandom().nextInt(90);

        return day + "-" + month + "-" + year;
    }

    /**
     * Aqui virá o padrão 'errado' -> dd-MM-yy
     * Depois vou converter para o padrão certo LocalDate -> 'yyyy-MM-dd'
     */
    private List<Pessoa> generateListaPessoas() {
        return new ArrayList<>() {{
            add(0, new Pessoa("Pessoa A", generateRandomDatas()));
            add(1, new Pessoa("Pessoa B", generateRandomDatas()));
            add(2, new Pessoa("Pessoa C", generateRandomDatas()));
            add(3, new Pessoa("Pessoa D", generateRandomDatas()));
            add(4, new Pessoa("Pessoa E", generateRandomDatas()));
            add(5, new Pessoa("Pessoa G", generateRandomDatas()));
            add(6, new Pessoa("Pessoa H", generateRandomDatas()));
            add(7, new Pessoa("Pessoa I", generateRandomDatas()));
            add(8, new Pessoa("Pessoa O", generateRandomDatas()));
            add(9, new Pessoa("Pessoa P", generateRandomDatas()));
        }};
    }

    private List<Map<String, String>> generateMapPessoas() {
        return new ArrayList<>() {{
            add(Map.of("Pessoa A", generateRandomDatas()));
            add(Map.of("Pessoa B", generateRandomDatas()));
            add(Map.of("Pessoa C", generateRandomDatas()));
            add(Map.of("Pessoa D", generateRandomDatas()));
            add(Map.of("Pessoa E", generateRandomDatas()));
            add(Map.of("Pessoa G", generateRandomDatas()));
            add(Map.of("Pessoa H", generateRandomDatas()));
            add(Map.of("Pessoa I", generateRandomDatas()));
            add(Map.of("Pessoa O", generateRandomDatas()));
            add(Map.of("Pessoa P", generateRandomDatas()));
        }};
    }

    class Pessoa {
        private String nome;
        private String dataNascimento;

        public Pessoa(String nome, String dataNascimento) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
        }

        public String getNome() {
            return nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }
    }

}