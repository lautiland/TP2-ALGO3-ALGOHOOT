package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorPenalty;
import edu.fiuba.algo3.modelo.modificador.Anulador;

import java.util.ArrayList;
import java.util.Collections;

public class PenaltyTF extends Pregunta{
    public PenaltyTF(String enunciado, ArrayList<Opcion> opciones, Opcion opcionCorrecta, String categoria, String descripcionRespuesta) {
        super(enunciado, opciones, 2,2,
                new ArrayList<>(Collections.singletonList(opcionCorrecta)), new EvaluadorPenalty(), categoria, descripcionRespuesta, new ArrayList<>(){{
            add(new Anulador());
            add(new Multiplicador(2));
            add(new Multiplicador(3));
        }});
    }
}