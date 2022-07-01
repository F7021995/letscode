package exercicio2;

import java.util.Scanner;

public class CaracteresImpares {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String digitado;

        System.out.print("Digite uma palavra: ");
        digitado = scan.nextLine();

        while(digitado.equals("")) {
            System.out.print("Digite uma palavra: ");
            digitado = scan.nextLine();
        }

        System.out.println();

        System.out.println("Apenas os caracteres ímpares dessa palavra: ");
        for (int i = 0; i < digitado.length(); i++) {
            if(i % 2 == 0) {
                System.out.print(digitado.toUpperCase().charAt(i) + " ");
            }
        }

        /**
         * OBS: é invertido esse if aí.
         *      índice 0 é a posição 1.
         *      O índice 0 é par/neutro, mas a posição é ímpar (1ª letra)
         */
    }
}
