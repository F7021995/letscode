package exercicio2;

import java.util.Scanner;

public class CincoConvidados {

    //lê o nome de 5 pessoas e armazena numa lista de convidados. Ao final, informe qual o nome mais longo presente na lista.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] convidados = new String[5];
        String digitado;

        for (int i = 0; i < 5; i++) {
            System.out.printf("Informe o %dº convidado: ", i+1);
            digitado = scan.nextLine();

            while(digitado.equals("")) {
                System.out.printf("Informe o %dº convidado: ", i+1);
                digitado = scan.nextLine();
            }

            convidados[i] = digitado;
        };

        /**
         * Isso que eu fiz foi quase um algoritmo de seleção:
         *      Eu to ordenando decrescente.
         *      To fazendo coisa sem necessidade aí.
         *      Não preciso ir de 0 a 5 nos dois fors.
         */
        String aux;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(convidados[i].length() > convidados[j].length()) {
                    aux = convidados[j];
                    convidados[j] = convidados[i];
                    convidados[i] = aux;
                }
            }
        }

        System.out.printf("Maior nome desses 5: %s ", convidados[0]);
    }

}
