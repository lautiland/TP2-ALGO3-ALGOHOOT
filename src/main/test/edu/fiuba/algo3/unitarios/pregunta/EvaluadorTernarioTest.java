package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluadorTernarioTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernario newEvaluador = new EvaluadorTernario();
        assertEquals(1, newEvaluador.calcular(1, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernario newEvaluador = new EvaluadorTernario();
        assertEquals(0, newEvaluador.calcular(0, 1));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        EvaluadorTernario newEvaluador = new EvaluadorTernario();
        assertEquals(0, newEvaluador.calcular(1, 1));
    }

    @Test
    public void test04NoHayRespuestas() {
        EvaluadorTernario newEvaluador = new EvaluadorTernario();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }


}




