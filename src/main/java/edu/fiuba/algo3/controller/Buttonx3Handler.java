package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.view.PreguntaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Buttonx3Handler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;

    public Buttonx3Handler(Stage stage, Juego juego){
        this.STAGE = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        PreguntaView preguntaView = new PreguntaView(STAGE, juego);
        juego.activarMultiplicador(3);
        try {
            STAGE.setScene(preguntaView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}



