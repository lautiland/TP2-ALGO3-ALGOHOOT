package edu.fiuba.algo3.modelo.pregunta;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    public static final int CANTIDAD_OPCIONES_MIN = 2;
    public static final int CANTIDAD_OPCIONES_MAX = 5;

    private final ArrayList<Opcion> opcionesCorrectas;
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, CANTIDAD_OPCIONES_MIN, CANTIDAD_OPCIONES_MAX);
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        for (Opcion opcionCorrecta : opcionesCorrectas) {
            if (!respuestas.contains(opcionCorrecta)) return PUNTOS_NO_RESPONDIDA;
        }
        return PUNTOS_BIEN_RESPONDIDA;
    }
}
