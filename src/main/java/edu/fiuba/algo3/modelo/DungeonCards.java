package edu.fiuba.algo3.modelo;

public class DungeonCards {
    private final Tablero tablero;

    public DungeonCards(IGeneradorRandom random) {
        Carta[][] cartas =  new Carta[][]{
                {new Enemigo(1), new Enemigo(1), new Enemigo(1)},
                {new Enemigo(1), new Heroe(), new Enemigo(1)},
                {new Enemigo(1), new Enemigo(1), new Enemigo(1)}
        };
        this.tablero = new Tablero(new GeneradorDeCartas(random, 10), cartas);
    }

    public Tablero tablero() {
        return tablero;
    }
}
