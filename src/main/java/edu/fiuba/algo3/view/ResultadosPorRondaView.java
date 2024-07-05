package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonSiguienteRondaHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.geometry.Pos;


import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class ResultadosPorRondaView extends SceneGui {

    private final Stage stage;
    private final Juego juego;

    public ResultadosPorRondaView(Stage stage_actual, Juego juego) {
        this.stage = stage_actual;
        this.juego = juego;
    }
    public Scene getScene() {

        Label labelScreen = new Label("Resultados Por Ronda");
        labelScreen.setStyle("-fx-font-size: 36px;");

        //Label descripcion = new Label("Puntajes de la ronda:");


        Button siguienteRonda = new Button("Siguiente ronda");
        configurarBoton(siguienteRonda);
        siguienteRonda.setOnAction(new ButtonSiguienteRondaHandler(stage, juego));

        Label points = new Label("");
        points.setTranslateY(0);
        points.setTranslateX(0);
        points.setStyle("-fx-font-size: 24px;");
        ArrayList<String> nombresJugadores = juego.obtenerNombresJugadores();
        for (String nombreJugador : nombresJugadores) {
            int pointsPlayer = juego.obtenerPuntaje(nombreJugador);
            String pointsString = nombreJugador + ": " + pointsPlayer;
            points.setText(points.getText() + "\n" + pointsString);
        }

        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        //TODO: agregar descripcion
        botonesBox.getChildren().addAll(labelScreen, points, siguienteRonda);
        botonesBox.setAlignment(Pos.CENTER);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}

