package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;


public class PreguntaView extends SceneGui {

    static Stage stage;
    private final Juego juego;

    public PreguntaView(Stage stage_actual, Juego juego_actual) {
        stage = stage_actual;
        juego = juego_actual;
    }

    public static void getRootFalseTrueQuestion(VBox root, ArrayList<Opcion> respuestas, Button confirmar) {

        Button trueBtn = new Button("Verdadero");
        configurarBoton(trueBtn);
        Button falseBtn = new Button("Falso");
        configurarBoton(falseBtn);

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

//    public void getRootOrdererChoiceQuestion(Pane root) {
//        //TODO: adaptar ordered
//        Button option1 = new Button("Option 1");
//        option1.setLayoutX(450);
//        option1.setLayoutY(450);
//        configurarBoton(option1);
//
//        Button option2 = new Button("Option 2");
//        option2.setLayoutX(350);
//        option2.setLayoutY(300);
//        configurarBoton(option2);
//
//        root.getChildren().addAll(option1, option2);
//    }

    public void getRootGroupChoiceQuestion(Pregunta pregunta, VBox root, ArrayList<Opcion> respuestas, Button confirmar) {
        HBox opcionesBoxH = new HBox();
        VBox opcionesBoxV = new VBox();
        int cantidadDeOpcionesTotales = pregunta.obtenerOpciones().size();
        ArrayList<Opcion> respuestas2 = new ArrayList<>();

        HBox hBoxTitulos = new HBox();

        VBox vBoxGrupo1Text = new VBox();
        //TODO: agregar titulos de los grupos
        Label grupo1Text = new Label("Grupo 1");
        grupo1Text.setStyle("-fx-font-size: 12px;");
        vBoxGrupo1Text.getChildren().add(grupo1Text);
        vBoxGrupo1Text.setPadding(new Insets(0, 10, 0, 10));

        VBox vBoxGrupo2Text = new VBox();
        Label grupo2Text = new Label("Grupo 2");
        grupo1Text.setStyle("-fx-font-size: 12px;");
        vBoxGrupo2Text.getChildren().add(grupo2Text);
        vBoxGrupo2Text.setPadding(new Insets(0, 10, 0, 10));


        hBoxTitulos.getChildren().addAll(vBoxGrupo1Text, vBoxGrupo2Text);
        hBoxTitulos.setAlignment(Pos.CENTER_RIGHT);
        hBoxTitulos.setPadding(new Insets(2, 2, 2, 2));
        opcionesBoxV.getChildren().add(hBoxTitulos);

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();
        for(Opcion opcion : opciones){
            HBox hBox = new HBox();

            Label labelOpcion = new Label(opcion.getTexto());
            labelOpcion.setStyle("-fx-font-size: 12px;");
            labelOpcion.setPadding(new Insets(0, 10, 0, 10));

            VBox vBoxGrupo1 = new VBox();
            Button grupo1 = new Button();
            configurarBoton(grupo1);
            grupo1.setPrefSize(BTN_HEIGHT, BTN_HEIGHT);
            grupo1.setMinSize(BTN_HEIGHT, BTN_HEIGHT);
            vBoxGrupo1.getChildren().add(grupo1);
            vBoxGrupo1.setPadding(new Insets(0, 10, 0, 10));

            VBox vBoxGrupo2 = new VBox();
            Button grupo2 = new Button();
            configurarBoton(grupo2);
            grupo2.setPrefSize(BTN_HEIGHT, BTN_HEIGHT);
            grupo2.setMinSize(BTN_HEIGHT, BTN_HEIGHT);
            vBoxGrupo2.getChildren().add(grupo2);
            vBoxGrupo2.setPadding(new Insets(0, 10, 0, 10));

            grupo1.setOnAction(new ButtonGroup1ChoiceHandler(grupo1, grupo2, opcion, respuestas, cantidadDeOpcionesTotales, respuestas2, confirmar));
            grupo2.setOnAction(new ButtonGroup2ChoiceHandler(grupo2, grupo1, opcion, respuestas, cantidadDeOpcionesTotales, respuestas2, confirmar));

            hBox.getChildren().addAll(labelOpcion, vBoxGrupo1, vBoxGrupo2);
            hBox.setAlignment(Pos.CENTER_RIGHT);
            hBox.setPadding(new Insets(2, 2, 2, 2));
            opcionesBoxV.getChildren().add(hBox);
        }
        opcionesBoxV.maxWidth(WINDOW_WIDTH*0.75);
        opcionesBoxH.getChildren().add(opcionesBoxV);
        opcionesBoxH.setAlignment(Pos.CENTER);

        root.getChildren().add(opcionesBoxH);
    }

    public Scene getScene() {
        Pregunta preguntaActual = juego.obtenerPreguntaActual();

        Label pregunta = new Label(preguntaActual.getEnunciado());
        pregunta.setWrapText(true);
        pregunta.setMaxWidth(WINDOW_WIDTH*0.75);
        pregunta.setStyle("-fx-font-size: 24px;");

        Label labelTipoDePregunta = new Label(preguntaActual.getTipoDePregunta());
        labelTipoDePregunta.setStyle("-fx-font-size: 12px;");

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
        //TODO: agregar tipo de preguntas faltantes
        if(tipoDePregunta.equalsIgnoreCase("multiple choice clasico") || tipoDePregunta.equalsIgnoreCase("multiple choice parcial") || tipoDePregunta.equalsIgnoreCase("multiple choice con penalidad")){
            getRootMultipleChoiceQuestion(preguntaActual, opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("true false clasico") || tipoDePregunta.equalsIgnoreCase("true false con penalidad")) {
            getRootFalseTrueQuestion(opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("group choice")) {
            getRootGroupChoiceQuestion(preguntaActual, opcionesBox, respuestas, confirmar);
        }

        opcionesBox.getChildren().add(confirmar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, opcionesBox);

        return new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}

