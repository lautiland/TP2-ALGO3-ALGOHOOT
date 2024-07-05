package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.CantidadJugadoresInvalido;
import edu.fiuba.algo3.model.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.model.excepciones.MultiplicadorInvalido;
import edu.fiuba.algo3.model.excepciones.NombreJugadorInvalido;
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
    private final ArrayList<Jugador> turnoJugadores;
    private ArrayList<Pregunta> preguntas;
    private final Modificador anulador;
    private final Modificador exclusividad;
    private final ArrayList<Modificador> multiplicadores;
    private Pregunta preguntaActual;

    public Juego(ArrayList<Jugador> jugadores, Reader archivo){
        if (jugadores.size() < CANTIDAD_JUGADORES_MINIMOS){
            throw new CantidadJugadoresInvalido("La cantidad de jugadores debe ser al menos 2");
        }

        this.jugadores = jugadores;
        this.turnoJugadores = new ArrayList<>(jugadores);

        cargarPreguntas(archivo);

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(2));
        multiplicadores.add(new Multiplicador(3));
    }

    // Este contructor esta pensado para que los jugadores puedan crear sus preguntas y preguntar a los otros (no esta en el alcance de tp):
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
        this.turnoJugadores = new ArrayList<>(jugadores);

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

    public String getJugadorActual(){
        return turnoJugadores.get(0).getNombre();
    }

    public void activarAnulador(){
        if (preguntaActual.esCompatibleCon(anulador)) {
            anulador.usar(turnoJugadores.get(0));
        }
    }

    public void activarExclusividad(){
        if (preguntaActual.esCompatibleCon(exclusividad)) {
            exclusividad.usar(turnoJugadores.get(0));
        }
    }

    public int obtenerPuntaje(String nombreJugador){
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)){
                return jugador.getPuntos();
            }
        }

        throw new NombreJugadorInvalido();
    }

    public void activarMultiplicador(int factor){
        int i = multiplicadores.indexOf(new Multiplicador(factor));
        if(i == NO_ENCONTRADO){
            throw new MultiplicadorInvalido();
        }

        Multiplicador multiplicador = (Multiplicador) multiplicadores.get(i);

        if (preguntaActual.esCompatibleCon(multiplicador)) {
            multiplicador.usar(turnoJugadores.get(0));
        }
    }

    public Boolean sinJugadoresRestantes(){
        return turnoJugadores.isEmpty();
    }

    public void responder(ArrayList<Opcion> respuestas){

        Jugador jugadorActual = turnoJugadores.remove(0);

        jugadorActual.responderPregunta(respuestas);
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

    public ArrayList<String> obtenerNombresJugadores(){
        ArrayList<String> nombres = new ArrayList<>();
        jugadores.forEach(jugador -> nombres.add(jugador.getNombre()));
        return nombres;
    }

    public boolean siguientePregunta(){

        turnoJugadores.addAll(jugadores);

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
