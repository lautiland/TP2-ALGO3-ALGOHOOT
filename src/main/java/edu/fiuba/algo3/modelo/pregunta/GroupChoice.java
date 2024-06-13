package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

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
            if (!respuestasGrupo1.contains(opcion)) return PUNTOS_NO_RESPONDIDA;
        }
        return PUNTOS_BIEN_RESPONDIDA;
    }

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}