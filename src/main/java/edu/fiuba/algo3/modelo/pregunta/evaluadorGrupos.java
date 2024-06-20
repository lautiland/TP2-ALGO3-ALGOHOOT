package edu.fiuba.algo3.modelo.pregunta;

public class evaluadorGrupos extends evaluadorDePuntajes {

    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        if(respuestasCorrectas  == 0 || respuestasIncorrectas == 0){
            return PUNTOS_BIEN_RESPONDIDA;
        }return PUNTOS_MAL_RESPONDIDA;
    }
}
