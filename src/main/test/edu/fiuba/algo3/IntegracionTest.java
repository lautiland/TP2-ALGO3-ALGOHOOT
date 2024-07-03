package edu.fiuba.algo3;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Opcion;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IntegracionTest {
    private final String ARCHIVO_PREGUNTAS = "src/main/test/edu/fiuba/algo3/unitarios/example/preguntas_simplificado.json";

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

        Juego juego = new Juego(jugadores,new FileReader(ARCHIVO_PREGUNTAS));

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

        juego.responder(jugador1, respuesta1); // 1 punto
        juego.responder(jugador2, respuesta2);
        juego.responder(jugador3, respuesta3);

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

        juego.responder(jugador1, respuesta1); // 1 punto
        juego.responder(jugador2, respuesta2);
        juego.responder(jugador3, respuesta3); // 1 punto

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(1));

        juego.responder(jugador1, respuesta1); // Se le anula
        juego.responder(jugador2, respuesta1); // 1 punto
        juego.responder(jugador3, respuesta1); // Se le anula

        juego.activarAnulador(jugador2);

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

        juego.responder(jugador1, respuesta1); // 2 punto
        juego.responder(jugador2, respuesta2); // 0 puntos
        juego.responder(jugador3, respuesta3); // 1 punto

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        opciones = juego.obtenerPreguntaActual().obtenerOpciones();
        respuesta1 = new ArrayList<>();
        respuesta1.add(opciones.get(0));
        respuesta3 = new ArrayList<>();
        respuesta3.add(opciones.get(1));

        juego.responder(jugador1, respuesta1); // 1 puntos
        juego.responder(jugador2, respuesta1); // 1 puntos
        juego.responder(jugador3, respuesta3); // 0 puntos

        juego.activarMultiplicador(jugador1, 3); // 3 puntos
        juego.activarMultiplicador(jugador2, 2); // 2 puntos
        juego.activarMultiplicador(jugador3, 2); // -2 puntos

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

        juego.responder(jugador1, respuesta1); // 1-1=0 puntos
        juego.responder(jugador2, respuesta2); // 0 puntos
        juego.responder(jugador3, respuesta3); // 2 puntos

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

        juego.responder(jugador1, respuesta1); // 0 punto
        juego.responder(jugador2, respuesta2); // 1 * 3 = 3 puntos
        juego.responder(jugador3, respuesta3); // 0 puntos

        juego.activarExclusividad(jugador1);
        juego.activarExclusividad(jugador3);

        juego.evaluarRespuestas();

        assertFalse(juego.siguientePregunta());
        assertEquals(7, jugador1.getPuntos());
        assertEquals(6, jugador2.getPuntos());
        assertEquals(2, jugador3.getPuntos());
    }
}
