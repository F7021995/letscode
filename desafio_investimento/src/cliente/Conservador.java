package cliente;

import rendaFixa.RendaFixa;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Conservador só pode ter investimentos relacionados com RendaFixa.
 * @param <TipoInvestimento>
 */
public class Conservador<TipoInvestimento extends RendaFixa> extends Cliente<TipoInvestimento> {

    @Override
    public void contratarInvestimento(TipoInvestimento rendaFixa) {
        super.listaInvestimento.add(rendaFixa);
    }

    /**
     * Dois possíveis rendimentos (CDB e TesouroDireto).
     */
    @Override
    public List<TipoInvestimento> getCarteiraInvestimento() {
        return super.getCarteiraInvestimento();
    }

}