package vestuario;

import categorias.abstracoes.Vestuario;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.TipoMaterial;

import java.math.BigDecimal;

// OK
public class Calca extends Vestuario<Calca> {
    private TipoMaterial tipoMaterial;
    private int numeroTamanho;

    public Calca(String marca, String modelo, BigDecimal preco,
                 Genero genero, FaixaEtaria faixaEtaria,
                 TipoMaterial tipoMaterial, int numeroTamanho) {
        super(marca, modelo, preco, genero, faixaEtaria);
        this.setTipoMaterial(tipoMaterial).setNumeroTamanho(numeroTamanho);
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public Calca setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
        return this;
    }

    public int getNumeroTamanho() {
        return numeroTamanho;
    }

    /**
     * A menor calça que vou aceitar é de tamanho 20.
     * A maior calça que vou aceitar é de tamanho 68.
     */
    public Calca setNumeroTamanho(int numeroTamanho) throws IllegalArgumentException {
        if (numeroTamanho < 20 || numeroTamanho > 68) {
            throw new IllegalArgumentException("Só temos calças de tamanho 20 ao 68");
        }

        this.numeroTamanho = numeroTamanho;
        return this;
    }
}