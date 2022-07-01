import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class cMyOwnLists {

    /**
     *  Objetivo desse método: transformar um array genérico em uma lista genérica ordenada.
     *  T é o genérico, a lista será desse tipo genérico.
     *  Será passado um array de T para retorna uma lista de T ordenada.
     */
    public static <T> List<T> asListedSorted(T[] arrayElementos, Comparator<T> comparator) {
        List<T> lista = Arrays.asList(arrayElementos);
        lista.sort(comparator);
        return lista;
    }


    /**
     *  Usei diferentes formas para ordernar só para testar conhecimento...
     *  Comparator e Comparable são duas interfaces que servem para ordenar as coisas.
     */
    public static void main(String[] args) {
        // Teste usando o mesmo método para ordenar classes diferentes.
        List<String> strings = cMyOwnLists.asListedSorted(new String[]{"ba2", "se123a", "ac"}, Comparator.naturalOrder());
        System.out.println(strings);

        List<Integer> numeros = cMyOwnLists.asListedSorted(new Integer[]{3, 5, 1, 2, 3, 4}, Comparator.reverseOrder());
        System.out.println(numeros);

        // Diferentes formas de ordenação.
        ordenarComClasseAnonima();
        ordenarImplementandoAsInterfaces();
        ordenarLambdasOuReference();
    }


    /**
     * Formas diferentes de ordenação.
     * a) Classe Anônima
     * b) Interfaces: Comparator e Comparable, implementar seus métodos.
     * c) Lambda
     * d) Método Reference
     */
    static void ordenarComClasseAnonima() {
        // Ordenar usando classe anônima.
        List<Emprego> empregadoList =
                cMyOwnLists.asListedSorted(
                        new Emprego[]{new Emprego(3), new Emprego(1)},
                        new Comparator<Emprego>() {
                            @Override
                            public int compare(Emprego o1, Emprego o2) {
                                return Integer.compare(o1.getCodigo(), o2.getCodigo());
                            }
                        }
                );
        System.out.println("Usando classe anônima: " + empregadoList);
    }

    static void ordenarImplementandoAsInterfaces() {
        // Ordenando crescente.
        List<Emprego> empregadoList =
                cMyOwnLists.asListedSorted(
                        new Emprego[]{new Emprego(3), new Emprego(1)},
                        new Comparator<Emprego>() {
                            @Override
                            public int compare(Emprego o1, Emprego o2) {
                                return Integer.compare(o1.getCodigo(), o2.getCodigo());
                            }
                        }
                );

        // Ordenando decrescente.
        // Collections.sort() usa Comparable para ordenar com 1 parâmetro.
        // Como já fiz a implementação da interface Comparable em Empregado, ele consegue ordenar desse jeito.
        Collections.sort(empregadoList);
        System.out.println("Usando Collections e Comparable: " + empregadoList);

        // Ordenando decrescente.
        // Ordenar dessa forma com um objeto usa Comparator
        empregadoList.sort(new EmpregadoComparator());
        System.out.println("Usando classe auxiliar que implementa Comparator: " + empregadoList);
    }

    static void ordenarLambdasOuReference() {
        // Ordenar usando lambda.
        List<Emprego> empregadoList1 =
                cMyOwnLists.asListedSorted(
                        new Emprego[]{new Emprego(3), new Emprego(1)},
                        (e1, e2) -> Integer.compare(e1.getCodigo(), e2.getCodigo())
                );

        // Essa comparação funciona, mas está errada.
        // Não use 'Comparator.comparing' para ordenar inteiros...
        // Ele usa boxing e unboxing sem necessidade.
        List<Emprego> empregadoList2 =
                cMyOwnLists.asListedSorted(
                        new Emprego[]{new Emprego(3), new Emprego(1)},
                        Comparator.comparing(Emprego::getCodigo)
                );

        // Esse é o Comparator para comparar inteiros. Comparator.comparingint
        List<Emprego> empregadoList3 =
                cMyOwnLists.asListedSorted(
                        new Emprego[]{new Emprego(3), new Emprego(1)},
                        Comparator.comparingInt(Emprego::getCodigo)
                );
    }


}
class Emprego implements Comparable<Emprego> {
    private final int codigo;

    public Emprego(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Emprego{" +
                "codigo=" + codigo +
                '}';
    }

    @Override
    public int compareTo(Emprego o) {
        return Integer.compare(o.getCodigo(), this.codigo);
    }
}

/**
 *  Com isso eu posso fazer o sort.
 */
class EmpregadoComparator implements Comparator<Emprego> {

    /*
     *  EmpregadoComparator<Empregado> implements Comparator<Empregado>: está errado.
     *      Empregado, nessa situação, seria o apelido... o <T>... não confunda isso.
     *  EmpregadoComparator implements Comparator<Empregado>: está correto.
     */

    @Override
    public int compare(Emprego o1, Emprego o2) {
        return Integer.compare(o2.getCodigo(), o1.getCodigo());
    }
}
