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

        Pregunta primerPregunta = preguntas.get(0);
        Pregunta ultimaPregunta = preguntas.get(preguntas.size()-1);

        assertEquals(24, preguntas.size());

        assertEquals("Ordered Choice", primerPregunta.getTipoDePregunta());
        assertEquals("CIENCIAS", primerPregunta.getCategoria());
        assertEquals("Ordene de MAYOR A MENOR los siguientes objetos hogareños según su nivel de radiación electromagnética emitido (el máximo recomendado es 100 microTeslas)", primerPregunta.getEnunciado());
        assertEquals(4, primerPregunta.getOpciones().size());
        assertEquals("El microondas emite a  3 cm entre 73 y 200µ, y a 30 cm entre 4 a 8 µT. ",primerPregunta.getDescripcionRespuesta());

        assertEquals("Multiple Choice con Penalidad", ultimaPregunta.getTipoDePregunta());
        assertEquals("MISCELANEAS", ultimaPregunta.getCategoria());
        assertEquals("¿Cuáles de las siguientes calles, avenidas o pasajes son del barrio de San Telmo, donde está ubicada la sede Paseo Colón de nuestra universidad?", ultimaPregunta.getEnunciado());
        assertEquals(5, ultimaPregunta.getOpciones().size());
        assertEquals("A buscar el mapa", ultimaPregunta.getDescripcionRespuesta());
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

        Pregunta pregunta = preguntas.get(0);

        assertEquals("Group Choice", pregunta.getTipoDePregunta());
        assertEquals("DEPORTES", pregunta.getCategoria());
        assertEquals("Asigne las siguientes leyendas del deporte nacional a disciplina grupales (Fútbol, Básquet, Voley, Rugby,) o individuales (atletismo, tenis, artes marciales, ajedrez, etc):", pregunta.getEnunciado());
        assertEquals(6, pregunta.getOpciones().size());
        assertEquals("Deportes Grupales", ((GroupChoice) pregunta).getDescripcionGrupoA());
        assertEquals("Deportes Individuales", ((GroupChoice) pregunta).getDescripcionGrupoB());
        assertEquals("say no more...", pregunta.getDescripcionRespuesta());
    }

    @Test
    public void test10NoPuedoParsearUnaPreguntaDeUnTipoNoSoportado() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "pregunta_tipo_invalido.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test11NoPuedoParsearUnaPreguntaSinAlMenosDosOpciones() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "pregunta_opciones_faltantes.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }

    @Test
    public void test12NoPuedoParasearUnaPreguntaSinTextoRespuesta() throws FileNotFoundException {
        JuegoParser parser = new JuegoParser();

        Reader archivo = new FileReader(RUTA_EJEMPLOS+ "pregunta_sin_texto_respuesta.json");
        assertThrows(JSONInvalido.class, () -> parser.parsear(archivo, FORMATO));
    }
}
