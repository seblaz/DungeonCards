package edu.fiuba.algo3.vista;

@FunctionalInterface
public interface VistaFactory<T, R> {
    R vista(T t);
}
