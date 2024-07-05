package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonAddJugadorHandler;
import edu.fiuba.algo3.controller.ButtonIniciarPartidaHandler;
import edu.fiuba.algo3.model.Jugador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddJugadoresView extends SceneGui {

    public Stage STAGE;
    private final int limitePreguntas;
    private final int limitePuntos;

    public AddJugadoresView(Stage stage, int limitePreguntas, int limitePuntos) {
        STAGE = stage;
        this.limitePreguntas = limitePreguntas;
        this.limitePuntos = limitePuntos;
    }

    public Scene getScene() {

        //Creacion de botones pantalla principal
        ArrayList<Jugador> jugadores = new ArrayList<>();

        TextField preguntaJugadores = new TextField();

        preguntaJugadores.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO, TITULO_SIZE));
        preguntaJugadores.setPromptText("Nombre del Jugador");
        preguntaJugadores.setMaxWidth(450);

        Label accionLabel = new Label("Ingresa el nombre del jugador:");
        accionLabel.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",COLOR_PRIMARIO,15));
        accionLabel.setPrefSize(320,60);

        Label addPlayer = new Label();
        addPlayer.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;",COLOR_FONDO_SECUNDARIO,11));
        addPlayer.setMaxSize(300,500);

        Button iniciarPartida = new Button("Iniciar Partida");
        configurarBoton(iniciarPartida);
        iniciarPartida.setOnAction(new ButtonIniciarPartidaHandler(STAGE,jugadores, limitePreguntas, limitePuntos));
        iniciarPartida.setDisable(true);

        Button addButton = new Button("Agregar Jugador");
        configurarBoton(addButton);
        addButton.setOnAction(new ButtonAddJugadorHandler(jugadores,addPlayer,preguntaJugadores, iniciarPartida));

        Label playersList = new Label("Jugadores Agregados:");
        playersList.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",COLOR_TERCIARIO,15));
        playersList.setMaxSize(200,70);

        //creación de contenedor fondo
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(accionLabel, preguntaJugadores, playersList, addPlayer, addButton, iniciarPartida);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
