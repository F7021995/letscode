package timefutebol;

public class Jogador {
    private String nome;
    private Tipo posicao;

    public Jogador(String nome, Tipo posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public Tipo getPosicao() {
        return posicao;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", posicao=" + posicao +
                '}';
    }
}
