package edu.fiuba.algo3.model.parser;

import edu.fiuba.algo3.model.excepciones.JSONInvalido;
import edu.fiuba.algo3.model.pregunta.Pregunta;

import java.io.*;
import java.util.ArrayList;

public class JuegoParser {
    public ArrayList<Pregunta> parsear(Reader archivo, String formato) {
        if (formato.equals("json")){
            return JSONReader.obtenerPregunta(archivo);
        }

        throw new JSONInvalido("Formato no soportado");
    }
}
