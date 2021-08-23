package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.Vector;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VistaTablero extends HBox {
    private final Pane root;
    private final Tablero tablero;

    public VistaTablero(Tablero tablero) throws IOException {
        this.tablero = tablero;
        root = Loader.load("tablero.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() throws IOException {
        GridPane grid = (GridPane) root.lookup("#grid");

        for (int fila = 0; fila < tablero.dimension(); fila++) {
            for (int columna = 0; columna < tablero.dimension(); columna++) {
                Carta carta = tablero.obtener(new Vector(columna, fila));
                grid.add(new VistaCarta(carta), fila, columna);
            }
        }
    }
}
