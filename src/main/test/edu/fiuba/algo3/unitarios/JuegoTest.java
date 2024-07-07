package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.excepciones.*;
import edu.fiuba.algo3.model.pregunta.ClassicTF;
import edu.fiuba.algo3.model.pregunta.PenaltyTF;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    private static final int LIMITE_PREGUNTAS = 100;
    private static final int LIMITE_PUNTOS = 100;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Jugador> jugadores;

    @BeforeEach
    public void setUp() {
        jugador1 = new Jugador("Mati");
        jugador2 = new Jugador("Lauti");
        jugadores = new ArrayList<>();
    }

    @Test
    public void test01CantidadDeJugadoresInvalida() {
        jugadores.add(jugador1);

        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones, opcion1, "", "");

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(preguntaTF);

        assertThrows(CantidadJugadoresInvalido.class, () -> new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS));
    }

    @Test
    public void test02CantidadDeJugadoresInvalida() {
        jugadores.add(jugador1);

        assertThrows(CantidadJugadoresInvalido.class, () -> new Juego(jugadores,new FileReader("src/main/resources/preguntas.json"), LIMITE_PREGUNTAS, LIMITE_PUNTOS));
    }

    @Test
    public void test03NoHayPreguntasEnElJuego(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        assertThrows(CantidadPreguntasInvalida.class, () -> new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS));
    }

    @Test
    public void test04SeCarganLasPreguntasCorrectamente() throws FileNotFoundException {
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Juego juego = new Juego(jugadores,new FileReader("src/main/test/edu/fiuba/algo3/unitarios/example/preguntas_simplificado.json"), LIMITE_PREGUNTAS, LIMITE_PUNTOS);
        ArrayList<Opcion> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add(new Opcion("Microondas"));
        respuestaCorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaCorrecta.add(new Opcion("Heladera"));
        respuestaCorrecta.add(new Opcion("Imanes del delivery"));

        ArrayList<Opcion> respuestaIncorrecta = new ArrayList<>();
        respuestaIncorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaIncorrecta.add(new Opcion("Microondas"));
        respuestaIncorrecta.add(new Opcion("Imanes del delivery"));
        respuestaIncorrecta.add(new Opcion("Heladera"));

        jugador1.responderPregunta(respuestaCorrecta);
        jugador2.responderPregunta(respuestaIncorrecta);

        juego.evaluarRespuestas();

        assertEquals(1, jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
    }

    @Test
    public void test05MultiplicadorInvalido() throws FileNotFoundException {
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        Juego juego = new Juego(jugadores,new FileReader("src/main/resources/preguntas.json"), LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertThrows(MultiplicadorInvalido.class, () -> juego.activarMultiplicador( 6));
    }

    @Test
    public void test06SeCuentanLosModificadoresPorRondaCorrectamente() throws FileNotFoundException {
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Juego juego = new Juego(jugadores,new FileReader("src/main/test/edu/fiuba/algo3/unitarios/example/preguntas_simplificado.json"), LIMITE_PREGUNTAS, LIMITE_PUNTOS);
        ArrayList<Opcion> respuestaCorrecta = new ArrayList<>();
        respuestaCorrecta.add(new Opcion("Microondas"));
        respuestaCorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaCorrecta.add(new Opcion("Heladera"));
        respuestaCorrecta.add(new Opcion("Imanes del delivery"));

        ArrayList<Opcion> respuestaIncorrecta = new ArrayList<>();
        respuestaIncorrecta.add(new Opcion("Televisor de tubo CRT"));
        respuestaIncorrecta.add(new Opcion("Microondas"));
        respuestaIncorrecta.add(new Opcion("Imanes del delivery"));
        respuestaIncorrecta.add(new Opcion("Heladera"));

        juego.activarExclusividad();
        juego.responder(respuestaCorrecta);

        juego.activarAnulador();
        juego.responder(respuestaIncorrecta);

        juego.evaluarRespuestas();

        HashMap<String, Integer> modificadores = juego.getModificadoresUsadosEsteTurno();

        assertEquals(1,modificadores.get("Exclusividad"));
        assertEquals(1,modificadores.get("Anulador"));
    }

    @Test
    public void test07NoSePuedeUsarExclusividadEnUnaPreguntaPenalidad(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, new Opcion("Verdadero"), "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertFalse(juego.puedeUsarExclusividad());
    }

    @Test
    public void test08NoSePuedeUsarMultiplicadorEnUnaPreguntaSinPenalidad(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Pregunta pregunta = new ClassicTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, new Opcion("Verdadero"), "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertFalse(juego.puedeUsarMultiplicador(2));
    }

    @Test
    public void test09NoSePuedeUsarAnuladorMasDeUnaVez(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new ClassicTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertTrue(juego.puedeUsarAnulador());
        juego.activarAnulador();
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        assertFalse(juego.puedeUsarAnulador());
        juego.activarAnulador();
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        assertTrue(juego.puedeUsarAnulador());
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
    }

    @Test
    public void test10NoSePuedeUsarExclusividadMasDeDosVeces(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new ClassicTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        preguntas.add(pregunta);
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertTrue(juego.puedeUsarExclusividad());
        juego.activarExclusividad();
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        assertTrue(juego.puedeUsarExclusividad());
        juego.activarExclusividad();
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        assertFalse(juego.puedeUsarExclusividad());
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
        assertTrue(juego.puedeUsarExclusividad());
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
    }

    @Test
    public void test11NoSePuedeUsarMultiplicadorMasDeUnaVez(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertTrue(juego.puedeUsarMultiplicador(2));
        juego.activarMultiplicador(2);
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
        assertTrue(juego.puedeUsarMultiplicador(3));
        juego.activarMultiplicador(3);
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        assertFalse(juego.puedeUsarMultiplicador(2));
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
        assertFalse(juego.puedeUsarMultiplicador(3));
        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });
    }

    @Test
    public void test12NoSePuedeUsarUnMultiplicadorInvalido(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertThrows(MultiplicadorInvalido.class, () -> juego.puedeUsarMultiplicador(4));
    }

    @Test
    public void test13SeCambiaDeJugadorCorrectamente(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertEquals(new ArrayList<>(){
            {
                add("Mati");
                add("Lauti");
            }

        }, juego.obtenerNombresJugadores());

        assertEquals("Mati", juego.getJugadorActual());
        assertEquals(0, juego.obtenerPuntaje("Mati"));

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        assertEquals("Lauti", juego.getJugadorActual());
        assertEquals(0, juego.obtenerPuntaje("Lauti"));

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        assertTrue(juego.todosLosJugadoresRespondieron());
        assertFalse(juego.estaJuegoTerminado());

        juego.evaluarRespuestas();
        juego.siguientePregunta();

        assertEquals("Mati", juego.getJugadorActual());
        assertEquals(1, juego.obtenerPuntaje("Mati"));

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        assertEquals("Lauti", juego.getJugadorActual());
        assertEquals(1, juego.obtenerPuntaje("Lauti"));

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        assertTrue(juego.todosLosJugadoresRespondieron());
        assertTrue(juego.estaJuegoTerminado());
    }

    @Test
    public void test14NoSePuedeObtenerPuntajeDeUnJugadorQueNoExiste(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        assertThrows(NombreJugadorInvalido.class, () -> juego.obtenerPuntaje("Pepe"));
    }

    @Test
    public void test15NoSePuedeSeguirJugandoUnaPartidaSinpreguntas(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, LIMITE_PREGUNTAS, LIMITE_PUNTOS);

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        assertThrows(JuegoFinalizadoError.class, juego::siguientePregunta);
    }

    @Test
    public void test16ElJuegoFinalizaSiSeLlegaAlLimiteDePuntaje(){
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        Opcion opcionCorrecta = new Opcion("Verdadero");

        Pregunta pregunta = new PenaltyTF("Pregunta de verdadero o falso", new ArrayList<>(){
            {
                add(new Opcion("Verdadero"));
                add(new Opcion("Falso"));
            }
        }, opcionCorrecta, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores, preguntas, 1, LIMITE_PREGUNTAS);
        assertFalse(juego.estaJuegoTerminado());


        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.responder(new ArrayList<>(){
            {
                add(opcionCorrecta);
            }
        });

        juego.evaluarRespuestas();
        assertTrue(juego.estaJuegoTerminado());
    }
}
