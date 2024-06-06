package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassicMCTest {
    @Test
    public void test01SeIntentaCrearClassicMCSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta classicMC = new ClassicMC("Elegir las opciones que dicen Si", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearClassicMCConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si", true);
            Opcion opcion2 = new Opcion("No", false);
            Opcion opcion3 = new Opcion("Si", true);
            Opcion opcion4 = new Opcion("Siuuuu", false);
            Opcion opcion5 = new Opcion("Si", true);
            Opcion opcion6 = new Opcion("Si", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            opciones.add(opcion4);
            opciones.add(opcion5);
            opciones.add(opcion6);
            
            Pregunta classicMC = new ClassicMC("Elegir las opciones que dicen Si", opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaMCCorrectamente(){
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
    public void test04PuedoEvaluarUnaRespuestaMCCorrecta(){
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
    public void test05PuedoEvaluarUnaRespuestaMCIncorrecta(){
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
}
