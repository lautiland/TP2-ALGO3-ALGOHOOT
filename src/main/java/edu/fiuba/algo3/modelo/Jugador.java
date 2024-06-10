package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntos;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public ArrayList<Opcion> obtenerRespuestas(Pregunta pregunta){
        //TODO: CAMBIAR EN PRODUCCION
        /*
        Verificar cantidad de opciones posibles a elegir.
        Por cada opcion posible:
            obtener opcion de índice X
          (Para ordered, o multiple choice)

         */
        return null;
    }

    public void modificarPuntos(int puntos){
        this.puntos += puntos;
    }
}
