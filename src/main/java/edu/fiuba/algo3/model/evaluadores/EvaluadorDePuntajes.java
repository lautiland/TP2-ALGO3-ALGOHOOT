package edu.fiuba.algo3.model.evaluadores;

public abstract class EvaluadorDePuntajes {

    protected final int PUNTOS_MAL_RESPONDIDA_PENALIDAD = -1;
    protected final int PUNTOS_BIEN_RESPONDIDA = 1;
    protected final int PUNTOS_MAL_RESPONDIDA = 0;

    public abstract int calcular(int respuestasCorrectas, int respuestasIncorrectas);

}
