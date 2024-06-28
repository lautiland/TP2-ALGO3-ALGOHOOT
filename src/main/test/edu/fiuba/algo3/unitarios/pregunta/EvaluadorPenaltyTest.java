package edu.fiuba.algo3.unitarios.pregunta;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.model.evaluadores.EvaluadorPenalty;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluadorPenaltyTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorPenalty newEvaluador = new EvaluadorPenalty();
        assertEquals(2, newEvaluador.calcular(2, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorPenalty newEvaluador = new EvaluadorPenalty();
        assertEquals(-2, newEvaluador.calcular(0, 2));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorPenalty newEvaluador = new EvaluadorPenalty();
        assertEquals(0, newEvaluador.calcular(2, 2));
    }

    @Test
    public void test04NoHayRespuestas() {
        EvaluadorPenalty newEvaluador = new EvaluadorPenalty();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }


}


