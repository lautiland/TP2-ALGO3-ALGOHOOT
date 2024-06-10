package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.pregunta.ClassicTF;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JuegoTest {
    @Test
    public void test01CantidadDeJugadoresInvalida() {
        assertThrows(CantidadJugadoresInvalida.class, () -> {

            Jugador jugador1 = new Jugador("Franco");
            ArrayList<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador1);

            Opcion opcion1 = new Opcion("Verdadero", true,1);
            Opcion opcion2 = new Opcion("Falso", false,1);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);

            Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones);

            ArrayList<Pregunta> preguntas = new ArrayList<>();
            preguntas.add(preguntaTF);

            Juego juego = new Juego(jugadores, preguntas);
        });
    }


    @Test
    public void test02NoHayPreguntasEnElJuego(){
        assertThrows(CantidadPreguntasInvalida.class, () -> {

            Jugador jugador1 = new Jugador("Franco");
            Jugador jugador2 = new Jugador("Lautaro");
            ArrayList<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador1);
            jugadores.add(jugador2);

            ArrayList<Pregunta> preguntas = new ArrayList<>();


            Juego juego = new Juego(jugadores, preguntas);
        });
    }
}
