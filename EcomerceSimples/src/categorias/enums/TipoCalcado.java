package categorias.enums;

public enum TipoCalcado {
    TENIS("TÊNIS"),
    SAPATENIS("SAPATÊNIS"),
    SAPATO("SAPATO"),
    BOTA("BOTA"),
    SANDALIA("SANDÁLIA");

    private final String tipo;

    TipoCalcado(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}