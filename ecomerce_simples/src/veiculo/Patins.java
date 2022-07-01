package veiculo;

import categorias.enums.FaixaEtaria;
import categorias.enums.Genero;
import categorias.abstracoes.Veiculo;
import categorias.enums.PublicoAlvo;
import categorias.enums.TipoVeiculo;

import java.math.BigDecimal;

/**
 * Patins não é dobrável... extends VeiculoRodasNaoMotorizado
 */
// OK, não consegui pensar em característica específica de Patins.
public class Patins extends Veiculo<Patins> {

    public Patins(String marca, String modelo, BigDecimal preco,
                  Genero genero, FaixaEtaria faixaEtaria, PublicoAlvo publicoAlvo) {
        // Não existe patins elétrico... Logo TipoVeiculo sempre será MANUAL.
        super(marca, modelo, preco, genero, faixaEtaria, publicoAlvo, TipoVeiculo.MANUAL);
    }

}