package edu.fiuba.algo3.modelo;

public class GeneradorDeCartas {
    private final int puntosMaximos;

    public GeneradorDeCartas(IGeneradorRandom random, int puntosMaximos) {
        this.puntosMaximos = puntosMaximos;
    }

    public Carta nueva() {
        return new Enemigo((int) Math.ceil(puntosMaximos * 0.5));
    }
}
