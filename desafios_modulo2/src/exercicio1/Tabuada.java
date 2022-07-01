package exercicio1;

import java.util.Scanner;

public class Tabuada {

    // Tabuada de 1 a 10 de um único número.
    public static void main(String[] args) {
        int numero;

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite número para calcular tabuada: ");
        while(!scan.hasNextInt()) {
            scan.nextLine();
            System.out.print("Digite número para calcular tabuada: ");
        }
        numero = Integer.parseInt(scan.nextLine());

        // Tabuada sem usar laço de repetição.
        System.out.printf("%s * 1 = %s %n", numero, numero);
        System.out.printf("%s * 2 = %s %n", numero, numero * 2);
        System.out.printf("%s * 3 = %s %n", numero, numero * 3);
        System.out.printf("%s * 4 = %s %n", numero, numero * 4);
        System.out.printf("%s * 5 = %s %n", numero, numero * 5);
        System.out.printf("%s * 6 = %s %n", numero, numero * 6);
        System.out.printf("%s * 7 = %s %n", numero, numero * 7);
        System.out.printf("%s * 8 = %s %n", numero, numero * 8);
        System.out.printf("%s * 9 = %s %n", numero, numero * 9);
        System.out.printf("%s * 10 = %s %n", numero, numero * 10);

        // Tabuada usando laço de repetição
        for (int i = 1; i < 11 ; i++) {
            System.out.printf("%d * %d = %d %n", numero, i, numero * i);
        }

        // Tabuada usando while
        int contador = 1;
        while (contador < 11) {
            System.out.printf("%d * %d = %d %n", numero, contador, numero * contador);
            contador++;
        }

        // Tabuada usando do-while
        contador = 1;
        do {
            System.out.printf("%d * %d = %d %n", numero, contador, numero * contador);
            contador++;
        } while (contador < 11);

        /**
         * Sobre ser 11 ou 10:
         *      While precisa ser < 11, pois a verificação é feita antes.
         *      Fará 10 vezes e na 11ª sairá.
         *
         *      Cuidado nesse do aí:
         *          A primeira execução o contador já vai para 2.
         *          Dá a impressão que vai executar até 11 vezes, mas vai apenas 10.
         */
    }
}
