package categorias.abstracoes;

import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;

import java.math.BigDecimal;

/**
 * Vestuario são produtos... Todos os filhos de vestuário deve ter os dados de um produto.
 */
public abstract class Vestuario<T extends Vestuario<T>> extends Produto<T> {

    private Genero genero;
    private FaixaEtaria faixaEtaria;

    public Vestuario(String marca, String modelo, BigDecimal preco, Genero genero, FaixaEtaria faixaEtaria) {
        super(marca, modelo, preco);
        this.setGenero(genero).setFaixaEtaria(faixaEtaria);
    }

    public Genero getGenero() {
        return genero;
    }

    public Vestuario<T> setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public Vestuario<T> setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        return this;
    }
}