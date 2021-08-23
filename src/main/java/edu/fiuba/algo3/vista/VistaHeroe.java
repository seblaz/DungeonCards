package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Heroe;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class VistaHeroe extends HBox implements Observador {
    private final Pane root;
    private final Heroe heroe;

    public VistaHeroe(Heroe heroe) {
        super();
        this.heroe = heroe;
        heroe.agregarObservador(this);
        this.root = Loader.load("heroe.fxml");
        getChildren().add(root);
        actualizar();
    }

    public void actualizar() {
        ((Text) root.lookup("#salud")).setText(String.valueOf(heroe.puntosDeSalud()));
    }
}
