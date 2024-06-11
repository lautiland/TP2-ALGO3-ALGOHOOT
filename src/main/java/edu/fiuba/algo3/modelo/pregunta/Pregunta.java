package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

abstract public class Pregunta {
    protected final String enunciado;
    protected final ArrayList<Opcion> opciones;

    protected Pregunta(String enunciado, ArrayList<Opcion> opciones, int cantidadOpcionesMin, int cantidadOpcionesMax){
        if (opciones.size() < cantidadOpcionesMin || opciones.size() > cantidadOpcionesMax){
            throw new CantidadOpcionesInvalida("La cantidad de opciones es invalida");
        }
        this.enunciado = enunciado;
        this.opciones = opciones;
    }

    public Opcion seleccionarOpcion(int indice){
        return this.opciones.get(indice);
    }

    public abstract int evaluarRespuestas(ArrayList<Opcion> respuestas);
}