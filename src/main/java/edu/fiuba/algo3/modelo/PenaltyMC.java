package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PenaltyMC extends Pregunta{
    public PenaltyMC(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones, 2, 5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int puntosTotales = 0;
        for (Opcion respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                puntosTotales++;
            }else puntosTotales--;
        }
        return puntosTotales;
    }
}