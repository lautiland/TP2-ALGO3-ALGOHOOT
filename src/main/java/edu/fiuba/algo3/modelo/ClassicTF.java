package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ClassicTF extends Pregunta{
    public ClassicTF(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones);
    }

    @Override
    public Opcion seleccionarOpcion(int indice) {
        return this.opciones.get(indice);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int validas = 0;
        for (Opcion respuesta : respuestas) {
            if (respuesta.esCorrecta()) {
                validas++;
            }
        }

        return validas;
    }
}
