package edu.fiuba.algo3;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Opcion;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegracionTest {
    private final String ARCHIVO_PREGUNTAS = "src/main/test/edu/fiuba/algo3/unitarios/example/preguntas_simplificado.json";
    private static final int LIMITE_PREGUNTAS = 100;
    private static final int LIMITE_PUNTOS = 100;

    @Test
    public void test01PuedoJugarUnaPartidaCompleta() throws FileNotFoundException {
        Jugador jugador1 = new Jugador("Mati");
        Jugador jugador2 = new Jugador("Jorge");
        Jugador jugador3 = new Jugador("Lucas");
        ArrayList<Jugador> jugadores = new ArrayList<>(){
            {
                add(jugador1);
                add(jugador2);
                add(jugador3);
            }
        };

        Juego juego = new Juego(jugadores,new FileReader(ARCHIVO_PREGUNTAS), LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        ArrayList<Opcion> opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        ArrayList<Opcion> respuesta1  = new ArrayList<>();
        respuesta1.add(opciones.get(1));
        respuesta1.add(opciones.get(0));
        respuesta1.add(opciones.get(3));
        respuesta1.add(opciones.get(2));
        ArrayList<Opcion> respuesta2  = new ArrayList<>();
        respuesta2.add(opciones.get(0));
        respuesta2.add(opciones.get(1));
        respuesta2.add(opciones.get(2));
        respuesta2.add(opciones.get(3));
        ArrayList<Opcion> respuesta3  = new ArrayList<>();
        respuesta3.add(opciones.get(3));
        respuesta3.add(opciones.get(2));
        respuesta3.add(opciones.get(1));
        respuesta3.add(opciones.get(0));

        juego.responder(respuesta1); // 1 punto
        juego.responder(respuesta2);
        juego.responder(respuesta3);

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(3));
        respuesta1.add(opciones.get(0));
        respuesta2 = new ArrayList<>();
        respuesta2.add(opciones.get(0));
        respuesta2.add(opciones.get(1));
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(3));
        respuesta3.add(opciones.get(0));

        juego.responder(respuesta1); // 1 punto
        juego.responder(respuesta2);
        juego.responder(respuesta3); // 1 punto

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(1));

        juego.responder(respuesta1); // Se le anula
        juego.activarAnulador();
        juego.responder(respuesta1); // 1 punto
        juego.responder(respuesta1); // Se le anula


        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(2));
        respuesta1.add(opciones.get(4));
        respuesta2 = new ArrayList<>();
        respuesta2.add(opciones.get(0));
        respuesta2.add(opciones.get(1));
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(2));

        juego.responder(respuesta1); // 2 punto
        juego.responder(respuesta2); // 0 puntos
        juego.responder(respuesta3); // 1 punto

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(0));
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(1));

        juego.activarMultiplicador( 3); // 3 puntos
        juego.responder(respuesta1); // 1 puntos
        juego.activarMultiplicador( 2); // 2 puntos
        juego.responder(respuesta1); // 1 puntos
        juego.activarMultiplicador( 2); // -2 puntos
        juego.responder(respuesta3); // 0 puntos


        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(3));
        respuesta1.add(opciones.get(0));
        respuesta2 = new ArrayList<>();
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(3));
        respuesta3.add(opciones.get(1));

        juego.responder(respuesta1); // 1-1=0 puntos
        juego.responder(respuesta2); // 0 puntos
        juego.responder(respuesta3); // 2 puntos

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(0));
        respuesta1.add(opciones.get(1));
        respuesta1.add(opciones.get(2));
        respuesta2 = new ArrayList<>();
        respuesta2.add(opciones.get(2));
        respuesta2.add(opciones.get(3));
        respuesta2.add(opciones.get(5));
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(0));
        respuesta3.add(opciones.get(1));
        respuesta3.add(opciones.get(2));

        juego.activarExclusividad();
        juego.responder(respuesta1); // 0 punto
        juego.responder(respuesta2); // 1 * 3 = 3 puntos
        juego.activarExclusividad();
        juego.responder(respuesta3); // 0 puntos


        juego.evaluarRespuestas();

        assertEquals(7, jugador1.getPuntos());
        assertEquals(6, jugador2.getPuntos());
        assertEquals(2, jugador3.getPuntos());
        assertTrue(juego.estaJuegoTerminado());
    }
}
