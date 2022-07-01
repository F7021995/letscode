package veiculo;

import categorias.abstracoes.Veiculo;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.PublicoAlvo;
import categorias.enums.TipoVeiculo;

import java.math.BigDecimal;

// OK
public class Bicicleta extends Veiculo<Bicicleta> {
    private boolean portaBagagem;
    private boolean campainha;
    private int aro;

    public Bicicleta(String marca, String modelo, BigDecimal preco,
                     Genero genero, FaixaEtaria faixaEtaria, PublicoAlvo publicoAlvo,
                     TipoVeiculo tipoVeiculo,
                     boolean portaBagagem, boolean campainha, int aro) {
        super(marca, modelo, preco, genero, faixaEtaria, publicoAlvo, tipoVeiculo);
        // Posso fazer os inserts dessa forma... por estar retornando this.
        // aro é o primeiro, se vier um valor inválido já termina a execução.
        this.setAro(aro).setPortaBagagem(portaBagagem).setCampainha(campainha);
    }

    public boolean isPortaBagagem() {
        return portaBagagem;
    }

    public Bicicleta setPortaBagagem(boolean portaBagagem) {
        this.portaBagagem = portaBagagem;
        return this;
    }

    public boolean isCampainha() {
        return campainha;
    }

    public Bicicleta setCampainha(boolean campainha) {
        this.campainha = campainha;
        return this;
    }

    public int getAro() {
        return aro;
    }

    public Bicicleta setAro(int aro) throws IllegalArgumentException {
        if (isAroValid(aro)) {
            this.aro = aro;
            return this;
        }
        throw new IllegalArgumentException("Aro das notas bicicletas vão de 12 a 30.");
    }

    /**
     * Menor aro de uma bicicleta é 12.
     * Maior aro eu não sei... coloquei 30.
     */
    private boolean isAroValid(int aro) {
        return (aro >= 12 && aro <= 30);
    }

}