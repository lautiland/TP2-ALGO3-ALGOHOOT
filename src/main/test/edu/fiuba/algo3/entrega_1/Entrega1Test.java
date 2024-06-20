package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.pregunta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void beforeEach() {
       jugador1 = new Jugador("Juan");
       jugador2 = new Jugador("Daniel");
    }

    @Test
    public void test01PreguntaTFClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("¿Verdadero o falso?", opciones, opcion1, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(1, jugador2.getPuntos());
    }

    @Test
    public void test02PreguntaTFClasicaAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("Verdadero o falso?", opciones, opcion2, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(0,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test03PreguntaMultipleChoiceClasicaAsignaPuntosCorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        Opcion opcion4 = new Opcion("Respuesta4");

        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }});
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);

        Pregunta pregunta = new ClassicMC("Elija la opcion correcta", opciones, opcionesCorrectas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(1, jugador2.getPuntos());
    }

    @Test
    public void test04PreguntaMultipleChoiceClasicaAsignaPuntosCorrectamenteAJugadoresQueRespondieronIncorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        Opcion opcion4 = new Opcion("Respuesta4");

        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }});
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);

        Pregunta pregunta = new ClassicMC("Elija la opcion correcta", opciones, opcionesCorrectas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(0,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test05PreguntaTFPenalidadAsignaPuntosCorrectamenteARespuestasCorrectas(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion2);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion2);
        }});

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new PenaltyTF("Verdadero o falso?", opciones, opcion2, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(1, jugador2.getPuntos());
    }

    @Test
    public void test06PreguntaTFPenalidadAsignaPuntosCorrectamenteARespuestasIncorrectas(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion1);
        }});

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new PenaltyTF("Verdadero o falso?", opciones, opcion2, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(-1,jugador1.getPuntos());
        assertEquals(-1, jugador2.getPuntos());
    }

    @Test
    public void test07PreguntaMultipleChoicePenalidadAsignaPuntosCorrectamenteAJugadoresQueRespondieronCorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        Opcion opcion4 = new Opcion("Respuesta4");

        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion1);
            add(opcion3);
        }});
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);

        Pregunta pregunta = new PenaltyMC("Elija la opcion correcta", opciones, opcionesCorrectas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);
        juego.evaluarRespuestas();

        assertEquals(2,jugador1.getPuntos());
        assertEquals(2, jugador2.getPuntos());
    }

    @Test
    public void test08PreguntaMultipleChoicePenalidadAsignaPuntosCorrectamenteAJugadoresQueRespondieronIncorrectamente(){
        Opcion opcion1 = new Opcion("Respuesta1");
        Opcion opcion2 = new Opcion("Respuesta2");
        Opcion opcion3 = new Opcion("Respuesta3");
        Opcion opcion4 = new Opcion("Respuesta4");

        jugador1.responderPregunta(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }});
        jugador2.responderPregunta(new ArrayList<>(){{
            add(opcion2);
            add(opcion4);
        }});
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion3);

        Pregunta pregunta = new PenaltyMC("Elija la opcion correcta", opciones, opcionesCorrectas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.evaluarRespuestas();

        assertEquals(-2,jugador1.getPuntos());
        assertEquals(-2, jugador2.getPuntos());
    }
}
