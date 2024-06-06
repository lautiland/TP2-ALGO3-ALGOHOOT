package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PenaltyTFTest {
    @Test
    public void test01SeIntentaCrearPenalidadTFSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearPenalidadTFConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            Opcion opcion2 = new Opcion("Falso", false);
            Opcion opcion3 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            
            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaPenalidadTFCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones);

        assertEquals(preguntaTF.seleccionarOpcion(1), opcion2);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaPenalidadTFCorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaPenalidadTFIncorrecta(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion2);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), -1);
    }
}