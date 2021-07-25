package edu.fiuba.algo3.modelo;

public class GeneradorDeCartas {
    private final IGeneradorRandom generadorRandom;
    private final int puntosMaximos;

    public GeneradorDeCartas(IGeneradorRandom generadorRandom, int puntosMaximos) {
        this.generadorRandom = generadorRandom;
        this.puntosMaximos = puntosMaximos;
    }

    public Carta nueva() {
        int puntosDeSalud = (int) Math.ceil(puntosMaximos * this.generadorRandom.nuevo());
        return new Enemigo(Math.max(1, puntosDeSalud));
    }
}
