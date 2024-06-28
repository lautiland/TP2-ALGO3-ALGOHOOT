package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ButtonIniciarHandler;
import edu.fiuba.algo3.controller.ButtonSalirHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class PantallaInicial extends SceneGui {

    Stage stage;


    public PantallaInicial(Stage stage_actual) {
        stage = stage_actual;
    }

    public Scene getScene() {

        //creacion de Botones
        Label bienvenida = new Label("Bienvenido a AlgoHoot");
        bienvenida.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorPrimario,40));
        bienvenida.setPrefSize(600,200);
        bienvenida.setTextAlignment(TextAlignment.CENTER);

        Button iniciarJuego = new Button("Comenzar Juego");
        configurarBoton(iniciarJuego);
        iniciarJuego.setOnAction(new ButtonIniciarHandler(stage));

        Button salir = new Button("Salir");
        configurarBoton(salir);
        salir.setOnAction(new ButtonSalirHandler(stage));

        //creación de contenedor fondo de los botones
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",colorFondoPrimario));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de botones
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(bienvenida, iniciarJuego,salir);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador de botones
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",colorFondoSecundario));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene escena = new Scene(contenedorJuego, AnchoJuego, AltoJuego);

        //stage setting
        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);
        return escena;
    }
}
