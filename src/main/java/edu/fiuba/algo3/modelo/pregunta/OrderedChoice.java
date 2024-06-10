package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones, 2, 5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int puntosTotales = 1;
        int i = 1;
        for (Opcion respuesta : respuestas) {
            if (respuesta.getOrden() == i) {
                i++;
            }else{
                puntosTotales = 0;
                break;
            }
        }
        return puntosTotales;
    }
}
