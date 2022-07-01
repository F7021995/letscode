package exercicio1;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyConversion {

    public static void main(String[] args) {
        double cotacaoDollar = 4.70;
        double reais = 0.3;

        final Locale PTBR = new Locale("pt", "BR");

        // Isso retorna strings.
        String c = NumberFormat.getCurrencyInstance(PTBR).format(400.21);

        // Usando função própria.
        String d = formatarMoeda(300.12, new Locale("pt", "BR"));
        String e = formatarMoeda(500.32 / cotacaoDollar, Locale.US);

        NumberFormat.getCurrencyInstance(PTBR).format(reais);
        NumberFormat.getCurrencyInstance(Locale.US).format(reais / cotacaoDollar);
    }

    static String formatarMoeda(Double valor, Locale locale) {
        return NumberFormat.getNumberInstance(locale).format(valor);
    }

}
