package game;

import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws IOException {
        Lagar lagar = new Lagar(LocalDate.now());
        /*
         * Aqui eu vou criar 5 threads que possuem while true.
         */

        var n = Executors.newFixedThreadPool(5);
        n.execute(() -> new Plantacao(lagar, "Plantação de Galega").carregaCaminhoes());
        n.execute(() -> new Plantacao(lagar, "Plantação de Galega").carregaCaminhoes());
        n.execute(() -> new Plantacao(lagar, "Plantação de Cordovil").carregaCaminhoes());
        n.execute(() -> new Plantacao(lagar, "Plantação de Cordovil").carregaCaminhoes());
        n.execute(() -> new Plantacao(lagar, "Plantação de Picual").carregaCaminhoes());

        n.shutdown();
    }

}