package edu.fiuba.algo3.modelo.pregunta;

public class evaluadorTernarioAcumulativo extends evaluadorDePuntajes {
    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        if(respuestasIncorrectas == 0){
            return respuestasCorrectas * PUNTOS_BIEN_RESPONDIDA;
        }return PUNTOS_MAL_RESPONDIDA;
    }
}
