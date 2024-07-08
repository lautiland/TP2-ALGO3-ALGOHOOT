package edu.fiuba.algo3.model;

import edu.fiuba.algo3.model.excepciones.*;
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
    private Pregunta preguntaActual;
    private final Modificador anulador;
    private final Modificador exclusividad;
    private final ArrayList<Multiplicador> multiplicadores;
    private final int limitePuntos;
    private final int limitePreguntas;
    private int cantidadPreguntas = 1;

    public Juego(ArrayList<Jugador> jugadores, Reader archivo, int limitePreguntas, int limitePuntos){
        if (jugadores.size() < CANTIDAD_JUGADORES_MINIMOS){
            throw new CantidadJugadoresInvalido("La cantidad de jugadores debe ser al menos 2");
        }

        this.jugadores = jugadores;
        this.turnoJugadores = new ArrayList<>(jugadores);

        cargarPreguntas(archivo);

        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        this.limitePuntos = limitePuntos;
        this.limitePreguntas = limitePreguntas;
        multiplicadores.add(new Multiplicador(2));
        multiplicadores.add(new Multiplicador(3));
    }

    public Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, int limitePuntos, int limitePreguntas) {
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
        this.limitePuntos = limitePuntos;
        this.limitePreguntas = limitePreguntas;
        this.anulador = new Anulador();
        this.exclusividad = new Exclusividad();
        this.multiplicadores = new ArrayList<>();
        multiplicadores.add(new Multiplicador(CANTIDAD_JUGADORES_MINIMOS));
        multiplicadores.add(new Multiplicador(3));
    }

    public boolean puedeUsarExclusividad(){
        if(!preguntaActual.esCompatibleCon(exclusividad)){
            return false;
        }

        return exclusividad.puedeUsar(turnoJugadores.get(0));
    }

    public boolean puedeUsarAnulador(){
        if(!preguntaActual.esCompatibleCon(anulador)){
            return false;
        }

        return anulador.puedeUsar(turnoJugadores.get(0));
    }

    public boolean puedeUsarMultiplicador(int factor){
        int i = multiplicadores.indexOf(new Multiplicador(factor));
        if(i == NO_ENCONTRADO){
            throw new MultiplicadorNoEncontrado();
        }
        if (!preguntaActual.esCompatibleCon(multiplicadores.get(i))){
            return false;
        }
        return multiplicadores.get(i).puedeUsar(turnoJugadores.get(0));
    }

    public boolean todosLosJugadoresRespondieron(){
        return turnoJugadores.isEmpty();
    }

    public boolean estaJuegoTerminado(){
        int preguntasRestantes = preguntas.size();
        if (preguntasRestantes == 0 || cantidadPreguntas >= limitePreguntas){
            return true;
        }

        for (Jugador jugador : jugadores) {
            if (jugador.getPuntos() >= limitePuntos){
                return true;
            }
        }

        return false;
    }

    public void mezclarPreguntas(){
        preguntas.add(preguntaActual);
        ArrayList<Pregunta> preguntasMezcladas = new ArrayList<>();
        String categoriaAnterior = "";
        while (!preguntas.isEmpty()){
            int i = (int) (Math.random() * preguntas.size());
            Pregunta pregunta = preguntas.remove(i);
            if (!pregunta.getCategoria().equals(categoriaAnterior)){
                preguntasMezcladas.add(pregunta);
                categoriaAnterior = pregunta.getCategoria();
            }else{
                preguntas.add(pregunta);
            }
        }
        preguntas = preguntasMezcladas;
        preguntaActual = preguntas.remove(0);
    }

    public void cargarPreguntas(Reader archivo){
        JuegoParser parser = new JuegoParser();
        preguntas = parser.parsear(archivo, "json");
        preguntaActual = preguntas.remove(0);
    }

    public void activarAnulador(){
        if(puedeUsarAnulador()){
            anulador.usar(turnoJugadores.get(0));
        }
    }

    public void activarExclusividad(){
        if(puedeUsarExclusividad()){
            exclusividad.usar(turnoJugadores.get(0));
        }
    }

    public void activarMultiplicador(int factor){
        int i = multiplicadores.indexOf(new Multiplicador(factor));
        if(i == NO_ENCONTRADO){
            throw new MultiplicadorNoEncontrado();
        }

        Multiplicador multiplicador = multiplicadores.get(i);

        if (puedeUsarMultiplicador(factor)) {
            multiplicador.usar(turnoJugadores.get(0));
        }
    }

    public void siguientePregunta(){
        if(estaJuegoTerminado()) {
            throw new JuegoFinalizado();
        }

        anulador.desactivar();
        exclusividad.desactivar();
        multiplicadores.forEach(Modificador::desactivar);
        turnoJugadores.addAll(jugadores);

        preguntaActual = preguntas.remove(0);
        cantidadPreguntas++;
    }

    public void responder(ArrayList<Opcion> respuestas){

        Jugador jugadorActual = turnoJugadores.remove(0);

        jugadorActual.responderPregunta(respuestas);
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
    }

    public int obtenerPuntaje(String nombreJugador){
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombreJugador)){
                return jugador.getPuntos();
            }
        }

        throw new JugadorNoEncontrado();
    }

    public Pregunta obtenerPreguntaActual(){
        return preguntaActual;
    }

    public String getJugadorActual(){
        return turnoJugadores.get(0).getNombre();
    }

    public ArrayList<String> obtenerNombresJugadores(){
        ArrayList<String> nombres = new ArrayList<>();
        jugadores.forEach(jugador -> nombres.add(jugador.getNombre()));
        return nombres;
    }

    public HashMap<String, Integer> getModificadoresUsadosEsteTurno(){
        HashMap<String, Integer> usos = new HashMap<>();
        usos.put(anulador.toString(), anulador.getUsadosEsteTurno());
        usos.put(exclusividad.toString(), exclusividad.getUsadosEsteTurno());
        for (Modificador multiplicador : multiplicadores) {
            usos.put(multiplicador.toString(), multiplicador.getUsadosEsteTurno());
        }
        return usos;
    }

    private HashMap<Jugador,Integer> filtrarPuntajes(HashMap<Jugador, Integer> puntajes){
        HashMap<Jugador,Integer> puntajeFiltrado = anulador.filtrarPuntos(puntajes);
        puntajeFiltrado = exclusividad.filtrarPuntos(puntajeFiltrado);
        for (Modificador multiplicador : multiplicadores) {
            puntajeFiltrado = multiplicador.filtrarPuntos(puntajeFiltrado);
        }

        return puntajeFiltrado;
    }
}
