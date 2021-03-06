package edu.fiuba.algo3.modelo;

public class DungeonCards {
    private final Tablero tablero;
    private final Heroe heroe;

    public DungeonCards(IGeneradorRandom random) {
        heroe = new Heroe();
        Carta[][] cartas =  new Carta[][]{
                {new Enemigo(1), new Enemigo(1), new Enemigo(1)},
                {new Enemigo(1), heroe, new Enemigo(1)},
                {new Enemigo(1), new Enemigo(1), new Enemigo(1)}
        };
        this.tablero = new Tablero(new GeneradorDeCartas(random, 10), cartas);
    }

    public Tablero tablero() {
        return tablero;
    }

    public Heroe heroe() {
        return heroe;
    }
}
