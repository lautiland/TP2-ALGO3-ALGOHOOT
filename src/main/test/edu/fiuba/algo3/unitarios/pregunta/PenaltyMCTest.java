package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.model.pregunta.PenaltyMC;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PenaltyMCTest {
    @Test
    public void test01SeIntentaCrearPenalidadMCSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta penalidadMC = new PenaltyMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            penalidadMC.evaluarRespuestas(opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearPenalidadMCConDemasiadasOpciones(){

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
            
            Pregunta penalidadMC = new PenaltyMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            penalidadMC.evaluarRespuestas(opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaPenalidadMCCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenaltyMC("Pregunta de multiple choice", opciones, opciones, "", "");

        assertEquals(preguntaMC.seleccionarOpcion(2), opcion3);
        assertEquals(preguntaMC.seleccionarOpcion(3), opcion4);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaPenalidadMCCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenaltyMC("Pregunta de multiple choice", opciones, opciones, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion3);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 2);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaPenalidadMCIncorrecta(){
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

        Pregunta preguntaMC = new PenaltyMC("Pregunta de multiple choice", opciones, respuestasCorrectas, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), -2);
    }

    @Test
    public void test06PuedoEvaluarUnaRespuestaPenalidadMCCorrectaConTodasCorrectas(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new PenaltyMC("Pregunta de multiple choice", opciones, opciones, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 2);
    }
}

