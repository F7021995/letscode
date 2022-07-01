import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

public class ListaUnicaOrdenada {

    /**
     * Achei que era para fazer uma List<> com valores únicos.
     * Posso usar Set<> que já faz isso por mim.
     * A lógica aqui foi usando List
     */
    public static void main(String[] args) {
        // quantidade de elementos também é gerada aleatoriamente, entre 0 a 30.
        int qtdElementos = new SecureRandom().nextInt(30);

        /*
         * inicializando as duas listas, vai usar a qtdElementos para gerar números aleatórios (de 0 até qtdElementos)
         * é o aleatório do aleatório... fez sentido?
         * @qtdElementos é aleatório de 0 até o número que eu quizer (nesse caso foi 30).
         * Os elementos da lista são também aleatórios, só que de 0 até qtdElementos (que foi gerado aleatoriamente)
         */

        List<Integer> lista1 = new ListaUnicaOrdenada().inicializarUmaLista(qtdElementos);
        List<Integer> lista2 = new ListaUnicaOrdenada().inicializarUmaLista(qtdElementos);
        imprimirListasOriginais(lista1, lista2);

        // Juntando as listas e imprimir antes e depois.
        List<Integer> lista3 = juntarDuasListasSemVerficacao(lista1, lista2);

        // Imprimir o antes e o depois (valores repetidos e valores distintos):
        System.out.println("***************************************");
        imprimirLista3(lista3, "Lista3 sem nenhuma alteração: ");
        lista3 = listaAgirComoSet(lista3);
        imprimirLista3(lista3, "Lista3 (agindo como set, removendo os iguais): ");
        System.out.println("***************************************");
        System.out.println();

        // Forma mais fácil de ordenar:
        lista3.sort(Integer::compare); // Ordenar inteiros de forma crescente.
        lista3.sort((a1, a2) -> Integer.compare(a1, a2)); // Isso é exatamente o Integer::compare

        lista3.sort((a1, a2) -> Integer.compare(a2, a1)); // Ordenar forma decrescente (troquei a2 e a1 de lugar).
        System.out.println("Ordenando inteiro fácil: " + lista3);

        // Três formas diferentes de ordenar uma lista... (não precisa usar as 3 formas, só pra eu saber que existem).

        // Criando cópia da mesma lista para testar diferentes tipos de ordenação.
        List<Integer> listaOrdenarComparator    = juntarDuasListasSemVerficacao(lista1, lista2);
        List<Integer> listaOrdenarLambda        = juntarDuasListasSemVerficacao(lista1, lista2);
        List<Integer> listaOrndearClasseAnonima = juntarDuasListasSemVerficacao(lista1, lista2);

        // Não fiz cópia das duas próximas lista... estou alterando a própria lista, pois passo a referência no parâmetro.
        ordenarListaDescComparator(listaOrdenarComparator);
        System.out.println("Lista3 ordenada comparator: " + listaOrdenarComparator);

        ordenarListaDescLambda(listaOrdenarLambda);
        System.out.println("Lista3 ordenada lambda: " + listaOrdenarLambda);

        ordenarListaDescClasseAnonima(listaOrndearClasseAnonima);
        System.out.println("Lista3 ordenada classe anônima: " + listaOrndearClasseAnonima);
    }

    /**
     * Até a quantidade de elementos que uma lista terá é aleatório.
     * Não vou criar uma lista com 0 elementos, por isso preciso adicionar + 1.
     */
    private ArrayList<Integer> inicializarUmaLista(int qtdElementos) {
        return randomizarLista(new SecureRandom().nextInt(qtdElementos + 1));
    }

    /**
     * Randozimar os valores inteiros de uma lista.
     * {@qtdElementos} é gerado aleatoriamente também (0 até número que eu disser).
     */
    private ArrayList<Integer> randomizarLista(int qtdElementos) {
        ArrayList<Integer> randomizedList = new ArrayList<>(qtdElementos);
        for (int i = 0; i < qtdElementos; i++) {
            randomizedList.add(new SecureRandom().nextInt(qtdElementos));
        }
        return randomizedList;
    }

    /**
     *  Faça uma 'cópia de verdade' da lista1 para não alterar a original.
     *  Depois adicione toda a lista2 na lista1.
     */
    static List<Integer> juntarDuasListasSemVerficacao(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> retorno = new ArrayList<>(lista1);
        retorno.addAll(lista2);
        return retorno;
    }

    /**
     *  Três formas de pegar apenas os valores únicos.
     *  1) usando 'for comum' ou 'for enhanced'
     *  2) usando 'forEach'
     *  3) usando 'stream'
     */
    static List<Integer> listaAgirComoSet(List<Integer> lista) {
        List<Integer> auxiliar = new ArrayList<>();
        for (Integer numero : lista) {
            if (!auxiliar.contains(numero)) {
                auxiliar.add(numero);
            }
        }
        return auxiliar;
    }

    static List<Integer> listaUnicaUsandoForEach(List<Integer> lista) {
        List<Integer> apenasDistintos = new ArrayList<>();
        lista.forEach(value -> {
            if(!apenasDistintos.contains(value)) {
                apenasDistintos.add(value);
            }
        });
        return apenasDistintos;
    }

    static List<Integer> listaUnicaUsandoStream(List<Integer> lista) {
        return lista.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Três formas de ordenar uma lista
     * 1) usando classe anônima.
     * 2) usando lambda.
     * 3) usando Comparator
     */
    static List<Integer> ordenarListaDescClasseAnonima(List<Integer> lista) {
        // Ordenando decrescente. usando classe anônima.
        lista.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        return lista;
    }

    static List<Integer> ordenarListaDescLambda(List<Integer> lista) {
        // Ordenando usando Lambda.
        lista.sort((o1, o2) -> Integer.compare(o2, o1));
        return lista;
    }

    static List<Integer> ordenarListaDescComparator(List<Integer> lista) {
        // Ordenando usando comparador reverseOrder()
        lista.sort(Comparator.reverseOrder());
        return lista;
    }

    /**
     *  Só pra não deixar essa impressão no main.
     */
    static void imprimirListasOriginais(List<Integer> lista1, List<Integer> lista2) {
        System.out.println();
        System.out.println("***************************************");
        System.out.println("Listas randomizadas sem tratamento algum:");
        System.out.println("Lista1: " + lista1);
        System.out.println("Lista2: " + lista2);
        System.out.println("***************************************");
        System.out.println();
    }

    static void imprimirLista3(List<Integer> list, String texto) {
        System.out.println(texto + " "+ list);
    }

}