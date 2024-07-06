package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonLimitesHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LimitesView extends SceneGui {

    public final Stage STAGE;

    public LimitesView(Stage stage) {
        STAGE = stage;
    }

    public Scene getScene() {

        Label limitesLabel = new Label("Ingresa los limites:");
        configurarSubtitulo(limitesLabel);

        TextField inputLimitePreguntas = new TextField();
        configurarTextFieldNumerico(inputLimitePreguntas, "Limite de Preguntas");

        TextField inputLimitePuntos = new TextField();
        configurarTextFieldNumerico(inputLimitePuntos, "Limite de Puntos");

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        continuar.setOnAction(new ButtonLimitesHandler(STAGE, inputLimitePreguntas, inputLimitePuntos));
        continuar.setTranslateY(10);

        HBox contenedorLimites = new HBox();
        contenedorLimites.getChildren().addAll(inputLimitePreguntas,inputLimitePuntos);
        contenedorLimites.setAlignment(Pos.CENTER);
        contenedorLimites.setSpacing(10);

        VBox contenido = new VBox();
        contenido.getChildren().addAll(limitesLabel,contenedorLimites, continuar);
        return configurarEscena(contenido);
    }
}
