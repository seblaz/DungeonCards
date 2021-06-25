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

    public Carta obtenerAdyacente(Carta carta, Direccion derecha) {
        return this.cartas[0][1];
    }


}
