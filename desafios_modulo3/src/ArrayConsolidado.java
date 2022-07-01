import java.util.Arrays;

public class ArrayConsolidado {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6, 8};
        int[] arrayConsolidade = new int[0];

        System.out.println();
        System.out.println("************ Sem usar System.arraycopy ***************");
        juntarArrays(array1, array2, arrayConsolidade);
        System.out.println();
        System.out.println("******************************************************");

        System.out.println();
        System.out.println("*********** Usando System.arraycopy ******************");
        usandoMetodoSystem(array1, array2, arrayConsolidade);
        System.out.println("******************************************************");
    }

    private static void juntarArrays(int[] array1, int[] array2, int[] arrayConsolidado) {
        int qtdArray1 = array1.length;
        int qtdArray2 = array2.length;
        int somaTotal = qtdArray1 + qtdArray2;
        arrayConsolidado = new int[somaTotal];

        // Jeito simples... fazendo dois for, um para cada.
        for (int i = 0; i < qtdArray1; i++) {
            arrayConsolidado[i] = array1[i];
        }

        // qtdArray1 se der 4, tem 3 índices apenas (preciso do -1)
        // somaTotal se der 8, tem 7 índices apenas (preciso do -1)
        // preciso de j = 0, pois array2 inicia da posição 0, apenas arrayConsolidado em outra posição.
        for (int i = qtdArray1 - 1, j = 0; i < somaTotal - 1; i++, j++) {
            arrayConsolidado[i] = array2[j];
        }

        ordenarArrays(arrayConsolidado);
    }

    private static void ordenarArrays(int[] arrayConsolidado) {
        // Ordenando array usando Arrays... Mas não pode usar java.util.Arrays.
        Arrays.sort(arrayConsolidado);
        System.out.println("Ordenando usando Arrays.sort(): " + Arrays.toString(arrayConsolidado));

        // Usando arrays.stream()... Mas mesmo assim usa o pacote java.util.Arrays.
        arrayConsolidado = Arrays.stream(arrayConsolidado).sorted().toArray();
        System.out.println("Ordenando usando Arrays.stream(): " + Arrays.toString(arrayConsolidado));

        // Usando um 'selection sort zuado' pra ordenar isso dai.
        for (int i = 0; i < arrayConsolidado.length; i++) {
            for (int j = i + 1; j < arrayConsolidado.length; j++) {
                // Se o anterior for maior que o próximo... empurra o anterior para frente.
                if (arrayConsolidado[i] > arrayConsolidado[j]) {
                    int aux = arrayConsolidado[j];
                    arrayConsolidado[j] = arrayConsolidado[i];
                    arrayConsolidado[i] = aux;
                }
            }
        }

        System.out.print("Imprimindo Array usando loop: ");
        // Usando loop para imprimir essa bosta
        for (int i = 0; i < arrayConsolidado.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(arrayConsolidado[i]);
        }
    }

    /**
     * Outra forma de fazer uma cópia do array... Usando System.arraycopy()
     */
    private static void usandoMetodoSystem(int[] array1, int[] array2, int[] arrayConsolidado) {

        arrayConsolidado = new int[array1.length + array2.length];

        // copia do array1 iniciando da posição 0 do array1
        // colocando no arrayConsolidado na posição 0 do array consolidado, o tamanho inteiro do array1.
        System.arraycopy(array1, 0, arrayConsolidado, 0, array1.length);
        System.out.println("Primeira parte da cópia usando arraycopy: " + Arrays.toString(arrayConsolidado));

        // copia do arary2 iniciado da posição que o array1 terminou (iniciando do seu length).
        // colocando no arrayConsolodado na posição que terminou (array1.length) a totalidade do array2.
        System.arraycopy(array2, 0, arrayConsolidado, array1.length, array2.length);
        System.out.println("Segunda parte da cópia usando arraycopy: " + Arrays.toString(arrayConsolidado));

        Arrays.sort(arrayConsolidado);
        System.out.println("Ordenando usando Arrays.sort(): " + Arrays.toString(arrayConsolidado));
    }

}