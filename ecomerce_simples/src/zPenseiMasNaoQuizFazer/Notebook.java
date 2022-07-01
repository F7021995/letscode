package zPenseiMasNaoQuizFazer;

import java.math.BigDecimal;

public class Notebook extends Computador<Notebook> {
    private final BigDecimal precoMaoObra = BigDecimal.valueOf(500);

    @Override
    public String tipoComputador() {
        return "NOTEBOOK";
    }

    @Override
    public BigDecimal precoTotalComMaoObra() {
        return precoSemMaoObra().add(precoMaoObra);
    }

}