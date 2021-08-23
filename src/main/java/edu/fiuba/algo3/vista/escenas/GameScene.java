package edu.fiuba.algo3.vista.escenas;

import edu.fiuba.algo3.modelo.DungeonCards;
import edu.fiuba.algo3.vista.VistaTablero;
import javafx.scene.Scene;

public class GameScene extends Scene {
    public GameScene(DungeonCards juego) {
        super(new VistaTablero(juego.tablero(), juego.heroe()));
    }
}
