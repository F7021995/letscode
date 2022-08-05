package game;

public class Caminhao {

    public int carga;
    public Plantacao plantacao;

    public Caminhao(int carga, Plantacao plantacao) {
        this.carga = carga;
        this.plantacao = plantacao;
    }

    public int getCarga() {
        return carga;
    }

    public Plantacao getPlantacao() {
        return plantacao;
    }

    @Override
    public String toString() {
        return "Caminhao{" + "carga=" + carga + ", plantacao=" + plantacao + '}';
    }
}