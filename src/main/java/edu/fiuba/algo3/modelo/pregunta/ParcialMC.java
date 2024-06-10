package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ParcialMC extends Pregunta{
    public ParcialMC(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones, 2, 5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int puntosTotales = 0;
        for (Opcion respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                puntosTotales++;
            }else{
                puntosTotales = 0;
                break;
            }
        }
        return puntosTotales;
    }
}
