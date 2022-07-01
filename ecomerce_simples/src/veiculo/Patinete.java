package veiculo;

import categorias.abstracoes.Veiculo;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.PublicoAlvo;
import categorias.enums.TipoVeiculo;

import java.math.BigDecimal;

// OK
public class Patinete extends Veiculo<Patinete> {

    private int quantidadeRodas;
    private int duracaoBateriaHoras = 0;

    public Patinete(String marca, String modelo, BigDecimal preco,
                    Genero genero, FaixaEtaria faixaEtaria, PublicoAlvo publicoAlvo,
                    TipoVeiculo tipoVeiculo,
                    int quantidadeRodas, int duracaoBateriaHoras) {
        super(marca, modelo, preco, genero, faixaEtaria, publicoAlvo, tipoVeiculo);
        // Se for elétrico terá uma quantidade de horas, senão será 0 horas.
        this.setQuantidadeRodas(quantidadeRodas).setDuracaoBateriaHoras(duracaoBateriaHoras);
    }

    public int getQuantidadeRodas() {
        return quantidadeRodas;
    }

    /**
     * Patinete tem entre 2 a 4 rodas.
     * Patinete mínimo 2 horas e no máximo 4 horas.
     */
    public Patinete setQuantidadeRodas(int quantidadeRodas) throws IllegalArgumentException {
        if (isQuantidadeRodasValid(quantidadeRodas)) {
            this.quantidadeRodas = quantidadeRodas;
            return this;
        }

        throw new IllegalArgumentException("Vendemos patinetes de 2 a 4 rodas apenas");
    }

    private boolean isQuantidadeRodasValid(int quantidadeRodas) {
        return (quantidadeRodas >= 2 && quantidadeRodas <= 4);
    }

    public int getDuracaoBateriaHoras() {
        return duracaoBateriaHoras;
    }

    public Patinete setDuracaoBateriaHoras(int duracaoBateriaHoras) {
        // Se for manual: não tem bateria e já retorna.
        if (getTipoVeiculo() == TipoVeiculo.MANUAL) {
            this.duracaoBateriaHoras = 0;
            return this;
        }

        if (duracaoBateriaHoras > 0 && duracaoBateriaHoras < 12) {
            this.duracaoBateriaHoras = duracaoBateriaHoras;
            return this;
        }

        throw new IllegalArgumentException("Baterias dos nossos patinetes duram até 12 horas.");
    }

    private boolean isPatineteEletrico(TipoVeiculo tipoVeiculo) {
        return tipoVeiculo.equals(TipoVeiculo.ELETRICO);
    }

}