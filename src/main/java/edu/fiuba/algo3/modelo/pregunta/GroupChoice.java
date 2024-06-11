package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<Opcion> opcionesGrupo1;
    public GroupChoice(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesGrupo1) {
        super(enunciado, opciones, 2, 6);
        this.opcionesGrupo1 = opcionesGrupo1;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestasGrupo1) {
        for (Opcion opcion : opcionesGrupo1) {
            if (!respuestasGrupo1.contains(opcion)) return 0;
        }
        return 1;
    }
}