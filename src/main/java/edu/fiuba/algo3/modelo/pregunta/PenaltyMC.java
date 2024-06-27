package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorPenalty;
import edu.fiuba.algo3.modelo.modificador.Anulador;

import java.util.ArrayList;

public class PenaltyMC extends Pregunta{
    public PenaltyMC(String enunciado, ArrayList<Opcion> opciones,
                     ArrayList<Opcion> opcionesCorrectas, String categoria, String descripcionRespuesta) {

        super(enunciado, opciones, 2, 5,opcionesCorrectas, new EvaluadorPenalty(), categoria, descripcionRespuesta,
                new ArrayList<>(){{
                    add(new Anulador());
                    add(new Multiplicador(2));
                    add(new Multiplicador(3));
                }});
    }
}