package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Jugador;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonAddJugadorHanlder implements EventHandler<ActionEvent>{
    private final Stage STAGE;
    ArrayList<Jugador> jugadores;
    TextField jugador;
    Label label;

    public ButtonAddJugadorHanlder(Stage stage, ArrayList<Jugador> jugadores_actuales, Label label, TextField jugador_nombre ){
        this.STAGE = stage;
        jugadores = jugadores_actuales;
        jugador = jugador_nombre;
        this.label=label;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String playerName = jugador.getText();
        if (!playerName.isEmpty()) {
            Jugador jugadorActual = new Jugador(playerName);
            label.setText(label.getText() + "\n" + playerName);
            jugadores.add(jugadorActual);
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}

