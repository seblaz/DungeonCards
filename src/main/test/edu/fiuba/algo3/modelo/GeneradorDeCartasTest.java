package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GeneradorDeCartasTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    public void generaUnEnemigoConLosPuntosDeVidaIndicados(int puntos) {
        IGeneradorRandom random = mock(IGeneradorRandom.class);
        when(random.nuevo()).thenReturn(0.5);

        GeneradorDeCartas generador = new GeneradorDeCartas(random, puntos);
        Enemigo enemigo = (Enemigo) generador.nueva();

        assertEquals(Math.ceil(puntos * 0.5), enemigo.puntosDeSalud());
    }
}
