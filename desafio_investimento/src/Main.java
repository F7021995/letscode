import cliente.Arrojado;
import cliente.Conservador;
import cliente.Moderado;
import investimento.Investimento;
import rendaFixa.CDB;
import rendaFixa.RendaFixa;
import rendaFixa.Tesouro;
import rendaVariavel.Acao;
import rendaVariavel.FundoImobiliario;
import rendaVariavel.RendaVariavel;

public class Main {

    public static void main(String[] args) {
        Arrojado<RendaVariavel> arrojado = new Arrojado<>();

        arrojado.contratarInvestimento(new Acao());
        // arrojado.contratarInvestimento(new CDB());

        Conservador<RendaFixa> conservador = new Conservador<>();
        conservador.contratarInvestimento(new CDB());
        // conservador.contratarInvestimento(new Acao());

        Moderado<Investimento> moderado = new Moderado<>();
        moderado.contratarInvestimento(new CDB());
        moderado.contratarInvestimento(new Acao());
        moderado.contratarInvestimento(new Tesouro());
        moderado.contratarInvestimento(new FundoImobiliario());


        for (Investimento i : arrojado.getCarteiraInvestimento()) {
            System.out.print(i + ", ");
        }
        System.out.println();

        for (Investimento i : conservador.getCarteiraInvestimento()) {
            System.out.println(i + ", ");
        }
        System.out.println();

        for (Investimento i : moderado.getCarteiraInvestimento()) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

}