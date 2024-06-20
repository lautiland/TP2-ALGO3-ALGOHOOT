package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;
import edu.fiuba.algo3.modelo.pregunta.Pregunta;

import java.io.*;
import java.util.ArrayList;

public class JuegoParser {
    public ArrayList<Pregunta> parsear(String ruta, String formato) {
        try (Reader reader = new FileReader(ruta)) {
            if (formato.equals("json")){
                return JSONReader.obtenerPregunta(reader);
            }
        } catch (FileNotFoundException e) {
            throw new JSONInvalido("No se encontro el archivo");
        } catch (IOException e) {
            throw new JSONInvalido("Error al leer el archivo");
        }
        return null;
    }
}
