package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class PenaltyMC extends Pregunta{
    public static final int CANTIDAD_OPCIONES_MIN = 2;
    public static final int CANTIDAD_OPCIONES_MAX = 5;

    private final ArrayList<Opcion> opcionesCorrectas;
    public PenaltyMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, CANTIDAD_OPCIONES_MIN, CANTIDAD_OPCIONES_MAX);
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int puntosTotales = 0;
        for (Opcion respuesta : respuestas) {
            if (opcionesCorrectas.contains(respuesta)) puntosTotales += PUNTOS_BIEN_RESPONDIDA;
            else puntosTotales += PUNTOS_MAL_RESPONDIDA;
        }
        return puntosTotales;
    }
}