package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Jugador;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonAddJugadorHanlder implements EventHandler<ActionEvent>{
    private final Stage STAGE;
    ArrayList<Jugador> jugadores;
    TextField jugador;

    public ButtonAddJugadorHanlder(Stage stage, ArrayList<Jugador> jugadores_actuales, TextField jugador_nombre ){
        this.STAGE = stage;
        jugadores = jugadores_actuales;
        jugador = jugador_nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String playerName = jugador.getText();
        if (!playerName.isEmpty()) {
            Jugador jugadorActual = new Jugador(playerName);
            jugadores.add(jugadorActual);
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}

