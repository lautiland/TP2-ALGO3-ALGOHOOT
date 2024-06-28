package edu.fiuba.algo3.model.evaluadores;

public class EvaluadorTernarioAcumulativo extends EvaluadorDePuntajes {
    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        if(respuestasIncorrectas == 0){
            return respuestasCorrectas * PUNTOS_BIEN_RESPONDIDA;
        }return PUNTOS_MAL_RESPONDIDA;
    }
}
