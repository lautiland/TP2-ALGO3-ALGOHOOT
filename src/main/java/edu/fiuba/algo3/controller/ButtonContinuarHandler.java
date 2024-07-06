package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.SceneGui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonContinuarHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final SceneGui SIGUIENTE_ESCENA;

    public ButtonContinuarHandler(Stage stage, SceneGui siguienteEscena){
        this.STAGE = stage;
        this.SIGUIENTE_ESCENA = siguienteEscena;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            STAGE.setScene(SIGUIENTE_ESCENA.getScene(STAGE));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
