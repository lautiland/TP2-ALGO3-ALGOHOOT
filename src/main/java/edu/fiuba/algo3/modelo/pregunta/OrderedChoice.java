package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas) {
        super(enunciado, opcionesOrdenadas, 2, 6);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int i = 0;
        for (Opcion respuesta : respuestas) {
            if(!(opciones.get(i) == respuesta)) return 0;
            i++;
        }
        return 1;
    }
}
