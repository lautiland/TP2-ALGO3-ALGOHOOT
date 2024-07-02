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
        preguntaJugadores.setPromptText("Nombre del Jugador");
        preguntaJugadores.setMaxWidth(450);

        Button addButton = new Button("Agregar");
        configurarBoton(addButton);

        Label accionLabel = new Label("Ingresar el nombre de los jugadores");
        accionLabel.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO,15));
        accionLabel.setPrefSize(320,60);
        accionLabel.setAlignment(Pos.CENTER);


        Label playersList = new Label("Jugadores actuales");
        playersList.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;", COLOR_FONDO_SECUNDARIO,15));
        playersList.setMaxSize(300,70);

        Label addPlayer = new Label();
        addPlayer.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;", COLOR_FONDO_SECUNDARIO,11));
        addPlayer.setMaxSize(300,500);
        addButton.setOnAction(e -> {
            String playerName = preguntaJugadores.getText();
            if (!playerName.isEmpty()) {

                Jugador jugador = new Jugador(addPlayer.getText());
                jugadores.add(jugador);
                if (addPlayer.getText().isEmpty()) {
                    addPlayer.setText(playerName);
                } else {
                    addPlayer.setText(addPlayer.getText() + "\n" + playerName);
                }
                preguntaJugadores.clear();
            }
        });

        Button iniciarPartida = new Button("Iniciar Partida");
        configurarBoton(iniciarPartida);
        iniciarPartida.setOnAction(new ButtonIniciarPartidaHandler(STAGE,jugadores));

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(accionLabel, preguntaJugadores, playersList, addPlayer, addButton, iniciarPartida);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
