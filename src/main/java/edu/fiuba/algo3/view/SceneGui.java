package edu.fiuba.algo3.view;

import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

abstract public class SceneGui {

    protected static final String ARCHIVO_PREGUNTAS =  "src/main/resources/preguntas.json";
    protected static final String COLOR_PRIMARIO = "#d6eaf8";
    protected static final String COLOR_FONDO_PRIMARIO = "#d6dbdf";
    protected static final String COLOR_FONDO_SECUNDARIO = "#2e4053";
    protected static final String COLOR_SECUNDARIO = "#a9cce3";
    protected static final String COLOR_TERCIARIO = "#8ABCF0";
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

    protected Scene configurarEscena(VBox contenido) {
        StackPane contenedorVentana = new StackPane();
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_PRIMARIO));
        cambiarAnchoAlto(contenedorJuego, 600, 800);
        contenido.setSpacing(10);
        contenido.setAlignment(Pos.CENTER);
        contenedorVentana.setStyle(String.format("-fx-background-color: %s;", COLOR_FONDO_SECUNDARIO));
        contenedorVentana.getChildren().addAll(contenedorJuego, contenido);
        contenedorVentana.setLayoutX((contenedorVentana.getWidth() - contenedorVentana.getWidth()) / 2);

        return new Scene(contenedorVentana, WINDOW_WIDTH, WINDOW_HEIGHT);
    }

    protected void configurarTextFieldNumerico(TextField textField, String textoEjemplo) {
        configurarTextField(textField, textoEjemplo);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("\\D", ""));
            }else if (newValue.equals("0")) {
                textField.setText("");
            }
        });
    }

    protected void cambiarAncho(Region elemento, double ancho){
        elemento.setMinWidth(ancho);
        elemento.setPrefWidth(ancho);
        elemento.setMaxWidth(ancho);
    }

    protected void cambiarAlto(Region elemento, double alto){
        elemento.setMinHeight(alto);
        elemento.setPrefHeight(alto);
        elemento.setMaxHeight(alto);
    }

    protected void cambiarAnchoAlto(Region elemento, double ancho, double alto){
        cambiarAncho(elemento, ancho);
        cambiarAlto(elemento, alto);
    }

    protected void configurarTextField(TextField textField, String textoEjemplo) {
        textField.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_PRIMARIO, TITULO_SIZE));
        textField.setMaxWidth(450);
        textField.setPromptText(textoEjemplo);
    }

    protected void configurarSubtitulo(Label subtitulo){
        subtitulo.setStyle(String.format("-fx-font-size: %spx; -fx-text-fill: black;", TITULO_SIZE));
        subtitulo.setAlignment(Pos.TOP_CENTER);
        subtitulo.setTranslateY(-20);
        subtitulo.setWrapText(true);
        subtitulo.setMaxWidth(WINDOW_WIDTH*0.70);
    }

    protected void configurarTitulo(Label bienvenida) {
        bienvenida.setStyle(String.format("-fx-font-size: %spx; -fx-text-fill: black;", TITULO_SIZE * 2));
        bienvenida.setAlignment(Pos.TOP_CENTER);
        bienvenida.setTranslateY(-20);
    }

}
