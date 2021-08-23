package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class VistaEnemigo extends HBox implements Observador {
    private final HBox root;
    private final Enemigo enemigo;

    public VistaEnemigo(Enemigo enemigo) throws IOException {
        super();
        this.enemigo = enemigo;
        enemigo.agregarObservador(this);
        this.root = Loader.load("enemigo.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() {
        ((Text) root.lookup("#salud")).setText(String.valueOf(enemigo.puntosDeSalud()));
    }
}
