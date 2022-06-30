package hardware;

import categorias.abstracoes.Produto;
import categorias.interfaces.Hardware;

import java.math.BigDecimal;

public class PlacaMae extends Produto<PlacaMae> implements Hardware {
    private String tipoMemoria;
    private String familiaProcessadores;
    private int slotsRam;

    public PlacaMae(String marca, String modelo, BigDecimal preco,
                    String tipoMemoria, String familiaProcessadores, int slotsRam) {
        super(marca, modelo, preco);
        this.setTipoMemoria(tipoMemoria)
                .setfamiliaProcessadores(familiaProcessadores)
                .setSlotsRam(slotsRam);
    }

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    public PlacaMae setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
        return this;
    }

    public String getfamiliaProcessadores() {
        return familiaProcessadores;
    }

    public PlacaMae setfamiliaProcessadores(String familiaProcessadores) {
        this.familiaProcessadores = familiaProcessadores;
        return this;
    }

    public int getSlotsRam() {
        return slotsRam;
    }

    public PlacaMae setSlotsRam(int slotsRam) {
        this.slotsRam = slotsRam;
        return this;
    }
}