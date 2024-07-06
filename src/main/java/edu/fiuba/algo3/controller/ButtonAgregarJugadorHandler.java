package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Jugador;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonAgregarJugadorHandler implements EventHandler<ActionEvent>{
    private final ArrayList<Jugador> JUGADORES ;
    private final TextField INPUT_JUGADOR;
    private final Button INICIAR_PARTIDA;
    private final Label LISTADO_JUGADORES;

    public ButtonAgregarJugadorHandler(ArrayList<Jugador> jugadores, Label listadoJugadores, TextField inputJugador, Button iniciarPartida){
        JUGADORES = jugadores;
        INPUT_JUGADOR = inputJugador;
        LISTADO_JUGADORES = listadoJugadores;
        INICIAR_PARTIDA = iniciarPartida;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String playerName = INPUT_JUGADOR.getText();

        if (!playerName.isEmpty()) {
            Jugador jugadorActual = new Jugador(playerName);
            LISTADO_JUGADORES.setText(LISTADO_JUGADORES.getText() + playerName + "\n");
            JUGADORES.add(jugadorActual);
            INPUT_JUGADOR.clear();
            if (JUGADORES.size() > 1) {
                INICIAR_PARTIDA.setDisable(false);
            }
        }
    }
}

