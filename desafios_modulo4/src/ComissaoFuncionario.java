import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

/**
 * Um funcionário recebe uma comissão de 0.5% sobre o valor do seu dia trabalhado.
 * Criar uma função para receber o valor do salário mensal e o ano e partir dessas informações calcular a previsão do salário mês a mês.
 * <p>
 * Considerar apenas os dias úteis (segunda a sexta).
 */
public class ComissaoFuncionario {

    public static void main(String[] args) {
        BigDecimal valorSalario = BigDecimal.valueOf(1000);
        new ComissaoFuncionario().previsaoSalarioCadaMes(2022, valorSalario);
    }

    /**
     * Tem um problema aqui...
     * Se recebeu R$ 2000 e trabalhou 22 dias, salário por dia será menor.
     * Se recebeu R$ 2000 e trabalho 20 dias, salário por dia será maior.
     * Cálculo certo seria saber o valor do dia trabalhado e não o recebido no mês.
     */
    private void previsaoSalarioCadaMes(int ano, BigDecimal valorSalario) {
        int quantidadeDiasTrabalhados;
        BigDecimal valorSalarioPorDiaTrabalho;

        for (int i = 1; i <= 12; i++) {
            BigDecimal valorDaComissao = BigDecimal.ZERO;
            quantidadeDiasTrabalhados = calcularQuantidadeDiasUteisNoMes(i, ano);
            valorSalarioPorDiaTrabalho = valorSalario.divide(BigDecimal.valueOf(quantidadeDiasTrabalhados), 2, RoundingMode.HALF_EVEN);
       
            for (int j = 0; j < quantidadeDiasTrabalhados; j++) {
                valorDaComissao = valorDaComissao.add(
                        valorSalarioPorDiaTrabalho
                                .multiply(BigDecimal.valueOf(0.5))
                                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN)
                );
            }

            System.out.println("Previsão salário no mês: " + Month.of(i) + " será de: " + valorSalario.add(valorDaComissao));
        }
    }

    // Cálcular quantidade de dias úteis no ano... fiz, mas não precisou.
    private int calcularQuantidadeDiasUteisTotais(int ano) {
        int diasUteisNoAno = 0;
        for (int i = 1; i <= 12; i++) {
            diasUteisNoAno += calcularQuantidadeDiasUteisNoMes(i, ano);
        }
        return diasUteisNoAno;
    }

    /**
     * Retorna a quantidade de dias úteis em um mês...
     * Mês 1 (jan) e ano 2022, Mês 2 (fev) e ano 2022, Mês 3 (mar) e ano 2022...
     * Faço um loop por fora em outro lugar (de 1 até 12[dez]) para calcular de todos os meses.
     */
    private int calcularQuantidadeDiasUteisNoMes(int mes, int ano) {
        YearMonth yearMonth = YearMonth.of(ano, mes);
        LocalDate localDate = yearMonth.atDay(1);
        int diasUteisNoMes = 0;
        while (localDate.isBefore(yearMonth.atDay(1).plusMonths(1))) {
            if (localDate.getDayOfWeek() != DayOfWeek.SATURDAY && localDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                diasUteisNoMes++;
            }

            localDate = localDate.plusDays(1);
        }
        return diasUteisNoMes;
    }

}