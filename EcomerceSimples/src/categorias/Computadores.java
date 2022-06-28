package categorias;

import javax.swing.text.NumberFormatter;
import java.text.Format;
import java.util.Formatter;

public interface Computadores {
    Double getPreco();

    // todo: tentar fazer um método default que funciona para todos computadores.
    default String formatarPreco(Double preco) {
        NumberFormatter numberFormatter = new NumberFormatter();
        return "R$ " + preco + ",00";
    }
}
