import java.time.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Vai acontecer um evento internacional com transmissão online em São Paulo e Paris.
 * Começa no dia 20 de Julho às 10h de São Paulo, mas deverá ter uma nova sessão a cada 10 dias.
 * A cada sessão a hora de início deve avançar 2 horas, comparado com a sessão anterior.
 * <p>
 * Cada sessão vai durar 6h.
 * O evento termina no fim de Outubro.
 * <p>
 * Crie a agenda do evento programaticamente utilizando o Java Time, deverá fornecer:
 * A agenda das sessões para cada lugar.
 * Com o número da sessão.
 * Apresentar a data de cada sessão.
 * Done - O horário de início e de fim, para cada lugar respectivamente.
 * Done - Apresentar o dia da semana em português.
 * Organizar o código em classes e adotar algum padrão de projeto.
 */
public class EventoInternacional {

    private static final LocalDate dataInicial = LocalDate.of(2022, 7, 20);
    private static final LocalTime horaInicial = LocalTime.of(10, 0, 0);
    private static final LocalDateTime dataInicialEvento = LocalDateTime.of(dataInicial, horaInicial);

    public static void main(String[] args) {
        System.out.println("Agenda dos eventos até outubro: ");
        new EventoInternacional().impressaoZonedDateTime(agendaComTodosHorarios());
    }

    private void impressaoZonedDateTime(List<LocalDateTime> listaSessoes) {
        ZoneId saoPauloZoneId = ZoneId.of("America/Sao_Paulo");
        ZoneId parisZoneId = ZoneId.of("Europe/Paris");

        listaSessoes.forEach(value -> {
            ZonedDateTime timeAtSaoPaulo = value.atZone(saoPauloZoneId);
            imprimirHorario(timeAtSaoPaulo);

            ZonedDateTime timeAtParis = timeAtSaoPaulo.withZoneSameInstant(parisZoneId);
            imprimirHorario(timeAtParis);

            System.out.println();
        });
    }

    // Uma agenda tem ordem... Logo é necessário uma lista (um set não é bom);
    private static List<LocalDateTime> agendaComTodosHorarios() {
        List<LocalDateTime> agendaSessoes = new LinkedList<>();
        LocalDateTime proximaSessao = dataInicialEvento;

        do {
            agendaSessoes.add(proximaSessao);
            proximaSessao = calcularProximaSessao(proximaSessao);
        } while (proximaSessao.getMonth().getValue() < Month.OCTOBER.getValue());

        return agendaSessoes;
    }

    private static LocalDateTime calcularProximaSessao(LocalDateTime dateTimeSessaoAnterior) {
        return dateTimeSessaoAnterior.plusDays(10).plusHours(2);
    }

    private void imprimirHorario(ZonedDateTime zonedDateTime) {
        String horarioFormatado = "início: " + formatarDataString(zonedDateTime);
        String diaSemana = diaSemanaPortugues(zonedDateTime.getDayOfWeek());

        zonedDateTime = zonedDateTime.plusHours(6);

        horarioFormatado += "; término: " + formatarDataString(zonedDateTime)
                + "; dia semana: " + diaSemana
                + "; fuso horário: " + zonedDateTime.getZone() + ".";

        System.out.println(horarioFormatado);
    }

    private static String formatarDataString(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toLocalDate() + " " + zonedDateTime.toLocalTime();
    }

    private static String diaSemanaPortugues(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case SUNDAY:
                return "DOMINGO";
            case MONDAY:
                return "SEGUNDA-FEIRA";
            case TUESDAY:
                return "TERÇA-FEIRA";
            case WEDNESDAY:
                return "QUARTA-FEIRA";
            case THURSDAY:
                return "QUINTA-FEIRA";
            case FRIDAY:
                return "SEXTA-FEIRA";
            case SATURDAY:
                return "SÁBADO";
            default:
                return "Dia inválida";
        }
    }

}