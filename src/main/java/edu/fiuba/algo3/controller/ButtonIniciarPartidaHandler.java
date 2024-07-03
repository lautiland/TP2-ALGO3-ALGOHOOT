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
    ArrayList<Jugador> jugadores;
    private final static String ARCHIVO_PREGUNTAS =  "src/main/resources/preguntas.json";

    public ButtonIniciarPartidaHandler(Stage stage, ArrayList<Jugador> jugadores_actual){
        this.STAGE = stage;
        jugadores = jugadores_actual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego;
        try {
            juego = new Juego(jugadores,new FileReader(ARCHIVO_PREGUNTAS));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JugarTurnoView jugadorView = new JugarTurnoView(STAGE, juego);
         try {
             STAGE.setScene(jugadorView.getScene());
         } catch (Exception ex) {
             throw new RuntimeException(ex);
         }
        //ResultadosView resultados_ronda = new ResultadosView(STAGE, jugadores);
        //STAGE.setScene(resultados_ronda.getScene());
    }
}
