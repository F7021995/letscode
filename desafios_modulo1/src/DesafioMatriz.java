import static java.lang.System.out;

public class DesafioMatriz {

    public static void main(String[] args) {
        int[][] matriz = {{3, 4, 5}, {3, 7, 8}, {9, 6, 2}};

        // Imprimir todos os elementos
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.printf("%d \t", matriz[i][j]);
            }
            out.println();
        }
        out.println();

        // imprimir inverso
        for (int i = 2; i >= 0 ; i--) {
            for (int j = 2; j >= 0 ; j--) {
                out.printf("%d \t", matriz[i][j]);
            }
            out.println();
        }
        out.println();

        // Imprimir matriz diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j) {
                    out.printf("%d", matriz[i][j]);
                }
                else {
                    out.print("\t");
                }
            }
            out.println();
        }
        out.println();

        // Parte inferior da matriz diagonal
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i > j) {
                    out.printf("%d", matriz[i][j]);
                    out.print("\t");
                }
                else {
                    out.print("\t");
                }
            }
            out.println();
        }
    }

}
