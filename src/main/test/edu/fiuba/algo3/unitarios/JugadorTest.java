package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class JugadorTest {
    @Test
    public void test01UnJugadorSeCreaCorrectamente(){
        Jugador jugador = new Jugador("nombreJugador");

        assert(jugador.getPuntos() == 0);
    }

    @Test
    public void test02UnJugadorSumaPuntosCorrectamente(){
        Jugador jugador = new Jugador("nombreJugador");

        jugador.modificarPuntos(5);

        assert(jugador.getPuntos() == 5);
    }

    @Test
    public void test03UnJugadorRestaPuntosCorrectamente(){
        Jugador jugador = new Jugador("nombreJugador");

        jugador.modificarPuntos(-5);

        assert(jugador.getPuntos() == -5);
    }

    @Test
    public void test04SeCreaUnJugadorConUnNombreYLoDevuelveCorrectamente(){
        String nombre = "nombreJugador";
        Jugador jugador = new Jugador(nombre);

        assert(Objects.equals(jugador.getNombre(), nombre));
    }

}
