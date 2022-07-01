package exercicio2;

import java.util.Objects;
import java.util.Scanner;

public class CincoFrutas {

    /**
     * Programa:
     *      lê o nome de 5 frutas e armazena num carrinho de compras.
     *      Lê os 5 nomes
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] frutas = new String[5];

        for (int i = 0; i < 5; i++) {
            // Cuidado: array em Java inicia com 0
            System.out.printf("Digite a %dª fruta: ", i+1);
            frutas[i] = scan.nextLine();
        }

        // For normal
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s ", frutas[i]);
        }

        // For mais elegante:
        System.out.println("As frutas digitadas são: ");
        for (String fruta : frutas) {
            if(!Objects.equals(fruta, frutas[frutas.length - 1]))
                System.out.print(fruta + ", ");
            else
                System.out.println(fruta);
        }
    }

}
