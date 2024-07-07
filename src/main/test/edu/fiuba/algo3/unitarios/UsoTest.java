package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Uso;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class UsoTest {

    @Test
    public void test01DosUsosSonEquivalentes(){
        Jugador jugador1 = new Jugador("Jugador 1");
        Uso uso1 = new Uso(jugador1);
        Uso uso2 = new Uso(jugador1);

        assertEquals(uso1, uso2);
    }

    @Test
    public void test02DosUsosNoSonEquivalentes(){
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Uso uso1 = new Uso(jugador1);
        Uso uso2 = new Uso(jugador2);

        assertNotEquals(uso1, uso2);
    }

    @Test
    public void test03ContarEquivalentesAUnUso(){
        Jugador jugador1 = new Jugador("Jugador 1");
        Jugador jugador2 = new Jugador("Jugador 2");
        Uso uso1 = new Uso(jugador1);
        Uso uso2 = new Uso(jugador1);
        Uso uso3 = new Uso(jugador2);

        assertEquals(2,uso1.contarMisEquivalentes(new ArrayList<>(Arrays.asList(uso1, uso2, uso3))));
    }

}
