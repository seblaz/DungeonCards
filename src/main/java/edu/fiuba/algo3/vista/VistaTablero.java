package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorCarta;
import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Heroe;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.Vector;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VistaTablero extends HBox {
    private final Pane root;
    private final Tablero tablero;
    private final Heroe heroe;

    public VistaTablero(Tablero tablero, Heroe heroe) throws IOException {
        this.tablero = tablero;
        this.heroe = heroe;
        root = Loader.load("tablero.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() throws IOException {
        GridPane grid = (GridPane) root.lookup("#grid");

        for (int fila = 0; fila < tablero.dimension(); fila++) {
            for (int columna = 0; columna < tablero.dimension(); columna++) {
                Carta carta = tablero.obtener(new Vector(columna, fila));
                ControladorCarta controlador = new ControladorCarta(carta, tablero, heroe);
                grid.add(new VistaCarta(carta, controlador), fila, columna);
            }
        }
    }
}
