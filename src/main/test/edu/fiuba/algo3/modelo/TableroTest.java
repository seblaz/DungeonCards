package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ejemplos.CartaEjemplo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
                Arguments.of(tablero, cartas[1][2], Tablero.Direccion.IZQUIERDA, cartas[1][1]),
                Arguments.of(tablero, cartas[2][2], Tablero.Direccion.IZQUIERDA, cartas[2][1]),
                Arguments.of(tablero, cartas[0][0], Tablero.Direccion.ABAJO, cartas[1][0]),
                Arguments.of(tablero, cartas[1][0], Tablero.Direccion.ABAJO, cartas[2][0]),
                Arguments.of(tablero, cartas[1][1], Tablero.Direccion.ARRIBA, cartas[0][1]),
                Arguments.of(tablero, cartas[1][0], Tablero.Direccion.ARRIBA, cartas[0][0]),
                Arguments.of(tablero, cartas[2][2], Tablero.Direccion.ARRIBA, cartas[1][2])
        );
    }

    @ParameterizedTest
    @MethodSource("cartasPorPosicion")
    public void obtieneLasCartasDelTablero(Tablero tablero, int columna, int fila, Carta esperado) {
        assertEquals(esperado, tablero.obtener(columna, fila));
    }

    public static Stream<Arguments> cartasPorPosicion() {
        Carta[][] cartas = cartas();
        Tablero tablero = new Tablero(cartas);
        // Índices: (fila, columna)
        return Stream.of(
            Arguments.of(tablero, 0, 0, cartas[0][0]),
            Arguments.of(tablero, 1, 0, cartas[1][0]),
            Arguments.of(tablero, 0, 1, cartas[0][1]),
            Arguments.of(tablero, 2, 1, cartas[2][1]),
            Arguments.of(tablero, 2, 2, cartas[2][2])
        );
    }

    @Disabled
    public void siLaCartaDesapareceSeCompletaConUnaNueva() {
        Carta[][] cartas = cartas();
        Heroe heroe = new Heroe();
        Carta cartaADestruir = mock(Carta.class);
        when(cartaADestruir.activar(heroe)).thenReturn(false);

        cartas[0][2] = cartaADestruir;
        cartas[0][1] = heroe;

        Tablero tablero = new Tablero(cartas);
        tablero.activar(heroe, cartaADestruir);

        assertEquals(heroe, tablero.obtener(0, 2));
    }
}