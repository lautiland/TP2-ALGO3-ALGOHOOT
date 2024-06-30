package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.controller.ButtonFalseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;


public class PreguntaView extends SceneGui {

    static Stage stage;
    public PreguntaView(Stage stage_actual) {
        stage = stage_actual;
    }

    public static void getRootFalseTrueQuestion(StackPane root) {

        Button falseBtn = new Button("False");
        configurarBoton(falseBtn);
        falseBtn.setOnAction(new ButtonFalseHandler(stage));

        Button trueBtn = new Button("True");
        configurarBoton(falseBtn);
        trueBtn.setOnAction(new ButtonFalseHandler(stage));

        falseBtn.setTranslateY(300);
        falseBtn.setTranslateX(200);

        trueBtn.setTranslateY(300);
        trueBtn.setTranslateX(500);

        root.getChildren().addAll(falseBtn, trueBtn);
    }

    public static void getRootMultipleChoiceQuestion(StackPane root) {

        CheckBox opcion1 = new CheckBox("Opcion 1");
        CheckBox opcion2 = new CheckBox("Opcion 2");
        CheckBox opcion3 = new CheckBox("Opcion 3");

        opcion1.setTranslateY(200);
        opcion1.setTranslateX(50);
        opcion1.setStyle("-fx-font-size: 18px;");

        opcion2.setTranslateY(250);
        opcion2.setTranslateX(50);
        opcion2.setStyle("-fx-font-size: 18px;");

        opcion3.setTranslateY(300);
        opcion3.setTranslateX(50);
        opcion3.setStyle("-fx-font-size: 18px;");

        root.getChildren().addAll(opcion1, opcion2, opcion3);
    }

    public static void getRootOrdererChoiceQuestion(StackPane root) {

        Button option1 = new Button("Option 1");
        option1.setLayoutX(450);
        option1.setLayoutY(450);
        configurarBoton(option1);

        Button option2 = new Button("Option 2");
        option2.setLayoutX(350);
        option2.setLayoutY(300);
        configurarBoton(option2);

        root.getChildren().addAll(option1, option2);
    }

    public static void getRootGroupChoiceQuestion(StackPane root) {
        Button falseBtn = new Button("False");
        configurarBoton(falseBtn);
        falseBtn.setOnAction(new ButtonFalseHandler(stage));

        Button trueBtn = new Button("True");
        configurarBoton(trueBtn);
        trueBtn.setOnAction(new ButtonFalseHandler(stage));

        root.getChildren().addAll(falseBtn, trueBtn);
    }

    public Scene getScene() {

        Label labelScreen = new Label("Pregunta:");
        labelScreen.setTranslateY(50);
        labelScreen.setTranslateX(50);
        labelScreen.setStyle("-fx-font-size: 36px;");

        Label pregunta = new Label("Esta es una pregunta de prueba");
        pregunta.setTranslateY(150);
        pregunta.setTranslateX(50);
        pregunta.setStyle("-fx-font-size: 24px;");

        StackPane root = new StackPane();
        getRootFalseTrueQuestion(root);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(labelScreen, pregunta);

        Scene scene = new Scene(root, AnchoJuego, AltoJuego);
        return scene;
    }
}

