package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonLimitesHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LimitesView extends SceneGui {

    public Stage STAGE;

    public LimitesView(Stage stage) {
        STAGE = stage;
    }

    public Scene getScene() {

        //Creacion de botones pantalla principal

        HBox contenedorLimites = new HBox();
        contenedorLimites.setAlignment(Pos.CENTER);
        contenedorLimites.setSpacing(10);


        TextField preguntaLimitePreguntas = new TextField();
        TextField preguntaLimitePuntos = new TextField();

        contenedorLimites.getChildren().addAll(preguntaLimitePreguntas,preguntaLimitePuntos);

        Label limitesLabel = new Label("Ingresa los limites:");
        limitesLabel.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",COLOR_PRIMARIO,15));
        limitesLabel.setPrefSize(320,60);

        preguntaLimitePreguntas.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO, TITULO_SIZE));
        preguntaLimitePreguntas.setPromptText("Limite de Preguntas");
        preguntaLimitePreguntas.setMaxWidth(450);

        preguntaLimitePuntos.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO, TITULO_SIZE));
        preguntaLimitePuntos.setPromptText("Limite de Puntos");
        preguntaLimitePuntos.setMaxWidth(450);


        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        continuar.setOnAction(new ButtonLimitesHandler(STAGE, preguntaLimitePreguntas, preguntaLimitePuntos));

        //creación de contenedor fondo
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        preguntaLimitePreguntas.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                preguntaLimitePreguntas.setText(newValue.replaceAll("[^\\d]", ""));
            }else if (newValue.equals("0")) {
                preguntaLimitePreguntas.setText("");
            }
        });

        preguntaLimitePuntos.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                preguntaLimitePuntos.setText(newValue.replaceAll("[^\\d]", ""));
            }else if (newValue.equals("0")) {
                preguntaLimitePuntos.setText("");
            }
        });

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(limitesLabel,contenedorLimites, continuar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
