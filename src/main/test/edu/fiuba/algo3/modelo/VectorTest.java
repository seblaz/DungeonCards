package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    @Test
    public void porDefectoComienzaEnElCeroCero() {
        Vector vector = new Vector();
        assertEquals(0, vector.x());
        assertEquals(0, vector.y());
    }

    @ParameterizedTest
    @MethodSource("posicionesIniciales")
    public void comienzaDondeSeIndiqueEnElConstructor(int x, int y) {
        Vector vector = new Vector(x, y);
        assertEquals(x, vector.x());
        assertEquals(y, vector.y());
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

    @Test
    public void restarseASiMismoDevuelveElOrigen() {
        Vector posicion = new Vector(1, 2);
        Vector resultado = posicion.restar(posicion);
        Vector esperado = new Vector(0, 0);
        assertEquals(esperado, resultado);
    }

    @Test
    public void otraPosicionMenosElOrigenDevuelveLAPosicion() {
        Vector vector = new Vector(1, 2);
        Vector origen = new Vector(0, 0);
        Vector resultado = vector.restar(origen);
        assertEquals(vector, resultado);
    }

    @Test
    public void sumarAlOrigenDevuelveASiMismo() {
        Vector vector = new Vector(1, 2);
        Vector origen = new Vector(0, 0);
        Vector resultado = vector.sumar(origen);
        assertEquals(vector, resultado);
    }

    @Test
    public void sumarConOtroDevuelveLaSuma() {
        Vector vector = new Vector(1, 2);
        Vector origen = new Vector(2, 2);
        Vector resultado = vector.sumar(origen);
        Vector esperado = new Vector(3, 4);
        assertEquals(esperado, resultado);
    }
}