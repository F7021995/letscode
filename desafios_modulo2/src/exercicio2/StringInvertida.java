package exercicio2;

import java.util.Scanner;

public class StringInvertida {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String palavra = "";

        System.out.print("Digite uma palavra: ");
        palavra = scan.nextLine();

        // Jeito fácil de inverter
        System.out.println(new StringBuilder(palavra).reverse().toString());

        // Jeito usando recursividade
        System.out.println(reverse(palavra));

        // Jeito usando repetição
        String concat = "";

        for(int i = palavra.length() - 1; i >= 0; i--) {
            concat += palavra.charAt(i);
        }

        System.out.println(concat);

        /**
         *  Tudo em Java começa com 0:
         *      Palavra tem 7 caracteres: vai de 0 até 6
         *      Tem que ser length() - 1 e >= 0
         */
    }

    static String reverse(String valor) {
        if(valor.length() > 1)
            return reverse(valor.substring(1)) + valor.charAt(0);

        return valor;
    }

}
