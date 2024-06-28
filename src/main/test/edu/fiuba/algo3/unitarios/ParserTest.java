package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;
import edu.fiuba.algo3.modelo.parser.JuegoParser;
import edu.fiuba.algo3.modelo.pregunta.GroupChoice;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    private final String FORMATO = "json";
    private final String RUTA_EJEMPLOS = "src/main/test/edu/fiuba/algo3/unitarios/example/";

    @Test
    public void test01SePuedeParsearUnArchivoJSONCorrectamente(){
        JuegoParser parser = new JuegoParser();

        ArrayList<Pregunta> preguntas = parser.parsear(RUTA_EJEMPLOS+"preguntas.json", FORMATO);

        // Getters en preguntas para chequear si se parsearon bien?

        assertEquals(24, preguntas.size());
    }

    @Test
    public void test02NoSePuedeParsearUnArchivoInexistente(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+"preguntasInexistente.json", FORMATO));
    }

    @Test
    public void test03NoSePuedeParsearUnFormatoInvalido(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+"preguntas.json", "xml"));
    }

    @Test
    public void test04NoPuedoParsearUnArchivoConTemaFaltante(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+ "preguntas_sin_tema.json", FORMATO));
    }

    @Test
    public void test05NoPuedoParsearUnArchivoConTipoFaltante(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+ "preguntas_sin_tipo.json", FORMATO));
    }

    @Test
    public void test06NoPuedoParsearUnArchivoConPreguntaFaltante(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+"preguntas_sin_pregunta.json", FORMATO));
    }

    @Test
    public void test07NoPuedoParsearUnArchivoConRespuestasFaltantes(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+ "preguntas_sin_respuestas.json", FORMATO));
    }

    @Test
    public void test08NoPuedoParsearUnArchivoConOpcionesFaltantes(){
        JuegoParser parser = new JuegoParser();

        assertThrows(JSONInvalido.class, () -> parser.parsear(RUTA_EJEMPLOS+ "preguntas_sin_opciones.json", FORMATO));
    }

    @Test
    public void test09PuedoParsearUnaPreguntaTipoGroupChoiceCorrectamente(){
        JuegoParser parser = new JuegoParser();

        ArrayList<Pregunta> preguntas = parser.parsear(RUTA_EJEMPLOS+ "pregunta_group_choice.json", FORMATO);

       assertTrue(preguntas.get(0) instanceof GroupChoice);
    }
}
