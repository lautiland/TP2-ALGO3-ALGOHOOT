package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.evaluadores.EvaluadorDePuntajes;
import edu.fiuba.algo3.model.modificador.Modificador;
import edu.fiuba.algo3.model.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.model.Opcion;

import java.util.ArrayList;

abstract public class Pregunta {
    protected final String enunciado;
    protected final ArrayList<Opcion> opciones;
    protected final ArrayList<Opcion> opcionesCorrectas;
    protected EvaluadorDePuntajes evaluador;
    private final String categoria;
    private final String descripcionRespuesta;
    private final ArrayList<Modificador> modificadoresCompatibles;

    protected Pregunta(String enunciado, ArrayList<Opcion> opciones,
                       int cantidadOpcionesMin, int cantidadOpcionesMax ,
                       ArrayList<Opcion> opcionesCorrectas, EvaluadorDePuntajes evaluador, String categoria, String descripcionRespuesta, ArrayList<Modificador> modificadoresCompatibles) {

        if (opciones.size() < cantidadOpcionesMin || opciones.size() > cantidadOpcionesMax){
            throw new CantidadOpcionesInvalida("La cantidad de opciones es invalida");
        }

        this.enunciado = enunciado;
        this.opciones = opciones;
        this.opcionesCorrectas = opcionesCorrectas;
        this.evaluador = evaluador;
        this.categoria = categoria;
        this.descripcionRespuesta = descripcionRespuesta;
        this.modificadoresCompatibles = modificadoresCompatibles;
    }

    public Opcion seleccionarOpcion(int indice){
        return this.opciones.get(indice);
    }

    public int evaluarRespuestas(ArrayList<Opcion> respuestas){

        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;

        for (Opcion opcion : opciones) {
            if(opcionesCorrectas.contains(opcion) && respuestas.contains(opcion)){
                respuestasCorrectas++;
            }else if(!opcionesCorrectas.contains(opcion) && respuestas.contains(opcion)){
                respuestasIncorrectas++;
            }
        }
        return calcularPuntaje(respuestasCorrectas,respuestasIncorrectas);
    }

    protected int calcularPuntaje( int respuestasCorrectas, int respuestasIncorrectas){
        return evaluador.calcular(respuestasCorrectas,respuestasIncorrectas);
    }

    public boolean esCompatibleCon(Modificador modificadorActual) {
        return modificadoresCompatibles.contains(modificadorActual);
    }
}
