package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntos;
    private ArrayList<Opcion> respuestasActuales;
    private ArrayList<Modificador> modificadores;
    private Modificador modificadorActual;

    public Jugador(String nombre){
        this.puntos = 0;
        this.nombre = nombre;
        modificadores.add(new Multiplicador(2));
        modificadores.add(new Multiplicador(3));
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


    public Modificador obtenerModificador(){
        return modificadorActual;
    }
    public void responderModificador(Modificador modificador){
        modificadorActual = modificador;
    }

    public ArrayList<Opcion> obtenerRespuestas(){
        return respuestasActuales;
    }

    public void modificarPuntos(int puntos){
        this.puntos += puntos;
    }
}
