package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorCarta;
import edu.fiuba.algo3.modelo.*;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;

public class VistaTablero extends HBox implements Observador {
    private final Pane root;
    private final Tablero tablero;
    private final Heroe heroe;

    public VistaTablero(Tablero tablero, Heroe heroe) {
        super();
        this.tablero = tablero;
        this.heroe = heroe;
        root = Loader.load("tablero.fxml");

        tablero.agregarObservador(this);
        getChildren().add(root);
        dibujar();
    }

    public void actualizar() {
        transiciones();
    }

    private List<Node> vistasCartas() {
        GridPane grid = (GridPane) root.lookup("#grid");
        return grid.getChildren();
    }

    private void transiciones() {
        SequentialTransition sequentialTransition = new SequentialTransition();
        ParallelTransition parallelTransition = new ParallelTransition();

        List<Node> anteriores = vistasCartas();
        for (int i = 0; i < anteriores.size(); i++) {
            VistaCarta vista = (VistaCarta) anteriores.get(i);
            Vector posicion = new Vector(i % 3, i / 3);
            Carta cartaNueva = tablero.obtener(posicion);

            if (vista.carta() != cartaNueva) {
                if (!vista.carta().activa()) {
                    sequentialTransition.getChildren().add(transicionCartaDestruida(vista));
                } else {
                    parallelTransition.getChildren().add(transicionCartaMovida(vista, posicion));
                }
            }
        }
        sequentialTransition.getChildren().add(parallelTransition);
        sequentialTransition.setOnFinished(e -> this.dibujar());
        sequentialTransition.play();
    }

    private Transition transicionCartaDestruida(Node vista) {
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(500));
        scaleTransition.setNode(vista);
        scaleTransition.setByY(-1);
        scaleTransition.setByX(-1);
        return scaleTransition;
    }

    private Transition transicionCartaMovida(VistaCarta vista, Vector posicionAnterior) {
        Vector posicionNueva = tablero.posicion(vista.carta());
        Vector direccion = posicionNueva.restar(posicionAnterior);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setNode(vista);
        translateTransition.setByX(direccion.y() * 195);
        translateTransition.setByY(direccion.x() * 263);

        return translateTransition;
    }

    private void dibujar() {
        GridPane grid = (GridPane) root.lookup("#grid");
        grid.getChildren().clear();
        for (int fila = 0; fila < tablero.dimension(); fila++) {
            for (int columna = 0; columna < tablero.dimension(); columna++) {
                Carta carta = tablero.obtener(new Vector(columna, fila));
                ControladorCarta controlador = new ControladorCarta(carta, tablero, heroe);
                grid.add(new VistaCarta(carta, controlador), fila, columna);
            }
        }
    }
}
