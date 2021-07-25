package edu.fiuba.algo3.modelo;

import java.util.Random;

public class GeneradorRandom implements IGeneradorRandom {

    private final Random random;

    public GeneradorRandom() {
        this.random = new Random();
    }

    @Override
    public double nuevo() {
        return this.random.nextDouble();
    }
}
