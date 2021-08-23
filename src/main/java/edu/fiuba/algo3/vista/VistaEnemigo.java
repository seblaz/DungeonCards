package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Enemigo;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class VistaEnemigo extends Parent {
    private final Pane root;
    private final Enemigo enemigo;

    public VistaEnemigo(Enemigo enemigo) throws IOException {
        this.enemigo = enemigo;
        this.root = Loader.load("enemigo.fxml");
        getChildren().add(root);
        actualizar();
    }

    private void actualizar() {
        ((Text) root.lookup("#salud")).setText(String.valueOf(enemigo.puntosDeSalud()));
    }
}
