package exercicio2;

import java.util.Arrays;
import java.util.Scanner;

public class MaiorMenorMedia {

    static int menor, maior;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numeros = new int[5];
        int soma = 0;

        System.out.println("Calcular maior, menor e média.");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Informe o %dº numero: ", i+1);

            while (!scan.hasNextInt()) {
                System.out.printf("Informe o %dº numero: ", i + 1);
                scan.next();
            }

            numeros[i] = Integer.parseInt(scan.next());

            soma += numeros[i];
        }

        // Buscar menor e maior facilmente.
        Arrays.sort(numeros);
        menor = numeros[0];
        maior = numeros[numeros.length - 1];

        // Ordenação decrescente
        int aux;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(numeros[i] > numeros[j]) {
                    aux = numeros[j];
                    numeros[j] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }

        for (int numero : numeros) {
            System.out.println(numero + " ");
        }

        System.out.printf("Maior número é: %d%n", maior);
        System.out.printf("Menor número é: %d%n", menor);
        System.out.printf("Média desses números é: %d", soma/5);
    }

}
