package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class Juego {
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Pregunta> preguntas;

    public Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        if (jugadores.size() < 2){
            throw new CantidadJugadoresInvalida("La cantidad de jugadores debe ser al menos 2");
        }
        if (preguntas.isEmpty()){
            throw new CantidadPreguntasInvalida("La cantidad de preguntas debe ser al menos 1");
        }

        this.jugadores = jugadores;
        this.preguntas = preguntas;
    }

    public void evaluarRespuestas(){
        Pregunta preguntaActual = preguntas.remove(0);
        jugadores.forEach(jugador -> {
            ArrayList<Opcion> respuestas = jugador.obtenerRespuestas();
            int puntaje = preguntaActual.evaluarRespuestas(respuestas);
            jugador.modificarPuntos(puntaje);
        });
    }
}
