package edu.fiuba.algo3.modelo;

public class Enemigo {
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

    public void activar(Heroe heroe) {
        heroe.atacar(this);
    }
}
