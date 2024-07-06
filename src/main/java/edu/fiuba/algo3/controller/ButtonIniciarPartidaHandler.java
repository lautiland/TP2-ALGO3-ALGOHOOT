package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.view.JugarTurnoView;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ButtonIniciarPartidaHandler implements EventHandler<ActionEvent>{
    private final Stage STAGE;
    private final String ARCHIVO_PREGUNTAS;
    private final ArrayList<Jugador> JUGADORES;
    private final int LIMITE_PREGUNTAS;
    private final int LIMITE_PUNTOS;

    public ButtonIniciarPartidaHandler(Stage stage, ArrayList<Jugador> jugadores, String archivoPreguntas , int limitePreguntas, int limitePuntos){
        STAGE = stage;
        ARCHIVO_PREGUNTAS = archivoPreguntas;
        JUGADORES = jugadores;
        LIMITE_PREGUNTAS = limitePreguntas;
        LIMITE_PUNTOS = limitePuntos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego;

        try {
            juego = new Juego(JUGADORES, new FileReader(ARCHIVO_PREGUNTAS), LIMITE_PREGUNTAS, LIMITE_PUNTOS);
            juego.mezclarPreguntas();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

         try {
             STAGE.setScene(new JugarTurnoView(STAGE, juego).getScene());
         } catch (Exception ex) {
             throw new RuntimeException(ex);
         }
    }
}
