package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class ButtonTrueHandler implements EventHandler<ActionEvent>{
    private final Stage STAGE;

    public ButtonTrueHandler(Stage stage){
        this.STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            //STAGE.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
