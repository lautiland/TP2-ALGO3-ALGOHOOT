package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.modelo.modificador.Anulador;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;
import java.util.Collections;

public class ClassicTF extends Pregunta{
    public ClassicTF(String enunciado, ArrayList<Opcion> opciones, Opcion opcionCorrecta, String categoria, String descripcionRespuesta) {
        super(enunciado, opciones, 2, 2, new ArrayList<>(Collections.singletonList(opcionCorrecta)), new EvaluadorTernario(), categoria, descripcionRespuesta);
    }


    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return modificadorActual.equals(new Anulador()) || modificadorActual.equals(new Exclusividad());
    }
}
