package edu.fiuba.algo3.unitarios.pregunta;
import edu.fiuba.algo3.modelo.pregunta.evaluadorGrupos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class evaluadorGruposTest {
    @Test
    public void test01NoHayRespuestasIncorrectas() {
        evaluadorGrupos newEvaluador = new evaluadorGrupos();
        assertEquals(1, newEvaluador.calcular(2, 0));
    }

    @Test
    public void test02NoHayRespuestasCorrectas() {
        evaluadorGrupos newEvaluador = new evaluadorGrupos();
        assertEquals(1, newEvaluador.calcular(0, 2));
    }

    @Test
    public void test03HayRespuestasCorrectasEIncorrectas() {
        evaluadorGrupos newEvaluador = new evaluadorGrupos();
        assertEquals(0, newEvaluador.calcular(2, 1));
    }

    @Test
    public void test04NoHayRespuestas() {
        evaluadorGrupos newEvaluador = new evaluadorGrupos();
        assertEquals(0, newEvaluador.calcular(0, 4));
    }

    @Test
    public void test05NoHayRespuestasCorrectas() {
        evaluadorGrupos newEvaluador = new evaluadorGrupos();
        assertEquals(1, newEvaluador.calcular(0, 1));
    }

}


