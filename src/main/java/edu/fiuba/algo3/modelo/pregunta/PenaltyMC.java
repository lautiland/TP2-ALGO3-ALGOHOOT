package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorPenalty;
import edu.fiuba.algo3.modelo.modificador.Anulador;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class PenaltyMC extends Pregunta{
    public PenaltyMC(String enunciado, ArrayList<Opcion> opciones,
                     ArrayList<Opcion> opcionesCorrectas, String categoria, String descripcionRespuesta) {

        super(enunciado, opciones, 2, 5,opcionesCorrectas, new EvaluadorPenalty(), categoria, descripcionRespuesta);
    }


    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return modificadorActual.equals(new Anulador()) || modificadorActual.equals(new Multiplicador(2)) || modificadorActual.equals(new Multiplicador(3));
    }
}