public class IntervaloSoma {

    public static void main(String[] args) {
        valoresIntervalo(1, 2);
        usandoIfIntervalo(-8, 3);
    }

    /**
     * Encontrando maior e menor usando Math.min ou Math.max
     */
    private static void valoresIntervalo(int x, int y) {
        int menor = Math.min(x, y);
        int maior = Math.max(x, y);

        for (int i = menor; i <= maior; i++) {
            if(i > menor) {
                System.out.print(", ");
            }
            System.out.print(i);
        }
        System.out.println();

        somarUsandoPA(menor, maior);
        somarUsandoFor(menor, maior);

        // Daria pra usar Integer.min, Double.min, Float.min...
        menor = Integer.min(x, y);
        maior = Integer.max(x, y);

    }

    /**
     * Encontrando maior e menor usando ternário.
     * Encontrando maior e menor usando if comum.
     */
    private static void usandoIfIntervalo(int x, int y) {
        // usando ternário.
        int menor = x <= y  ? x : y;
        int maior = x >=y ? x : y;

        System.out.println("menor: " + menor + ", maior: " + maior);

        //usando if normal.
        if (x <= y) {
            menor = x;
            maior = y;
        }
        else {
            menor = y;
            maior = x;
        }

        System.out.println("menor: " + menor + ", maior: " + maior);

    }

    /**
     * Somatório de uma sequência usando Progressão arimética.
     * (menor + maior) * qtd / 2;
     */
    private static void somarUsandoPA(int menor, int maior) {
        // PA = ((menor + maior) * qtdelementos) / 2
        int soma = maior + menor;
        int qtdElementos = (maior - menor) + 1;
        int prograssaoAritmetica = (soma * qtdElementos) / 2;
        System.out.println("Soma sequência usando PA: " + prograssaoAritmetica);
    }

    /**
     * Somatório de uma sequência usando for.
     * Inicia no menor valor... vai até o maior valor somando esses valores.
     */
    private static void somarUsandoFor(int menor, int maior) {
        // vai do menor até o maior (<=)
        int soma = 0;
        for (int i = menor; i <= maior; i++) {
            soma += i;
        }

        System.out.println("Soma usando FOR: " + soma);
    }
}
