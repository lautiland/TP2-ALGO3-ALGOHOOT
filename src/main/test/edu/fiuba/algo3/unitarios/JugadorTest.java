package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

public class JugadorTest {
    @Test
    public void test01UnJugadorSeCreaCorrectamente(){
        Jugador jugador = new Jugador("Paula");

        assert(jugador.getPuntos() == 0);
    }

    @Test
    public void test02UnJugadorSumaPuntosCorrectamente(){
        Jugador jugador = new Jugador("Paula");

        jugador.modificarPuntos(5);

        assert(jugador.getPuntos() == 5);
    }
}
