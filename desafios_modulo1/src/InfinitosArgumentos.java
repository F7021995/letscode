import static java.lang.System.out;

public class InfinitosArgumentos {

    public static void main(String[] args) {
        testarArgumentos(1, new int[]{1, 2, 3, 4, 5, 6});

        out.println();

        outrosArgumentos(1, 10, 22, 33, 44, 5, 6, 87, 0, 3);
    }

    static void testarArgumentos(int a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            if(i > 0) {
                out.print(", ");
            }
            out.print("Alô: " + i);
        }
    }

    static void outrosArgumentos(int a, int... b) {
        for (int i = 0; i < b.length; i++) {
            if(i > 0) {
                out.print(", ");
            }
            out.print("Alô: " + b[i]);
        }
    }

}
