package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.PreguntaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonNingunoHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;

    public ButtonNingunoHandler(Stage stage){
        this.STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        PreguntaView preguntaView = new PreguntaView(STAGE);
        try {
            STAGE.setScene(preguntaView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
