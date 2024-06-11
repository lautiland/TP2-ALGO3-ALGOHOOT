package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.modelo.pregunta.OrderedChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderedChoiceTest {
    @Test
    public void test01SeIntentaCrearOrderedChoiceSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
            opcionesOrdenadas.add(opcion1);

            Pregunta orderedChoice = new OrderedChoice("Elegir las opcionesOrdenadas que dicen Si", opcionesOrdenadas);
            orderedChoice.evaluarRespuestas(opcionesOrdenadas);
        });
    }


    @Test
    public void test02SeIntentaCrearOrderedChoiceConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            Opcion opcion2 = new Opcion("No");
            Opcion opcion3 = new Opcion("Si");
            Opcion opcion4 = new Opcion("Siuuuu");
            Opcion opcion5 = new Opcion("Si");
            Opcion opcion6 = new Opcion("Si");
            Opcion opcion7 = new Opcion("Si");
            ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
            opcionesOrdenadas.add(opcion1);
            opcionesOrdenadas.add(opcion2);
            opcionesOrdenadas.add(opcion3);
            opcionesOrdenadas.add(opcion4);
            opcionesOrdenadas.add(opcion5);
            opcionesOrdenadas.add(opcion6);
            opcionesOrdenadas.add(opcion7);

            Pregunta orderedChoice = new OrderedChoice("Elegir las opciones que dicen Si", opcionesOrdenadas);
            orderedChoice.evaluarRespuestas(opcionesOrdenadas);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaOrderedChoiceCorrectamente(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta orderedChoice = new OrderedChoice("Pregunta de multiple choice", opcionesOrdenadas);

        assertEquals(orderedChoice.seleccionarOpcion(2), opcion3);
        assertEquals(orderedChoice.seleccionarOpcion(3), opcion4);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaOrderedChoiceCorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta orderedChoice = new OrderedChoice("Pregunta de multiple choice", opcionesOrdenadas);

        assertEquals(orderedChoice.evaluarRespuestas(opcionesOrdenadas), 1);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaOrderedChoiceIncorrecta(){
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta orderedChoice = new OrderedChoice("Pregunta de multiple choice", opcionesOrdenadas);

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);
        respuestas.add(opcion3);
        respuestas.add(opcion2);

        assertEquals(orderedChoice.evaluarRespuestas(respuestas), 0);
    }
}

