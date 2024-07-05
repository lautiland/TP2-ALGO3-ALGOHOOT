package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonConfirmarHandler;
import edu.fiuba.algo3.controller.ButtonFalseHandler;
import edu.fiuba.algo3.controller.ButtonTrueHandler;
import edu.fiuba.algo3.controller.OpcionHandler;
import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;


public class PreguntaView extends SceneGui {

    private double startX, startY;
    static Stage stage;
    private final Juego juego;

    public PreguntaView(Stage stage_actual, Juego juego_actual) {
        stage = stage_actual;
        juego = juego_actual;
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

    public static void getRootFalseTrueQuestion(VBox root, ArrayList<Opcion> respuestas, Button confirmar) {

        Button falseBtn = new Button("False");
        configurarBoton(falseBtn);
        Button trueBtn = new Button("True");
        configurarBoton(trueBtn);

        falseBtn.setOnAction(new ButtonFalseHandler(trueBtn, falseBtn, respuestas, confirmar));
        trueBtn.setOnAction(new ButtonTrueHandler(trueBtn, falseBtn, respuestas, confirmar));

        root.getChildren().addAll(trueBtn, falseBtn);
        confirmar.setTranslateY(20);
    }

    public void getRootMultipleChoiceQuestion(Pregunta pregunta, VBox root, ArrayList<Opcion> respuestas, Button confirmar) {
        VBox opcionesBox = new VBox();
        opcionesBox.setAlignment(Pos.CENTER);
        opcionesBox.setPadding(new Insets(20,200,20, 200));
        opcionesBox.setSpacing(10);

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();
        for(Opcion opcion : opciones){
            CheckBox checkBox = new CheckBox(opcion.getTexto());
            checkBox.setOnAction(new OpcionHandler(respuestas, opcion.getTexto(), confirmar));
            checkBox.setAlignment(Pos.TOP_LEFT);
            checkBox.setMaxWidth(Double.MAX_VALUE);
            opcionesBox.getChildren().add(checkBox);
        }
        root.getChildren().add(opcionesBox);
    }

    public void getRootOrdererChoiceQuestion(Pane root) {
        //TODO: adaptar ordered
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

//    public void getRootGroupChoiceQuestion(Pane root) {
            //TODO: adaptar group

//        Button falseBtn = new Button("False");
//        configurarBoton(falseBtn);
//        falseBtn.setOnAction(new ButtonFalseHandler());
//
//        Button trueBtn = new Button("True");
//        configurarBoton(trueBtn);
//        trueBtn.setOnAction(new ButtonFalseHandler(stage));
//
//        root.getChildren().addAll(falseBtn, trueBtn);
//        root.getChildren().forEach(this::makeDraggable);
//    }

    public Scene getScene() {
        Pregunta preguntaActual = juego.obtenerPreguntaActual();

        Label pregunta = new Label(preguntaActual.getEnunciado());
        pregunta.setWrapText(true);
        pregunta.setMaxWidth(WINDOW_WIDTH*0.75);
        Label labelTipoDePregunta = new Label(preguntaActual.getTipoDePregunta());
        labelTipoDePregunta.setStyle("-fx-font-size: 12px;");
        pregunta.setStyle("-fx-font-size: 24px;");

        //creación de contenedor fondo
        ArrayList<Opcion> respuestas = new ArrayList<>();
        VBox opcionesBox = new VBox();
        opcionesBox.getChildren().addAll(pregunta, labelTipoDePregunta);
        opcionesBox.setAlignment(Pos.CENTER);
        opcionesBox.setFillWidth(true);

        Button confirmar = new Button("Confirmar");
        configurarBoton(confirmar);
        confirmar.setDisable(true);
        confirmar.setOnAction(new ButtonConfirmarHandler(stage, juego, respuestas));

        String tipoDePregunta = preguntaActual.getTipoDePregunta();
        if(tipoDePregunta.equalsIgnoreCase("multiple choice clasico")){
            getRootMultipleChoiceQuestion(preguntaActual, opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("true false clasico")) {
            getRootFalseTrueQuestion(opcionesBox, respuestas, confirmar);
        }

        opcionesBox.getChildren().add(confirmar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, opcionesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}

