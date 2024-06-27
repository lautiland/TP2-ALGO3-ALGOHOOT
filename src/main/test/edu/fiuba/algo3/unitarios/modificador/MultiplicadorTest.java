package edu.fiuba.algo3.unitarios.modificador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificador.Modificador;
import edu.fiuba.algo3.modelo.modificador.Multiplicador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorTest {
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
    public void test01JugadorUsaMultiplicadorX2Correctamente(){
        Modificador multiplicador = new Multiplicador(2);
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        multiplicador.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = multiplicador.filtrarPuntos(puntosRespuesta);

        assertEquals(2, puntosRecibidos.get(jugador1));
        assertEquals(2, puntosRecibidos.get(jugador2));
        assertEquals(3, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test02DosJugadoresUsanMultiplicadoresCorrectamente(){
        Modificador multiplicador2 = new Multiplicador(2);
        Modificador multiplicador3 = new Multiplicador(3);
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        multiplicador2.usar(jugador1);
        multiplicador3.usar(jugador2);

        HashMap<Jugador,Integer> puntosRecibidos = multiplicador2.filtrarPuntos(puntosRespuesta);
        puntosRecibidos = multiplicador3.filtrarPuntos(puntosRecibidos);

        assertEquals(2, puntosRecibidos.get(jugador1));
        assertEquals(6, puntosRecibidos.get(jugador2));
        assertEquals(3, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test03UnJugadorIntentaUsarMultiplicadorDosVeces(){
        Modificador multiplicador = new Multiplicador(2);
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        multiplicador.usar(jugador1);

        multiplicador.desactivar();

        multiplicador.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = multiplicador.filtrarPuntos(puntosRespuesta);

        assertEquals(1, puntosRecibidos.get(jugador1));
        assertEquals(2, puntosRecibidos.get(jugador2));
        assertEquals(3, puntosRecibidos.get(jugador3));
    }
}
