/**
 * Escreva um algoritmo que receba um parâmetro String. *
 * Verificar se há 3 letras "X" em sequência entre dois números que somam 8. *
 * Exemplo: frdts2XXX6xxbl2XXXeee5 *
 * Retorna true pois a String possui a combinação "2XXX6" (Sequencia de 3 "X" entre os números 6 e 2 que somam 8).
 */
public class aBuscarPatternEmString {
    /*
     *  .*      -> pode ter qualquer coisa antes.
     *  \\d     -> tem que ter um dígito antes do x.
     *  X{3}    -> tem que ter XXX
     *  \\d     -> tem que ter um dígito depois do x.
     *  .*      -> pode ter qualquer coisa depois.
     */

    private static final String regexAntigo = ".*[0-9]XXX[0-9].*";
    private static final String regexNovo = ".*\\dX{3}\\d.*";
    // Mesma coisa do anterior.


    public static void main(String... args) {

        // 3 trues
        /*System.out.println("regexAntigo " + verificarStringRegex("frdts2XXX6xxbl2XXXeee5", regexAntigo));
        System.out.println("regexNovo " + verificarStringRegex("frdts2XXX6xxbl2XXXeee5", regexNovo));
        System.out.println("semRegex " + verificarStringSemRegex("frdts2XXX6xxbl2XXXeee5"));
        System.out.println();

        // 3 falses
        System.out.println(verificarStringRegex("frdtsAXXX6xxbl2XXXeee5", regexAntigo));
        System.out.println(verificarStringRegex("frdtsAXXX6xxbl2XXXeee5", regexNovo));
        System.out.println(verificarStringSemRegex("frdtsAXXX6xxbl2XXXeee5"));*/

        System.out.println(verificarStringSemRegexCharacter("frdtsAXXXAxxbl2XXXeee5"));
    }

    /**
     * 1-solução) Usando regex para dizer se a string contém o padrão.
     * Fiz dois regex diferentes, que no fundo são a mesma coisa, um é mais resumido que o outro.
     */
    static public boolean verificarStringRegex(String texto, String regex) {
        if (texto.matches(regex)) {
            int valorAntesX = Integer.parseInt(String.valueOf(texto.charAt(texto.indexOf("XXX") - 1)));
            int valorDepoisX = Integer.parseInt(String.valueOf(texto.charAt(texto.indexOf("XXX") + 3)));

            // For igual a 8 return true, else return false
            return (valorAntesX + valorDepoisX) == 8;
        }

        return false;
    }

    /**
     * 2-solução) Usando recursividade e Character.isDigit()
     * Essa solução verifica a string inteira, não apenas a primeira ocorrência.
     * Se o primeiro (2XXXa) der erro, continua na String e vê se tem outro.
     */
    static boolean verificarStringSemRegexCharacter(String texto) {
        if (!texto.contains("XXX")) {
            return false;
        }

        char charAntesX = texto.charAt(texto.indexOf("XXX") - 1);
        char charDepoisX = texto.charAt(texto.indexOf("XXX") + 3);

        boolean isDigitAntesX = Character.isDigit(charAntesX);
        boolean isDigitDepoisX = Character.isDigit(charDepoisX);

        if (isDigitAntesX && isDigitDepoisX) {
            int valorAntesX = Integer.parseInt(String.valueOf(charAntesX));
            int valorDepoisX = Integer.parseInt(String.valueOf(charDepoisX));

            if(valorAntesX + valorDepoisX == 8) {
                return true;
            }
        }

        return verificarStringSemRegexCharacter(texto.substring(texto.indexOf("XXX") + 3));
    }

    /**
     * Verifica somente a primeira ocorrência do (XXX).
     * Se o primeiro já vier com problema, não vai continuar na string.
     * Poderia fazer um loop usando substring em outro lugar?
     */
    static public boolean verificarStringSemRegex(String texto) {
        // Se não conter XXX já dá false.
        if(!texto.contains("XXX")) {
            return false;
        }

        int valorAntesX;
        int valorDepoisX;

        /*
         * 2 trys para dizer exatamente qual caracter não é um número...
         * Fosse um try só não daria para diferenciar.
         */
        try {
            valorAntesX = Integer.parseInt(String.valueOf(texto.charAt(texto.indexOf("XXX") - 1)));
        }
        catch (Exception e) {
            System.err.println("Antes do XXX não é um número");
            return false;
        }

        try {
            valorDepoisX = Integer.parseInt(String.valueOf(texto.charAt(texto.indexOf("XXX") + 3)));
        }
        catch (Exception e) {
            System.out.println();
            System.err.println("Depois do XXX não é um número");
            return false;
        }

        // Se a soma for 8: retorna true.
        return (valorAntesX + valorDepoisX) == 8;
    }


}