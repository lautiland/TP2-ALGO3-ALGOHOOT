package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;


public class JugarTurnoView  extends SceneGui {

    private final Stage STAGE;
    private final Juego JUEGO;

    public JugarTurnoView(Stage stage, Juego juego) {
        STAGE = stage;
        JUEGO = juego;
    }

    public Scene getScene() {

        Label turnoDelJugador = new Label("Turno del jugador: " + JUEGO.getJugadorActual());
        configurarSubtitulo(turnoDelJugador);

        Label player = new Label("Puntos: " + JUEGO.obtenerPuntaje(JUEGO.getJugadorActual()));
        configurarSubtitulo(player);

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        continuar.setOnAction(new ButtonContinuarHandler(STAGE, new ModificadoresView(STAGE, JUEGO)));

        VBox contenido = new VBox();
        contenido.getChildren().addAll(turnoDelJugador, player, continuar);
        return configurarEscena(contenido);
    }
}
