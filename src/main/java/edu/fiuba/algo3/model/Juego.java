package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.CantidadJugadoresInvalido;
import edu.fiuba.algo3.model.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.model.excepciones.MultiplicadorInvalido;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;
import edu.fiuba.algo3.model.modificador.Modificador;
import edu.fiuba.algo3.model.modificador.Multiplicador;
import edu.fiuba.algo3.model.parser.JuegoParser;
import edu.fiuba.algo3.model.pregunta.Pregunta;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Juego {
    private static final int NO_ENCONTRADO = -1;
    private static final int CANTIDAD_JUGADORES_MINIMOS = 2;
    private final ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;
    private final Modificador anulador;
    private final Modificador exclusividad;
    private final ArrayList<Modificador> multiplicadores;
    private Pregunta preguntaActual;

    public Juego(ArrayList<Jugador> jugadores){
        if (jugadores.size() < CANTIDAD_JUGADORES_MINIMOS){
            throw new CantidadJugadoresInvalido("La cantidad de jugadores debe ser al menos 2");
        }

        this.jugadores = jugadores;

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(CANTIDAD_JUGADORES_MINIMOS));
        multiplicadores.add(new Multiplicador(3));
    }

    // Este dejará de existir a futuro
    public Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas) {
        if (jugadores.size() < CANTIDAD_JUGADORES_MINIMOS){
            throw new CantidadJugadoresInvalido("La cantidad de jugadores debe ser al menos 2");
        }
        if (preguntas.isEmpty()){
            throw new CantidadPreguntasInvalida("La cantidad de preguntas debe ser al menos 1");
        }

        this.jugadores = jugadores;
        this.preguntas = preguntas;
        preguntaActual = preguntas.remove(0);

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(CANTIDAD_JUGADORES_MINIMOS));
        multiplicadores.add(new Multiplicador(3));
    }

    public void cargarPreguntas(Reader archivo){
        JuegoParser parser = new JuegoParser();
        preguntas = parser.parsear(archivo, "json");
        preguntaActual = preguntas.remove(0);
    }

    public void activarAnulador(Jugador jugador){
        if (preguntaActual.esCompatibleCon(anulador)) {
            anulador.usar(jugador);
        }
    }

    public void activarExclusividad(Jugador jugador){
        if (preguntaActual.esCompatibleCon(exclusividad)) {
            exclusividad.usar(jugador);
        }
    }

    public void activarMultiplicador(Jugador jugador, int factor){
        int i = multiplicadores.indexOf(new Multiplicador(factor));
        if(i == NO_ENCONTRADO){
            throw new MultiplicadorInvalido();
        }

        Multiplicador multiplicador = (Multiplicador) multiplicadores.get(i);

        if (preguntaActual.esCompatibleCon(multiplicador)) {
            multiplicador.usar(jugador);
        }
    }

    public void responder(Jugador jugador, ArrayList<Opcion> respuestas){
        jugador.responderPregunta(respuestas);
    }

    private HashMap<Jugador,Integer> filtrarPuntajes(HashMap<Jugador, Integer> puntajes){
        HashMap<Jugador,Integer> puntajeFiltrado = anulador.filtrarPuntos(puntajes);
        puntajeFiltrado = exclusividad.filtrarPuntos(puntajeFiltrado);
        for (Modificador multiplicador : multiplicadores) {
            puntajeFiltrado = multiplicador.filtrarPuntos(puntajeFiltrado);
        }

        return puntajeFiltrado;
    }

    public Pregunta obtenerPreguntaActual(){
        return preguntaActual;
    }

    public boolean siguientePregunta(){
        if (preguntas.isEmpty()){
            return false;
        }

        preguntaActual = preguntas.remove(0);
        return true;
    }

    public void evaluarRespuestas(){
        HashMap<Jugador, Integer> puntajes = new HashMap<>();

        jugadores.forEach(jugador -> {
            ArrayList<Opcion> respuestas = jugador.obtenerRespuestas();
            int puntajeActual = preguntaActual.evaluarRespuestas(respuestas);
            puntajes.put(jugador, puntajeActual);
        });

        HashMap<Jugador,Integer> puntajesFinales = this.filtrarPuntajes(puntajes);

        puntajesFinales.forEach(Jugador::modificarPuntos);
        anulador.desactivar();
        exclusividad.desactivar();
        multiplicadores.forEach(Modificador::desactivar);
    }
}
