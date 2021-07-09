package edu.fiuba.algo3.modelo;


public class Tablero {
    public enum Direccion {
        DERECHA(1, 0),
        IZQUIERDA(-1, 0),
        ABAJO(0, 1),
        ARRIBA(0, -1);

        private final int horizontal;
        private final int vertical;

        Direccion(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    private final Carta[][] cartas;

    public Tablero(Carta[][] cartas) {
        this.cartas = cartas.clone();
    }

    public Carta obtenerAdyacente(Carta carta, Direccion direccion) {
        int[] indice = this.indice(carta);
        return this.cartas[indice[0] + direccion.vertical][indice[1] + direccion.horizontal];
    }

    private int[] indice(Carta carta) {
        for (int i = 0; i < this.cartas.length; i++) {
            for (int j = 0; j < this.cartas[i].length; j++) {
                if (this.cartas[i][j] == carta) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public void activar(Heroe heroe, Carta carta) {
        if (!carta.activar(heroe)) {
            int[] indice = this.indice(carta);
            this.cartas[indice[0]][indice[1]] = heroe;
        }
    }

    public Carta obtener(int fila, int columna) {
        return cartas[fila][columna];
    }
}
