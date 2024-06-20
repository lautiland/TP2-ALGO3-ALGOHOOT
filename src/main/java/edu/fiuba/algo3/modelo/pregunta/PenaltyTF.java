package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;
import java.util.Collections;

public class PenaltyTF extends Pregunta{
    private final Opcion opcionCorrecta;
    public PenaltyTF(String enunciado, ArrayList<Opcion> opciones, Opcion opcionCorrecta) {
        super(enunciado, opciones, 2,2,
                new ArrayList<>(Collections.singletonList(opcionCorrecta)), new evaluadorPenalty());
        this.opcionCorrecta = opcionCorrecta;
    }


    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Exclusividad"));
    }
}