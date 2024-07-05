package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Jugador;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonAddJugadorHandler implements EventHandler<ActionEvent>{
    ArrayList<Jugador> jugadores;
    TextField jugador;
    Label label;
    Button iniciarPartida;

    public ButtonAddJugadorHandler(ArrayList<Jugador> jugadores_actuales, Label label, TextField jugador_nombre, Button iniciarPartida){
        jugadores = jugadores_actuales;
        jugador = jugador_nombre;
        this.label=label;
        this.iniciarPartida = iniciarPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String playerName = jugador.getText();
        if (!playerName.isEmpty()) {
            Jugador jugadorActual = new Jugador(playerName);
            label.setText(label.getText() + playerName + "\n");
            jugadores.add(jugadorActual);
            jugador.clear();
            if (jugadores.size() > 1) {
                iniciarPartida.setDisable(false);
            }
        }
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}

