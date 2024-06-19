package edu.fiuba.algo3.modelo;

public class Multiplicador {
    private final int factor;
    private int usos;

    public Multiplicador(int factor){
        this.factor = factor;
        this.usos = 2;
    }

    public int usar(int puntos){
        if (usos > 0){
            usos--;
            return puntos * factor;
        }
        return puntos;
    }

    public int getFactor(){
        return this.factor;
    }
}
