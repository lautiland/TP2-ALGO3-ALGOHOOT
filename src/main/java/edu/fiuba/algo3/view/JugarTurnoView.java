package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
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
        Label labelScreen = new Label("Turno del jugador: " + juego.getJugadorActual());
        Label player = new Label("Puntos: " + juego.obtenerPuntaje(juego.getJugadorActual()));

        Button buttonContinuar = new Button("Continuar");
        configurarBoton(buttonContinuar);
        buttonContinuar.setOnAction(new ButtonContinuarHandler(stage, new MultiplicadoresView(stage, juego)));

        player.setStyle("-fx-font-size: 24px;");
        labelScreen.setStyle("-fx-font-size: 24px;");
        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(player, labelScreen, buttonContinuar);

        //creación de contenedor fondo
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(labelScreen, player, buttonContinuar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);


        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
