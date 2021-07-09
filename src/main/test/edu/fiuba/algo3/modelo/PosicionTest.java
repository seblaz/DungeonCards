package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void porDefectoComienzaEnElCeroCero() {
        Posicion posicion = new Posicion();
        assertEquals(0, posicion.x());
        assertEquals(0, posicion.y());
    }

    @ParameterizedTest
    @MethodSource("posicionesIniciales")
    public void comienzaDondeSeIndiqueEnElConstructor(int x, int y) {
        Posicion posicion = new Posicion(x, y);
        assertEquals(x, posicion.x());
        assertEquals(y, posicion.y());
    }

    public static Stream<Arguments> posicionesIniciales() {
        return Stream.of(
                //           x, y
                Arguments.of(0, 2),
                Arguments.of(0, 1),
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(2, 1)
        );
    }
}