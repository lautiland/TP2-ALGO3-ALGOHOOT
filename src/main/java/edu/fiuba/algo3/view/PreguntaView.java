package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.pregunta.GroupChoice;
import edu.fiuba.algo3.model.pregunta.Pregunta;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.ArrayList;

public class PreguntaView extends SceneGui {

    private final Stage STAGE;
    private final Juego JUEGO;

    public PreguntaView(Stage stage, Juego juego) {
        STAGE = stage;
        JUEGO = juego;
    }

    public void cargarOpcionesTrueFalse(VBox opcionesBox, ArrayList<Opcion> respuestas, Button confirmar) {

        Button trueBtn = new Button("Verdadero");
        configurarBoton(trueBtn);
        Button falseBtn = new Button("Falso");
        configurarBoton(falseBtn);

        falseBtn.setOnAction(new ButtonFalseHandler(trueBtn, falseBtn, respuestas, confirmar));
        trueBtn.setOnAction(new ButtonTrueHandler(trueBtn, falseBtn, respuestas, confirmar));

        opcionesBox.getChildren().addAll(trueBtn, falseBtn);
        confirmar.setTranslateY(20);
    }

    public void cargarOpcionesMC(Pregunta pregunta, VBox opcionesBox, ArrayList<Opcion> respuestas, Button confirmar) {
        VBox contenedor = new VBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPadding(new Insets(20,200,20, 200));
        contenedor.setSpacing(10);

        ArrayList<Opcion> opciones = pregunta.getOpciones();
        for(Opcion opcion : opciones){
            HBox hBox = new HBox();
            Label textoCheckBox = new Label(opcion.getTexto());

            CheckBox checkBox = new CheckBox();
            checkBox.setOnAction(new OpcionHandler(respuestas, opcion.getTexto(), confirmar));
            checkBox.setAlignment(Pos.TOP_LEFT);
            checkBox.styleProperty().set("-fx-font-size: 18px; -fx-text-fill: black; -fx-font-weight: bold;");

            hBox.getChildren().addAll(checkBox, textoCheckBox);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);
            contenedor.getChildren().add(hBox);
        }
        opcionesBox.getChildren().add(contenedor);
    }

    public void cargarOpcionesOrderedChoice(Pregunta pregunta, VBox opcionesBox, ArrayList<Opcion> respuestas, Button confirmar) {

        ArrayList<Opcion> opciones = pregunta.getOpciones();

        for(Opcion opcion : opciones){
            HBox hBox = new HBox();
            int numeroDeOpcion = opciones.indexOf(opcion);
            numeroDeOpcion ++;
            Label labelOpcion = new Label(numeroDeOpcion + ". " + opcion.getTexto());
            labelOpcion.setStyle("-fx-font-size: 18px;");

            hBox.getChildren().add(labelOpcion);
            hBox.setAlignment(Pos.CENTER);
            opcionesBox.getChildren().add(hBox);
        }

        HBox cajaOrdenar = new HBox();

        Label labelOrdenar = new Label("Ordenar: ");
        labelOrdenar.setStyle("-fx-font-size: 12px;");
        labelOrdenar.setTranslateX(-10);

        TextField textField = new TextField();
        textField.setPromptText("1, 2, 3, ...");
        textField.setMinSize((double) BTN_WIDTH *0.75, BTN_HEIGHT);
        textField.setPrefSize((double) BTN_WIDTH *0.75, BTN_HEIGHT);

        Button validar = new Button("Validar");
        configurarBoton(validar);
        validar.setMinSize((double) BTN_WIDTH *0.75, BTN_HEIGHT*1.5);
        validar.setPrefSize((double) BTN_WIDTH *0.75, BTN_HEIGHT*1.5);
        validar.setOnAction(new ButtonOrdenarHandler(textField, opciones, respuestas, confirmar, validar));
        validar.setTranslateX(10);

        cajaOrdenar.getChildren().addAll(labelOrdenar, textField, validar);
        cajaOrdenar.setAlignment(Pos.CENTER);

        opcionesBox.getChildren().add(cajaOrdenar);
    }

    public void cargarOpcionesGroupChoice(Pregunta pregunta, VBox opcionesBox, ArrayList<Opcion> respuestas, Button confirmar) {
        HBox opcionesBoxH = new HBox();
        VBox opcionesBoxV = new VBox();
        int cantidadDeOpcionesTotales = pregunta.getOpciones().size();
        ArrayList<Opcion> respuestas2 = new ArrayList<>();
        HBox hBoxTitulos = new HBox();

        Label labelTitulo = new Label(" ");
        labelTitulo.setStyle("-fx-font-size: 12px;");
        labelTitulo.setPadding(new Insets(0, 10, 0, 10));
        labelTitulo.setTranslateX(-100);

        VBox vBoxGrupo1Text = new VBox();
        for (String palabra : ((GroupChoice) pregunta).getDescripcionGrupoA().split(" ")) {
            Label grupo1Text = new Label(palabra);
            grupo1Text.setStyle("-fx-font-size: 12px;");
            grupo1Text.setPrefSize(BTN_HEIGHT*2.25, BTN_HEIGHT);
            grupo1Text.setMinSize(BTN_HEIGHT*2.25, BTN_HEIGHT);
            vBoxGrupo1Text.getChildren().add(grupo1Text);
            vBoxGrupo1Text.setPadding(new Insets(0, 10, 0, 10));
        }
        vBoxGrupo1Text.setTranslateX(-10);

        VBox vBoxGrupo2Text = new VBox();
        for (String palabra : ((GroupChoice) pregunta).getDescripcionGrupoB().split(" ")) {
            Label grupo2Text = new Label(palabra);
            grupo2Text.setStyle("-fx-font-size: 12px;");
            grupo2Text.setPrefSize(BTN_HEIGHT*2.25, BTN_HEIGHT);
            grupo2Text.setMinSize(BTN_HEIGHT*2.25, BTN_HEIGHT);
            vBoxGrupo2Text.getChildren().add(grupo2Text);
            vBoxGrupo2Text.setPadding(new Insets(0, 10, 0, 10));
        }
        vBoxGrupo2Text.setTranslateX(10);


        hBoxTitulos.getChildren().addAll(labelTitulo,vBoxGrupo1Text, vBoxGrupo2Text);
        hBoxTitulos.setAlignment(Pos.CENTER_RIGHT);
        hBoxTitulos.setPadding(new Insets(2, 2, 2, 2));
        opcionesBoxV.getChildren().add(hBoxTitulos);

        ArrayList<Opcion> opciones = pregunta.getOpciones();

        for(Opcion opcion : opciones){
            HBox hBox = new HBox();

            Label labelOpcion = new Label(opcion.getTexto());
            labelOpcion.setStyle("-fx-font-size: 12px;");
            labelOpcion.setPadding(new Insets(0, 10, 0, 10));
            labelOpcion.setTranslateX(-100);

            VBox vBoxGrupo1 = new VBox();
            Button grupo1 = new Button();
            configurarBoton(grupo1);
            grupo1.setPrefSize(BTN_HEIGHT, BTN_HEIGHT);
            grupo1.setMinSize(BTN_HEIGHT, BTN_HEIGHT);
            grupo1.setTranslateX(-50);
            vBoxGrupo1.getChildren().add(grupo1);
            vBoxGrupo1.setPadding(new Insets(0, 10, 0, 10));


            VBox vBoxGrupo2 = new VBox();
            Button grupo2 = new Button();
            configurarBoton(grupo2);
            grupo2.setPrefSize(BTN_HEIGHT, BTN_HEIGHT);
            grupo2.setMinSize(BTN_HEIGHT, BTN_HEIGHT);
            vBoxGrupo2.getChildren().add(grupo2);
            vBoxGrupo2.setPadding(new Insets(0, 10, 0, 10));
            vBoxGrupo2.setTranslateX(10);

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

        opcionesBox.getChildren().add(opcionesBoxH);
    }

    public Scene getScene() {
        ArrayList<Opcion> respuestas = new ArrayList<>();
        Pregunta preguntaActual = JUEGO.obtenerPreguntaActual();

        Label tipoDePregunta = new Label("Pregunta " + preguntaActual.getTipoDePregunta() + ": categoría " + preguntaActual.getCategoria());
        tipoDePregunta.setStyle(String.format("-fx-font-size: %spx; -fx-text-fill: grey;", TITULO_SIZE/2));
        tipoDePregunta.setAlignment(Pos.TOP_LEFT);
        tipoDePregunta.setTranslateY(-20);

        Label pregunta = new Label(preguntaActual.getEnunciado());
        configurarSubtitulo(pregunta);

        Button confirmar = new Button("Confirmar");
        configurarBoton(confirmar);
        confirmar.setDisable(true);
        confirmar.setOnAction(new ButtonConfirmarHandler(STAGE, JUEGO, respuestas));

        VBox contenido = new VBox();
        contenido.getChildren().addAll(tipoDePregunta, pregunta);
        contenido.setAlignment(Pos.CENTER);
        contenido.setFillWidth(true);
        cargarOpciones(preguntaActual, contenido, respuestas, confirmar);
        contenido.getChildren().add(confirmar);

        return configurarEscena(contenido);
    }

    private void cargarOpciones(Pregunta pregunta, VBox opcionesBox, ArrayList<Opcion> respuestas, Button confirmar){
        String tipoDePregunta = pregunta.getTipoDePregunta();

        if(tipoDePregunta.equalsIgnoreCase("multiple choice clasico") || tipoDePregunta.equalsIgnoreCase("multiple choice parcial") || tipoDePregunta.equalsIgnoreCase("multiple choice con penalidad")){
            cargarOpcionesMC(pregunta, opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("true false clasico") || tipoDePregunta.equalsIgnoreCase("true false con penalidad")) {
            cargarOpcionesTrueFalse(opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("group choice")) {
            cargarOpcionesGroupChoice(pregunta, opcionesBox, respuestas, confirmar);
        } else if (tipoDePregunta.equalsIgnoreCase("ordered choice")) {
            cargarOpcionesOrderedChoice(pregunta, opcionesBox, respuestas, confirmar);
        }
    }
}

