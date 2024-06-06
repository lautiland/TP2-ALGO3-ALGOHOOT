package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaTest {
    @Test
    public void test01PuedoSeleccionarUnaPreguntaTFCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones);

        assertEquals(preguntaTF.seleccionarOpcion(1), opcion2);
    }

    @Test
    public void test02PuedoEvaluarUnaRespuestaTFCorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test03PuedoEvaluarUnaRespuestaTFIncorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion2);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), 0);
    }

    @Test
    public void test04PuedoSeleccionarUnaPreguntaMCCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones);

        assertEquals(preguntaMC.seleccionarOpcion(2), opcion3);
        assertEquals(preguntaMC.seleccionarOpcion(3), opcion4);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaMCCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion3);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 2);
    }

    @Test
    public void test06PuedoEvaluarUnaRespuestaMCIncorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 0);
    }

    @Test
    public void test07PuedoSeleccionarUnaPreguntaPenalidadTFCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenalidadTF("Pregunta de verdadero o falso", opciones);

        assertEquals(preguntaTF.seleccionarOpcion(1), opcion2);
    }

    @Test
    public void test08PuedoEvaluarUnaRespuestaPenalidadTFCorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenalidadTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test09PuedoEvaluarUnaRespuestaPenalidadTFIncorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenalidadTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion2);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), -1);
    }

    @Test
    public void test10PuedoSeleccionarUnaPreguntaPenalidadMCCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenalidadMC("Pregunta de multiple choice", opciones);

        assertEquals(preguntaMC.seleccionarOpcion(2), opcion3);
        assertEquals(preguntaMC.seleccionarOpcion(3), opcion4);
    }

    @Test
    public void test11PuedoEvaluarUnaRespuestaPenalidadMCCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenalidadMC("Pregunta de multiple choice", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion3);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 2);
    }

    @Test
    public void test12PuedoEvaluarUnaRespuestaPenalidadMCIncorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1", true);
        Opcion opcion2 = new Opcion("Opcion 2", false);
        Opcion opcion3 = new Opcion("Opcion 3", true);
        Opcion opcion4 = new Opcion("Opcion 4", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenalidadMC("Pregunta de multiple choice", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 0);
    }
}
