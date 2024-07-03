package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.controller.ButtonFalseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;


public class PreguntaView extends SceneGui {

    private double startX, startY;
    static Stage stage;
    public PreguntaView(Stage stage_actual) {
        stage = stage_actual;
    }

    private void makeDraggable(Node node){
        node.setOnMousePressed(e -> {
            startX = e.getSceneX()-node.getTranslateX();
            startY = e.getSceneY()-node.getTranslateY();
        });

        node.setOnMouseDragged(e->{
            node.setTranslateX(e.getSceneX()-startX);
            node.setTranslateY(e.getSceneY()-startY);
        });
    }

    public static void getRootFalseTrueQuestion(Pane root) {

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

    public static void getRootMultipleChoiceQuestion(Pane root) {

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

    public void getRootOrdererChoiceQuestion(Pane root) {

        Button option1 = new Button("Option 1");
        option1.setLayoutX(450);
        option1.setLayoutY(450);
        configurarBoton(option1);

        Button option2 = new Button("Option 2");
        option2.setLayoutX(350);
        option2.setLayoutY(300);
        configurarBoton(option2);

        root.getChildren().addAll(option1, option2);
        root.getChildren().forEach(this::makeDraggable);
    }

    public void getRootGroupChoiceQuestion(Pane root) {
        Button falseBtn = new Button("False");
        configurarBoton(falseBtn);
        falseBtn.setOnAction(new ButtonFalseHandler(stage));

        Button trueBtn = new Button("True");
        configurarBoton(trueBtn);
        trueBtn.setOnAction(new ButtonFalseHandler(stage));

        root.getChildren().addAll(falseBtn, trueBtn);
        root.getChildren().forEach(this::makeDraggable);
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

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        //continar.setOnAction(new ButtonContinuarHanlder(stage, new ResultadosPorRondaView(stage)));
        // aca tengo pregunta:
        // if(Pregunta pregunta.getType() ==  TF) getRootflase...
        // if(pregunta == OC) getRootOrdewr...

        Pane root = new Pane();
        //getRootFalseTrueQuestion(root);
        getRootOrdererChoiceQuestion(root);
        root.setPadding(new Insets(20));
        //root.setAlignment(Pos.TOP_LEFT);
        root.getChildren().addAll(labelScreen, pregunta);

        //creación de contenedor fondo de los botones
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(labelScreen, pregunta, root);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador de botones
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_SECUNDARIO));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene scene = new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
        return scene;
    }
}

