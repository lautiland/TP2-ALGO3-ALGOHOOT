package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.parser.JuegoParser;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.util.ArrayList;

public class ControladorJuego {
    private Juego juego;
    private int cantidadJugadores;
    private ArrayList<Jugador> jugadores;
    private int cantidadPreguntas;

    public void iniciarJuego(){
        setCantidadJugadores();
        setJugadores();
        ArrayList<Pregunta> preguntas;
        JuegoParser parser = new JuegoParser();
        preguntas = parser.parsear(InteraccionesConJugadores.pedirRutaArchivo(), "json");
        this.cantidadPreguntas= preguntas.size();
        this.juego = new Juego(jugadores,preguntas);
        controlarJuego();
    }
    public void controlarJuego(){
        for(int i = 0; i < cantidadPreguntas; i++){
            juego.evaluarRespuestas();
        }
        finalizarJuego();
    }

    public void setJugadores() {
        this.jugadores = InteraccionesConJugadores.pedirJugadores(cantidadJugadores);
    }

    public void setCantidadJugadores() {
        this.cantidadJugadores = InteraccionesConJugadores.pedirCantidadDeJugadores();
    }

    public void finalizarJuego(){
        //Mostrar la pantalla de fin de partida, junto con un reiniciar juego/ salir.
    }

}
