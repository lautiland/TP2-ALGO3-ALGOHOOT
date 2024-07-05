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
import java.util.HashMap;

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

        Label descripcion = new Label(juego.obtenerPreguntaActual().getDescripcionRespuesta());
        labelScreen.setStyle("-fx-font-size: 30px;");
        descripcion.setWrapText(true);
        descripcion.setMaxWidth(WINDOW_WIDTH*0.75);


        Button siguienteRonda = new Button("Siguiente ronda");
        configurarBoton(siguienteRonda);
        siguienteRonda.setOnAction(new ButtonSiguienteRondaHandler(stage, juego));

        Label modificadoresUsados = new Label("Modificadores usados:\n");
        modificadoresUsados.setStyle("-fx-font-size: 24px;");
        modificadoresUsados.setTranslateY(0);
        modificadoresUsados.setTranslateX(0);

        HashMap<String, Integer> modificadores = juego.getModificadoresUsadosEsteTurno();
        for (String modificador : modificadores.keySet()) {
            int cantidadUsos = modificadores.get(modificador);
            if (cantidadUsos == 0) {
                continue;
            }
            String modificadorString = modificador + ": " + cantidadUsos;
            modificadoresUsados.setText(modificadoresUsados.getText() + "\n" + modificadorString);
        }

        Label points = new Label("");
        points.setStyle("-fx-font-size: 24px;");
        ArrayList<String> nombresJugadores = juego.obtenerNombresJugadores();
        for (String nombreJugador : nombresJugadores) {
            int pointsPlayer = juego.obtenerPuntaje(nombreJugador);
            String pointsString = nombreJugador + ": " + pointsPlayer;
            points.setText(points.getText() + "\n" + pointsString);
        }

        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(labelScreen,descripcion, modificadoresUsados, points, siguienteRonda);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}

