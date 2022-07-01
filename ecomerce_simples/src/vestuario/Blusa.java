package vestuario;

import categorias.abstracoes.Vestuario;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.TipoMaterial;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// OK
public class Blusa extends Vestuario<Blusa> {
    private static final Set<String> descricoesPossiveis = new LinkedHashSet<>(List.of("P", "M", "G", "GG", "GGG"));
    private TipoMaterial tipoMaterial;
    private String descricaoTamanho;
    private int numeroTamanho; // G1, G2, G3...

    public Blusa(String marca, String modelo, BigDecimal preco,
                 Genero genero, FaixaEtaria faixaEtaria, TipoMaterial tipoMaterial,
                 String descricaoTamanho, int numeroTamanho) {
        super(marca, modelo, preco, genero, faixaEtaria);
        this.setTipoMaterial(tipoMaterial).setDescricaoTamanho(descricaoTamanho).setNumeroTamanho(numeroTamanho);
    }

    // Quem deveria saber o material é o próprio enum material?
    public String getTipoMaterial() {
        return this.tipoMaterial.getMaterial();
    }

    // Tipo do material que será alterado é o da própria blusa.
    public Blusa setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
        return this;
    }

    public String getDescricaoTamanho() {
        return descricaoTamanho;
    }

    /**
     * Descrição do tamanho da blusa não estiver nesse HashSet() não permite cadastrar.
     */
    public Blusa setDescricaoTamanho(String descricaoTamanho) throws IllegalArgumentException {
        // Se a descrição
        if (!Blusa.descricoesPossiveis.contains(descricaoTamanho.toUpperCase())) {
            throw new IllegalArgumentException("Nossas blusas podem ser dos tamanhos: P, M, G, GG ou GGG");
        }

        this.descricaoTamanho = descricaoTamanho.toUpperCase().trim();
        return this;
    }

    public int getNumeroTamanho() {
        return numeroTamanho;
    }

    /**
     * Algumas camisas um número além do tamanho.
     * Camisa GG4, GG5, GG3...
     */
    public Blusa setNumeroTamanho(int numeroTamanho) throws IllegalArgumentException {
        if (numeroTamanho < 1 || numeroTamanho > 6) {
            throw new IllegalArgumentException("Número do tamanho de uma camisa só pode ser entre 0 a 6");
        }

        this.numeroTamanho = numeroTamanho;
        return this;
    }
}