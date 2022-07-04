import java.text.Normalizer;

public class FormatarStringEmail {

    public static void main(String[] args) {
        System.out.println(maiusculo("TUdo VAI ficar MAIÚSCULO (upperCase)"));
        System.out.println(minusculo("TUDO VAI ficar MINÚsculo (lowerCase)"));
        System.out.println(primeiraCapitalizada("SOMENTE a primeira LETRA CAPITALIZADA."));
        System.out.println(tudoCapitalizado("PRIMEIRA leTRA de CADA PALAvra CApitalizada"));
        System.out.println(removerAcentos("REMOVENDO ÁÁÁÁÁÁ ACENTOS ÂÊÎÔÛ ÁÉÍÓÚ ÀÈÌÒÙ"));
    }

    private static String maiusculo(String texto) {
        return texto.toUpperCase();
    }

    private static String minusculo(String texto) {
        return texto.toLowerCase();
    }

    private static String primeiraCapitalizada(String texto) {
        return String.valueOf(texto.charAt(0)).toUpperCase() + texto.substring(1).toLowerCase();
    }

    private static String tudoCapitalizado(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = primeiraCapitalizada(palavras[i]);
            retorno.append(palavras[i]).append(" ");
        }

        return String.valueOf(retorno);
    }

    private static String pera(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD);
    }

    /**
     * replaceAll é quem vai substituir as letras com acento para letras normais.
     */
    private static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

}