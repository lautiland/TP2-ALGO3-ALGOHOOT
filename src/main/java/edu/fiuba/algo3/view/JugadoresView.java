package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonIniciarPartidaHandler;
import edu.fiuba.algo3.model.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JugadoresView extends SceneGui {

    public Stage STAGE;

    public JugadoresView(Stage stage) {
        STAGE = stage;
    }

    public Scene getScene() {

        //Creacion de botones pantalla principal
        ArrayList<Jugador> jugadores = new ArrayList<>();
        TextField preguntaJugadores = new TextField();
        preguntaJugadores.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO, TITULO_SIZE));
        preguntaJugadores.setPromptText("Mi nombre");
        preguntaJugadores.setMaxWidth(450);

        Button addButton = new Button("Agregar Jugador");
        addButton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_SECUNDARIO,15));
        addButton.setMaxSize(120,60);

        Label accionLabel = new Label("Ingresa el nombre del jugador:");
        accionLabel.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO,15));
        accionLabel.setPrefSize(320,60);


        Label playersList = new Label("Jugadores Agregados:");
        playersList.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_TERCIARIO,15));
        playersList.setMaxSize(200,70);

        Label addPlayer = new Label();
        addPlayer.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;", COLOR_FONDO_SECUNDARIO,11));
        addPlayer.setMaxSize(300,500);
        addButton.setOnAction(e -> {
            String playerName = preguntaJugadores.getText();
            if (!playerName.isEmpty()) {

                Jugador jugador = new Jugador(addPlayer.getText());
                jugadores.add(jugador);
                addPlayer.setText(addPlayer.getText() + "\n" + playerName);
                preguntaJugadores.clear();
            }
        });

        Button iniciarPartida = new Button("Iniciar Partida");
        configurarBoton(iniciarPartida);
        iniciarPartida.setOnAction(new ButtonIniciarPartidaHandler(STAGE,jugadores));

        //creación de contenedor fondo

        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(accionLabel,preguntaJugadores, addButton, playersList, addPlayer,iniciarPartida);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_SECUNDARIO));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene escena = new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);

        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);

        return escena;
    }
}
