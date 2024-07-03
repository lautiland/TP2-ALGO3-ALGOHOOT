package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonContinuarHanlder;
import edu.fiuba.algo3.controller.ButtonFalseHandler;
import edu.fiuba.algo3.model.Jugador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class ResultadosView extends SceneGui {

    static Stage stage;
    ArrayList<Jugador> jugadores;
    public ResultadosView(Stage stage_actual, ArrayList<Jugador> jugadores) {
        stage = stage_actual;
        this.jugadores = jugadores;
    }
    public Scene getScene() {

        Label labelScreen = new Label("Resultados");
        labelScreen.setTranslateY(-200);
        labelScreen.setTranslateX(0);
        labelScreen.setStyle("-fx-font-size: 36px;");

        Button continuar = new Button("Continuar");
        configurarBoton(continuar);
        continuar.setOnAction(new ButtonContinuarHanlder(stage,new PantallaInicial(stage)));

        Label points = new Label("");
        points.setTranslateY(0);
        points.setTranslateX(0);
        points.setStyle("-fx-font-size: 24px;");
        for (Jugador jugador : jugadores) {
            int pointsPlayer = jugador.getPuntos();
            String pointsString = jugador.getNombre()+ ": " + String.valueOf(pointsPlayer);
            points.setText(points.getText() + "\n" + pointsString);
        }
        //creación de contenedor fondo de los botones
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_PRIMARIO));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(labelScreen,points);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador de botones
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",COLOR_FONDO_SECUNDARIO));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene scene = new Scene(contenedorJuego, WINDOW_WIDTH, WINDOW_HEIGHT);
        return scene;
    }
}

