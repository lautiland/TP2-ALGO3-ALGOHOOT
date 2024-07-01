package edu.fiuba.algo3.model.evaluadores;

public class EvaluadorGroup extends EvaluadorDePuntajes{

    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas) {
        if (respuestasCorrectas == 0 || respuestasIncorrectas == 0){
            return PUNTOS_BIEN_RESPONDIDA;
        }
        return PUNTOS_MAL_RESPONDIDA;
    }
}
