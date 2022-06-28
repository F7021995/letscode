package produtos;

import categorias.Computadores;
import hardware.MemoriaRam;
import hardware.PlacaMae;
import hardware.Processador;

public class Desktop implements Computadores {
    String preco;

    Processador processador;
    PlacaMae placaMae;
    MemoriaRam memoriaRam;


    @Override
    public Double getPreco() {
        return null;
    }
}
