package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DungeonCardsTest {
    private DungeonCards juego;

    @BeforeEach
    public void crearJuego() {
        IGeneradorRandom random = mock(IGeneradorRandom.class);
        when(random.nuevo()).thenReturn(0.5);
        this.juego = new DungeonCards(random);
    }

    @Test
    public void devuelveElMismoTablero() {
        assertEquals(juego.tablero(), juego.tablero());
    }
}
