package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonIniciarHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaInicial extends SceneGui {

    Stage stage;


    public PantallaInicial(Stage stage_actual) {
        stage = stage_actual;
    }

    public Scene getScene() {

        //creacion de Botones
        Label bienvenida = new Label("AlgoHoot");
        bienvenida.setStyle(String.format("-fx-background-color: %s; -fx-text-fill: black; -fx-font-size: %spx ;", COLOR_PRIMARIO, 50));
        bienvenida.setPrefSize(600,200);
        bienvenida.setAlignment(Pos.CENTER);

        Button iniciarJuego = new Button("Comenzar Juego");
        configurarBoton(iniciarJuego);
        iniciarJuego.setOnAction(new ButtonIniciarHandler(stage));

        Button salir = new Button("Salir");
        configurarBoton(salir);
        salir.setOnAction(e-> {
            try {
                stage.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(bienvenida, iniciarJuego,salir);
        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);

    }
}
