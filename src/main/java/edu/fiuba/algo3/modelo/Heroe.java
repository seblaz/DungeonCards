package edu.fiuba.algo3.modelo;

public class Heroe extends Observable implements Carta {
    private final Salud salud;

    public Heroe() {
        this.salud = new Salud(10);
    }

    public int puntosDeSalud() {
        return this.salud.puntos();
    }

    public void atacar(Enemigo enemigo) {
        int danio = enemigo.puntosDeDanio();
        enemigo.recibirDanio(this.salud.puntos());
        this.recibirDanio(danio);
        this.notificar();
    }

    public void recibirDanio(int danio) {
        this.salud.disminuir(danio);
    }

    @Override
    public boolean activa() {
        return true;
    }

    public boolean activar(Heroe heroe) {
        return true;
    }
}
