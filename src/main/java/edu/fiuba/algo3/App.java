package edu.fiuba.algo3;

import edu.fiuba.algo3.view.PantallaInicial;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import edu.fiuba.algo3.view.SceneGui;

import java.util.Objects;


public class App extends Application {

    //private MediaPlayer mediaPlayer;   //para que el recolector de basura no lo borre y se siga reproduciendo


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        //TODO: agregar musica

        configurarVentana(stage);
        PantallaInicial inicio = new PantallaInicial(stage);

        stage.setScene(inicio.getScene());
        stage.show();
    }

    private void configurarVentana(Stage stage) {
        stage.setTitle("Algohoot");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/icono.png")).toExternalForm());
        stage.getIcons().add(icon);
        float width = 800;
        float height = 600;
        SceneGui.setDimensions(width, height);
        //stage.setMaximized(true);
        stage.setResizable(false);
        //reproducirSonido();
    }
}
