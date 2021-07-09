package edu.fiuba.algo3.modelo.ejemplos;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Heroe;

public class CartaEjemplo implements Carta {

    @Override
    public boolean activar(Heroe heroe) {
        return true;
    }

    @Override
    public void recibirDanio(int danio) {}
}
