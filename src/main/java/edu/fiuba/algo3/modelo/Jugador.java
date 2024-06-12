package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntos;
    private ArrayList<Opcion> respuestasActuales;

    public Jugador(String nombre){
        this.puntos = 0;
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public void responderPregunta(ArrayList<Opcion> respuestas){
        this.respuestasActuales = respuestas;
    }

    public ArrayList<Opcion> obtenerRespuestas(){
        return respuestasActuales;
    }

    public void modificarPuntos(int puntos){
        this.puntos += puntos;
    }
}
