package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ejemplos.CartaEjemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableroTest {

    private Carta[][] cartas;
    private Tablero tablero;

    @BeforeEach
    public void crearTablero() {
        this.cartas = new Carta[][]{
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
        };
        this.tablero = new Tablero(cartas);
    }

    @Test
    public void devuelveLaCartaALaIzquierda() {
        Carta carta = this.tablero.obtenerAdyacente(this.cartas[0][0], Tablero.Direccion.DERECHA);
        assertEquals(this.cartas[0][1], carta);
    }
}