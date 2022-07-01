package zPenseiMasNaoQuizFazer;

import hardware.MemoriaRam;
import hardware.PlacaMae;
import hardware.Processador;

import java.math.BigDecimal;

/**
 * Se eu quiser fazer uma junção dos hardwares e vender outro produto (computador ou notebook)...
 * Apenas o esboço de como seria isso (Computador algo genérico para Desktop e Notebook)...
 *
 * Pra isso funcionar: [Computador tem que extends de Produto] e Os filhos extenderem de Computador.
 * O problema é: Desktop tem marca e modelo?
 */
public abstract class Computador<T extends Computador<T>> {

    private Processador processador;
    private PlacaMae placaMae;
    private MemoriaRam memoriaRam;

    public Processador getProcessador() {
        return processador;
    }

    public Computador<T> setProcessador(Processador processador) {
        this.processador = processador;
        return this;
    }

    public PlacaMae getPlacaMae() {
        return placaMae;
    }

    public Computador<T> setPlacaMae(PlacaMae placaMae) {
        this.placaMae = placaMae;
        return this;
    }

    public MemoriaRam getMemoriaRam() {
        return memoriaRam;
    }

    public Computador<T> setMemoriaRam(MemoriaRam memoriaRam) {
        this.memoriaRam = memoriaRam;
        return this;
    }

    public BigDecimal precoSemMaoObra() {
         return placaMae.getPreco().add(processador.getPreco()).add(memoriaRam.getPreco());
    }

    public abstract String tipoComputador();

    public abstract BigDecimal precoTotalComMaoObra();
}