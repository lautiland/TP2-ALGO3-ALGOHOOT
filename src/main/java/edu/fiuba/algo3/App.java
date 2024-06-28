package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.views.PantallaInicial;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.fiuba.algo3.views.SceneGui;


public class App extends Application {

    //private MediaPlayer mediaPlayer;   //para que el recolector de basura no lo borre y se siga reproduciendo


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        configurarVentana(stage);
        PantallaInicial inicio = new PantallaInicial(stage);

        stage.setScene(inicio.getScene());
        stage.show();
    }

    private void configurarVentana(Stage stage) {
        stage.setTitle("AlgoRoma");

        float width = 800;
        float height = 600;
        SceneGui.setDimensions(width, height);
        //stage.setMaximized(true);
        stage.setResizable(false);
        //reproducirSonido();
    }
}
