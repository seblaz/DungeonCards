package edu.fiuba.algo3.vista;

import java.io.IOException;

@FunctionalInterface
public interface VistaFactory<T, R> {
    R vista(T t) throws IOException;
}
