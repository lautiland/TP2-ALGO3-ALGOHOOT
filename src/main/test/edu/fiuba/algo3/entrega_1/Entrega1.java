package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Entrega1Test {
    private Jugador jugador1Spy;
    private Jugador jugador2Spy;

    @BeforeEach
    public void beforeEach() {
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Daniel");

        jugador1Spy = spy(jugador1);
        jugador2Spy = spy(jugador2);
    }

    @Test
    public void test01PreguntaVoFClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        doReturn(new ArrayList<>(){{
            add(opcion1);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion1);
        }}).when(jugador2Spy).obtenerRespuestas(any(Pregunta.class));

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Spy);
        jugadores.add(jugador2Spy);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("¿Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(1,jugador1Spy.getPuntos());
        assertEquals(1, jugador2Spy.getPuntos());
    }

    @Test
    public void test02PreguntaVoFClasicaAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Opcion opcion1 = new Opcion("Verdadero", false);
        Opcion opcion2 = new Opcion("Falso", true);
        doReturn(new ArrayList<>(){{
            add(opcion1);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion1);
        }}).when(jugador2Spy).obtenerRespuestas(any(Pregunta.class));

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Spy);
        jugadores.add(jugador2Spy);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(0,jugador1Spy.getPuntos());
        assertEquals(0, jugador2Spy.getPuntos());
    }

    @Test
    public void test03PreguntaMultipleChoiceClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1", true);
        Opcion opcion2 = new Opcion("Respuesta2", false);
        Opcion opcion3 = new Opcion("Respuesta3", true);
        Opcion opcion4 = new Opcion("Respuesta4", false);

        doReturn(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }}).when(jugador2Spy).obtenerRespuestas(any(Pregunta.class));
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Spy);
        jugadores.add(jugador2Spy);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new ClassicMC("Elija la opcion correcta", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(2,jugador1Spy.getPuntos());
        assertEquals(2, jugador2Spy.getPuntos());
    }
}
