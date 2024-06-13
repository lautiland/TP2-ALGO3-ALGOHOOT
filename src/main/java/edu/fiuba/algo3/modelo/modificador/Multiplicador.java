package edu.fiuba.algo3.modelo.modificador;

public class Multiplicador implements Modificador {
    private final int gradoDeMultiplicidad;

    public Multiplicador(int gradoDeMultiplicidad) {
        this.gradoDeMultiplicidad = gradoDeMultiplicidad;
    }

    public int modificarPuntaje(int puntajeSinModificar){
        return puntajeSinModificar*gradoDeMultiplicidad;
    }
}
