package timefutebol;

import java.util.List;

public class Time {
    String nome;
    List<Jogador> jogadores;

    public Time(String nome, List<Jogador> jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

}