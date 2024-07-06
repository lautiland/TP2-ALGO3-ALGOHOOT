package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.view.PreguntaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonMultiplicadorHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego JUEGO;
    private final int MULTIPLICADOR;

    public ButtonMultiplicadorHandler(Stage stage, Juego juego, int multiplicador){
        STAGE = stage;
        JUEGO = juego;
        MULTIPLICADOR = multiplicador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        JUEGO.activarMultiplicador(MULTIPLICADOR);

        try {
            STAGE.setScene(new PreguntaView(STAGE, JUEGO).getScene());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}


