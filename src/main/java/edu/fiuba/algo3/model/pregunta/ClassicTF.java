package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;
import java.util.Collections;

public class ClassicTF extends Pregunta{
    public ClassicTF(String enunciado, ArrayList<Opcion> opciones, Opcion opcionCorrecta, String categoria, String descripcionRespuesta) {
        super(enunciado, opciones, 2, 2, new ArrayList<>(Collections.singletonList(opcionCorrecta)), new EvaluadorTernario(), categoria, descripcionRespuesta, new ArrayList<>(){{
            add(new Anulador());
            add(new Exclusividad());
        }});
    }
}
