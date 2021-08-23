package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ObservableTest {

    @Test
    public void notificaALosObservadoresDeUnCambio() {
        Observable observable = new Observable();
        Observador observador1 = mock(Observador.class);
        Observador observador2 = mock(Observador.class);
        observable.agregarObservador(observador1);
        observable.agregarObservador(observador2);

        observable.notificar();

        verify(observador1).actualizar();
        verify(observador2).actualizar();
    }
}
