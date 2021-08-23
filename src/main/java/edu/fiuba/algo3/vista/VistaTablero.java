package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Tablero;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class VistaTablero extends Parent {
    private final Pane root;
    private Tablero tablero;

    public VistaTablero(Tablero tablero) throws IOException {
        this.tablero = tablero;
        this.root = Loader.load("tablero.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() {

//        ((Text) root.lookup("#salud")).setText(String.valueOf(enemigo.puntosDeSalud()));
    }
}
