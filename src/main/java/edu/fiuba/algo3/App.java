package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.DungeonCards;
import edu.fiuba.algo3.modelo.GeneradorRandom;
import edu.fiuba.algo3.vista.escenas.GameScene;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        DungeonCards juego = new DungeonCards(new GeneradorRandom());
        stage.setScene(new GameScene(juego));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}