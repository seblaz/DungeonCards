package edu.fiuba.algo3.modelo;


public class Tablero {
    public enum Direccion {
        DERECHA(1, 0),
        IZQUIERDA(-1, 0),
        ABAJO(0, 1),
        ARRIBA(0, -1);

        private final int horizontal;
        private final int vertical;
        private final Vector direccion;

        Direccion(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
            this.direccion = new Vector(horizontal, vertical);
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

//    private Vector posicion(Carta carta) {
//        for (int i = 0; i < this.cartas.length; i++) {
//            for (int j = 0; j < this.cartas[i].length; j++) {
//                if (this.cartas[i][j] == carta) {
//                    return new Vector(i, j);
//                }
//            }
//        }
//        return null;
//    }

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
            int[] velocidad = this.velocidad(carta, heroe);
            try {
                Carta opuesta = this.opuesta(heroe, velocidad);
                this.mover(heroe, velocidad);
                this.mover(opuesta, velocidad);
            } catch (IndexOutOfBoundsException ignored) {
                this.mover(heroe, velocidad);
            }
        }
    }

    private Carta opuesta(Carta carta, int[] velocidad) {
        int[] indice = this.indice(carta);
        return this.cartas[indice[0] - velocidad[0]][indice[1] - velocidad[1]];
    }

    private void mover(Carta carta, int[] velocidad) {
        int[] indice = this.indice(carta);
        this.cartas[indice[0] + velocidad[0]][indice[1] + velocidad[1]] = carta;
    }

    private int[] velocidad(Carta una, Carta otra) {
        int[] unIndice = this.indice(una);
        int[] otroIndice = this.indice(otra);
        return new int[] { unIndice[0] - otroIndice[0], unIndice[1] - otroIndice[1]};
    }

    public Carta obtener(int fila, int columna) {
        return cartas[fila][columna];
    }
}
