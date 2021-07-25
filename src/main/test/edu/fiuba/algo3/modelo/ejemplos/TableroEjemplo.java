package edu.fiuba.algo3.modelo.ejemplos;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.GeneradorDeCartas;
import edu.fiuba.algo3.modelo.GeneradorRandom;

public class TableroEjemplo {

    private GeneradorDeCartas generadorDeCartas;
    private Carta[][] cartas;

    public static TableroEjemplo crear() {
        return new TableroEjemplo();
    }

    private TableroEjemplo() {
        this.generadorDeCartas = new GeneradorDeCartas(new GeneradorRandom(), 10);
    }

    public TableroEjemplo conCartas(Carta[][] cartas) {
        this.cartas = cartas;
        return this;
    }

    public TableroEjemplo conGeneradorDeCartas(GeneradorDeCartas generadorDeCartas) {
        this.generadorDeCartas = generadorDeCartas;
        return this;
    }

    public edu.fiuba.algo3.modelo.Tablero build() {
        return new edu.fiuba.algo3.modelo.Tablero(
                this.generadorDeCartas,
                this.cartas
        );
    }
}
