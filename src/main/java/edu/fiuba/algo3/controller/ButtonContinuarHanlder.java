package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.MultiplicadoresView;
import edu.fiuba.algo3.view.SceneGui;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonContinuarHanlder implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final SceneGui scene;

    public ButtonContinuarHanlder(Stage stage, SceneGui scene){
        this.STAGE = stage;
        this.scene = scene;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            STAGE.setScene(scene.getScene(STAGE));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}