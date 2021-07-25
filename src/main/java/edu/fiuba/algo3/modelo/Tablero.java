package edu.fiuba.algo3.modelo;


public class Tablero {
    public enum Direccion {
        DERECHA(1, 0),
        IZQUIERDA(-1, 0),
        ABAJO(0, 1),
        ARRIBA(0, -1);

        private final Vector direccion;

        Direccion(int horizontal, int vertical) {
            this.direccion = new Vector(horizontal, vertical);
        }
    }

    private final GeneradorDeCartas generadorDeCartas;
    private final Carta[][] cartas;

    public Tablero(GeneradorDeCartas generadorDeCartas, Carta[][] cartas) {
        this.generadorDeCartas = generadorDeCartas;
        this.cartas = cartas.clone();
    }

    public Carta obtener(Vector posicion) {
        this.validarLimites(posicion);
        return this.cartas[posicion.y()][posicion.x()];
    }

    private void validarLimites(Vector posicion) {
        if(posicion.x() < 0 || posicion.x() > 2) {
            throw new PosicionFueraDeLimites();
        }
        if(posicion.y() < 0 || posicion.y() > 2) {
            throw new PosicionFueraDeLimites();
        }
    }

    private void asignar(Carta carta, Vector posicion) {
        this.cartas[posicion.y()][posicion.x()] = carta;
    }

    private Vector posicion(Carta carta) {
        for (int i = 0; i < this.cartas.length; i++) {
            for (int j = 0; j < this.cartas[i].length; j++) {
                if (this.cartas[i][j] == carta) {
                    return new Vector(j, i);
                }
            }
        }
        throw new CartaNoEncontrada();
    }

    public Carta obtenerAdyacente(Carta carta, Direccion direccion) {
        Vector posicion = this.posicion(carta);
        Vector adyacente = posicion.sumar(direccion.direccion);
        return this.obtener(adyacente);
    }

    public void activar(Heroe heroe, Carta carta) {
        if (!carta.activar(heroe)) {
            Vector direccionDeAtaque = this.velocidad(carta, heroe);
            Carta nuevaCarta = this.generadorDeCartas.nueva();
            try {
                Carta opuesta = this.opuesta(heroe, direccionDeAtaque);
                Vector posicionOpuesta = this.posicion(opuesta);
                this.mover(heroe, direccionDeAtaque);
                this.mover(opuesta, direccionDeAtaque);
                this.asignar(nuevaCarta, posicionOpuesta);
            } catch (PosicionFueraDeLimites ignored) {
                Vector posicionHeroe = this.posicion(heroe);
                this.mover(heroe, direccionDeAtaque);
                this.asignar(nuevaCarta, posicionHeroe);
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

    private Vector velocidad(Carta una, Carta otra) {
        Vector unaPosicion = this.posicion(una);
        Vector otraPosicion = this.posicion(otra);
        return unaPosicion.restar(otraPosicion);
    }
}
