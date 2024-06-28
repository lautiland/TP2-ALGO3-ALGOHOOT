package edu.fiuba.algo3;

import edu.fiuba.algo3.view.PantallaInicial;
import javafx.application.Application;
import javafx.stage.Stage;
import edu.fiuba.algo3.view.SceneGui;


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
        stage.setTitle("Algo Hoot");

        float width = 800;
        float height = 600;
        SceneGui.setDimensions(width, height);
        //stage.setMaximized(true);
        stage.setResizable(false);
        //reproducirSonido();
    }
}
