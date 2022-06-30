package vestuario;

import categorias.abstracoes.Vestuario;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.TipoCalcado;

import java.math.BigDecimal;

/**
 * Eu pensei criar uma classe para cada tipo de calçado (Tenis, Sapatenis, Bota, Sandália, Tamanco)...
 * Mas são todos calçados e não tem nenhuma diferença entre eles.
 * Tudo tem marca, modelo, preco, tamanho...
 */

// OK
public class Calcado extends Vestuario<Calcado> {
    private TipoCalcado tipoCalcado;
    private int tamanhoCalcado;

    public Calcado(String marca, String modelo, BigDecimal preco,
                   Genero genero, FaixaEtaria faixaEtaria,
                   TipoCalcado tipoCalcado, int tamanhoCalcado) {
        super(marca, modelo, preco, genero, faixaEtaria);
        this.setTipoCalcado(tipoCalcado).setTamanhoCalcado(tamanhoCalcado);
    }

    /**
     * Retorna uma String que está dentro do enum.
     * Essa String vai dizer qual é o tipo do material.
     */
    public String getTipoCalcado() {
        return tipoCalcado.getTipo();
    }

    /**
     * Vai alterar apenas dentro dessa classe aqui.
     * Não vai alterar o valor da String lá dentro do enum.
     */
    public Calcado setTipoCalcado(TipoCalcado tipoCalcado) {
        this.tipoCalcado = tipoCalcado;
        return this;
    }

    public int getTamanhoCalcado() {
        return tamanhoCalcado;
    }

    /**
     * Menor calçado que vou aceitar é de tamanho 16.
     * Maior calçado que vou aceitar é de tamanho 45.
     */
    public Calcado setTamanhoCalcado(int tamanhoCalcado) {
        if (tamanhoCalcado < 16 || tamanhoCalcado > 45) {
            throw new IllegalArgumentException("Só vendemos calçados dos tamanhos 16 ao 45");
        }

        this.tamanhoCalcado = tamanhoCalcado;
        return this;
    }

}