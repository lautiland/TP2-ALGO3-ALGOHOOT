package edu.fiuba.algo3.unitarios.pregunta;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.pregunta.evaluadorPenalty;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class evaluadorPenaltyTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        evaluadorPenalty newEvaluador = new evaluadorPenalty();
        assertEquals(2, newEvaluador.calcular(2, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorPenalty newEvaluador = new evaluadorPenalty();
        assertEquals(-2, newEvaluador.calcular(0, 2));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorPenalty newEvaluador = new evaluadorPenalty();
        assertEquals(0, newEvaluador.calcular(2, 2));
    }

    @Test
    public void test04NoHayRespuestas() {
        evaluadorPenalty newEvaluador = new evaluadorPenalty();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }


}


