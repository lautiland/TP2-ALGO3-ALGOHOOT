package edu.fiuba.algo3.modelo.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.excepciones.JSONInvalido;

import java.io.Reader;

public class JSONReader {
    private static JsonObject validarJSON(JsonElement jsonElement) {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonArray preguntas = jsonObject.getAsJsonArray("preguntas");
        for (JsonElement pregunta : preguntas) {
            JsonObject preguntaObject = pregunta.getAsJsonObject();
            if(!preguntaObject.has("ID")) {
                throw new JSONInvalido("Falta el ID de la pregunta");
            }
            if(!preguntaObject.has("Tema")){
                throw new JSONInvalido("Falta el tema de la pregunta");
            }
            if(!preguntaObject.has("Tipo")){
                throw new JSONInvalido("Falta el tipo de la pregunta");
            }
            if(!preguntaObject.has("Pregunta")){
                throw new JSONInvalido("Falta la pregunta");
            }
            if(!preguntaObject.has("Respuesta")){
                throw new JSONInvalido("Falta la respuesta");
            }
            if(!preguntaObject.has("Opcion 1")){
                throw new JSONInvalido("Falta la opcion 1");
            }
            if(!preguntaObject.has("Opcion 2")){
                throw new JSONInvalido("Falta la opcion 2");
            }
            if(!preguntaObject.has("Texto respuesta")){
                throw new JSONInvalido("Falta el texto de la respuesta");
            }
        }

        return jsonObject;
    }

    public static void obtenerPregunta(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);

        JsonObject jsonObject = validarJSON(jsonElement);

        JsonArray preguntas = jsonObject.getAsJsonArray("preguntas");
        for (JsonElement pregunta : preguntas) {
            JsonObject preguntaObject = pregunta.getAsJsonObject();
            int id = preguntaObject.get("ID").getAsInt();
            String tema = preguntaObject.get("Tema").getAsString();
            String tipo = preguntaObject.get("Tipo").getAsString();
            String preguntaTexto = preguntaObject.get("Pregunta").getAsString();
            String respuesta = preguntaObject.get("Respuesta").getAsString();
            for (int i = 1; i <= 6; i++) {
                if(preguntaObject.has("Opcion " + i)){
                    String opcion = preguntaObject.get("Opcion " + i).getAsString();
                }
            }
            String textoRespuesta = preguntaObject.get("Texto respuesta").getAsString();
        }
    }
}
