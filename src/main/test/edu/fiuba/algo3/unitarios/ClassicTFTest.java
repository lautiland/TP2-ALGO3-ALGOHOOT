package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassicTFTest {
    @Test
    public void test01SeIntentaCrearClassicTFSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta classicTF = new ClassicTF("Verdadero o Falso", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearClassicTFConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            Opcion opcion2 = new Opcion("Falso", false);
            Opcion opcion3 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            
            Pregunta classicTF = new ClassicTF("Verdadero o Falso", opciones);
        });
    }
    @Test
    public void test03PuedoSeleccionarUnaPreguntaTFCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero", true);
        Opcion opcion2 = new Opcion("Falso", false);
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new ClassicTF("Pregunta de verdadero o falso", opciones);

        assertEquals(preguntaTF.seleccionarOpcion(1), opcion2);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaTFCorrecta(){
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
    public void test05PuedoEvaluarUnaRespuestaTFIncorrecta(){
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
}
