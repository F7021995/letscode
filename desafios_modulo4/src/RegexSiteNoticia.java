import java.util.regex.Pattern;

public class RegexSiteNoticia {

    public static void main(String[] args) {
        logicaRegex();
    }

    private static void logicaRegex() {
        String regexNoticia = "" + // Só pro IntelliJ não modificar a formatação com autoformat.
                "(https?)://" +             // início http ou https + ://
                "[a-zA-Z]*.com.br/" +       // nome do site só com letras (sem -) + .com.br/
                "[a-zA-Z]*/" +              // categoria do site (só letras) + /
                "[a-zA-Z]*/" +              // subcategoria do site (só letras) + /
                "\\d{4}/\\d{2}/\\d{2}/" +   // ano/mes/dia sem verificar se data é válida (yyyy-MM-dd)
                "[-a-zA-Z]*.html";          // nome da notícia (letras e hífen).html
        String site = "https://sitenoticas.com.br/negocios/investimentos/2022/04/01/fim-de-semana-com-muita-chuva.html";
        String site1 = "https://sitenoticas.com.br/negocios/investimentos/2022/04/01/fim-de-semana-com-muita-chuva.htm";
        String site2 = "https://sitenoticas.com.br/negocios/investimentos/2022/04/01/fim-de-###semana-com-muita-chuva.html";

        System.out.println(Pattern.matches(regexNoticia, site));
        System.out.println(Pattern.matches(regexNoticia, site1));
        System.out.println(Pattern.matches(regexNoticia, site2));
    }

}