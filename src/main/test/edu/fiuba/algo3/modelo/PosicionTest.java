package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void porDefectoComienzaEnElCeroCero() {
        Posicion posicion = new Posicion();
        assertEquals(posicion.x(), 0);
        assertEquals(posicion.y(), 0);
    }
}