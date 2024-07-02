package edu.fiuba.algo3.view;

import javafx.scene.control.Button;

abstract public class SceneGui {
    protected static final String COLOR_PRIMARIO = "#fecea8";
    protected static final String COLOR_FONDO_PRIMARIO = "#99b898";
    protected static final String COLOR_FONDO_SECUNDARIO = "#2a363b";
    protected static final String COLOR_SECUNDARIO = "#ff847c";
    protected static final String COLOR_TERCIARIO = "#e84a5f";
    protected static final int TITULO_SIZE = 20;
    private static final int BTN_WIDTH = 150;
    private static final int BTN_HEIGHT = 30;
    protected static float WINDOW_WIDTH;
    protected static float WINDOW_HEIGHT;

    public static void setDimensions(float ancho, float alto){
        WINDOW_WIDTH = ancho;
        WINDOW_HEIGHT = alto;
    }

    protected static void configurarBoton(Button boton){

        boton.setPrefSize(BTN_WIDTH, BTN_HEIGHT);
        boton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;", COLOR_SECUNDARIO, TITULO_SIZE));
        boton.setMinSize(400, 50);
    }
}
