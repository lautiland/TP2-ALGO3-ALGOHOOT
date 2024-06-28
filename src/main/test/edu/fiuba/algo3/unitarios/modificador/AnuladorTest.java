package edu.fiuba.algo3.unitarios.modificador;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Modificador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnuladorTest {
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
    public void test01JugadorUsaAnuladorCorrectamente(){
        Modificador anulador = new Anulador();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        anulador.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = anulador.filtrarPuntos(puntosRespuesta);

        assertEquals(1, puntosRecibidos.get(jugador1));
        assertEquals(0, puntosRecibidos.get(jugador2));
        assertEquals(0, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test02DosJugadoresUsanAnuladoresCorrectamente(){
        Modificador anulador = new Anulador();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        anulador.usar(jugador1);
        anulador.usar(jugador2);
        HashMap<Jugador,Integer> puntosRecibidos = anulador.filtrarPuntos(puntosRespuesta);

        assertEquals(0, puntosRecibidos.get(jugador1));
        assertEquals(0, puntosRecibidos.get(jugador2));
        assertEquals(0, puntosRecibidos.get(jugador3));
    }

    @Test
    public void test03UnJugadorIntentaUsarAnuladorDosVeces(){
        Modificador anulador = new Anulador();
        HashMap<Jugador, Integer> puntosRespuesta = new HashMap<>(){{
            put(jugador1, 1);
            put(jugador2, 2);
            put(jugador3, 3);
        }};

        anulador.usar(jugador1);

        anulador.desactivar();

        anulador.usar(jugador1);
        HashMap<Jugador,Integer> puntosRecibidos = anulador.filtrarPuntos(puntosRespuesta);

        assertEquals(1, puntosRecibidos.get(jugador1));
        assertEquals(2, puntosRecibidos.get(jugador2));
        assertEquals(3, puntosRecibidos.get(jugador3));
    }
}
