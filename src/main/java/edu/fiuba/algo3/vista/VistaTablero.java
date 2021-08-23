package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.Vector;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class VistaTablero extends Parent {
    private final GridPane root;
    private final Tablero tablero;

    public VistaTablero(Tablero tablero) throws IOException {
        this.tablero = tablero;
        this.root = Loader.load("tablero.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() throws IOException {
        for (int fila = 0; fila < tablero.dimension(); fila++) {
            for (int columna = 0; columna < tablero.dimension(); columna++) {
                Enemigo enemigo = (Enemigo) tablero.obtener(new Vector(columna, fila));
                root.add(new VistaEnemigo(enemigo), fila, columna);
            }
        }
    }
}
