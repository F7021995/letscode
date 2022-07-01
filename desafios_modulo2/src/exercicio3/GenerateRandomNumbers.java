package exercicio3;

import java.security.SecureRandom;

public class GenerateRandomNumbers {

    public static void main(String[] args) {
        int qtdValores = 200;
        Integer[] inteiros = generateIntValues(qtdValores);
        Double[] fracionados = generateDoubleIntervalue(qtdValores);

        for (int i = 0; i < inteiros.length; i++) {
            String out;
            String inteiro;

            out = inteiros[i] < 10 ?
                    String.format("0%d %.2f", inteiros[i], fracionados[i]) :
                    String.format("%d %.2f", inteiros[i], fracionados[i]);

            if((i+1) % 5 == 0) {
                System.out.printf(out);
                System.out.println();
            }
            else {
                out += " ... ";
                System.out.printf(out);
            }
        }

        /**
         *  Duas coisas a saber:
         *      Gerar valores inteiros não precisa de start e end.
         *      Gerar valores doubles/floats precisa de start e end.
         *
         *  Qual a diferença:
         *      nextDouble: vai de 0.00000000 até 0.999999999
         *      nextInt: vai de -2 bilhões até +2 bilhões (os máximos do inteiro).
         *
         *  Matemática:
         *      Inteiro (na programação) tem valores finitos (4 bilhões, -2bilhões a +2bihlões).
         *      Double tem infinitos valores. Entre 2 e 3 tem infinitos valores...
         *
         *  Sabendo disso:
         *      Não preciso dizer intervalo entre Integer, preciso dizer um máximo.
         *      Preciso dizer um intervalo start e end para double.
         */
    }

    static Integer[] generateIntValues(int qtdValues) {
        Integer[] valores = new Integer[qtdValues];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = new SecureRandom().nextInt(100);
        }

        return valores;
    }

    static Double[] generateDoubleIntervalue(int qtdValues) {
        Double[] alturas = new Double[qtdValues];

        double start = 0.5;
        double end = 2.5;

        for (int i = 0; i < alturas.length; i++) {
            // Isso é uma fórmula padrão para encontrar intervalo de double/float.
            alturas[i] = start + (new SecureRandom().nextDouble() * (end - start));
        }

        return alturas;
    }
}
