package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas) {
        super(enunciado, opcionesOrdenadas, 2, 5);
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

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}
