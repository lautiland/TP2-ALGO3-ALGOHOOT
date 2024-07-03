package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.controller.ButtonFalseHandler;
import edu.fiuba.algo3.controller.OpcionHandler;
import edu.fiuba.algo3.model.Juego;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.pregunta.Pregunta;
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

    public void getRootMultipleChoiceQuestion(Pregunta pregunta, VBox root, ArrayList<Opcion> respuestas) {
        VBox opcionesBox = new VBox();
        opcionesBox.setAlignment(Pos.CENTER);
        opcionesBox.setPadding(new Insets(20,200,20, 200));
        opcionesBox.setSpacing(10);

        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();
        for(Opcion opcion : opciones){
            CheckBox checkBox = new CheckBox(opcion.getTexto());
            checkBox.setOnAction(new OpcionHandler(respuestas, opcion.getTexto()));
            checkBox.setAlignment(Pos.TOP_LEFT);
            checkBox.setMaxWidth(Double.MAX_VALUE);
            opcionesBox.getChildren().add(checkBox);
        }
        root.getChildren().add(opcionesBox);
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
        Pregunta preguntaActual = juego.obtenerPreguntaActual();

        Label pregunta = new Label(preguntaActual.getEnunciado());
        pregunta.setStyle("-fx-font-size: 24px;");

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);

        //continar.setOnAction(new ButtonContinuarHanlder(stage, new ResultadosPorRondaView(stage)));
        // aca tengo pregunta:
        // if(Pregunta pregunta.getType() ==  TF) getRootflase...
        // if(pregunta == OC) getRootOrdewr...

        //creación de contenedor fondo
        ArrayList<Opcion> respuestas = new ArrayList<>();
        VBox botonesBox = new VBox();
        botonesBox.getChildren().add(pregunta);
        botonesBox.setAlignment(Pos.CENTER);
        botonesBox.setFillWidth(true);

        continuar.setOnAction( e -> {
            for (Opcion opcion : respuestas) {
                System.out.println(opcion.getTexto() + " seleccionada");
            }
        });

        if(preguntaActual.getClass().getSimpleName().equalsIgnoreCase("ClassicMC")){
            getRootMultipleChoiceQuestion(preguntaActual, botonesBox, respuestas);
        }
        // Mas casos...

        botonesBox.getChildren().add(continuar);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, 800,600);
    }
}

