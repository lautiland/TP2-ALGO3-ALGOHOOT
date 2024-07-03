package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.view.PreguntaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Buttonx2Handler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;

    public Buttonx2Handler(Stage stage, Juego juego){
        this.STAGE = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        PreguntaView preguntaView = new PreguntaView(STAGE, juego);
        juego.activarMultiplicador(2);
        try {
            STAGE.setScene(preguntaView.getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}


