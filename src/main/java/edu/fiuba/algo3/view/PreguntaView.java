package edu.fiuba.algo3.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;


public class PreguntaView extends SceneGui {

    Stage stage;
    public PreguntaView(Stage stage_actual) {
        stage = stage_actual;
    }

    public Scene getScene() {

        Label labelScreen = new Label("Pregunta:");
        Label pregunta = new Label("Esta es una pregunta de prueba");



        // hay que ver el tema de que preguntas es:


        // Pregunta Verdadero y falso:
        Button falseBtn = new Button("False");
        Button trueBtn = new Button("True");

        // Multiple choice:
        CheckBox opcion1 = new CheckBox("Opcion 1");
        CheckBox opcion2 = new CheckBox("Opcion 2");
        CheckBox opcion3 = new CheckBox("Opcion 3");


        // Aca seria el tema de order choice, aca hay que hacer la logica
        // de ver que pregunta esta seleccionado para poder moverlo con la
        // flechas:
        ObservableList<CheckBox> opciones = FXCollections.observableArrayList(
                new CheckBox("Opción 1"),
                new CheckBox("Opción 2"),
                new CheckBox("Opción 3")
        );

        opcion1.setTranslateY(200);
        opcion1.setTranslateX(50);
        opcion1.setStyle("-fx-font-size: 18px;");

        opcion2.setTranslateY(250);
        opcion2.setTranslateX(50);
        opcion2.setStyle("-fx-font-size: 18px;");

        opcion3.setTranslateY(300);
        opcion3.setTranslateX(50);
        opcion3.setStyle("-fx-font-size: 18px;");

        labelScreen.setTranslateY(50);
        labelScreen.setTranslateX(50);
        labelScreen.setStyle("-fx-font-size: 36px;");


        pregunta.setTranslateY(150);
        pregunta.setTranslateX(50);
        pregunta.setStyle("-fx-font-size: 24px;");

        falseBtn.setTranslateY(300);
        falseBtn.setTranslateX(200);

        trueBtn.setTranslateY(300);
        trueBtn.setTranslateX(500);

        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        //root.getChildren().addAll(labelScreen,falseBtn,trueBtn,pregunta);
        //root.getChildren().addAll(labelScreen,pregunta,opcion1,opcion2,opcion3);
        root.getChildren().addAll(labelScreen, pregunta, listView);

        Scene scene = new Scene(root, 800, 600);
        return scene;
    }
}
