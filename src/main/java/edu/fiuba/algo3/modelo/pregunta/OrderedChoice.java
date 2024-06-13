package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public static final int CANTIDAD_OPCIONES_MIN = 2;
    public static final int CANTIDAD_OPCIONES_MAX = 5;

    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas) {
        super(enunciado, opcionesOrdenadas, CANTIDAD_OPCIONES_MIN, CANTIDAD_OPCIONES_MAX);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int i = 0;
        for (Opcion respuesta : respuestas) {
            if(!(opciones.get(i) == respuesta)) return PUNTOS_NO_RESPONDIDA;
            i++;
        }
        return PUNTOS_BIEN_RESPONDIDA;
    }
}
