package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHandler;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class ResultadosFinalesView extends SceneGui {

    private final Stage stage;
    private final Juego juego;
    public ResultadosFinalesView(Stage stage_actual, Juego juego) {
        stage = stage_actual;
        this.juego = juego;
    }
    public Scene getScene() {

        Label finDelJuego = new Label("Fin del Juego");
        configurarTitulo(finDelJuego);

        Label resultados = new Label("Resultados Finales:");
        configurarSubtitulo(resultados);

        Button volverAlMenu = new Button("Volver al Menu");
        configurarBoton(volverAlMenu);
        volverAlMenu.setOnAction(new ButtonContinuarHandler(stage,new PantallaInicialView(stage)));

        Label listaPuntos = new Label("");
        configurarSubtitulo(listaPuntos);
        ArrayList<String> nombresJugadores = juego.obtenerNombresJugadores();
        for (String nombreJugador : nombresJugadores) {
            int pointsPlayer = juego.obtenerPuntaje(nombreJugador);
            String pointsString = nombreJugador + ": " + pointsPlayer;
            listaPuntos.setText(listaPuntos.getText() + "\n" + pointsString);
        }

        VBox contenido = new VBox();
        contenido.getChildren().addAll(finDelJuego, resultados, listaPuntos, volverAlMenu);
        return configurarEscena(contenido);
    }
}

