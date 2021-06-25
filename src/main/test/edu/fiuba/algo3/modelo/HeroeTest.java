package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroeTest {

    @Test
    public void comienzaCon10PuntosDeSalud() {
        Heroe heroe = new Heroe();
        assertEquals(10, heroe.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void alAtacarSinArmasPierdeSalud(int puntosDeSaludDelEnemigo) {
        Heroe heroe = new Heroe();
        int puntosDeSaludIniciales = heroe.puntosDeSalud();
        Enemigo enemigo = new Enemigo(puntosDeSaludDelEnemigo);

        heroe.atacar(enemigo);

        assertEquals(puntosDeSaludIniciales - puntosDeSaludDelEnemigo, heroe.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void alAtacarSinArmasElEnemigoMuere(int puntosEnemigo) {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(puntosEnemigo);

        heroe.atacar(enemigo);

        assertEquals(0, enemigo.puntosDeSalud());
    }


    @ParameterizedTest
    @ValueSource(ints = {10, 13, 15, Integer.MAX_VALUE})
    public void alAtacarSinArmasSiElEnemigoEsMuyFuerteElHeroeMuere(int puntosEnemigo) {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(puntosEnemigo);

        heroe.atacar(enemigo);

        assertEquals(0, heroe.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 13, 15, Integer.MAX_VALUE})
    public void alAtacarSinArmasSiElEnemigoEsMuyFuerteElEnemigoNoMuere(int puntosEnemigo) {
        Heroe heroe = new Heroe();
        Enemigo enemigo = new Enemigo(puntosEnemigo);

        heroe.atacar(enemigo);

        assertEquals(puntosEnemigo - 10, enemigo.puntosDeSalud());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 1, 5})
    public void alRecibirDanioSeDisminuyeSuSalud(int danio) {
        Heroe heroe = new Heroe();
        int saludInicial = heroe.puntosDeSalud();

        heroe.recibirDanio(danio);

        assertEquals(saludInicial - danio, heroe.puntosDeSalud());
    }
}