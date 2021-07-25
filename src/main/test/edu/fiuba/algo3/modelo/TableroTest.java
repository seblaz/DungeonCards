package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ejemplos.CartaEjemplo;
import edu.fiuba.algo3.modelo.ejemplos.TableroEjemplo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Tablero tablero = TableroEjemplo.crear().conCartas(cartas).build();
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
    public void obtieneLasCartasDelTablero(
            Tablero tablero,
            Vector posicion,
            Carta esperado
    ) {
        assertEquals(esperado, tablero.obtener(posicion));
    }

    public static Stream<Arguments> cartasPorPosicion() {
        Carta[][] cartas = cartas();
        Tablero tablero = TableroEjemplo.crear().conCartas(cartas).build();
        return Stream.of(
                Arguments.of(tablero, new Vector(0, 0), cartas[0][0]),
                Arguments.of(tablero,  new Vector(0, 1), cartas[1][0]),
                Arguments.of(tablero,  new Vector(1, 0), cartas[0][1]),
                Arguments.of(tablero,  new Vector(1, 2), cartas[2][1]),
                Arguments.of(tablero,  new Vector(2, 2), cartas[2][2])
        );
    }

    @ParameterizedTest
    @MethodSource("cartasADestruir")
    public void siLaCartaEsDestruidaSeOcupaSuPosicionConLaDelHeroe(
            Vector posicionCarta,
            Vector posicionHeroe
    ) {
        Carta[][] cartas = cartas();
        Heroe heroe = new Heroe();
        Carta cartaADestruir = mock(Carta.class);
        when(cartaADestruir.activar(heroe)).thenReturn(false);

        cartas[posicionCarta.y()][posicionCarta.x()] = cartaADestruir;
        cartas[posicionHeroe.y()][posicionHeroe.x()] = heroe;

        Tablero tablero = TableroEjemplo.crear().conCartas(cartas).build();
        tablero.activar(heroe, cartaADestruir);

        assertEquals(heroe, tablero.obtener(posicionCarta));
    }

    public static Stream<Arguments> cartasADestruir() {
        return Stream.of(
                //                   cartaADestruir              heroe
                Arguments.of(new Vector(2, 0), new Vector(1, 0)),
                Arguments.of(new Vector(1, 0), new Vector(2, 0)),
                Arguments.of(new Vector(0, 0), new Vector(1, 0)),
                Arguments.of(new Vector(1, 0), new Vector(1, 1)),
                Arguments.of(new Vector(2, 2), new Vector(2, 1)),
                Arguments.of(new Vector(2, 2), new Vector(1, 2))
        );
    }

    @Test
    public void siLaCartaNoEsDestruidaNoSeOcupaSuPosicion() {
        Carta[][] cartas = cartas();
        Heroe heroe = new Heroe();
        Carta cartaAPermanecer = mock(Carta.class);
        when(cartaAPermanecer.activar(heroe)).thenReturn(true);

        cartas[0][0] = cartaAPermanecer;
        cartas[0][1] = heroe;

        Tablero tablero = TableroEjemplo.crear().conCartas(cartas).build();
        tablero.activar(heroe, cartaAPermanecer);

        assertEquals(cartaAPermanecer, tablero.obtener(new Vector(0, 0)));
    }

    @ParameterizedTest
    @MethodSource("cartasAMover")
    public void siLaCartaEsDestruidaOtraSeMueveUnEspacio(
            Vector posicionCartaADestruir,
            Vector posicionHeroe,
            Vector posicionCartaAMover
    ) {
        Carta[][] cartas = cartas();
        Heroe heroe = new Heroe();
        Carta cartaADestruir = mock(Carta.class);
        when(cartaADestruir.activar(heroe)).thenReturn(false);
        Carta cartaAMover = cartas[posicionCartaAMover.y()][posicionCartaAMover.x()];

        cartas[posicionCartaADestruir.y()][posicionCartaADestruir.x()] = cartaADestruir;
        cartas[posicionHeroe.y()][posicionHeroe.x()] = heroe;

        Tablero tablero = TableroEjemplo.crear().conCartas(cartas).build();
        tablero.activar(heroe, cartaADestruir);

        assertEquals(cartaAMover, tablero.obtener(posicionHeroe));
    }

    public static Stream<Arguments> cartasAMover() {
        return Stream.of(
                //                  cartaADestruir                 heroe              cartaAMover
                Arguments.of(new Vector(2, 0), new Vector(1, 0), new Vector(0, 0)),
                Arguments.of(new Vector(0, 0), new Vector(1, 0), new Vector(2, 0)),
                Arguments.of(new Vector(0, 0), new Vector(0, 1), new Vector(0, 2)),
                Arguments.of(new Vector(1, 0), new Vector(1, 1), new Vector(1, 2)),
                Arguments.of(new Vector(1, 2), new Vector(1, 1), new Vector(1, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("cartasNuevas")
    public void siLaCartaEsDestruidaApareceUnaNueva(
            Vector posicionCartaADestruir,
            Vector posicionHeroe,
            Vector posicionNueva
    ) {
        Carta[][] cartas = cartas();
        Heroe heroe = new Heroe();
        Carta cartaADestruir = mock(Carta.class);
        when(cartaADestruir.activar(heroe)).thenReturn(false);

        cartas[posicionCartaADestruir.y()][posicionCartaADestruir.x()] = cartaADestruir;
        cartas[posicionHeroe.y()][posicionHeroe.x()] = heroe;

        GeneradorDeCartas generadorDeCartas = mock(GeneradorDeCartas.class);
        Carta nuevaCartaEsperada = new CartaEjemplo();
        when(generadorDeCartas.nueva()).thenReturn(nuevaCartaEsperada);

        Tablero tablero = TableroEjemplo.crear()
                .conCartas(cartas)
                .conGeneradorDeCartas(generadorDeCartas)
                .build();

        tablero.activar(heroe, cartaADestruir);

        assertEquals(nuevaCartaEsperada, tablero.obtener(posicionNueva));
    }

    public static Stream<Arguments> cartasNuevas() {
        return Stream.of(
                //                  cartaADestruir                 heroe              cartaNueva
                Arguments.of(new Vector(2, 0), new Vector(1, 0), new Vector(0, 0)),
                Arguments.of(new Vector(0, 0), new Vector(1, 0), new Vector(2, 0)),
                Arguments.of(new Vector(0, 0), new Vector(0, 1), new Vector(0, 2)),
                Arguments.of(new Vector(1, 0), new Vector(1, 1), new Vector(1, 2)),
                Arguments.of(new Vector(1, 2), new Vector(1, 1), new Vector(1, 0)),
                Arguments.of(new Vector(1, 0), new Vector(0, 0), new Vector(0, 0))
        );
    }

    @ParameterizedTest
    @MethodSource("posicionesFueraDeTablero")
    public void alPedirUnaCartaEnUnaPosicionFueraDelTableroElevaUnaExcepcion(Vector posicion) {
        Tablero tablero = TableroEjemplo.crear().build();
        assertThrows(PosicionFueraDeLimites.class, () -> {
            tablero.obtener(posicion);
        });
    }

    public static Stream<Arguments> posicionesFueraDeTablero() {
        return Stream.of(
                Arguments.of(new Vector(-1, -1)),
                Arguments.of(new Vector(-1, 0)),
                Arguments.of(new Vector(-1, 1)),
                Arguments.of(new Vector(-1, 2)),
                Arguments.of(new Vector(-1, 3)),
                Arguments.of(new Vector(0, -1)),
                Arguments.of(new Vector(1, -1)),
                Arguments.of(new Vector(2, -1)),
                Arguments.of(new Vector(3, -1)),
                Arguments.of(new Vector(0, 3)),
                Arguments.of(new Vector(1, 3)),
                Arguments.of(new Vector(2, 3)),
                Arguments.of(new Vector(3, 3)),
                Arguments.of(new Vector(3, 2)),
                Arguments.of(new Vector(3, 1)),
                Arguments.of(new Vector(3, 0))
        );
    }
}

