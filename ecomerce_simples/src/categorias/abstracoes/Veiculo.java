package categorias.abstracoes;

import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.PublicoAlvo;
import categorias.enums.TipoVeiculo;

import java.math.BigDecimal;

/**
 * Veículo aqui não é motorizado: carro, moto, ônibus...
 * Veículo aqui é 'brinquedo': bicicleta, patinete, monocículo, skate, patins...
 */
public abstract class Veiculo<T extends Veiculo<T>> extends Produto<Veiculo<T>> {
    // Pra que esse monte de extends aí? é pra fazer algo mais funcional.
    // permitir que as classes filhas retornem o 'this' nos sets e possam fazer set().set().set()....

    private Genero genero;
    private FaixaEtaria faixaEtaria;
    private PublicoAlvo publicoAlvo;
    private TipoVeiculo tipoVeiculo;

    /**
     * Bicicletas, Patinetes, Skates, Patins...
     */
    public Veiculo(String marca, String modelo, BigDecimal preco,
                   Genero genero, FaixaEtaria faixaEtaria, PublicoAlvo publicoAlvo,
                   TipoVeiculo tipoVeiculo) {
        super(marca, modelo, preco);
        this.genero = genero;
        this.faixaEtaria = faixaEtaria;
        this.publicoAlvo = publicoAlvo;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Genero getGenero() {
        return genero;
    }

    public Veiculo<T> setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public Veiculo<T> setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        return this;
    }

    public PublicoAlvo getPublicoAlvo() {
        return publicoAlvo;
    }

    public Veiculo<T> setPublicoAlvo(PublicoAlvo publicoAlvo) {
        this.publicoAlvo = publicoAlvo;
        return this;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public Veiculo<T> setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
        return this;
    }

}