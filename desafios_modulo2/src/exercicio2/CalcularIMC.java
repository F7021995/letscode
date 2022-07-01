package exercicio2;

import java.security.SecureRandom;
import java.util.Scanner;

public class CalcularIMC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Variáveis de input
        String nome;
        String peso; //altura e peso são strings para fazer verificação.
        String altura;

        // Arrays
        double[] alturas = new double[5];
        double[] pesos = new double[5];
        String[] nomes = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº nome: ", i+1);
            nome = scan.nextLine();

            while(nome.equals("")) {
                System.out.printf("Digite o %dº nome: ", i+1);
                nome = scan.nextLine();
            }

            System.out.printf("Digite o peso do %s: ", nome);
            peso = scan.nextLine();

            while(!ehDouble(peso)) {
                System.out.printf("Digite o peso do %s: ", nome);
                peso = scan.nextLine();
            }

            System.out.printf("Digite a altura do %s (em cm): ", nome);
            altura = scan.nextLine();

            while(!ehDouble(altura)) {
                System.out.printf("Digite a altura do %s (em cm): ", nome);
                altura = scan.nextLine();
            }

            nomes[i] = nome;
            alturas[i] = Double.parseDouble(altura)/100;
            pesos[i] = Double.parseDouble(peso);

            System.out.println();
        }

        // Calcular o IMC
        for (int i = 0; i < 5; i++) {
            double imc = pesos[i] / (alturas[i] * alturas[i]);
            if(imc < 18.5 || imc > 25) {
                System.out.printf("%s, seu IMC é de: %.1f%n", nomes[i], imc);
                System.out.println("Você não possui IMC ideal (entre 18.5 e 25)");
                System.out.println();
            }
        }
    }

    static boolean ehDouble(String value) {
        try {
            double x = Double.parseDouble(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
