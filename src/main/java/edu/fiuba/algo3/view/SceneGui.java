package edu.fiuba.algo3.view;

import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

abstract public class SceneGui {

    //TODO: cambiar colores
    protected static final String COLOR_PRIMARIO = "#fecea8";
    protected static final String COLOR_FONDO_PRIMARIO = "#99b898";
    protected static final String COLOR_FONDO_SECUNDARIO = "#2a363b";
    protected static final String COLOR_SECUNDARIO = "#ff847c";
    protected static final String COLOR_TERCIARIO = "#e84a5f";
    protected static final int TITULO_SIZE = 20;
    protected static final int BTN_WIDTH = 150;
    protected static final int BTN_HEIGHT = 30;
    protected static float WINDOW_WIDTH;
    protected static float WINDOW_HEIGHT;

    public static void setDimensions(float ancho, float alto){
        WINDOW_WIDTH = ancho;
        WINDOW_HEIGHT = alto;
    }

    public Scene getScene(Stage stage){
        return new Scene( new StackPane(), WINDOW_WIDTH, WINDOW_HEIGHT);
    }
    protected static void configurarBoton(Button boton){

        boton.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        boton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_SECUNDARIO, TITULO_SIZE));
        boton.setOnMouseEntered(e -> boton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;" +
                " -fx-border-color: black;" +
                "-fx-border-width: 2px;" +
                "-fx-border-style: solid;", COLOR_TERCIARIO, TITULO_SIZE)));
        boton.setOnMouseExited(e -> boton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;" +
                "-fx-border-width: 0;", COLOR_SECUNDARIO, TITULO_SIZE)));

        boton.setMinSize(400, 50);
    }

    protected void configurarBackground(StackPane contenedorJuego, VBox botonesBox) {
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);


        botonesBox.setSpacing(10);
        botonesBox.setAlignment(Pos.CENTER);

        contenedorJuego.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_SECUNDARIO));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);

        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);
    }
}
