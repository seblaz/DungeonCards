package edu.fiuba.algo3.modelo;

public class CartaNula implements Carta {

    @Override
    public boolean activar(Heroe heroe) {
        return true;
    }

    @Override
    public void recibirDanio(int danio) {}
}
