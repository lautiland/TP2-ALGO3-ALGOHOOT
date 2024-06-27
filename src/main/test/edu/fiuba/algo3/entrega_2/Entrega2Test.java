package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.pregunta.*;
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

        Pregunta pregunta = new PenaltyTF("¿Verdadero o falso?", opciones, opcion1, "", "");
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

    @Test
    public void test04ParcialMCFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadores.add(jugador3);


        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        opcionesCorrectas.add(opcion1);
        opcionesCorrectas.add(opcion2);
        opcionesCorrectas.add(opcion3);


        Pregunta pregunta = new ParcialMC("Pregunta de multiple choice", opciones, opcionesCorrectas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion3);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion4);
        }});

        juego.responder(jugador3, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
        }});

        juego.evaluarRespuestas();

        assertEquals(3,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());
        assertEquals(2, jugador3.getPuntos());
    }

    @Test
    public void test05OrderedChoiceFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta pregunta = new OrderedChoice("Pregunta de ordered choice", opcionesOrdenadas, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(pregunta);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion3);
            add(opcion4);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion4);
            add(opcion3);
        }});


        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(0, jugador2.getPuntos());

    }

    @Test
    public void test06GroupChoiceFuncionaCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        ArrayList<Opcion> opcionesGrupoA = new ArrayList<>();
        opcionesGrupoA.add(opcion1);
        opcionesGrupoA.add(opcion2);
        ArrayList<Opcion> opcionesGrupoB = new ArrayList<>();
        opcionesGrupoB.add(opcion3);
        opcionesGrupoB.add(opcion4);

        Pregunta groupChoice = new GroupChoice("Pregunta de multiple choice",
                opciones, opcionesGrupoA, opcionesGrupoB, "", "");
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(groupChoice);

        Juego juego = new Juego(jugadores,preguntas);

        juego.responder(jugador1, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion3);
            add(opcion4);
        }});

        juego.responder(jugador2, new ArrayList<>(){{
            add(opcion1);
            add(opcion2);
            add(opcion4);
            add(opcion3);
        }});


        juego.evaluarRespuestas();

        assertEquals(1,jugador1.getPuntos());
        assertEquals(1, jugador2.getPuntos());

    }
}
