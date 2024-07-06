package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonIniciarHandler;
import edu.fiuba.algo3.controller.ButtonSalirHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaInicialView extends SceneGui {

    private final Stage STAGE;

    public PantallaInicialView(Stage stage) {
        STAGE = stage;
    }

    public Scene getScene(Stage stageSinUso) {

        Label bienvenida = new Label("AlgoHoot");
        configurarTitulo(bienvenida);

        Button iniciarJuego = new Button("Iniciar Juego");
        configurarBoton(iniciarJuego);
        iniciarJuego.setOnAction(new ButtonIniciarHandler(STAGE));

        Button salir = new Button("Salir");
        configurarBoton(salir);
        salir.setOnAction(new ButtonSalirHandler(STAGE));

        VBox contenido = new VBox();
        contenido.getChildren().addAll(bienvenida, iniciarJuego, salir);
        return configurarEscena(contenido);

    }
}
