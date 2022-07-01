package exercicio1;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class ReaisEmDolar {

    // Converter reais para dolar, usando cotação informada.
    public static void main(String[] args) {
        double cotacaoDollar;
        double reais;

        Scanner scan = new Scanner(System.in);

        // Sem verficação se de fato é um número digitado.
        System.out.print("Qual a cotação do dollar? ");
        cotacaoDollar = Double.parseDouble(scan.nextLine());

        System.out.print("Quantos reais você tem? ");
        reais = Double.parseDouble(scan.nextLine());

        System.out.printf("R$ %.2f na cotação de R$ %.2f = $ %.2f", reais, cotacaoDollar,  reais / cotacaoDollar);

        Locale ptbr = new Locale("pt", "BR");

        // Isso retorna strings.
        String c = NumberFormat.getCurrencyInstance(ptbr).format(cotacaoDollar);
        String d = formatarMoeda(reais, new Locale("pt", "BR"));
        String e = formatarMoeda(((double) reais)/cotacaoDollar, Locale.US);

        NumberFormat.getCurrencyInstance(ptbr).format(reais);
        NumberFormat.getCurrencyInstance(Locale.US).format(reais / cotacaoDollar);

        //Isso é um problema... ficar repetindo valores.
    }

    /**
     * Função para formatar moedas
     * @param valor;
     * @param locale;
     */
    static String formatarMoeda(Double valor, Locale locale) {
        return NumberFormat.getNumberInstance(locale).format(valor);
    }

    void revisao() {
        /**
         * Lembrando sobre as divisões:
         *  > integer / integer = integer;
         *  > double / double = double;
         *  > double / integer = double;
         */
    }
}
