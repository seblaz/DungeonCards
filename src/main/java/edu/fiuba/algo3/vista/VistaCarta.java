package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorCarta;
import edu.fiuba.algo3.modelo.Carta;
import edu.fiuba.algo3.modelo.Enemigo;
import edu.fiuba.algo3.modelo.Heroe;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.util.Map;

public class VistaCarta extends HBox {
    public VistaCarta(Carta carta, ControladorCarta controlador) {
        super();
        Map<Class, VistaFactory<Carta, Parent>> vistas = Map.of(
                Heroe.class, (Carta heroe) -> new VistaHeroe((Heroe) heroe),
                Enemigo.class, (Carta heroe) -> new VistaEnemigo((Enemigo) heroe)
        );

        Parent vista = vistas.get(carta.getClass()).vista(carta);

        vista.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controlador.activar();
        });
        getChildren().add(vista);
    }
}
