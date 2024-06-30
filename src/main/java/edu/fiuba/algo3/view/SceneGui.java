package edu.fiuba.algo3.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

abstract public class SceneGui {
    protected static final String colorPrimario = "#fecea8";
    protected static final String colorFondoPrimario = "#99b898";
    protected static final String colorFondoSecundario = "#2a363b";
    protected static final String colorSecundario = "#ff847c";
    protected static final String colorTerciario = "#e84a5f";
    protected static final int sizeTextoTitulo = 20;
    private static final int BTN_WIDTH = 150;
    private static final int BTN_HEIGHT = 30;
    protected static float AnchoJuego;
    protected static float AltoJuego;

    public static void setDimensions(float ancho, float alto){
        AnchoJuego=ancho;
        AltoJuego=alto;
    }

    public Scene getScene(Stage stage){
        return new Scene( new StackPane(), AnchoJuego, AltoJuego);
    }
    protected static void configurarBoton(Button boton){

        boton.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        boton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorSecundario,sizeTextoTitulo));
        boton.setMinSize(400, 50);
    }
}
