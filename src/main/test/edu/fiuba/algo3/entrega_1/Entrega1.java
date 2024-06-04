package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Entrega1Test {
    @Test
    public void test01PreguntaVoFClasicaAsignaPuntosCorrectamente(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Daniel");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(1,jugador1.puntos());
        assertEquals(1, jugador2.puntos());
    }

    @Test
    public void test02PreguntaVoFClasicaAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Daniel");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcion1 = new Opcion("Verdadero", false);
        Opcion opcion2 = new Opcion("Falso", true);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("Verdadero o falso?", opciones);
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.hacerPregunta();

        assertEquals(0,jugador1.puntos());
        assertEquals(0, jugador2.puntos());
    }

    @Test
    public void test03PreguntaMultipleChoiceClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1", true);
        Opcion opcion2 = new Opcion("Respuesta2", false);
        Opcion opcion3 = new Opcion("Respuesta3", true);
        Opcion opcion4 = new Opcion("Respuesta4", false);

        Jugador jugador1Mock = mock(Jugador.class);
        when(jugador1Mock.obtenerRespuestas(any(Pregunta.class)))
                .thenReturn(new ArrayList<>(){{
                    add(opcion1);
                    add(opcion3);
                }});
        //Todo: ver si se puede hacer con Spy()
        doCallRealMethod().when(jugador1Mock).sumarPuntos(anyInt());
        doCallRealMethod().when(jugador1Mock).puntos();
        Jugador jugador2Mock = mock(Jugador.class);
        when(jugador2Mock.obtenerRespuestas(any(Pregunta.class)))
                .thenReturn(new ArrayList<>(){{
                    add(opcion1);
                    add(opcion3);
                }});
        doCallRealMethod().when(jugador2Mock).sumarPuntos(anyInt());
        doCallRealMethod().when(jugador2Mock).puntos();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1Mock);
        jugadores.add(jugador2Mock);

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

        assertEquals(2,jugador1Mock.puntos());
        assertEquals(2, jugador2Mock.puntos());
    }
}
