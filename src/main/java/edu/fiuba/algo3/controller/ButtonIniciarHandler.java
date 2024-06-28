package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.AddJugadoresView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

public class ButtonIniciarHandler implements EventHandler<ActionEvent>{
    private final Stage STAGE;

    public ButtonIniciarHandler(Stage stage){
        this.STAGE = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        AddJugadoresView jugadoresView = new AddJugadoresView(STAGE);
        try {
            STAGE.setScene(jugadoresView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);

        }
    }
}
