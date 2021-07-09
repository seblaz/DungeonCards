package edu.fiuba.algo3.modelo;

public interface Carta {
    /**
     * Activa una carta.
     * @param heroe Héroe.
     * @return un booleano indicando si la carta permanece activa.
     */
    boolean activar(Heroe heroe);

    void recibirDanio(int danio);
}
