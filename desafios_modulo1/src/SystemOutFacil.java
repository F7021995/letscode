import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class SystemOutFacil {

    /**
     * import static java.lang.System.out;
     * Permite fazer: out.println() ao invés de System.out.println()
     */
    public static void main(String[] args) {
        String[] nomes = {"A", "B", "C", "D", "E"};
        Double[] pesos = {70.3, 55.6, 65.0, 80.0, 90.0};
        Double[] alturas = {1.70, 1.60, 1.75, 1.80, 1.85};

        Pessoa[] pessoas = new Pessoa[5];

        for (int i = 0; i < 5; i++) {
            pessoas[i].setNome(nomes[i]);
            pessoas[i].setPeso(pesos[i]);
            pessoas[i].setAltura(alturas[i]);

            Double imc = pessoas[i].getPeso() / sqrt(pessoas[i].getAltura());

            if (imc < 18.5 || imc > 25) {
                out.printf("%s seu IMC é %.1f %n", pessoas[i].getNome(), imc);
                out.println("Você não possui IMC ideal (entre 18.5 e 25)");
            }
        }
    }

    void programaMuitoSystemOut() {
        out.println("print fácil");
        out.println("Importando static ...System.out; dá pra facilitar o print");
        out.println("Muitos");
        out.println("Prints");
        out.println("Assim");
        out.println("É bom importar o static System.out");
    }

}


class Pessoa {

    public void setNome(String nome) {
    }

    public void setPeso(Double peso) {
    }

    public double getAltura() {
        return 3.9;
    }

    public Double getPeso() {
        return 3.0;
    }

    public Object getNome() {
        return "meu nome";
    }

    public void setAltura(Double altura) {
    }

}