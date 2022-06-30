import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.HashMap;

public class fConversorMoedas {

    public static void main(String[] args) {
        Map<String, BigDecimal> dolarMap = new HashMap<>();
        dolarMap.put("USD", BigDecimal.valueOf(1.00)); // esse é a base da conversão.
        dolarMap.put("BRL", BigDecimal.valueOf(5.15)); // 1 dolar são 5.15 reais (dolar vale mais real)
        dolarMap.put("GBP", BigDecimal.valueOf(0.82)); // 1 dolar são 0.82 gbp (libra, dolar vale menos libra)
        dolarMap.put("EUR", BigDecimal.valueOf(0.95)); // 1 dolar são 0.95 eur (dolar vale menos euro).
        dolarMap.put("ARS", BigDecimal.valueOf(125.05)); // 1 dolar são 125 ars (dolar vale mais ars).

        conversao("BRL", "USD", BigDecimal.valueOf(50.00), dolarMap);
        conversao("BRL", "EUR", BigDecimal.valueOf(50.00), dolarMap);
        conversao("BRL", "GBP", BigDecimal.valueOf(50.00), dolarMap);
        System.out.println();

        conversao("USD", "BRL", BigDecimal.valueOf(50.00), dolarMap);
        conversao("USD", "GBP", BigDecimal.valueOf(50.00), dolarMap);
        conversao("USD", "EUR", BigDecimal.valueOf(50.00), dolarMap);
        System.out.println();
    }


    static void conversao(String de, String para, BigDecimal valor, Map<String, BigDecimal> dolar) {
        // 1 dolar são quantos na moeda 'de';
        BigDecimal taxaMoedaOrigemParaDolar = dolar.get(de);
        // 1 dolar são quantos na moeda 'para';
        BigDecimal taxaMoedaDestinoParaDolar = dolar.get(para);

        // Ao invés: BRL -> DOLAR, DOLAR -> EUR, eu faço (REAL dividido DOLAR dividido EUR)
        BigDecimal taxaConversaoDeParaDestino =
                taxaMoedaOrigemParaDolar.divide(taxaMoedaDestinoParaDolar, 2, RoundingMode.HALF_DOWN);

        BigDecimal resultadoConversao = valor.divide(taxaConversaoDeParaDestino, 2, RoundingMode.HALF_DOWN);
        System.out.println(de + " " + valor + " = " + para + " " + resultadoConversao);
    }

}