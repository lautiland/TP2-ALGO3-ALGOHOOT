package edu.fiuba.algo3.view;


import edu.fiuba.algo3.controller.*;
import edu.fiuba.algo3.model.Juego;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ModificadoresView extends SceneGui  {

    private final Stage STAGE;
    private final Juego JUEGO;

    public ModificadoresView(Stage stage, Juego juego) {
        STAGE = stage;
        JUEGO = juego;
    }

    @Override
    public Scene getScene(Stage stage) {

        Label elegirModificador = new Label("Que modificador vas a utilizar?");
        configurarSubtitulo(elegirModificador);

        Button x2 = new Button("x2");
        configurarBoton(x2);
        cambiarAncho(x2, BTN_WIDTH * 1.25);
        x2.setOnAction(new ButtonMultiplicadorHandler(STAGE, JUEGO, 2));
        if(!JUEGO.puedeUsarMultiplicador(2)){
            x2.setDisable(true);
        }

        Button x3 = new Button("x3");
        configurarBoton(x3);
        cambiarAncho(x3, BTN_WIDTH * 1.25);
        x3.setOnAction(new ButtonMultiplicadorHandler(STAGE, JUEGO, 3));
        if(!JUEGO.puedeUsarMultiplicador(3)){
            x3.setDisable(true);
        }

        Button exclusividad = new Button("Exclusividad");
        configurarBoton(exclusividad);
        exclusividad.setOnAction(new ButtonExclusividadHandler(STAGE, JUEGO));
        if(!JUEGO.puedeUsarExclusividad()){
            exclusividad.setDisable(true);
        }

        Button anulador = new Button("Anulador");
        configurarBoton(anulador);
        anulador.setOnAction(new ButtonAnuladorHandler(STAGE, JUEGO));
        if(!JUEGO.puedeUsarAnulador()){
            anulador.setDisable(true);
        }

        Button ninguno = new Button("Ninguno");
        configurarBoton(ninguno);
        ninguno.setOnAction(new ButtonNingunoHandler(STAGE, JUEGO));
        ninguno.setTranslateY(20);

        HBox multiplicadores = new HBox();
        multiplicadores.getChildren().addAll(x2,x3);
        multiplicadores.setAlignment(Pos.CENTER);
        x2.setTranslateX(-10);
        x3.setTranslateX(10);

        VBox contenido = new VBox();
        contenido.getChildren().addAll(elegirModificador,multiplicadores, exclusividad,anulador,ninguno);
        return configurarEscena(contenido);
    }
}
