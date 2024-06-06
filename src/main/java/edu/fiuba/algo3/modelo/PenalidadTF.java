package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PenalidadTF extends Pregunta{
    public PenalidadTF(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones);
    }

    @Override
    public Opcion seleccionarOpcion(int indice) {
        return this.opciones.get(indice);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        return  (respuestas.get(0).esCorrecta()) ? 1 : -1;
    }
}