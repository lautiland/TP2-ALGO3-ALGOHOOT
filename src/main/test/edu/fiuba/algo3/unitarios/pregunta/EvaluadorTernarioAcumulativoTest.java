package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernarioAcumulativo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluadorTernarioAcumulativoTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernarioAcumulativo newEvaluador = new EvaluadorTernarioAcumulativo();
        assertEquals(3, newEvaluador.calcular(3, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernarioAcumulativo newEvaluador = new EvaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(0, 1));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernarioAcumulativo newEvaluador = new EvaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(1, 1));
    }

    @Test
    public void test04NoHayRespuestas() {
        EvaluadorTernarioAcumulativo newEvaluador = new EvaluadorTernarioAcumulativo();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }

}


