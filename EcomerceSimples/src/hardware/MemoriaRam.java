package hardware;

import java.util.Arrays;

public class MemoriaRam {

    enum UsadaEm {
        COMPUTADOR,
        NOTEBOOK;
    }

    String marca;
    String modelo;
    UsadaEm usadaEm;
    int capacidade;
    int frequencia;
    String tipo;

    public MemoriaRam(String marca, String modelo, int capacidade, int frequencia, String tipo, UsadaEm usadaEm) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.frequencia = frequencia;
        this.tipo = tipo;
        this.usadaEm = usadaEm;
    }

    public String getMarca() {
        return marca;
    }

    public MemoriaRam setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public MemoriaRam setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public UsadaEm getUsadaEm() {
        return usadaEm;
    }

    public MemoriaRam setUsadaEm(UsadaEm usadaEm) {
        this.usadaEm = usadaEm;
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

    public int getFrequencia() {
        return frequencia;
    }

    public MemoriaRam setFrequencia(int frequencia) {
        this.frequencia = frequencia;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public MemoriaRam setTipo(String tipo) throws Exception {
        if (!Arrays.asList("DDR3", "DDR4", "DDR5").contains(tipo)) {
            throw new Exception("DDR3, DDR4 ou DDR5");
        }

        this.tipo = tipo;
        return this;
    }

    /**
     * Usando bitwise para dizer se é potencia de 2
     * Se n & n-1 for 0000 (binário): temos uma potência de 2.
     */
    private boolean ehPotenciaDois(int valor) {
        return (valor & valor-1) == 0;
    }
}