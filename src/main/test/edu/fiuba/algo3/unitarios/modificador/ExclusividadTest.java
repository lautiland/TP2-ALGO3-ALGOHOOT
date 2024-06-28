package edu.fiuba.algo3.unitarios.modificador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificador.Exclusividad;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadTest {
    Jugador jugador1;
    Jugador jugador2;
    Jugador jugador3;

    @BeforeEach
    public void setUp(){
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        jugador3 = new Jugador("Jugador 3");
    }

    @Test
    public void test01JugadorUsaExclusividadCorrectamente(){
        Modificador exclusividad = new Exclusividad();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 0);
            put(jugador3, 0);
        }};

        exclusividad.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = exclusividad.filtrarPuntos(puntosRespuesta);

        assertEquals(2, puntosRecibidos.get(jugador1));
        assertEquals(0, puntosRecibidos.get(jugador2));
        assertEquals(0, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test02JugadorUsaExclusividadCorrectamentePeroOtroRecibePuntos(){
        Modificador exclusividad = new Exclusividad();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 0);
            put(jugador2, 0);
            put(jugador3, 1);
        }};

        exclusividad.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = exclusividad.filtrarPuntos(puntosRespuesta);

        assertEquals(0, puntosRecibidos.get(jugador1));
        assertEquals(0, puntosRecibidos.get(jugador2));
        assertEquals(2, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test03DosJugadoresUsanExclusividadCorrectamentePeroOtroRecibePuntos(){
        Modificador exclusividad = new Exclusividad();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 0);
            put(jugador2, 1);
            put(jugador3, 0);
        }};

        exclusividad.usar(jugador1);
        exclusividad.usar(jugador3);
        HashMap<Jugador,Integer> puntosRecibidos = exclusividad.filtrarPuntos(puntosRespuesta);

        assertEquals(0, puntosRecibidos.get(jugador1));
        assertEquals(3, puntosRecibidos.get(jugador2));
        assertEquals(0, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test04JugadorUsaExclusividadPeroTodosRespondenBien(){
        Modificador exclusividad = new Exclusividad();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 1);
            put(jugador3, 1);
        }};

        exclusividad.usar(jugador1);
        exclusividad.usar(jugador3);
        HashMap<Jugador,Integer> puntosRecibidos = exclusividad.filtrarPuntos(puntosRespuesta);

        assertEquals(1, puntosRecibidos.get(jugador1));
        assertEquals(1, puntosRecibidos.get(jugador2));
        assertEquals(1, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test03UnJugadorIntentaUsarExclusividadTresVeces(){
        Modificador exclusividad = new Exclusividad();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 0);
            put(jugador3, 0);
        }};

        exclusividad.usar(jugador1);
        exclusividad.desactivar();

        exclusividad.usar(jugador1);
        exclusividad.desactivar();

        exclusividad.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = exclusividad.filtrarPuntos(puntosRespuesta);

        assertEquals(1, puntosRecibidos.get(jugador1));
        assertEquals(0, puntosRecibidos.get(jugador2));
        assertEquals(0, puntosRecibidos.get(jugador3));
    }
}
