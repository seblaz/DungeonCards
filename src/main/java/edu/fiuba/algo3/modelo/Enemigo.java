package edu.fiuba.algo3.modelo;

public class Enemigo extends Observable implements Carta {
    private final Salud salud;

    public Enemigo(int puntosDeSalud) {
        this.salud = new Salud(puntosDeSalud);
    }

    public int puntosDeDanio() {
        return this.salud.puntos();
    }

    public int puntosDeSalud() {
        return this.salud.puntos();
    }

    public void recibirDanio(int danio) {
        this.salud.disminuir(danio);
    }

    @Override
    public boolean activa() {
        return this.salud.vivo();
    }

    public boolean activar(Heroe heroe) {
        heroe.atacar(this);
        this.notificar();
        return this.salud.vivo();
    }
}
