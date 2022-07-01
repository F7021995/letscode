package exercicio1;

import java.util.Scanner;

public class OperacoesBasicasDoisNumeros {

    /**
     *  Sobre os formatters:
     *   > %d para números inteiros (byte, short, int e long).
     *   > %f são flutuantes (float e double).
     *   > %s qualquer tipo (string, numeros, pontuantes e qualquer outro).
     */

    // Pedir dois números e fazer as operações básicas (+, -, *, /)
    public static void main(String[] args) {
        int x;
        int y;

        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        while(!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println("Digite o primeiro número: ");
        }
        x = Integer.parseInt(scan.nextLine());

        System.out.print("Digite o segundo número: ");
        while(!scan.hasNextInt()) {
            scan.nextLine();
            System.out.println("Digite o segundo número: ");
        }
        y = Integer.parseInt(scan.nextLine());

        System.out.printf("Soma: x+y = %d %n", x + y);
        System.out.printf("Subtração: x-y = %d %n", x - y);
        System.out.printf("Multiplicação: x*y = %d %n", x * y);
        System.out.printf("Divisão: x/y = %.1f %n", ((double) x) / y);
    }

}