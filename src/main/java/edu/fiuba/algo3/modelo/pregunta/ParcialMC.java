package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ParcialMC extends Pregunta{
    private final ArrayList<Opcion> opcionesCorrectas;
    public ParcialMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, 2, 5);
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int puntosTotales = 0;
        for (Opcion respuesta : respuestas) {
            if (!opcionesCorrectas.contains(respuesta)) return 0;
            puntosTotales++;
        }
        return puntosTotales;
    }
}
