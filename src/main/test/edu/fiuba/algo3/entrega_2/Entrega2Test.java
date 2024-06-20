package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.pregunta.ClassicTF;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2Test {

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugador3;

    @BeforeEach
    public void beforeEach() {
        jugador1 = new Jugador("Juan");
        jugador2 = new Jugador("Daniel");
        jugador3 = new Jugador("Pedro");
    }

    @Test
    public void test01MultiplicadoresFuncionanCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("¿Verdadero o falso?", opciones, opcion1, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.responder(jugador3, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.activarMultiplicador(jugador1, 2);
        juego.activarMultiplicador(jugador2, 3);

        juego.evaluarRespuestas();

        assertEquals(2,jugador1.getPuntos());
        assertEquals(3, jugador2.getPuntos());
        assertEquals(1, jugador3.getPuntos());
    }

    @Test
    public void test02AnuladorFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("¿Verdadero o falso?", opciones, opcion1, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion2);
        }});

        juego.responder(jugador3, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.activarAnulador(jugador1);

        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
        assertEquals(0, jugador3.getPuntos());
    }

    @Test
    public void test03ExclusividadFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta pregunta = new ClassicTF("¿Verdadero o falso?", opciones, opcion2, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion1);
        }});

        juego.responder(jugador3, new ArrayList<>(){{
            add(opcion2);
        }});

        juego.activarExclusividad(jugador1);
        juego.activarExclusividad(jugador2);

        juego.evaluarRespuestas();

        assertEquals(0,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
        assertEquals(4, jugador3.getPuntos());
    }

    /*
    PRIMERO PRUEBAS EXTRA PARA LAS NUEVAS CLASES DE PREGUNTA
    group choice
    ordered choice
    parcial mc
    SEGUNDO PRUEBAS UNITARIAS PARA LOS EVALUADORES.
    ------ CON ESTO ESTARÍA LAS PRUEBAS--------
    CREAR ADMINISTRADOR DE JUEGO PARA EL FLUJO DE TURNOS, TABLERO, BLA.
    -----CON ESTO ESTARÍA TODO LO ESENCIAL PARA NO REPROBAR----
    CREAR UN OBSERVADOR Y AÑADIRLO AL ADMINISTRADOR DEL JUEGO.
    IMPORTAR TODOS LOS DATOS INICIO DE JUEGO. ( NO ACCEDER A ELLOS IN GAME, SINO PRE).
     */

}
