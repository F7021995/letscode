package cliente;

import investimento.Investimento;

import java.util.List;

/**
 * Moderado pode contratar qualquer tipo de investimento... extends Investimento.
 * Arrojado e Conservador não extendem diretamente de Investimento, extende de um filho de Investimento.
 * @param <TipoInvestimento>
 */
public class Moderado<TipoInvestimento extends Investimento> extends Cliente<TipoInvestimento> {

    @Override
    public void contratarInvestimento(TipoInvestimento investimento) {
        super.contratarInvestimento(investimento);
    }

    @Override
    public List<TipoInvestimento> getCarteiraInvestimento() {
        return super.getCarteiraInvestimento();
    }
}
