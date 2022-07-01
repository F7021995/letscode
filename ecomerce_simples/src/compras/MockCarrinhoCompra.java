package compras;

import categorias.abstracoes.Produto;
import categorias.abstracoes.Veiculo;
import categorias.abstracoes.Vestuario;
import categorias.enums.*;
import hardware.MemoriaRam;
import hardware.PlacaMae;
import hardware.Processador;
import veiculo.Bicicleta;
import vestuario.Blusa;
import vestuario.Calca;
import vestuario.Calcado;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class MockCarrinhoCompra {

    public static List<Vestuario<?>> carregarVestuario() {
        List<Vestuario<?>> vestuarios = new LinkedList<>();

        Blusa blusa = new Blusa(
                "Blusa A", "Modelo Blusa A", BigDecimal.valueOf(99.99),
                Genero.FEMININO, FaixaEtaria.ADULTO, TipoMaterial.COURO,
                "M", 1);

        Calca calca = new Calca(
                "Calça B", "Modelo Calça B", BigDecimal.valueOf(59.99),
                Genero.MASCULINO, FaixaEtaria.ADOLESCENTE, TipoMaterial.MOLETON,
                52
        );

        Calcado calcado = new Calcado(
                "Calçado C", "Modelo Calçado C", BigDecimal.valueOf(149.99),
                Genero.MASCULINO, FaixaEtaria.ADULTO,
                TipoCalcado.SAPATO,42
        );

        vestuarios.add(blusa);
        vestuarios.add(calca);
        vestuarios.add(calcado);

        return vestuarios;
    }

    /**
     * Hardware não tem classe pai... é diretamente Produto.
     * Não tem como saber se produto é um Hardware.
     * Por isso eu fiz interface Hardware (é uma anotação).
     */
    public static List<Produto<?>> carregarHardware() throws Exception {
        List<Produto<?>> hardwares = new LinkedList<>();

        MemoriaRam ram = new MemoriaRam(
                "XPG", "AX4U32008G16A-CBKD45", BigDecimal.valueOf(3000),
                8, 3300, "DDR4", MemoriaUsadaEm.COMPUTADOR
        );

        Processador processador = new Processador(
                "Intel", "i9", BigDecimal.valueOf(3000), "3.8", 6
        );

        PlacaMae placaMae = new PlacaMae(
                "Gigabyte", "aa", BigDecimal.valueOf(3000), "DDR4", "Intel", 4
        );

        hardwares.add(ram);
        hardwares.add(processador);
        hardwares.add(placaMae);

        return hardwares;
    }

    /**
     * Veículos é uma classe específica... Dá pra saber que é um Veículo.
     * É diferente de Hardware que conversa diretamente com Produto.
     */
    public static List<Veiculo<?>> carregarVeiculo() {
        List<Veiculo<?>> veiculos = new LinkedList<>();

        Bicicleta bicicleta = new Bicicleta(
                "a", "b", BigDecimal.valueOf(300),
                Genero.MASCULINO, FaixaEtaria.ADULTO, PublicoAlvo.PROFISSIONAL, TipoVeiculo.MANUAL,
                false,false, 25
        );

        veiculos.add(bicicleta);

        return veiculos;
    }

}
