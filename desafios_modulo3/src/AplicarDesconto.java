/**
 * Os descontos são:
 *
 *     Se comprar 15 itens ou mais, aplicar 10% de desconto.
 *     Se comprar 10 itens e menos de 15 aplicar 8% de desconto.
 *     Se comprar 5 itens e menos de 10 aplicar 5% de desconto.
 *     Se comprar menos que 5 itens não aplicar desconto.
 *
 * Ao aplicar o desconto encerre a cadeia de verificações.
 * Deixe o código aberto para que outros tipos de descontos sejam aplicados futuramente.
 */
public class AplicarDesconto {

    public static void main(String[] args) {
        int quantidadeItens = 10;
        double totalCompra = 1000;
        double totalCompraComDesconto = 0;
        double descontoAplicado = 0;

        // Enum que guarda os descontos.
        for (Desconto desconto : Desconto.values()) {
            if (desconto.isDiscountApplicable(quantidadeItens)) {
                totalCompraComDesconto = totalCompra * desconto.multiplicarPorPorcentatem();
                descontoAplicado = desconto.taxaDesconto();
            }
        }

        System.out.println("Total da compra: " + totalCompra);
        System.out.println("Desconto aplicado: " +  descontoAplicado * 100 + "% = " + totalCompraComDesconto);
    }

    enum Desconto {
        DEZ_PORCENTO {
            @Override
            double taxaDesconto() {
                return 0.10;
            }

            @Override
            double multiplicarPorPorcentatem() {
                return 1.00 - this.taxaDesconto();
            }

            @Override
            boolean isDiscountApplicable(int value) {
                return (value >= 15);
            }
        },
        OITO_PORCENTO {
            @Override
            double taxaDesconto() {
                return 0.08;
            }

            @Override
            double multiplicarPorPorcentatem() {
                return 1.00 - this.taxaDesconto();
            }

            @Override
            boolean isDiscountApplicable(int value) {
                return (value >= 10) && (value < 15);
            }
        },
        CINCO_PORCENTO {
            @Override
            double taxaDesconto() {
                return 0.05;
            }

            @Override
            double multiplicarPorPorcentatem() {
                return 1.00 - this.taxaDesconto();
            }

            @Override
            boolean isDiscountApplicable(int value) {
                return (value >= 5) && (value < 10);
            }
        },
        ZERO_PORCENTO {
            @Override
            double taxaDesconto() {
                return 0.00;
            }

            @Override
            double multiplicarPorPorcentatem() {
                return 1.00 - this.taxaDesconto();
            }

            @Override
            boolean isDiscountApplicable(int value) {
                return (value < 5);
            }
        };

        abstract double taxaDesconto();
        abstract double multiplicarPorPorcentatem();
        abstract boolean isDiscountApplicable(int value);

    }
}
