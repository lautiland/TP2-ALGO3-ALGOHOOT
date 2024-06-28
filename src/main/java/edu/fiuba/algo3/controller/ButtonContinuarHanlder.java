package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.MultiplicadoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonContinuarHanlder implements EventHandler<ActionEvent> {
    private final Stage STAGE;

    public ButtonContinuarHanlder(Stage stage){
        this.STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        MultiplicadoresView multiplicadoresView = new MultiplicadoresView(STAGE);
        try {
            STAGE.setScene(multiplicadoresView.getScene(STAGE));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
