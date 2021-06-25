package edu.fiuba.algo3.modelo;


public class Tablero {
    public enum Direccion {
        DERECHA(1);

        public final int valor;

        Direccion(int valor) {
            this.valor = valor;
        }
    }

    private final Carta[][] cartas;

    public Tablero(Carta[][] cartas) {
        this.cartas = cartas.clone();
    }

    public Carta obtenerAdyacente(Carta carta, Direccion direccion) {
        int[] indice = this.indice(carta);
        return this.cartas[0][indice[1] + 1];
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
}
