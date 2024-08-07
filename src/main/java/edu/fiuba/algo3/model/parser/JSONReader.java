package edu.fiuba.algo3.model.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.excepciones.JSONInvalido;
import edu.fiuba.algo3.model.pregunta.*;

import java.io.Reader;
import java.util.ArrayList;


public class JSONReader {
    private static JsonArray validarJSON(JsonElement jsonElement) {

        JsonArray preguntas = jsonElement.getAsJsonArray();
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

        return preguntas;
    }

    private static Pregunta parserPregunta(String tipo, String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas, String categoria, String descripcionRespuesta){
       tipo = tipo.toLowerCase();
        switch (tipo){
            case "verdadero falso":
            case "verdadero falso simple":
                return new ClassicTF(enunciado, opciones, opcionesCorrectas.get(0), categoria, descripcionRespuesta);
            case "multiple choice simple":
                return new ClassicMC(enunciado, opciones, opcionesCorrectas, categoria, descripcionRespuesta);
            case "multiple choice puntaje parcial":
                return new ParcialMC(enunciado, opciones, opcionesCorrectas, categoria, descripcionRespuesta);
            case "verdadero falso penalidad":
                return new PenaltyTF(enunciado, opciones, opcionesCorrectas.get(0), categoria, descripcionRespuesta);
            case "multiple choice penalidad":
                return new PenaltyMC(enunciado, opciones, opcionesCorrectas, categoria, descripcionRespuesta);
            case "ordered choice":
                return new OrderedChoice(enunciado,opciones , opcionesCorrectas, categoria, descripcionRespuesta);
            default:
                throw new JSONInvalido("Tipo de pregunta invalido");
        }
    }

    private static Pregunta parsearGroupChoice(JsonObject preguntaObject){
        String tema = preguntaObject.get("Tema").getAsString();
        String textoRespuesta = preguntaObject.get("Texto respuesta").getAsString();
        String preguntaTexto = preguntaObject.get("Pregunta").getAsString();
        String respuesta = preguntaObject.get("Respuesta").getAsString();
        String[] respuestasGrupoA = respuesta.split(";")[0].substring(3).split(",");
        ArrayList<Opcion> opciones = new ArrayList<>();
        ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
        parsearOpciones(preguntaObject, opciones, respuestasGrupoA, opcionesCorrectas);

        String descripcionGrupoA = preguntaObject.get("Grupo A").getAsString();
        String descripcionGrupoB = preguntaObject.get("Grupo B").getAsString();
        return new GroupChoice(preguntaTexto, opciones, opcionesCorrectas, tema, textoRespuesta, descripcionGrupoA, descripcionGrupoB);
    }

    public static ArrayList<Pregunta> obtenerPregunta(Reader reader){
        JsonElement jsonElement = JsonParser.parseReader(reader);

        JsonArray preguntas = validarJSON(jsonElement);
        ArrayList<Pregunta> preguntasList = new ArrayList<>();
        for (JsonElement pregunta : preguntas) {
            JsonObject preguntaObject = pregunta.getAsJsonObject();
            String tipo = preguntaObject.get("Tipo").getAsString();
            if (tipo.equalsIgnoreCase("group choice")){
                preguntasList.add(parsearGroupChoice(preguntaObject));
                continue;
            }

            String tema = preguntaObject.get("Tema").getAsString();
            String textoRespuesta = preguntaObject.get("Texto respuesta").getAsString();
            String preguntaTexto = preguntaObject.get("Pregunta").getAsString();
            String respuesta = preguntaObject.get("Respuesta").getAsString();
            String[] respuestas = respuesta.split(",");
            ArrayList<Opcion> opciones = new ArrayList<>();
            ArrayList<Opcion> opcionesCorrectas = new ArrayList<>();
            parsearOpciones(preguntaObject, opciones, respuestas, opcionesCorrectas);

            preguntasList.add(parserPregunta(tipo, preguntaTexto, opciones, opcionesCorrectas, tema, textoRespuesta));
        }

        return preguntasList;
    }

    private static void parsearOpciones(JsonObject preguntaObject, ArrayList<Opcion> opciones, String[] respuestas, ArrayList<Opcion> opcionesCorrectas) {
        for (int i = 1; i <= 6; i++) {
            if(preguntaObject.has("Opcion " + i)){
                String opcion = preguntaObject.get("Opcion " + i).getAsString();
                opciones.add(new Opcion(opcion));
            }
        }
        for (String respuestaActual : respuestas) {
            opcionesCorrectas.add(opciones.get(Integer.parseInt(respuestaActual) - 1));
        }
    }
}
