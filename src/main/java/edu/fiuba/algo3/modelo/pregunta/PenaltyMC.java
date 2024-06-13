package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class PenaltyMC extends Pregunta{
    private final ArrayList<Opcion> opcionesCorrectas;
    public PenaltyMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, 2, 5);
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

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Exclusividad"));
    }
}