package exercicio3;

public class InnerClasses {

    /**
     *  Quando usar isso:
     *      Inner class for algo muito específico.
     *      Se algo só existir em função de outra classe.
     */

    static class Pessoa {
        private static final String a = "Alo";

        public Pessoa() {
            System.out.println("Inner class");
        }
    }

    /**
     *  Isso é uma inner class:
     *      Faz sentido dentro de uma classe Pessoa.
     *      Gênero, muitas das vezes, só existe relacionado a pessoa.
     *
     *  Enums são final e static:
     *      Enums não possuem add e não podem ser instanciados.
     */

    protected enum genero {
        MASCULINO, FEMININO
    }

}

/**
 *  Duas coisas diferentes:
 *      Inner class só existe com a classe pai.
 *      Não há, nas boas práticas, instanciar algo dentro de outra instância.
 *      Por isso que em 99% dos casos classe dentro de classe é static
 *
 *  Classe Pessoa e Inner Classe Pessoa:
 *      Isso funciona, pode ter uma inner class com o mesmo nome de uma classe.
 */

