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
        for (Opcion respuesta : respuestasGrupo1) {
            if (!opcionesGrupo1.contains(respuesta)) return 0;
        }
        return 1;
    }
}