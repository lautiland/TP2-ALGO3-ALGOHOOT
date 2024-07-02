package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.model.excepciones.JSONInvalido;
import edu.fiuba.algo3.model.parser.JuegoParser;
import edu.fiuba.algo3.model.pregunta.GroupChoice;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    private final String FORMATO = "json";
    private final String RUTA_EJEMPLOS = "src/main/test/edu/fiuba/algo3/unitarios/example/";

    @Test
    public void test01SePuedeParsearUnArchivoJSONCorrectamente() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+"preguntas.json");
        ArrayList<Pregunta> preguntas = parser.parsear(archivo, FORMATO);

        // Getters en preguntas para chequear si se parsearon bien?

        assertEquals(24, preguntas.size());
    }

    @Test
    public void test03NoSePuedeParsearUnFormatoInvalido() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+"preguntas.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, "xml"));
    }

    @Test
    public void test04NoPuedoParsearUnArchivoConTemaFaltante() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "preguntas_sin_tema.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test05NoPuedoParsearUnArchivoConTipoFaltante() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "preguntas_sin_tipo.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test06NoPuedoParsearUnArchivoConPreguntaFaltante() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+"preguntas_sin_preguntas.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test07NoPuedoParsearUnArchivoConRespuestasFaltantes() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "preguntas_sin_respuestas.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test08NoPuedoParsearUnArchivoConOpcionesFaltantes() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "preguntas_sin_opciones.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test09PuedoParsearUnaPreguntaTipoGroupChoiceCorrectamente() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "pregunta_group_choice.json");
        ArrayList<Pregunta> preguntas = parser.parsear(archivo, FORMATO);

        assertTrue(preguntas.get(0) instanceof GroupChoice);
    }
}
