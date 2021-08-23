package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Heroe;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorCarta implements EventHandler<MouseEvent> {
    private final Carta carta;
    private final Tablero tablero;
    private final Heroe heroe;

    public ControladorCarta(Carta carta, Tablero tablero, Heroe heroe) {
        this.carta = carta;
        this.tablero = tablero;
        this.heroe = heroe;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        tablero.activar(heroe, carta);
    }
}
