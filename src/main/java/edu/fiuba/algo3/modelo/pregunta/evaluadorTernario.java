package edu.fiuba.algo3.modelo.pregunta;

public class evaluadorTernario extends evaluadorDePuntajes {
    @Override
    public int calcular(int respuestasCorrectas, int respuestasIncorrectas){
        return respuestasIncorrectas == 0 ? PUNTOS_BIEN_RESPONDIDA : PUNTOS_MAL_RESPONDIDA;
    }
}
