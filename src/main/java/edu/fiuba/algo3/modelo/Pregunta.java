package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract public class Pregunta {
    protected String enunciado;
    protected ArrayList<Opcion> opciones;

    public Pregunta(String enunciado, ArrayList<Opcion> opciones){
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    public void mostrarPregunta(){
        System.out.println(this.enunciado);
        this.opciones.forEach(Opcion::mostrarOpciones);
    }

    public abstract Opcion seleccionarOpcion(int indice);

    public abstract int evaluarRespuestas(ArrayList<Opcion> respuestas);
}
