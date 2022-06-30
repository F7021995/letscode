package hardware;

import categorias.abstracoes.Produto;
import categorias.enums.MemoriaUsadaEm;
import categorias.interfaces.Hardware;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoriaRam extends Produto<MemoriaRam> implements Hardware {

    private static final Set<String> tiposMemoria = new HashSet<>(List.of("DDR3", "DDR4", "DDR5"));
    private static final Set<Integer> velocidadeMemoria = new HashSet<>(List.of(2100, 2400, 3200, 3300));
    private int capacidade;
    private int velocidade;
    private String tipo;
    private MemoriaUsadaEm memoriaUsadaEm;

    public MemoriaRam(String marca, String modelo, BigDecimal preco,
                      int capacidade, int velocidade,
                      String tipo, MemoriaUsadaEm memoriaUsadaEm) throws Exception {
        super(marca, modelo, preco);
        this.setCapacidade(capacidade)
                .setVelocidade(velocidade)
                .setTipo(tipo)
                .setUsadaEm(memoriaUsadaEm);
    }

    public MemoriaUsadaEm getUsadaEm() {
        return memoriaUsadaEm;
    }

    public MemoriaRam setUsadaEm(MemoriaUsadaEm memoriaUsadaEm) {
        this.memoriaUsadaEm = memoriaUsadaEm;
        return this;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public MemoriaRam setCapacidade(int capacidade) throws Exception {
        if (!ehPotenciaDois(capacidade)) {
            throw new Exception("RAM deve ser 4, 8, 16, 32...");
        }
        this.capacidade = capacidade;
        return this;
    }

    /**
     * Capacidade da memória são números potência de 2.
     * Usando bitwise para dizer se é potencia de 2.
     * Se n & n-1 for 0000 (binário): temos uma potência de 2.
     */
    private boolean ehPotenciaDois(int valor) {
        return (valor & valor - 1) == 0;
    }

    public String getVelocidade() {
        return velocidade + " Mhz";
    }

    /**
     * Tenho que ver as velocidade das memórias.
     */
    public MemoriaRam setVelocidade(int velocidade) throws IllegalArgumentException {
        if (!MemoriaRam.velocidadeMemoria.contains(velocidade)) {
            throw new IllegalArgumentException("Nossas velocidades de ram são apenas 2100, 2400 e 3200");
        }

        this.velocidade = velocidade;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    /**
     * Tipo de memória só pode ser DDR3, DDR4, DDR5.
     */
    public MemoriaRam setTipo(String tipo) throws Exception {
        if (!tiposMemoria.contains(tipo.toUpperCase().trim())) {
            throw new Exception("Só trabalhamos com memória do tipo: DDR3, DDR4 ou DDR5");
        }

        this.tipo = tipo.toUpperCase().trim();
        return this;
    }

}