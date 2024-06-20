package edu.fiuba.algo3.modelo.pregunta;

public class evaluadorPenalty extends evaluadorDePuntajes {
    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        return (respuestasCorrectas * PUNTOS_BIEN_RESPONDIDA) + (respuestasIncorrectas * PUNTOS_MAL_RESPONDIDA_PENALIDAD);
    }
}