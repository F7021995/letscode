package hardware;

import categorias.abstracoes.Produto;
import categorias.interfaces.Hardware;

import java.math.BigDecimal;

public class Processador extends Produto<Processador> implements Hardware {
    private String velocidade;
    private int numeroProcessadores;

    public Processador(String marca, String modelo, BigDecimal preco,
                       String velocidade, int numeroProcessadores) {
        super(marca, modelo, preco);
        this.setVelocidade(velocidade)
                .setNumeroProcessadores(numeroProcessadores);
    }

    public String getVelocidade() {
        return velocidade;
    }

    public Processador setVelocidade(String velocidade) {
        this.velocidade = velocidade;
        return this;
    }

    public int getNumeroProcessadores() {
        return numeroProcessadores;
    }

    public Processador setNumeroProcessadores(int numeroProcessadores) {
        this.numeroProcessadores = numeroProcessadores;
        return this;
    }
}
