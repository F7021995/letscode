package zPenseiMasNaoQuizFazer;

import java.math.BigDecimal;

public class Desktop extends Computador<Desktop> {
    private final BigDecimal precoMaoObra = BigDecimal.valueOf(200);

    @Override
    public String tipoComputador() {
        return "DESKTOP";
    }

    @Override
    public BigDecimal precoTotalComMaoObra() {
        return precoSemMaoObra().add(precoMaoObra);
    }

}