package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.view.JugarTurnoView;
import edu.fiuba.algo3.view.ResultadosPorRondaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ButtonConfirmarHandler implements EventHandler<ActionEvent> {
    private final Stage STAGE;
    private final Juego juego;
    private final ArrayList<Opcion> respuestas;

    public ButtonConfirmarHandler(Stage stage, Juego juego, ArrayList<Opcion> respuestas){
        this.STAGE = stage;
        this.juego = juego;
        this.respuestas = respuestas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.responder(respuestas);
        if (juego.sinJugadoresRestantes()){
            juego.evaluarRespuestas();
            ResultadosPorRondaView resultadosPorRondaView = new ResultadosPorRondaView(STAGE, juego);
            try {
                STAGE.setScene(resultadosPorRondaView.getScene());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }else{
            JugarTurnoView jugadorView = new JugarTurnoView(STAGE, juego);
            try {
                STAGE.setScene(jugadorView.getScene());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
