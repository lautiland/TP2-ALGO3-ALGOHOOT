package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ClassicTF extends Pregunta{
    private final Opcion opcionCorrecta;
    public ClassicTF(String enunciado, ArrayList<Opcion> opciones, Opcion opcionCorrecta) {
        super(enunciado, opciones, 2, 2);
        this.opcionCorrecta = opcionCorrecta;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        return  (respuestas.get(0).equals(opcionCorrecta)) ? PUNTOS_BIEN_RESPONDIDA : PUNTOS_NO_RESPONDIDA;
    }
}
