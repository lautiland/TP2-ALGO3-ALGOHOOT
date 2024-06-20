package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.CantidadJugadoresInvalida;
import edu.fiuba.algo3.modelo.excepciones.CantidadPreguntasInvalida;
import edu.fiuba.algo3.modelo.pregunta.ClassicTF;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JuegoTest {
    @Test
    public void test01CantidadDeJugadoresInvalida() {
        assertThrows(CantidadJugadoresInvalida.class, () -> {

            Jugador jugador1 = new Jugador("Franco");
            ArrayList<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugador1);

            Opcion opcion1 = new Opcion("Verdadero");
            Opcion opcion2 = new Opcion("Falso");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);

            Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones, opcion1, "", "");

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

    @Test
    public void test03SeCarganLasPreguntasCorrectamente(){
        Jugador jugador1 = new Jugador("Franco");
        Jugador jugador2 = new Jugador("Lautaro");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Juego juego = new Juego(jugadores);
        ArrayList<Opcion> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add(new Opcion("Microondas"));
        respuestaCorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaCorrecta.add(new Opcion("Heladera"));
        respuestaCorrecta.add(new Opcion("Imanes del delivery"));

        ArrayList<Opcion> respuestaIncorrecta = new ArrayList<>();
        respuestaIncorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaIncorrecta.add(new Opcion("Microondas"));
        respuestaIncorrecta.add(new Opcion("Imanes del delivery"));
        respuestaIncorrecta.add(new Opcion("Heladera"));

        juego.cargarPreguntas("src/main/resources/preguntas.json");

        jugador1.responderPregunta(respuestaCorrecta);
        jugador2.responderPregunta(respuestaIncorrecta);

        juego.evaluarRespuestas();

        assertEquals(1, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }
}
