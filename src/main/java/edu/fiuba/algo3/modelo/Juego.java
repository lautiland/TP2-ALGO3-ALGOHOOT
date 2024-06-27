package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.excepciones.MultiplicadorInvalido;
import edu.fiuba.algo3.modelo.modificador.Anulador;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import edu.fiuba.algo3.modelo.parser.JuegoParser;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;
import java.util.HashMap;

public class Juego {
    private static final int NO_ENCONTRADO = -1;
    private final ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;
    private final Modificador anulador;
    private final Modificador exclusividad;
    private final ArrayList<Modificador> multiplicadores;

    public Juego(ArrayList<Jugador> jugadores){
        if (jugadores.size() < 2){
            throw new CantidadJugadoresInvalida("La cantidad de jugadores debe ser al menos 2");
        }

        this.jugadores = jugadores;

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(2));
        multiplicadores.add(new Multiplicador(3));
    }

    // Este dejará de existir a futuro
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
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(2));
        multiplicadores.add(new Multiplicador(3));
    }

    public void cargarPreguntas(String ruta){
        JuegoParser parser = new JuegoParser();
        preguntas = parser.parsear(ruta, "json");
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
        Pregunta preguntaActual = preguntas.get(0);
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

    public void evaluarRespuestas(){
        Pregunta preguntaActual = preguntas.remove(0);
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
    }
}
