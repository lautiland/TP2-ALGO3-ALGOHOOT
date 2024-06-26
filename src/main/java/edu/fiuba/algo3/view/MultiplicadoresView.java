package edu.fiuba.algo3.view;


import edu.fiuba.algo3.model.Jugador;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

public class MultiplicadoresView  {
    Jugador jugador;

    public MultiplicadoresView(Jugador jugador_actual) {
        jugador = jugador_actual;
    }

    public void show(Stage stage) {
        Button x2 = new Button("x2");
        Button x3 = new Button("x3");
        Button exclusividad = new Button("Exclusividad");
        Button anulador = new Button("Anulador");
        Button ninguno = new Button("Ninguno");

        Label labelScreen = new Label("Que modificador vas a utilizar?");

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

        Scene scene = new Scene(root, 800, 600);

        stage.setTitle("Algo Hoot");
        stage.setScene(scene);
        stage.show();
    }
}
