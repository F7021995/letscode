import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Há um jardim cheio de lírios.
 * Tem 100 vermelhos, 50 amarelos e 25 azuis, todos bem misturadas, produzindo um efeito bem colorido.
 * Assuma que o lírio vermelho é o número 1, o amarelo o número 2 e o azul será o número 3.
 * <p>
 * Inicialize um stream com as sequências onde cada número representa uma flor e misture tudo.
 * Faça a colheita de todas as flores azuis e de 25% das outras flores.
 * <p>
 * Apresente o total de flores que sobram no jardim.
 * Utilize apenas stream, é proibido utilizar arrays e collections.
 */
public class JardimComLirios {

    private static List<Integer> jardimLirios;
    private static int contarVermelhasAoColher = 0;
    private static int contarAmarelasAoColher = 0;
    private static long quantidadeTotalVermelhas = 0;
    private static long quantidadeTotalAmarelas = 0;

    public static void main(String[] args) {
        construirJardimComLirios();

        // Vermelhos e Amarelos são usados em outras funções... Azuis só e usado aqui.
        long qtdAzuis = retornarQuantidadeDeUmLirio(jardimLirios, 3);

        System.out.println(
                "L" + Thread.currentThread().getStackTrace()[1].getLineNumber() + " ->" +
                        "\n\tqtdVermelhos: " + quantidadeTotalVermelhas +
                        "\n\tqtdAmarelos: " + quantidadeTotalAmarelas +
                        "\n\tqtdAzuis: " + qtdAzuis +
                        "\n\ttamanhoJardim: " + jardimLirios.size() +
                        "\n"
        );

        System.out.println("Jardim com todos os lírios: \n" + jardimLirios + "\n");

        List<Integer> jardimAposLiriosColhidos = removendoLirosNoMesmoStream(jardimLirios);
        System.out.println("Colhidos 25% lírios vermelhos: " + retornarQuantidadeDeUmLirio(jardimAposLiriosColhidos, 1));
        System.out.println("Colhidos 25% lírios Amarelos: " + retornarQuantidadeDeUmLirio(jardimAposLiriosColhidos, 2));
        System.out.println();

        System.out.println("Jardim após a colheita: \n" + jardimAposLiriosColhidos);
    }
    
    private static void construirJardimComLirios() {
        jardimLirios = montarJardimComStream();
        Collections.shuffle(jardimLirios);

        // Estas duas quantidades são facilitadores para eu remover depois (encontrar os 25%)
        quantidadeTotalVermelhas = retornarQuantidadeDeUmLirio(jardimLirios, 1);
        quantidadeTotalAmarelas = retornarQuantidadeDeUmLirio(jardimLirios, 2);
    }

    /**
     * Usando stream para gerar a quantidade de lírios de acordo com o limit.
     */
    private static List<Integer> montarJardimComStream() {
        List<Integer> numeros = new ArrayList<>();

        numeros.addAll(Stream.generate(() -> 1).limit(100).collect(Collectors.toList()));
        numeros.addAll(Stream.generate(() -> 2).limit(50).collect(Collectors.toList()));
        numeros.addAll(Stream.generate(() -> 3).limit(25).collect(Collectors.toList()));

        return numeros;
    }

    private static List<Integer> removendoLirosNoMesmoStream(List<Integer> listaLirios) {
        return listaLirios.stream()
                .filter(number -> {
                    if (number == 3) { // remova todos os lírios 3, retorna falso para tudo
                        return false;
                    } else if (number == 2) { // remova 25% dos lírios 2
                        if (contarAmarelasAoColher <= (quantidadeTotalAmarelas * 3 / 4)) {
                            contarAmarelasAoColher++;
                            return true;
                        }
                        return false;
                    } else if (number == 1) { // remova 25% dos lírios 1
                        if (contarVermelhasAoColher <= (quantidadeTotalVermelhas * 3 / 4)) {
                            contarVermelhasAoColher++;
                            return true;
                        }
                        return false;
                    } else {
                        return false;
                    }
                }).collect(Collectors.toList());
    }

    private static long retornarQuantidadeDeUmLirio(List<Integer> listaLirios, int numeroDoLirio) {
        return listaLirios.stream().filter(number -> number == numeroDoLirio).count();
    }

    /**
     * A primeira solução que eu fiz foi essa...
     * Criei uma nova lista e adicionei nela a filtragem da outra lista.
     */
    private static List<Integer> removendoLiriosStreamsDiferentes(List<Integer> listaLirios) {
        // Não preciso adicionar os lírios 3, pois foram todos removidos.
        List<Integer> liriosSobrou = new ArrayList<>();

        // remover 25% dos lírios amarelos. Vou limitar a 3/4 da quantidade total.
        liriosSobrou.addAll(
                listaLirios.stream()
                        .filter(number -> number == 2)
                        .limit(quantidadeTotalAmarelas * 3 / 4)
                        .collect(Collectors.toList()));

        // remover 25% dos lírios vermelhos. Vou limitar a 3/4 da quantidade total.
        liriosSobrou.addAll(
                listaLirios.stream()
                        .filter(number -> number == 1)
                        .limit(quantidadeTotalVermelhas * 3 / 4)
                        .collect(Collectors.toList()));

        return liriosSobrou;
    }

    /**
     * Não usar esse daqui...
     * Primeira forma de gerar o jardim que eu usei...
     */
    private static List<Integer> montarJardimComLista() {
        List<Integer> jardim = new ArrayList<>();

        // Lírios Vermelhos 100, Amarelos 50 e Azuis 25
        for (int i = 0; i < 175; i++) {
            if (i >= 150) { // vai adicionar 25 números 3
                jardim.add(i, 3);
            } else if (i >= 100) { // vai adicionar 50 números 2
                jardim.add(i, 2);
            } else { // vai adicionar 100 números 1
                jardim.add(i, 1);
            }
        }

        return jardim;
    }

}