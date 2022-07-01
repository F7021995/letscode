import categorias.enums.*;
import compras.CarrinhoCompra;
import categorias.abstracoes.Produto;

import java.util.LinkedList;
import java.util.List;

import static compras.MockCarrinhoCompra.carregarHardware;
import static compras.MockCarrinhoCompra.carregarVestuario;

public class Main {

    public static void main(String... args) throws Exception {
        List<Produto<?>> blusas = new LinkedList<>(carregarVestuario());
        List<Produto<?>> hardwares = new LinkedList<>(carregarHardware());
        CarrinhoCompra carrinhoCompra1 = new CarrinhoCompra();

        // Carrinho compra apenas blusas (dados estão lá no MockCarrinhoCompra):
        carrinhoCompra1.setAdicionarUmaListaProdutosNoCarrinho(blusas);
        carrinhoCompra1.setOpcaoPagamento(OpcaoPagamento.CARTÃO_PARCELADO);
        carrinhoCompra1.setQuantidadeParcelas(2);
        carrinhoCompra1.efetuarCompra();

        // Carrinho compra apenas hadrwares (dados estão lá no MockCarrinhoCompra):
        System.out.println();
        CarrinhoCompra carrinhoCompra2 = new CarrinhoCompra();
        carrinhoCompra2.setAdicionarUmaListaProdutosNoCarrinho(hardwares);
        carrinhoCompra2.setOpcaoPagamento(OpcaoPagamento.PAYPAL);
        carrinhoCompra2.efetuarCompra();

        // Carrinho de blusas e hardwares.
        System.out.println();
        CarrinhoCompra carrinhoCompra3 = new CarrinhoCompra();
        carrinhoCompra3.setAdicionarUmaListaProdutosNoCarrinho(blusas);
        carrinhoCompra3.setAdicionarUmaListaProdutosNoCarrinho(hardwares);
        carrinhoCompra3.setOpcaoPagamento(OpcaoPagamento.BOLETO);
        carrinhoCompra3.efetuarCompra();
    }

}