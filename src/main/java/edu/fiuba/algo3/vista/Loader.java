package edu.fiuba.algo3.vista;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

public class Loader extends FXMLLoader {

    public Loader(String filename) {
        super();
        URL location = getClass().getResource("/fxml/" + filename);
        this.setLocation(location);
    }

    public static <T> T load(String filename) throws IOException {
        return new Loader(filename).load();
    }

}
