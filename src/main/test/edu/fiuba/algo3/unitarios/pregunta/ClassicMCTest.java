package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.model.pregunta.ClassicMC;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassicMCTest {
    @Test
    public void test01SeIntentaCrearClassicMCSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta classicMC = new ClassicMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            classicMC.evaluarRespuestas(opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearClassicMCConDemasiadasOpciones(){

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
            
            Pregunta classicMC = new ClassicMC("Elegir las opciones que dicen Si", opciones, opciones, "", "");
            classicMC.evaluarRespuestas(opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaMCCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones, opciones, "", "");

        assertEquals(preguntaMC.seleccionarOpcion(2), opcion3);
        assertEquals(preguntaMC.seleccionarOpcion(3), opcion4);
        assertEquals("Multiple Choice Clasico", preguntaMC.getTipoDePregunta());
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaMCCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones, opciones, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion2);
        respuestas.add(opcion3);
        respuestas.add(opcion4);

        assertEquals(preguntaMC.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaMCIncorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        Pregunta preguntaMC = new ClassicMC("Pregunta de multiple choice", opciones, opciones, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);

        assertEquals(0, preguntaMC.evaluarRespuestas(respuestas));
    }
}
