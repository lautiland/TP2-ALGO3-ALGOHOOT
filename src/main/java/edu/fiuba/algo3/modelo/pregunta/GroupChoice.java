package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    public static final int CANTIDAD_OPCIONES_MIN = 2;
    public static final int CANTIDAD_OPCIONES_MAX = 6;

    private final ArrayList<Opcion> opcionesGrupo1;
    public GroupChoice(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesGrupo1) {
        super(enunciado, opciones, CANTIDAD_OPCIONES_MIN, CANTIDAD_OPCIONES_MAX);
        this.opcionesGrupo1 = opcionesGrupo1;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestasGrupo1) {
        for (Opcion opcion : opcionesGrupo1) {
            if (!respuestasGrupo1.contains(opcion)) return PUNTOS_NO_RESPONDIDA;
        }
        return PUNTOS_BIEN_RESPONDIDA;
    }
}