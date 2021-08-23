package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observador> observadores;

    public Observable() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        this.observadores.add(observador);
    }

    public void notificar() {
        this.observadores.forEach(Observador::actualizar);
    }
}
