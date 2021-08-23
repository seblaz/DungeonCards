package edu.fiuba.algo3.modelo;

public interface Carta {
    /**
     * Activa una carta.
     * @param heroe Héroe.
     * @return un booleano indicando si la carta continua en juego.
     */
    boolean activar(Heroe heroe);

    void recibirDanio(int danio);

    boolean activa();
}
