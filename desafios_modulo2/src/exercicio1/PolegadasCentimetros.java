package exercicio1;

import java.util.Scanner;

public class PolegadasCentimetros {

    // Converter polegadas em centímetros:
    public static void main(String[] args) {
        double polegadas;

        Scanner scan = new Scanner(System.in);

        // Sem verificar se de fato é um número
        System.out.print("Digite as polegadas para conversão: ");
        polegadas = Double.parseDouble(scan.nextLine());

        System.out.printf("%.1f polegadas = %.1f centímetros.", polegadas, polegadas * 2.54);
    }
}
