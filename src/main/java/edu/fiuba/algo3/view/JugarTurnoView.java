package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.model.Juego;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;


public class JugarTurnoView  extends SceneGui {

    Stage stage;
    Juego juego;

    public JugarTurnoView(Stage stage_actual,Juego juego) {
        stage = stage_actual;
        this.juego = juego;
    }

    public Scene getScene() {
        Label labelScreen = new Label("Turno del jugador: ");
        Label player = new Label(juego.getJugadorActual());

        labelScreen.setTranslateY(200);
        labelScreen.setTranslateX(200);

        player.setTranslateY(200);
        player.setTranslateX(450);

        Button buttonContinuar = new Button("Continuar");
        configurarBoton(buttonContinuar);
        buttonContinuar.setOnAction(new ButtonContinuarHanlder(stage, new MultiplicadoresView(stage, juego.obtenerPreguntaActual())));

        player.setStyle("-fx-font-size: 24px;");
        labelScreen.setStyle("-fx-font-size: 24px;");
        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(player, labelScreen, buttonContinuar);

        return new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
