package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones, 2,5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int validas = 0;
        for (Opcion respuesta : respuestas) {
            if (!respuesta.esCorrecta()){
                return 0;
            }
            validas++;
        }
        return validas;
    }
    /*
    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas, ArrayList<Opcion> respuestasCorrectas) {
        int validas = 0;
        for (Opcion respuesta : respuestas) {
            //if (miRespuestaActual NO está en respuestasCorrectas){
                return 0;
            }
            validas++;
        }
        return validas;
    }
     */
}
