package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.vista.VistaEnemigo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        VistaEnemigo vistaEnemigo = new VistaEnemigo(new Enemigo(11));

        var scene = new Scene(vistaEnemigo, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}