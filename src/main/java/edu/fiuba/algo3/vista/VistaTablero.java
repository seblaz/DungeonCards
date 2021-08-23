package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorCarta;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class VistaTablero extends HBox implements Observador {
    private final Pane root;
    private final Tablero tablero;
    private final Heroe heroe;

    public VistaTablero(Tablero tablero, Heroe heroe) {
        super();
        this.tablero = tablero;
        this.heroe = heroe;
        root = Loader.load("tablero.fxml");

        tablero.agregarObservador(this);
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() {
        GridPane grid = (GridPane) root.lookup("#grid");
        grid.getChildren().clear();

        for (int fila = 0; fila < tablero.dimension(); fila++) {
            for (int columna = 0; columna < tablero.dimension(); columna++) {
                Carta carta = tablero.obtener(new Vector(columna, fila));
                ControladorCarta controlador = new ControladorCarta(carta, tablero, heroe);
                grid.add(new VistaCarta(carta, controlador), fila, columna);
            }
        }
    }
}
