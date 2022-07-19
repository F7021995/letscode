import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encontre uma resolução para processar estas datas de nascimento, onde:
 * É preciso descobrir a pessoa mais velha e a mais nova.
 */
public class ListaComDatasNascimentos {

    /**
     * Eu estava querendo ordenar um Map...
     * Map não faz sentido ser ordenado, assim como um Set...
     */
    private static final List<Map<String, String>> original = new ArrayList<>(carregarDados());

    /**
     * Tem como percorrer um Map... Usando .entrySet()
     */
    public static void main(String[] args) {
        Map<String, LocalDateTime> copiaMapaOriginal = new HashMap<>();

        original.forEach(map -> {
            LocalDateTime dataTransformada = formatarData(splitDateString(map.get("nascimento")));
            copiaMapaOriginal.put(map.get("nome"), dataTransformada);
        });

        String maisVelho = null;
        String maisNovo = null;

        // Raciocínio é invertido... A data mais próximo de 0000 é a pessoa mais velha.
        LocalDateTime idadeMaisVelho = LocalDateTime.MAX;
        // A data mais próxima de 9999 é o mais novo.
        LocalDateTime idadeMaisNovo = LocalDateTime.MIN;

        for (Map.Entry<String, LocalDateTime> entry : copiaMapaOriginal.entrySet()) {
            // Se ele vem antes, ele é mais velho.
            if (entry.getValue().isBefore(idadeMaisVelho)) {
                idadeMaisVelho = entry.getValue();
                maisVelho = entry.getKey();
            }

            // Se ele vem depois, ele é mais novo carai (2000 vem depois de 1999, é mais novo).
            if (entry.getValue().isAfter(idadeMaisNovo)) {
                idadeMaisNovo = entry.getValue();
                maisNovo = entry.getKey();
            }
        }

        System.out.println("Lembrete: racicínio de mais velho e mais novo é invertido... O maior número é o mais novo.");
        System.out.println("Mais novo: " + maisNovo + " idade: " + idadeMaisNovo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Mais velho: " + maisVelho + " idade: " + idadeMaisVelho.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    /**
     * LocalDate em Java só pode ser 'yyyy-MM-dd'
     * Uma String pode ser qualquer coisa (as strings são formatadas com Patterns).
     * Não tem como alterar o Pattern e armazena no Tipo LocalDate, pois só aceita yyyy-MM-dd
     */
    private static String[] splitDateString(String date) {
        return date.split(" ");
    }

    /**
     * Cada array passado terá dois elementos, duas strings (um split de um texto).
     * Retornará um LocalDateTime formatado do Jeito correto.
     */
    private static LocalDateTime formatarData(String[] array) {
        String stringAtIndex0 = array[0];
        String stringAtIndex1 = array[1];
        LocalDate date;
        LocalTime time;

        // Esse FormatterBuilder é necessário quando vários tipos de regex são permitidos.
        DateTimeFormatterBuilder dateFormatterBuilder = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("[dd-MM-yyyy]" + "[yyyy-MM-dd]"));

        DateTimeFormatter dateFormatter = dateFormatterBuilder.toFormatter();

        if (stringAtIndex0.contains("-")) {
            date = LocalDate.parse(stringAtIndex0, dateFormatter);
            time = LocalTime.parse(stringAtIndex1);
        } else {
            time = LocalTime.parse(stringAtIndex0); //se s1 não tiver '-' será tempo.
            date = LocalDate.parse(stringAtIndex1, dateFormatter);
        }

        return LocalDateTime.of(date, time);
    }

    private static List<Map<String, String>> carregarDados() {
        List<Map<String, String>> original = new ArrayList<>();
        original.add(Map.of("nome", "João", "nascimento", "1985-12-11 12:10:33"));
        original.add(Map.of("nome", "Maria", "nascimento", "24-07-1988 23:02:41"));
        original.add(Map.of("nome", "Ana", "nascimento", "03:58:26 14-02-1983"));
        original.add(Map.of("nome", "Pedro", "nascimento", "08:03:07 1989-11-02"));
        return original;
    }

}