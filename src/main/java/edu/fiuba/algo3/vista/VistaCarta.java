package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Heroe;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Map;

public class VistaCarta extends HBox {
    public VistaCarta(Carta carta) throws IOException {
        super();
        Map<Class, VistaFactory<Carta, Parent>> vistas = Map.of(
                Heroe.class, (Carta heroe) -> new VistaHeroe((Heroe) heroe),
                Enemigo.class, (Carta heroe) -> new VistaEnemigo((Enemigo) heroe)
        );

        getChildren().add(vistas.get(carta.getClass()).vista(carta));
    }
}
