package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;

    public Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        this.jugadores = jugadores;
        this.preguntas = preguntas;
    }

    public void hacerPregunta(){
        Pregunta preguntaActual = preguntas.remove(0);
        preguntaActual.mostrarPregunta();
        jugadores.forEach(jugador -> {
            ArrayList<Opcion> respuestas = jugador.obtenerRespuestas(preguntaActual);
            int puntaje = preguntaActual.evaluarRespuestas(respuestas);
            jugador.sumarPuntos(puntaje);
        });
    }
}
