package cliente;

import rendaVariavel.RendaVariavel;

import java.util.List;

public class Arrojado<TipoInvestimento extends RendaVariavel> extends Cliente<TipoInvestimento> {

    @Override
    public void contratarInvestimento(TipoInvestimento tipoInvestimento) {
        super.contratarInvestimento(tipoInvestimento);
    }

    @Override
    public List<TipoInvestimento> getCarteiraInvestimento() {
        return super.getCarteiraInvestimento();
    }

}