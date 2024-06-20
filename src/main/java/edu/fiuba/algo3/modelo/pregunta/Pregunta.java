package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

abstract public class Pregunta {
    protected final String enunciado;
    protected final ArrayList<Opcion> opciones;
    protected final ArrayList<Opcion> opcionesCorrectas;
    protected evaluadorDePuntajes evaluador;

    protected Pregunta(String enunciado, ArrayList<Opcion> opciones,
                       int cantidadOpcionesMin, int cantidadOpcionesMax ,
                       ArrayList<Opcion> opcionesCorrectas, evaluadorDePuntajes evaluador){

        if (opciones.size() < cantidadOpcionesMin || opciones.size() > cantidadOpcionesMax){
            throw new CantidadOpcionesInvalida("La cantidad de opciones es invalida");
        }

        this.enunciado = enunciado;
        this.opciones = opciones;
        this.opcionesCorrectas = opcionesCorrectas;

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

    /*
    NOTAS PARA EL PARSER:
    PARA ORDERED CHOICE, LA LISTA DE RESPUESTAS CORRECTAS DEBE ESTAR ORDENADA.
    PARA GROUP CHOICE, LA LISTA DE RESPUESTAS CORRECTAS DEBE SER SOLO DE EL PRIMER GRUPO.
     */

    //el usuario elige 2 buenas y habian 3 buenas y 2 malas,

    //parser agarra las respuestas buenas de un solo grupo-> g1.

    //respuestas buenas = [g1: opc, opc, opc]

    //le pido al usuario que ordene en X1 y X2.

    //verifico X1 con G1 -> si todas buenas pertenece a g1 y están bien, si todas malas
    //pertenece a g2 y está bien. else, están mal


    protected int calcularPuntaje( int respuestasCorrectas, int respuestasIncorrectas){
        return evaluador.calcular(respuestasCorrectas,respuestasIncorrectas);
    }

    public abstract boolean esCompatibleCon(Modificador modificadorActual);
}
