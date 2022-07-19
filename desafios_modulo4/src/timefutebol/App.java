package timefutebol;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Construa tudo o que é necessário para estes código funcionar. <br>
 * Utilizando stream e lambda se necessário, realize a obtenção dos jogadores que são MEIA. <br>
 * Liste no output os nomes dos jogadores obtidos e os seus respectivos times.
 */
public class App {

    private static final List<Time> times = construirTimesFutebol();

    public static void main(String[] args) {
        System.out.println("Jeito bugado de imprimir???");
        jeitoBugadoImprimir(Tipo.MEIA);

        System.out.println();
        System.out.println("Jeito talvez correto de imprimir.");
        jeitoTalvezCorretoImprimir(Tipo.MEIA);
    }

    /**
     * Esse eu acho ser o jeito correto de fazer isso... <br>
     * Transformar em uma mapa de Time (key) e Jogadores (Values)... <br>
     * Já montar esse mapa com os Jogadores Filtrados na posição informada no parâmetro.
     */
    private static void jeitoTalvezCorretoImprimir(Tipo posicaoJogador) {
        /*
         * Só vou pegar os jogadores que estão na posiçãoJogador informada.
         * Time::getNome -> nome do time.
         * (posicaoFiltrada) -> lista dos jogadores já filtrados na posição desejada.
         */
        Map<String, List<Jogador>> mapJogadores = times.stream()
                .collect(Collectors.toMap(
                        Time::getNome,
                        (posicaoFiltrada) -> posicaoFiltrada.getJogadores().stream()
                                .filter(posicao -> posicao.getPosicao().equals(posicaoJogador))
                                .collect(Collectors.toList()))
                );

        /*
         * Se por algum motivo não existe jogadores na posição informada: imprima que não existe.
         * time -> é a key do mapa.
         * listaJogadores -> são os values dessa key.
         */
        mapJogadores.forEach((time, listaJogadores) -> {
            if (listaJogadores.isEmpty()) {
                System.out.println("Não existe jogadores nessa posição: " + posicaoJogador);
            } else {
                System.out.println("Time: " + time);
                listaJogadores.forEach(System.out::println);
                System.out.println();
            }
        });
    }


    /**
     * Faz o que eu preciso... Mas eu acho que não está correto?? <br>
     * .collect() só existe para que eu consiga imprimir o resultado na tela. <br>
     * Eu imprimi dentro de um map... Provavelmente isso tá errado. <br>
     * map ou flatMap nessa situação tanto faz... a ideia é apenas imprimir... <br>
     * return time.getJogadores().stream() também não faz nada... Só preciso disso pq o .map() exige um retorno.
     */
    private static void jeitoBugadoImprimir(Tipo posicaoJogador) {
        construirTimesFutebol()
                .stream()
                .map(time -> {
                    System.out.println("Time: " + time.nome);
                    time.jogadores.stream()
                            .filter(jogador -> jogador.getPosicao().equals(posicaoJogador))
                            .forEach(System.out::println);
                    System.out.println();

                    return time.getJogadores().stream();
                }).collect(Collectors.toList());
    }

    /**
     * O primeiro stream que eu fiz foi esse daí... <br>
     * Qual o problema disso aí: vai imprimir apenas os jogadores. <br>
     * Com ele eu não consigo acessar o nome do time.
     */
    private static void primeiroStream(Tipo posicaoJogador) {
        construirTimesFutebol()
                .stream()
                .flatMap(time -> time.jogadores.stream())
                .filter(posicao -> posicao.getPosicao().equals(posicaoJogador))
                .forEach(System.out::println);
    }

    /**
     * Preciso da classe Jogador -> Nome Jogador, Enum, Construtor e Getters. <br>
     * Preciso da classe Time -> Nome Time, Lista de Jogadores, Construtor e Getters.
     */
    private static List<Time> construirTimesFutebol() {
        /*
         * ArrayList que possui 2 índices/posições.
         * Cada índice tem: Nome do Time e Lista de Jogadores.
         */
        return new ArrayList<>() {{
            add(new Time(
                    "Gremio",
                    new ArrayList<>() {{
                        add(new Jogador("Gabriel Granco", Tipo.GOLEIRO));
                        add(new Jogador("Rafinha", Tipo.LATERAL));
                        add(new Jogador("Bruno Cortez", Tipo.LATERAL));
                        add(new Jogador("Pedro Geromel", Tipo.ZAGUEIRO));
                        add(new Jogador("Ruan", Tipo.ZAGUEIRO));
                        add(new Jogador("Tiago Santos", Tipo.VOLANTE));
                        add(new Jogador("Lucas Silva", Tipo.VOLANTE));
                        add(new Jogador("Ferreira", Tipo.MEIA));
                        add(new Jogador("Jaminton Campaz", Tipo.MEIA));
                        add(new Jogador("Jhonata Robert", Tipo.MEIA));
                        add(new Jogador("Diego Souza", Tipo.ATACANTE));
                    }}
            ));
            add(new Time(
                    "Flamengo",
                    new ArrayList<>() {{
                        add(new Jogador("Hugo Souza", Tipo.GOLEIRO));
                        add(new Jogador("Rodinel", Tipo.LATERAL));
                        add(new Jogador("Renê", Tipo.LATERAL));
                        add(new Jogador("Gustavo Henrique", Tipo.ZAGUEIRO));
                        add(new Jogador("Léo Pereira", Tipo.ZAGUEIRO));
                        add(new Jogador("Thiago Maia", Tipo.VOLANTE));
                        add(new Jogador("João Gomes", Tipo.VOLANTE));
                        add(new Jogador("Kenedy", Tipo.MEIA));
                        add(new Jogador("Diego", Tipo.MEIA));
                        add(new Jogador("Vitinho", Tipo.MEIA));
                        add(new Jogador("Vitor Gabriel", Tipo.ATACANTE));
                    }}
            ));
        }};
    }

}