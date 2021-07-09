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
        Vector posicion = this.posicion(carta);
        Vector adyacente = posicion.sumar(direccion.direccion);
        return this.obtener(adyacente);
    }

    public Carta obtener(Vector posicion) {
        return this.cartas[posicion.y()][posicion.x()];
    }

    private Vector posicion(Carta carta) {
        for (int i = 0; i < this.cartas.length; i++) {
            for (int j = 0; j < this.cartas[i].length; j++) {
                if (this.cartas[i][j] == carta) {
                    return new Vector(j, i);
                }
            }
        }
        return null;
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
            Vector velocidad = this.velocidad(carta, heroe);
            try {
                Carta opuesta = this.opuesta(heroe, velocidad);
                this.mover(heroe, velocidad);
                this.mover(opuesta, velocidad);
            } catch (IndexOutOfBoundsException ignored) {
                this.mover(heroe, velocidad);
            }
        }
    }

    private Carta opuesta(Carta carta, Vector velocidad) {
        Vector posicion = this.posicion(carta);
        return this.obtener(posicion.sumar(velocidad.multiplicar(-1)));
    }

    private void mover(Carta carta, Vector velocidad) {
        Vector posicionInicial = this.posicion(carta);
        Vector posicionFinal = posicionInicial.sumar(velocidad);
        this.asignar(carta, posicionFinal);
    }

    private void asignar(Carta carta, Vector posicion) {
        this.cartas[posicion.y()][posicion.x()] = carta;
    }

    private Vector velocidad(Carta una, Carta otra) {
        Vector unaPosicion = this.posicion(una);
        Vector otraPosicion = this.posicion(otra);
        return unaPosicion.restar(otraPosicion);
    }
}
