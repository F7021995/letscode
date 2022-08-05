package game;

import java.io.IOException;
import java.security.SecureRandom;

public class Plantacao {

    protected Lagar lagar;
    private String nome;

    private boolean acaboTempo;

    enum TipoAzeitona {

    }

    public Plantacao(Lagar lagar, String nome) {
        this.lagar = lagar;
        this.nome = nome;
    }

    public void carregaCaminhoes() {
        new Thread(() -> {
            long milis = System.currentTimeMillis();
            do {
                int tempoCarregamento = new SecureRandom().nextInt(7) * 1000;

                /*
                 * Quando lagar não estará disponível?
                 * Quando a fila de caminhões for >= 12
                 */
                if (!this.lagar.isDisponivel) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                /*
                 * Cada caminhão possui um tempo de carregamento, isso é outro Thread.sleep();
                 */
                try {
                    this.lagar.addCaminhao(new Caminhao(2, this));
                    Thread.sleep(tempoCarregamento);
                    this.lagar.recebeCaminhao();
                } catch (InterruptedException | IOException e) {
                    throw new RuntimeException(e);
                }
            } while (System.currentTimeMillis() - milis < 20_000);
        }).start();
    }
}