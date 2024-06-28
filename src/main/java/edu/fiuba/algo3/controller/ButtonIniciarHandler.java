package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.views.JugadoresView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;

public class ButtonIniciarHandler implements EventHandler<ActionEvent>{
    private final Stage STAGE;

    public ButtonIniciarHandler(Stage stage){
        this.STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        JugadoresView jugadoresView = new JugadoresView(STAGE);
        try {
            STAGE.setScene(jugadoresView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
    }
}
