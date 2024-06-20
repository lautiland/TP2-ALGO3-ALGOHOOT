package edu.fiuba.algo3.modelo.parser;

import java.io.*;

public class JuegoParser {
    public void parsear(String ruta, String formato) {
        try (Reader reader = new FileReader(ruta)) {
            if (formato.equals("json")){
                JSONReader.obtenerPregunta(reader);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
