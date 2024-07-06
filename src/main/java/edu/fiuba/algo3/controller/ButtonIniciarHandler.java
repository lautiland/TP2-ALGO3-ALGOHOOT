package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.LimitesView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class ButtonIniciarHandler implements EventHandler<ActionEvent>{

    private final Stage STAGE;

    public ButtonIniciarHandler(Stage stage){
        STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        LimitesView limitesView = new LimitesView(STAGE);
        try {
            STAGE.setScene(limitesView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
