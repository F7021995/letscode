package exercicio1;

import java.util.Scanner;

public class CelsiusFarenheit {

    // Conveter Celsius para Farenheit
    public static void main(String[] args) {
        double celsius;
        double fahrenheit;

        Scanner scan = new Scanner(System.in);

        // Sem verificação se é de fato um número.
        System.out.print("Digite a temperatura em Celsius: ");
        celsius = Double.parseDouble(scan.nextLine());

        fahrenheit = (celsius * 9/5) + 32;

        System.out.printf("%s ºC = %s ºF", celsius, fahrenheit);
    }

}
