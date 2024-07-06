package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonAgregarJugadorHandler;
import edu.fiuba.algo3.controller.ButtonIniciarPartidaHandler;
import edu.fiuba.algo3.model.Jugador;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class AgregarJugadoresView extends SceneGui {

    public final Stage STAGE;
    private final int LIMITE_PREGUNTAS;
    private final int LIMITE_PUNTOS;

    public AgregarJugadoresView(Stage stage, int limitePreguntas, int limitePuntos) {
        STAGE = stage;
        LIMITE_PREGUNTAS = limitePreguntas;
        LIMITE_PUNTOS = limitePuntos;
    }

    public Scene getScene() {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        Label accionLabel = new Label("Ingresar el nombre de los jugadores:");
        configurarSubtitulo(accionLabel);

        TextField inputJugador = new TextField();
        configurarTextField(inputJugador, "Nombre");

        Label jugadoresAgregados = new Label("Jugadores Agregados:");
        configurarSubtitulo(jugadoresAgregados);
        jugadoresAgregados.setTranslateY(10);

        Label listadoJugadores = new Label();
        listadoJugadores.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;",COLOR_FONDO_SECUNDARIO,11));
        listadoJugadores.setMaxSize(300,400);
        listadoJugadores.setPadding(new Insets(0,0,0,20));

        Button iniciarPartida = new Button("Iniciar Partida");
        configurarBoton(iniciarPartida);
        iniciarPartida.setOnAction(new ButtonIniciarPartidaHandler(STAGE, jugadores, ARCHIVO_PREGUNTAS, LIMITE_PREGUNTAS, LIMITE_PUNTOS));
        iniciarPartida.setDisable(true);

        Button agregarJugador = new Button("Agregar");
        configurarBoton(agregarJugador);
        agregarJugador.setOnAction(new ButtonAgregarJugadorHandler(jugadores, listadoJugadores, inputJugador, iniciarPartida));

        VBox contenido = new VBox();
        contenido.getChildren().addAll(accionLabel, inputJugador, agregarJugador, jugadoresAgregados, listadoJugadores, iniciarPartida);
        return configurarEscena(contenido);
    }
}
