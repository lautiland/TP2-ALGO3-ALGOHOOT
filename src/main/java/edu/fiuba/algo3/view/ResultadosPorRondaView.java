package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonSiguienteRondaHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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

        Label descripcion = new Label(juego.obtenerPreguntaActual().getDescripcionRespuesta());
        configurarSubtitulo(descripcion);

        Label modificadoresUsados = getModificadoresUsados();

        Label labelScreen = new Label("Resultados Por Ronda:");
        configurarSubtitulo(labelScreen);
        labelScreen.setTranslateY(20);

        Label listaPuntos = new Label("");
        configurarSubtitulo(listaPuntos);
        ArrayList<String> nombresJugadores = juego.obtenerNombresJugadores();
        for (String nombreJugador : nombresJugadores) {
            int pointsPlayer = juego.obtenerPuntaje(nombreJugador);
            String pointsString = nombreJugador + ": " + pointsPlayer;
            listaPuntos.setText(listaPuntos.getText() + "\n" + pointsString);
        }

        Button siguienteRonda = new Button("Siguiente ronda");
        configurarBoton(siguienteRonda);
        siguienteRonda.setOnAction(new ButtonSiguienteRondaHandler(stage, juego));

        VBox contenido = new VBox();
        contenido.getChildren().addAll(descripcion, modificadoresUsados, labelScreen, listaPuntos, siguienteRonda);
        return configurarEscena(contenido);
    }

    private Label getModificadoresUsados() {
        Label modificadoresUsados = new Label("");
        configurarSubtitulo(modificadoresUsados);
        modificadoresUsados.setTranslateY(20);

        HashMap<String, Integer> modificadores = juego.getModificadoresUsadosEsteTurno();
        for (int usado : modificadores.values()) {
            if (usado > 0) {
                modificadoresUsados.setText("Modificadores usados:");
                break;
            }
        }
        for (String modificador : modificadores.keySet()) {
            int cantidadUsos = modificadores.get(modificador);
            if (cantidadUsos == 0) {
                continue;
            }
            String modificadorString = modificador + ": " + cantidadUsos;
            modificadoresUsados.setText(modificadoresUsados.getText() + "\n" + modificadorString);
        }
        modificadoresUsados.setText(modificadoresUsados.getText() + "\n");
        modificadoresUsados.setAlignment(Pos.CENTER);
        return modificadoresUsados;
    }
}

