package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        Map<String , Integer> puntosJugadores = new HashMap<>();
        Map<String , Modificador> modificadoresJugadores = new HashMap<>();

        jugadores.forEach(jugador -> {
            Modificador modificadorActual = jugador.obtenerModificador();
            if( preguntaActual.esCompatibleCon(modificadorActual) ){
                modificadoresJugadores.put(jugador.getNombre(), modificadorActual);
            };
            ArrayList<Opcion> respuestas = jugador.obtenerRespuestas();
            int puntaje = preguntaActual.evaluarRespuestas(respuestas);
            puntosJugadores.put(jugador.getNombre(), puntaje);
            //pide modificador->verifica si puede usarlo->lo añade->pide respuesta->evaluaRespuesta->
        });
        //recorrer ->->->
        //verifico cada modificador de cada usuario->nadie uso exclusividad/anulador -> asigno puntos*multipl
        //alguien uso exclusividad -> puntos a asignar *2 (each time que suceda) -> busco si alguien acertó
        //-> si fue el único en acertar, puntosnuevos = puntos a asignar, sino, do nothing.
        // verifico si alguien usó anulador -> si alguien lo usó, todos tienen 0 menos ese que lo usó
        //Si más de uno lo usó, nadie tiene puntos.
    }
}
