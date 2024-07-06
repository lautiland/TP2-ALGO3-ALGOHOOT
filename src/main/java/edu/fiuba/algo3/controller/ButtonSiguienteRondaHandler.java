package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.view.JugarTurnoView;
import edu.fiuba.algo3.view.ResultadosFinalesView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ButtonSiguienteRondaHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;

    public ButtonSiguienteRondaHandler(Stage stage, Juego juego){
        this.STAGE = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try {
            juego.siguientePregunta();
            JugarTurnoView jugadorView = new JugarTurnoView(STAGE, juego);
            try {
                STAGE.setScene(jugadorView.getScene());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception JuegoFinalizadoError) {
            ResultadosFinalesView finalizarPartidaView = new ResultadosFinalesView(STAGE,juego);
            try {
                STAGE.setScene(finalizarPartidaView.getScene());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
