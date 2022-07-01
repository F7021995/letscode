package categorias.abstracoes;

import java.math.BigDecimal;

/**
 * Essa é a minha classe principal... Tudo é produto.
 * Tudo tem marca, modelo e preco.
 */
public abstract class Produto<T extends Produto<?>> {
    private String marca;
    private String modelo;
    private BigDecimal preco;

    public Produto(String marca, String modelo, BigDecimal preco) {
        this.setMarca(marca).setModelo(modelo).setPreco(preco);
    }

    public String getMarca() {
        return marca;
    }

    /**
     * Retornar produto (que é do tipo T) permite programação mais funcional.
     * Permite setMarca().setModelo().setPreco() e os sets específicos dos filhos.
     */
    public Produto<T> setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Produto<T> setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Produto<T> setPreco(BigDecimal preco) throws IllegalArgumentException {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço do produto não pode ser negativo.");
        }

        this.preco = preco;
        return this;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                '}';
    }
}