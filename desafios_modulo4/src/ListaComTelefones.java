import java.security.SecureRandom;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Baseado na lista de contatos abaixo, obtenha os nomes de quem possuí o número 7 no seu número de telefone
 * e liste os respectivos nomes em ordem alfabéntica.
 * Apensa utilizando Stream.
 */
public class ListaComTelefones {

    public static void main(String[] args) {
        // Não preciso ficar preso em Comparator.naturalOrder()
        List<Map<String, String>> listaFiltrada = filtrarTelefonesComSete(carregarListaTelefonesOriginal());
        List<Map<String, String>> listaRandomica = filtrarTelefonesComSete(gerarListaTelefoneAleatoria());
        System.out.println("Lista Original: \n" + listaFiltrada);
        System.out.println("Lista Randômica: \n" + listaRandomica);
    }

    /**
     * Filtrar os telefones... Retornar apenas os que possuem dígito 7 no telefone.
     */
    private static List<Map<String, String>> filtrarTelefonesComSete(List<Map<String, String>> lista) {
        return lista
                .stream()
                // Se telefone conter 7, deixe-o nesse stream
                .filter(stringStringMap -> stringStringMap.get("telefone").contains("7"))
                // Comparar duas strings e ordenar crescentemente. Comparator.comparing faz isso.
                .sorted(Comparator.comparing(map -> map.get("nome")))
                .collect(Collectors.toList());
    }

    private static List<Map<String, String>> carregarListaTelefonesOriginal() {
        return List.of(
                Map.of("nome", "João", "telefone", "9329823423"),
                Map.of("nome", "Maria", "telefone", "9124235435"),
                Map.of("nome", "Marta", "telefone", "9456335387"),
                Map.of("nome", "José", "telefone", "9632874738"),
                Map.of("nome", "Judas", "telefone", "9329244683")
        );
    }

    /**
     * Gerar uma lista aleatória de telefones.
     */
    private static List<Map<String, String>> gerarListaTelefoneAleatoria() {
        int quantidadeElementos = new SecureRandom().nextInt(10) + 1;
        List<Map<String, String>> mapa = new LinkedList<>();

        for (int i = 0; i < quantidadeElementos; i++) {
            mapa.add(i,
                    Map.of(
                            "nome", gerarStringAleatoria(),
                            "telefone", gerarTelefoneAleatorioSemDDD()
                    )
            );
        }
        return mapa;
    }

    /**
     * Mapa ta armazenando telefone como String, por isso String.valufOf();
     * Gerar um telefone sem DDD, apenas 9 números.
     */
    private static String gerarTelefoneAleatorioSemDDD() {
        return String.valueOf(900_000_000 + new SecureRandom().nextInt(100_000_000));
    }

    /**
     * Gerar um bando de letras aleatórias, tudo minúsculas.
     * Depois retornar algo capitalized.
     */
    private static String gerarStringAleatoria() {
        int leftLimit = 97; // 97 representa letra 'a'
        int rightLimit = 122; // 122 representa letra 'z'
        int targetStringLength = 10; // tamanho da minha string.
        SecureRandom random = new SecureRandom();

        // Isso copiei da internet... vai gerar 10 letras aleatórias.
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return capitalizeWord(generatedString);
    }

    /**
     * Capitalizar a primeira letra, concatenar com o resto tudo minúsculo.
     */
    private static String capitalizeWord(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase();
    }

}