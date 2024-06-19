package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.modificador.Anulador;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego {
    private final ArrayList<Jugador> jugadores;
    private final ArrayList<Pregunta> preguntas;
    private final Modificador anulador;
    private final Modificador exclusividad;

    public Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas){
        if (jugadores.size() < 2){
            throw new CantidadJugadoresInvalida("La cantidad de jugadores debe ser al menos 2");
        }
        if (preguntas.isEmpty()){
            throw new CantidadPreguntasInvalida("La cantidad de preguntas debe ser al menos 1");
        }

        this.jugadores = jugadores;
        this.preguntas = preguntas;

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
    }

    public void activarAnulador(Jugador jugador){
        Pregunta preguntaActual = preguntas.get(0);
        if (preguntaActual.esCompatibleCon(anulador)) {
            anulador.usar(jugador);
        }
    }

    public void activarExclusividad(Jugador jugador){
        Pregunta preguntaActual = preguntas.get(0);
        if (preguntaActual.esCompatibleCon(exclusividad)) {
            exclusividad.usar(jugador);
        }
    }

    public void activarMultiplicador(Jugador jugador, int factor){
        jugador.activarMultiplicador(factor);
    }

    public void responder(Jugador jugador, ArrayList<Opcion> respuestas){
        jugador.responderPregunta(respuestas);
    }

    public void evaluarRespuestas(){
        Pregunta preguntaActual = preguntas.remove(0);
        HashMap<Jugador, Integer> puntajes = new HashMap<>();

        jugadores.forEach(jugador -> {
            ArrayList<Opcion> respuestas = jugador.obtenerRespuestas();
            int puntajeActual = preguntaActual.evaluarRespuestas(respuestas);
            puntajes.put(jugador, puntajeActual);
        });

        HashMap<Jugador,Integer> puntajesAnulador = anulador.filtrarPuntos(puntajes);
        HashMap<Jugador,Integer> puntajesExclusividad = exclusividad.filtrarPuntos(puntajesAnulador);

        puntajesExclusividad.forEach(Jugador::modificarPuntos);
        anulador.desactivar();
        exclusividad.desactivar();
    }
}
