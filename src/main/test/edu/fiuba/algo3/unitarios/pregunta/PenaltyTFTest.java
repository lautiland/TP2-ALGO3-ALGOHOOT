package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.modelo.pregunta.PenaltyTF;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PenaltyTFTest {
    @Test
    public void test01SeIntentaCrearPenalidadTFSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones, opcion1);
            penalidadTF.evaluarRespuestas(opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearPenalidadTFConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero");
            Opcion opcion2 = new Opcion("Falso");
            Opcion opcion3 = new Opcion("Verdadero");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            
            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones, opcion1);
            penalidadTF.evaluarRespuestas(opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaPenalidadTFCorrectamente(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones, opcion1);

        assertEquals(preguntaTF.seleccionarOpcion(1), opcion2);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaPenalidadTFCorrecta(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones, opcion1);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaPenalidadTFIncorrecta(){
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);

        Pregunta preguntaTF = new PenaltyTF("Pregunta de verdadero o falso", opciones, opcion1);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion2);

        assertEquals(preguntaTF.evaluarRespuestas(respuestas), -1);
    }
}
