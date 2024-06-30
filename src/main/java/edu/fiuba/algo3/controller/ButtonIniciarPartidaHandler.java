package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.view.JugarTurnoView;
import edu.fiuba.algo3.view.ResultadosPorRondaView;
import edu.fiuba.algo3.view.ResultadosView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonIniciarPartidaHandler implements EventHandler<ActionEvent>{
    private final Stage STAGE;
    ArrayList<Jugador> jugadores;

    public ButtonIniciarPartidaHandler(Stage stage, ArrayList<Jugador> jugadores_actual){
        this.STAGE = stage;
        jugadores = jugadores_actual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        boolean final_de_ronda = false;
        Juego juego = new Juego(jugadores);
        for (Jugador jugador : jugadores){
            JugarTurnoView jugadorView = new JugarTurnoView(STAGE, jugador);
            try {
                STAGE.setScene(jugadorView.getScene());
            } catch (Exception ex) {
                throw new RuntimeException(ex);

            }
        }
        ResultadosView resultados_ronda = new ResultadosView(STAGE, jugadores);
        STAGE.setScene(resultados_ronda.getScene());
    }
}
