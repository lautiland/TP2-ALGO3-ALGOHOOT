package edu.fiuba.algo3;

import edu.fiuba.algo3.view.PantallaInicialView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import edu.fiuba.algo3.view.SceneGui;

import java.util.Objects;


public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        configurarVentana(stage);
        PantallaInicialView inicio = new PantallaInicialView(stage);

        stage.setScene(inicio.getScene(stage));
        stage.show();
    }

    private void configurarVentana(Stage stage) {
        stage.setTitle("Algohoot");
        Image icon = new Image(Objects.requireNonNull(getClass().getResource("/icono.png")).toExternalForm());
        stage.getIcons().add(icon);
        float width = 800;
        float height = 600;
        SceneGui.setDimensions(width, height);
        stage.setResizable(false);
    }
}
