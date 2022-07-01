package exercicio2;

import java.util.Scanner;

public class CincoPessoas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] idades = new int[5];
        String[] nomes = new String[5];

        int somaIdades = 0;
        String nome;

        // Idade é string para fazer verificação, no array vou converter para inteiro.
        String idade;

        for (int i = 0; i < 5; i++) {

            System.out.printf("Digite o %dº nome: ", i+1);
            nome = scan.nextLine();

            while(nome.equals("")) {
                System.out.printf("Digite o %dº nome: ", i+1);
                nome = scan.nextLine();
            }

            System.out.printf("Digite a %dª idade: ", i+1);
            idade = scan.nextLine();

            while(!ehInteiro(idade)) {
                System.out.printf("Digite a %dª idade: ", i+1);
                idade = scan.nextLine();
            }

            nomes[i] = nome;
            idades[i] = Integer.parseInt(idade);
            somaIdades += Integer.parseInt(idade);

            System.out.println();
        }
        
        // selectionSort zuado que eu fiz:
        int auxIdade;
        String auxNome;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                //idades[j] > idades[i]: ordem crescente.
                //idades[i] > idades[j]: ordem decrescente.
                if(idades[i] > idades[j]) {
                    auxIdade = idades[j];
                    idades[j] = idades[i];
                    idades[i] = auxIdade;

                    auxNome = nomes[j];
                    nomes[j] = nomes[i];
                    nomes[i] = auxNome;
                }
            }
        }

        System.out.printf("Mais novo: %s, tem %d anos.%n", nomes[nomes.length - 1], idades[idades.length - 1]);
        System.out.printf("Mai velho %s, tem %d anos.%n", nomes[0], idades[0]);
        System.out.printf("Média das idades = %.1f", somaIdades/5.0);
    }

    static boolean ehInteiro(String value) {
        try {
            int x = Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
