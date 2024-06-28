package edu.fiuba.algo3.views;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Credito  extends Application {
    //constantes
    String colorPrimario = "#fecea8";
    String colorFondoPrimario = "#99b898";
    String colorFondoSecundario = "#2a363b";
    String colorSecundario = "#ff847c";
    String colorTerciario = "#e84a5f";
    int sizeTextoTitulo = 20;
    int AnchoJuego = 800;
    int AltoJuego = 600;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        iniciarPantallaDeCreditos(stage);
    }

    public void iniciarPantallaDeCreditos(Stage primaryStage) throws Exception {

        //Creacion de botones pantalla principal

        Label creditosTitle = new Label("El juego fue desarrollado Con cariño por:");
        creditosTitle.setTextAlignment(TextAlignment.CENTER);
        creditosTitle.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorPrimario,30));
        creditosTitle.setPrefSize(600,200);

        Label dev1 = new Label("Daniel Arturo Pérez Contreras.");
        dev1.setTextAlignment(TextAlignment.CENTER);
        dev1.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorTerciario,16));
        dev1.setPrefSize(230,150);

        Label dev2 = new Label("Lautaro Jovanovics");
        dev2.setTextAlignment(TextAlignment.CENTER);
        dev2.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorSecundario,16));
        dev2.setPrefSize(230,150);

        Label dev3 = new Label("Matias Vallejos");
        dev3.setTextAlignment(TextAlignment.CENTER);
        dev3.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorTerciario,16));
        dev3.setPrefSize(230,150);

        Label dev4 = new Label("Alejandro, Pablo Martin");
        dev4.setTextAlignment(TextAlignment.CENTER);
        dev4.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorSecundario,16));
        dev4.setPrefSize(230,150);

        Label dev5 = new Label("Franco Gualdrini");
        dev5.setTextAlignment(TextAlignment.CENTER);
        dev5.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorTerciario,16));
        dev5.setPrefSize(230,150);

        Button menuPrincipal = new Button();
        menuPrincipal.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorPrimario,sizeTextoTitulo));
        menuPrincipal.setText("Volver al Menú Principal");
        menuPrincipal.setMinSize(300, 50);
        menuPrincipal.setOnAction(e-> {
            try {
                //iniciarPantallaInicial(primaryStage); // aca va el observer
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        //creación de contenedor fondo de los botones
        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",colorFondoPrimario));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de botones
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(creditosTitle,dev1,dev2,dev3,dev4,dev5, menuPrincipal);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador de botones
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",colorFondoSecundario));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene escena = new Scene(contenedorJuego, AnchoJuego, AltoJuego);

        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
