package edu.fiuba.algo3.view;


import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.Juego;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.geometry.Insets;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.StackPane;

public class MultiplicadoresView extends SceneGui  {
    Stage STAGE;
    Juego juego;

    public MultiplicadoresView(Stage stage, Juego juego) {
        STAGE = stage;
        this.juego = juego;
    }

    @Override
    public Scene getScene(Stage stage) {
        Label labelScreen = new Label("Que modificador vas a utilizar?");
        labelScreen.setPadding(new Insets(0, 0, 20, 0));

        Button x2 = new Button("x2");
        configurarBoton(x2);
        x2.setOnAction(new Buttonx2Handler(STAGE, juego));
        if(!juego.puedeUsarMultiplicador(2)){
            x2.setDisable(true);
        }

        Button x3 = new Button("x3");
        configurarBoton(x3);
        x3.setOnAction(new Buttonx3Handler(STAGE, juego));
        if(!juego.puedeUsarMultiplicador(3)){
            x3.setDisable(true);
        }

        Button exclusividad = new Button("Exclusividad");
        configurarBoton(exclusividad);
        exclusividad.setOnAction(new ButtonExclusividadHandler(STAGE, juego));
        if(!juego.puedeUsarExclusividad()){
            exclusividad.setDisable(true);
        }


        Button anulador = new Button("Anulador");
        configurarBoton(anulador);
        anulador.setOnAction(new ButtonAnuladorHandler(STAGE, juego));
        if(!juego.puedeUsarAnulador()){
            anulador.setDisable(true);
        }

        Button ninguno = new Button("Ninguno");
        configurarBoton(ninguno);
        ninguno.setOnAction(new ButtonNingunoHandler(STAGE, juego));

        ninguno.setTranslateY(20);

        labelScreen.setStyle("-fx-font-size: 32px;");

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.getChildren().addAll(labelScreen, x2, x3, exclusividad,anulador,ninguno);

        StackPane contenedorJuego = new StackPane();

        configurarBackground(contenedorJuego, botonesBox);

        return new Scene(contenedorJuego, 800, 600);
    }
}
