package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pregunta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Entrega1Test {

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
    public void test01PreguntaTFClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true,1);
        Opcion opcion2 = new Opcion("Falso", false,1);
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
    public void test02PreguntaTFClasicaAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Opcion opcion1 = new Opcion("Verdadero", false,1);
        Opcion opcion2 = new Opcion("Falso", true,1);
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
        Opcion opcion1 = new Opcion("Respuesta1", true,1);
        Opcion opcion2 = new Opcion("Respuesta2", false,1);
        Opcion opcion3 = new Opcion("Respuesta3", true,1);
        Opcion opcion4 = new Opcion("Respuesta4", false,1);

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

    @Test
    public void test04PreguntaMultipleChoiceClasicaAsignaPuntosCorrectamenteAJugadoresQueRespondieronIncorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1", true,1);
        Opcion opcion2 = new Opcion("Respuesta2", false,1);
        Opcion opcion3 = new Opcion("Respuesta3", true,1);
        Opcion opcion4 = new Opcion("Respuesta4", false,1);

        doReturn(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
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

        assertEquals(0,jugador1Spy.getPuntos());
        assertEquals(0, jugador2Spy.getPuntos());
    }

    @Test
    public void test05PreguntaTFPenalidadAsignaPuntosCorrectamenteARespuestasCorrectas(){
        Opcion opcion1 = new Opcion("Verdadero", false,1);
        Opcion opcion2 = new Opcion("Falso", true,1);
        doReturn(new ArrayList<>(){{
            add(opcion2);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion2);
        }}).when(jugador2Spy).obtenerRespuestas(any(Pregunta.class));

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Spy);
        jugadores.add(jugador2Spy);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new PenaltyTF("Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(1,jugador1Spy.getPuntos());
        assertEquals(1, jugador2Spy.getPuntos());
    }

    @Test
    public void test06PreguntaTFPenalidadAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Opcion opcion1 = new Opcion("Verdadero", false,1);
        Opcion opcion2 = new Opcion("Falso", true,1);
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

        Pregunta pregunta = new PenaltyTF("Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(-1,jugador1Spy.getPuntos());
        assertEquals(-1, jugador2Spy.getPuntos());
    }

    @Test
    public void test07PreguntaMultipleChoicePenalidadAsignaPuntosCorrectamenteAJugadoresQueRespondieronCorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1", true,1);
        Opcion opcion2 = new Opcion("Respuesta2", false,1);
        Opcion opcion3 = new Opcion("Respuesta3", true,1);
        Opcion opcion4 = new Opcion("Respuesta4", false,1);

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

        Pregunta pregunta = new PenaltyMC("Elija la opcion correcta", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(2,jugador1Spy.getPuntos());
        assertEquals(2, jugador2Spy.getPuntos());
    }

    @Test
    public void test08PreguntaMultipleChoicePenalidadAsignaPuntosCorrectamenteAJugadoresQueRespondieronIncorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1", true,1);
        Opcion opcion2 = new Opcion("Respuesta2", false,1);
        Opcion opcion3 = new Opcion("Respuesta3", true,1);
        Opcion opcion4 = new Opcion("Respuesta4", false,1);

        doReturn(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }}).when(jugador1Spy).obtenerRespuestas(any(Pregunta.class));
        doReturn(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }}).when(jugador2Spy).obtenerRespuestas(any(Pregunta.class));
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Spy);
        jugadores.add(jugador2Spy);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta pregunta = new PenaltyMC("Elija la opcion correcta", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(-2,jugador1Spy.getPuntos());
        assertEquals(-2, jugador2Spy.getPuntos());
    }
}
