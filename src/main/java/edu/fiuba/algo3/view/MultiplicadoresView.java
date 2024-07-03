package edu.fiuba.algo3.view;


import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;
import edu.fiuba.algo3.model.modificador.Multiplicador;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

public class MultiplicadoresView extends SceneGui  {
    Stage STAGE;
    Pregunta pregunta;

    public MultiplicadoresView(Stage stage, Pregunta pregunta) {
        STAGE = stage;
        this.pregunta = pregunta;
    }
    @Override
    public Scene getScene(Stage stage) {

        Label labelScreen = new Label("Que modificador vas a utilizar?");

        Button x2 = new Button("x2");
        configurarBoton(x2);
        x2.setOnAction(new Buttonx2Handler(STAGE));
        if(!pregunta.esCompatibleCon(new Multiplicador(2))){
            x2.setDisable(true);
        }

        Button x3 = new Button("x3");
        configurarBoton(x3);
        x3.setOnAction(new Buttonx3Handler(STAGE));
        if(!pregunta.esCompatibleCon(new Multiplicador(3))){
            x3.setDisable(true);
        }

        Button exclusividad = new Button("Exclusividad");
        configurarBoton(exclusividad);
        exclusividad.setOnAction(new ButtonExclusividadHandler(STAGE));
        if(!pregunta.esCompatibleCon(new Exclusividad())){
            exclusividad.setDisable(true);
        }


        Button anulador = new Button("Anulador");
        configurarBoton(anulador);
        anulador.setOnAction(new ButtonAnuladorHandler(STAGE));
        if(!pregunta.esCompatibleCon(new Anulador())){
            anulador.setDisable(true);
        }

        Button ninguno = new Button("Ninguno");
        configurarBoton(ninguno);
        ninguno.setOnAction(new ButtonNingunoHandler(STAGE));

        labelScreen.setTranslateY(100);
        labelScreen.setTranslateX(200);
        labelScreen.setStyle("-fx-font-size: 32px;");

        x2.setTranslateY(300);
        x2.setTranslateX(200);

        x3.setTranslateY(300);
        x3.setTranslateX(500);

        exclusividad.setTranslateY(400);
        exclusividad.setTranslateX(200);

        anulador.setTranslateY(400);
        anulador.setTranslateX(500);

        ninguno.setTranslateY(500);
        ninguno.setTranslateX(350);

        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(anulador, ninguno, x2, x3, exclusividad,labelScreen);

        return new Scene(root, 800, 600);
    }
}
