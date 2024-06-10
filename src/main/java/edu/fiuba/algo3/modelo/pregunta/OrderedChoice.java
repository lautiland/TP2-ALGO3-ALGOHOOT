package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas) {
        super(enunciado, opcionesOrdenadas, 2, 5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int i = 0;
        for (Opcion respuesta : respuestas) {
            if( respuesta != opciones.get(i) ) return 0;
        }
        return 1;
    }
}
