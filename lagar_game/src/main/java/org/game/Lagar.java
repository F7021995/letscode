package game;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Lagar {

    protected boolean isDisponivel = true;
    private final Queue<Caminhao> caminhao = new LinkedBlockingDeque<>();

    public Lagar(LocalDate localDate) throws IOException {
        Relatorio.construirArquivo(localDate);
    }

    protected void addCaminhao(Caminhao caminhao) throws InterruptedException, IOException {
        int quantidadeMaximaCaminhoes = 12;
        if (this.caminhao.size() <= quantidadeMaximaCaminhoes) {
            System.out.println("Adicionando caminhão à QUEUE: " + caminhao);

            this.caminhao.add(caminhao);
            new Relatorio().escreverArquivo("Carregando caminhão: ", caminhao, LocalTime.now());
        } else {
            this.isDisponivel = false;
        }
    }

    protected void recebeCaminhao() throws IOException {
        new Thread(() -> {
            System.out.println("Recebendo caminhão após tempo de descarga... ");
            try {
                new Relatorio().escreverArquivo(
                        "Recebendo Caminhão",
                        Objects.requireNonNull(this.caminhao.poll()), LocalTime.now());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.isDisponivel = true;
        }).start();
    }

}