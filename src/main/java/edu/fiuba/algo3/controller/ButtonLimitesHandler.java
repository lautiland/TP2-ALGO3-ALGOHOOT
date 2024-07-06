package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.AgregarJugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ButtonLimitesHandler implements EventHandler<ActionEvent> {

    private final Stage STAGE;
    private final TextField INPUT_LIMITE_PREGUNTAS;
    private final TextField INPUT_LIMITE_PUNTOS;

    public ButtonLimitesHandler(Stage STAGE, TextField inputLimitePreguntas, TextField inputLimitePuntos){
        this.INPUT_LIMITE_PREGUNTAS = inputLimitePreguntas;
        this.INPUT_LIMITE_PUNTOS = inputLimitePuntos;
        this.STAGE = STAGE;
    }

    @Override
    public void handle(ActionEvent event) {

        if (INPUT_LIMITE_PREGUNTAS.getText().isEmpty() || INPUT_LIMITE_PUNTOS.getText().isEmpty()){
            return;
        }

        int limitePreguntas = Integer.parseInt(INPUT_LIMITE_PREGUNTAS.getText());
        int limitePuntos = Integer.parseInt(INPUT_LIMITE_PUNTOS.getText());

        try {
            STAGE.setScene(new AgregarJugadoresView(STAGE, limitePreguntas, limitePuntos).getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
