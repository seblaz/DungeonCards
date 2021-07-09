package edu.fiuba.algo3.modelo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SaludTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    public void comienzaConTantosPuntosDeSaludComoSeIndique(int puntos) {
        Salud salud = new Salud(puntos);
        assertEquals(puntos, salud.puntos());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void disminuyeTantosPuntosDeSaludComoSeIndique(int puntos) {
        int puntosIniciales = 10;
        Salud salud = new Salud(puntosIniciales);
        salud.disminuir(puntos);
        assertEquals(puntosIniciales - puntos, salud.puntos());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 13, Integer.MAX_VALUE})
    public void siDisminuyeMasDeLaSaludTotalLosPuntosSonCero(int puntos) {
        Salud salud = new Salud(10);
        salud.disminuir(puntos);
        assertEquals(0, salud.puntos());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 13, Integer.MAX_VALUE})
    public void siDisminuyeMasDeLaSaludTotalNoEstaVivo(int puntos) {
        Salud salud = new Salud(10);
        salud.disminuir(puntos);
        assertFalse(salud.vivo());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 13, Integer.MAX_VALUE})
    public void siDisminuyeLuegoDeCeroPuntosNoDisminuyeLaSalud(int puntos) {
        Salud salud = new Salud(10);
        salud.disminuir(10);
        salud.disminuir(puntos);
        assertEquals(0, salud.puntos());
    }
}