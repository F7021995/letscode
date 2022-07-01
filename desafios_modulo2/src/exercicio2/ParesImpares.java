package exercicio2;

import java.util.Scanner;

// lê 5 números. Ao final, escreva primeiros todos os ímpares, depois todos os pares.
public class ParesImpares {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite %dº número: ", i+1);
            // Repetição para forçar digitar um número
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.printf("Digite %dº número: ", i+1);
            }
            numeros[i] = Integer.parseInt(scan.next());
        }

        System.out.println("Números ímpares.");
        for (int impar : numeros) {
            if(impar % 2 == 1)
                System.out.print(impar + " ");
        }

        System.out.println();

        System.out.println("Números pares.");
        for (int par : numeros) {
            if(par % 2 == 0)
                System.out.print(par + " ");
        }
    }
}
