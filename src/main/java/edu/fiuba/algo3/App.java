package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.DungeonCards;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.GeneradorRandom;
import edu.fiuba.algo3.vista.VistaEnemigo;
import edu.fiuba.algo3.vista.VistaTablero;
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
        DungeonCards juego = new DungeonCards(new GeneradorRandom());
        VistaTablero vistaTablero = new VistaTablero(juego.tablero());

        var scene = new Scene(vistaTablero);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}