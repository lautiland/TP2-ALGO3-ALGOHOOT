package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.pregunta.evaluadorTernarioAcumulativo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class evaluadorTernarioAcumulativoTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernarioAcumulativo newEvaluador = new evaluadorTernarioAcumulativo();
        assertEquals(3, newEvaluador.calcular(3, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernarioAcumulativo newEvaluador = new evaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(0, 1));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernarioAcumulativo newEvaluador = new evaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(1, 1));
    }

    @Test
    public void test04NoHayRespuestas() {
        evaluadorTernarioAcumulativo newEvaluador = new evaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }

}


