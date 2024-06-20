package edu.fiuba.algo3.unitarios.pregunta;

import edu.fiuba.algo3.modelo.pregunta.evaluadorTernario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class evaluadorTernarioTest {
    @Test
    public void test01RespuestasCorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernario newEvaluador = new evaluadorTernario();
        assertEquals(1, newEvaluador.calcular(1, 0));
    }

    @Test
    public void test02RespuestasIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernario newEvaluador = new evaluadorTernario();
        assertEquals(0, newEvaluador.calcular(0, 1));
    }

    @Test
    public void test03RespuestasCorrectasEIncorrectasDevuelveLosPuntosCorrectos() {
        evaluadorTernario newEvaluador = new evaluadorTernario();
        assertEquals(0, newEvaluador.calcular(1, 1));
    }

    @Test
    public void test04NoHayRespuestas() {
        evaluadorTernario newEvaluador = new evaluadorTernario();
        assertEquals(0, newEvaluador.calcular(0, 0));
    }


}




