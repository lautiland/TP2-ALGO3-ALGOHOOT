package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernarioAcumulativo;
import edu.fiuba.algo3.modelo.modificador.Anulador;

import java.util.ArrayList;

public class ParcialMC extends Pregunta{
    public ParcialMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas, String categoria, String descripcionRespuesta) {
        super(enunciado, opciones, 2, 5, opcionesCorrectas, new EvaluadorTernarioAcumulativo(), categoria, descripcionRespuesta, new ArrayList<>(){{
            add(new Anulador());
            add(new Multiplicador(2));
            add(new Multiplicador(3));
        }});
    }
}
