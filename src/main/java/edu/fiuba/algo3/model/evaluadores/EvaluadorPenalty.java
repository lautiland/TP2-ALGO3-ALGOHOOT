package edu.fiuba.algo3.model.evaluadores;

public class EvaluadorPenalty extends EvaluadorDePuntajes {
    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        return (respuestasCorrectas * PUNTOS_BIEN_RESPONDIDA) + (respuestasIncorrectas * PUNTOS_MAL_RESPONDIDA_PENALIDAD);
    }
}