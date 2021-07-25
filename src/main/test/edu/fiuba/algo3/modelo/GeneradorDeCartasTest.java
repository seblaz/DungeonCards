package edu.fiuba.algo3.modelo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GeneradorDeCartasTest {

    @ParameterizedTest
    @MethodSource("puntosDeVida")
    public void generaUnEnemigoConLosPuntosDeVidaIndicados(int puntosMaximos, double probabilidad, int resultado) {
        IGeneradorRandom random = mock(IGeneradorRandom.class);
        when(random.nuevo()).thenReturn(probabilidad);

        GeneradorDeCartas generador = new GeneradorDeCartas(random, puntosMaximos);
        Enemigo enemigo = (Enemigo) generador.nueva();

        assertEquals(resultado, enemigo.puntosDeSalud());
    }

    public static Stream<Arguments> puntosDeVida() {
        return Stream.of(
                Arguments.of(1, 0.5, 1),
                Arguments.of(3, 0.5, 2),
                Arguments.of(15, 0.1, 2),
                Arguments.of(7, 1, 7),
                Arguments.of(10, 0, 1)
        );
    }
}
