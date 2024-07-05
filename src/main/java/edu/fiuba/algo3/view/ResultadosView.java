package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class ResultadosView extends SceneGui {

    private final Stage stage;
    private final Juego juego;
    public ResultadosView(Stage stage_actual, Juego juego) {
        stage = stage_actual;
        this.juego = juego;
    }
    public Scene getScene() {

        Label labelScreen = new Label("Resultados");
        labelScreen.setStyle("-fx-font-size: 36px;");

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        continuar.setOnAction(new ButtonContinuarHandler(stage,new PantallaInicialView(stage)));

        Label points = new Label("");
        points.setStyle("-fx-font-size: 24px;");

        //.
        ArrayList<String> nombresJugadores = juego.obtenerNombresJugadores();
        for (String nombreJugador : nombresJugadores) {
            int pointsPlayer = juego.obtenerPuntaje(nombreJugador);
            String pointsString = nombreJugador + ": " + pointsPlayer;
            points.setText(points.getText() + "\n" + pointsString);
        }

        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(labelScreen, points, continuar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}

