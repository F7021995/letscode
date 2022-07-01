package compras;

import categorias.abstracoes.Produto;
import categorias.enums.OpcaoPagamento;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class CarrinhoCompra {

    // Remover e Adicionar produtos mais facilmente, por isso LinkedList.
    private final List<Produto<?>> carrinhoCompra = new LinkedList<>();
    private OpcaoPagamento opcaoPagamento;
    private int quantidadeParcelas = 1;

    private static final Locale PTBR = new Locale("pt", "BR");

    public CarrinhoCompra() {
    }

    public CarrinhoCompra setAdicionarUmProdutoNoCarrinhoCompra(Produto<?> produto) {
        carrinhoCompra.add(produto);
        return this;
    }

    public CarrinhoCompra setAdicionarUmaListaProdutosNoCarrinho(List<Produto<?>> produtos) {
        carrinhoCompra.addAll(produtos);
        return this;
    }

    /**
     * Sempre que retornar lista: unmodifiableList (tem como fazer um BUG).
     * Sem isso dá pra fazer getMinhaLista().add("novoValor").
     */
    public List<Produto<?>> getCarrinhoCompra() {
        return Collections.unmodifiableList(carrinhoCompra);
    }

    public CarrinhoCompra setOpcaoPagamento(OpcaoPagamento opcaoPagamento) {
        if (this.getQuantidadeParcelas() != 1 && opcaoPagamento != OpcaoPagamento.CARTÃO_PARCELADO) {
            throw new IllegalArgumentException(
                    "\nSomente Cartão Parcelado pode fazer pagamentos parcelados. \n" +
                    "Altere a quantidade de parcelas para 1 e tente novamente."
            );
        }
        this.opcaoPagamento = opcaoPagamento;
        return this;
    }

    public OpcaoPagamento getOpcaoPagamento() {
        return this.opcaoPagamento;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public CarrinhoCompra setQuantidadeParcelas(int quantidadeParcelas) {
        if (this.opcaoPagamento != OpcaoPagamento.CARTÃO_PARCELADO) {
            throw new IllegalArgumentException("Somente cartão parcelado pode parcelar uma compra");
        }

        if (quantidadeParcelas < 0 || quantidadeParcelas > 3) {
            throw new IllegalArgumentException("Parcelamentos em até 3 vezes");
        }

        this.quantidadeParcelas = quantidadeParcelas;
        return this;
    }

    public void efetuarCompra() {
        if (carrinhoCompra.isEmpty()) {
            throw new IllegalArgumentException("Carrinho de compra está vazio. ");
        }

        if (this.opcaoPagamento == null) {
            throw new IllegalArgumentException("Selecione uma forma de pagamento. ");
        }

        if (ehPagamentoCartaoParcelado()) {
            // Quantidade parcelas está em int, preciso converter para bigdecimal.
            // scale (2) e Rouding: estão relacionados com divide
            BigDecimal valorParcela =
                    this.getValorTotalCarrinhoCompra()
                    .divide(BigDecimal.valueOf(this.getQuantidadeParcelas()), 2, RoundingMode.HALF_DOWN);

            System.out.printf(
                    "Modo de pagamento: " + this.opcaoPagamento + ". " +
                    "Será pago em %d parcela(s) de %s",
                    this.getQuantidadeParcelas(),
                    this.getValorTotalCarrinhoCompraFormatado(valorParcela)
            );
        }
        else {
            System.out.printf(
                    "Modo de pagamento: " + this.opcaoPagamento + ". " +
                    "Uma única parcela de: " + this.getValorTotalCarrinhoCompraFormatado()
            );
        }
    }

    public BigDecimal getValorTotalCarrinhoCompra() {
        BigDecimal soma = BigDecimal.ZERO;
        for (Produto<?> p : carrinhoCompra) {
            soma = soma.add(p.getPreco());
        }
        return soma;
    }

    public String getValorTotalCarrinhoCompraFormatado() {
        return NumberFormat.getCurrencyInstance(PTBR).format(this.getValorTotalCarrinhoCompra());
    }

    private String getValorTotalCarrinhoCompraFormatado(BigDecimal valorParcela) {
        return NumberFormat.getCurrencyInstance(PTBR).format(valorParcela);
    }

    private boolean ehPagamentoCartaoParcelado() {
        return this.opcaoPagamento == OpcaoPagamento.CARTÃO_PARCELADO;
    }

}