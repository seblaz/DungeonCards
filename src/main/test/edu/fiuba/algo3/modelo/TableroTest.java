package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ejemplos.CartaEjemplo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableroTest {

    public static Carta[][] cartas() {
        return new Carta[][]{
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
                {new CartaEjemplo(), new CartaEjemplo(), new CartaEjemplo()},
        };
    }

    @ParameterizedTest
    @MethodSource("cartasAdyacentes")
    public void devuelveLaCartaAdyacente(Tablero tablero, Carta origen, Tablero.Direccion direccion, Carta esperado) {
        Carta resultado = tablero.obtenerAdyacente(origen, direccion);
        assertEquals(esperado, resultado);
    }

    public static Stream<Arguments> cartasAdyacentes() {
        Carta[][] cartas = cartas();
        Tablero tablero = new Tablero(cartas);
        // Índices: (fila, columna)
        return Stream.of(
                Arguments.of(tablero, cartas[0][0], Tablero.Direccion.DERECHA, cartas[0][1]),
                Arguments.of(tablero, cartas[0][1], Tablero.Direccion.DERECHA, cartas[0][2]),
                Arguments.of(tablero, cartas[1][0], Tablero.Direccion.DERECHA, cartas[1][1]),
                Arguments.of(tablero, cartas[1][1], Tablero.Direccion.DERECHA, cartas[1][2]),
                Arguments.of(tablero, cartas[2][0], Tablero.Direccion.DERECHA, cartas[2][1]),
                Arguments.of(tablero, cartas[2][1], Tablero.Direccion.DERECHA, cartas[2][2]),
                Arguments.of(tablero, cartas[0][1], Tablero.Direccion.IZQUIERDA, cartas[0][0]),
                Arguments.of(tablero, cartas[0][0], Tablero.Direccion.ABAJO, cartas[1][0]),
                Arguments.of(tablero, cartas[1][0], Tablero.Direccion.ABAJO, cartas[2][0]),
                Arguments.of(tablero, cartas[1][2], Tablero.Direccion.ABAJO, cartas[2][2])
        );
    }
}