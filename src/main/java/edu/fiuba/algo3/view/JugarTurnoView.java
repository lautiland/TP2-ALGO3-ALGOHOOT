package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.model.Jugador;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;


public class JugarTurnoView  extends SceneGui {

    Stage stage;
    Jugador jugador;

    public JugarTurnoView(Stage stage_actual,Jugador jugador_actual) {
        stage = stage_actual;
        jugador = jugador_actual;
    }

    public Scene getScene() {
        Label labelScreen = new Label("Turno del jugador: ");
        Label player = new Label(jugador.getNombre());

        labelScreen.setTranslateY(200);
        labelScreen.setTranslateX(200);

        player.setTranslateY(200);
        player.setTranslateX(450);

        Button buttonContinuar = new Button("Siguiente turno");
        configurarBoton(buttonContinuar);
        buttonContinuar.setOnAction(new ButtonContinuarHanlder(stage, new MultiplicadoresView(stage)));

        player.setStyle("-fx-font-size: 24px;");
        labelScreen.setStyle("-fx-font-size: 24px;");
        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(player, labelScreen, buttonContinuar);

        return new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
