package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.PreguntaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import edu.fiuba.algo3.model.Juego;

public class ButtonNingunoHandler implements EventHandler<ActionEvent> {

    private final Stage STAGE;
    private final Juego JUEGO;

    public ButtonNingunoHandler(Stage stage, Juego juego){
        STAGE = stage;
        JUEGO = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            STAGE.setScene(new PreguntaView(STAGE, JUEGO).getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
