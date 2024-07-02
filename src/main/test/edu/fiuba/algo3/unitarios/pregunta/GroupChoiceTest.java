package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.excepciones.CantidadOpcionesInvalida;
import edu.fiuba.algo3.model.pregunta.GroupChoice;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GroupChoiceTest {
    @Test
    public void test01SeIntentaCrearGroupChoiceSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            ArrayList<Opcion> opcionesGrupoA = new ArrayList<>();
            opcionesGrupoA.add(opcion1);
            ArrayList<Opcion> opcionesGrupoB = new ArrayList<>();


            Pregunta groupChoice = new GroupChoice("Elegir las opciones que dicen Si",
                    opciones, opcionesGrupoA, opcionesGrupoB, "", "");
            groupChoice.evaluarRespuestas(opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearGroupChoiceConDemasiadasOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si");
            Opcion opcion2 = new Opcion("No");
            Opcion opcion3 = new Opcion("Si");
            Opcion opcion4 = new Opcion("Siuuuu");
            Opcion opcion5 = new Opcion("Si");
            Opcion opcion6 = new Opcion("Si");
            Opcion opcion7 = new Opcion("Si");
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            opciones.add(opcion4);
            opciones.add(opcion5);
            opciones.add(opcion6);
            opciones.add(opcion7);
            ArrayList<Opcion> opcionesGrupoA = new ArrayList<>();
            opcionesGrupoA.add(opcion1);
            opcionesGrupoA.add(opcion2);
            opcionesGrupoA.add(opcion3);
            opcionesGrupoA.add(opcion4);
            ArrayList<Opcion> opcionesGrupoB = new ArrayList<>();
            opcionesGrupoB.add(opcion5);
            opcionesGrupoB.add(opcion6);
            opcionesGrupoB.add(opcion7);

            Pregunta groupChoice = new GroupChoice("Elegir las opciones que dicen Si",
                    opciones, opcionesGrupoA, opcionesGrupoB, "", "");
            groupChoice.evaluarRespuestas(opciones);
        });
    }

    @Test
    public void test03PuedoSeleccionarUnaPreguntaGCCorrectamente() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
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

        assertEquals(groupChoice.seleccionarOpcion(2), opcion3);
        assertEquals(groupChoice.seleccionarOpcion(3), opcion4);
    }

    @Test
    public void test04PuedoEvaluarUnaRespuestaGCCorrecta() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
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

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion2);

        assertEquals(groupChoice.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test05PuedoEvaluarUnaRespuestaGCIncorrecta() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
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

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion1);
        respuestas.add(opcion4);
        respuestas.add(opcion2);
        respuestas.add(opcion3);

        assertEquals(0, groupChoice.evaluarRespuestas(respuestas));
    }

    @Test
    public void test06PuedoEvaluarUnaRespuestaGCCorrectaDelSegundoGrupo() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
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

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion3);
        respuestas.add(opcion4);

        assertEquals(groupChoice.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test07PuedoEvaluarUnaRespuestaGCCorrectaImpar() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        ArrayList<Opcion> opcionesGrupoA = new ArrayList<>();
        opcionesGrupoA.add(opcion1);
        opcionesGrupoA.add(opcion2);
        opcionesGrupoA.add(opcion3);
        ArrayList<Opcion> opcionesGrupoB = new ArrayList<>();
        opcionesGrupoB.add(opcion4);

        Pregunta groupChoice = new GroupChoice("Pregunta de multiple choice",
                opciones, opcionesGrupoA, opcionesGrupoB, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion2);
        respuestas.add(opcion3);
        respuestas.add(opcion1);

        assertEquals(groupChoice.evaluarRespuestas(respuestas), 1);
    }

    @Test
    public void test08PuedoEvaluarUnaRespuestaGCCorrectaImparDelSegundoGrupo() {
        Opcion opcion1 = new Opcion("Opcion 1");
        Opcion opcion2 = new Opcion("Opcion 2");
        Opcion opcion3 = new Opcion("Opcion 3");
        Opcion opcion4 = new Opcion("Opcion 4");
        ArrayList<Opcion> opciones = new ArrayList<>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);
        ArrayList<Opcion> opcionesGrupoA = new ArrayList<>();
        opcionesGrupoA.add(opcion1);
        opcionesGrupoA.add(opcion2);
        opcionesGrupoA.add(opcion3);
        ArrayList<Opcion> opcionesGrupoB = new ArrayList<>();
        opcionesGrupoB.add(opcion4);

        Pregunta groupChoice = new GroupChoice("Pregunta de multiple choice",
                opciones, opcionesGrupoA, opcionesGrupoB, "", "");

        ArrayList<Opcion> respuestas = new ArrayList<>();
        respuestas.add(opcion4);

        assertEquals(groupChoice.evaluarRespuestas(respuestas), 1);
    }
}
