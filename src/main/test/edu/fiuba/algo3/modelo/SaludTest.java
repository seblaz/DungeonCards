package edu.fiuba.algo3.modelo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaludTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    public void comienzaConTantosPuntosDeSaludComoSeIndique(int puntos) {
        Salud salud = new Salud(puntos);
        assertEquals(salud.puntos(), puntos);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void restaConTantosPuntosDeSaludComoSeIndique(int puntos) {
        int puntosIniciales = 10;
        Salud salud = new Salud(puntosIniciales);
        salud.disminuir(puntos);
        assertEquals(salud.puntos(), puntosIniciales - puntos);
    }
}