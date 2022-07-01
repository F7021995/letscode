package veiculo;

import categorias.abstracoes.Veiculo;
import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.enums.PublicoAlvo;
import categorias.enums.TipoVeiculo;

import java.math.BigDecimal;

// OK, não consegui pensar em característica específica de Skate por enquanto.
public class Skate extends Veiculo<Skate> {

    public Skate(String marca, String modelo, BigDecimal preco,
                 Genero genero, FaixaEtaria faixaEtaria, PublicoAlvo publicoAlvo,
                 TipoVeiculo tipoVeiculo) {
        super(marca, modelo, preco, genero, faixaEtaria, publicoAlvo, tipoVeiculo);
    }

}