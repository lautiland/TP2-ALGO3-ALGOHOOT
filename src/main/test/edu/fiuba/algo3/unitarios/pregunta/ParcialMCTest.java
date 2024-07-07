package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.model.pregunta.ParcialMC;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParcialMCTest {
    @Test
    public void test01SeIntentaCrearParcialMCSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta parcialMC = new ParcialMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            parcialMC.evaluarRespuestas(opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearParcialMCConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            Opcion opcion2 = new Opcion("No");
            Opcion opcion3 = new Opcion("Si");
            Opcion opcion4 = new Opcion("Siuuuu");
            Opcion opcion5 = new Opcion("Si");
            Opcion opcion6 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            opciones.add(opcion4);
            opciones.add(opcion5);
            opciones.add(opcion6);

            Pregunta parcialMC = new ParcialMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            parcialMC.evaluarRespuestas(opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaParcialMCCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta parcialMC = new ParcialMC("Pregunta de multiple choice", opciones, opciones, "", "");

        assertEquals(parcialMC.seleccionarOpcion(2), opcion3);
        assertEquals(parcialMC.seleccionarOpcion(3), opcion4);
        assertEquals("Multiple Choice Parcial", parcialMC.getTipoDePregunta());
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaParcialMCCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta parcialMC = new ParcialMC("Pregunta de multiple choice", opciones, opciones, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion3);

        assertEquals(parcialMC.evaluarRespuestas(respuestas), 2);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaParcialMCIncorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        respuestasCorrectas.add(opcion2);
        respuestasCorrectas.add(opcion3);

        Pregunta parcialMC = new ParcialMC("Pregunta de multiple choice", opciones, respuestasCorrectas, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(parcialMC.evaluarRespuestas(respuestas), 0);
    }

    @Test
    public void test06PuedoEvaluarSoloUnaRespuestaCorrectaParcialMC(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        ArrayList<Opcion> respuestasCorrectas = new ArrayList<>();
        respuestasCorrectas.add(opcion2);
        respuestasCorrectas.add(opcion3);

        Pregunta parcialMC = new ParcialMC("Pregunta de multiple choice", opciones, respuestasCorrectas, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion3);
        respuestas.add(opcion1);

        assertEquals(parcialMC.evaluarRespuestas(respuestas), 0);
    }
}

