package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.AddJugadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ButtonLimitesHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final TextField preguntaLimitePreguntas;
    private final TextField preguntaLimitePuntos;

    public ButtonLimitesHandler(Stage STAGE, TextField preguntaLimitePreguntas, TextField preguntaLimitePuntos){
        this.preguntaLimitePreguntas = preguntaLimitePreguntas;
        this.preguntaLimitePuntos = preguntaLimitePuntos;
        this.STAGE = STAGE;
    }

    @Override
    public void handle(ActionEvent event) {
        if (preguntaLimitePreguntas.getText().isEmpty() || preguntaLimitePuntos.getText().isEmpty()){
            return;
        }
        int limitePreguntas = Integer.parseInt(preguntaLimitePreguntas.getText());
        int limitePuntos = Integer.parseInt(preguntaLimitePuntos.getText());

        try {
            STAGE.setScene(new AddJugadoresView(STAGE, limitePreguntas, limitePuntos).getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
