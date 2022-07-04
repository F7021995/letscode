package cliente;

import investimento.Investimento;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class Cliente<TipoInvestimento extends Investimento> {

    protected List<TipoInvestimento> listaInvestimento = new LinkedList<>();

    private String nome;

    protected void contratarInvestimento (TipoInvestimento investimento) {
        this.listaInvestimento.add(investimento);
    }

    protected List<TipoInvestimento> getCarteiraInvestimento() {
        return Collections.unmodifiableList(this.listaInvestimento);
    }

}