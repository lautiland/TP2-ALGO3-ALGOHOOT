package edu.fiuba.algo3.view;

import edu.fiuba.algo3.model.Jugador;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ScoreboardGui extends Application {
    //constantes
    String colorFondoPrimario = "#99b898";
    String colorFondoSecundario = "#2a363b";
    String colorSecundario = "#ff847c";
    int sizeTextoTitulo = 20;
    int AnchoJuego = 800;
    int AltoJuego = 600;
    ArrayList<Jugador> jugadores;

    public static void main(String[] args) {
        launch(args);
    }

    public ScoreboardGui(ArrayList<Jugador> lista_jugadores) {
        jugadores = lista_jugadores;
    }

    public void start(Stage stage) throws Exception {
        //mostrarScoreboard(stage,);
    }

    public void mostrarScoreboard(Stage primaryStage){

        //creacion de Infos de jugadores

        ArrayList<Label> infoJugadores = new ArrayList<>();
        for(Jugador jugador : jugadores){
            Label jugadorActual = new Label(jugador.getNombre() +
                    "  ---->   Puntos:  " + jugador.getPuntos());
            jugadorActual.setStyle(String.format("-fx-background-color: %s ;" +
                    " -fx-text-fill: black; -fx-font-size: %spx ;",colorSecundario,20));
            jugadorActual.setPrefSize(400,70);
            jugadorActual.setTextAlignment(TextAlignment.CENTER);
            infoJugadores.add(jugadorActual);
        }

        Button siguiente = new Button();
        siguiente.setStyle(String.format("-fx-background-color: %s ;" +
                " -fx-text-fill: black; -fx-font-size: %spx ;",colorSecundario,sizeTextoTitulo));
        siguiente.setText("Siguiente Pregunta");
        siguiente.setMinSize(200, 40);
        siguiente.setOnAction(e-> {
            try {
                System.out.println("¡Se ha presionado el botón!");
                //Aquí el continuar con la sig pregunta.
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
        for(int i = 0; i < infoJugadores.size(); i++){
            botonesBox.getChildren().add(infoJugadores.get(i));
        }
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador de botones
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",colorFondoSecundario));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene escena = new Scene(contenedorJuego, AnchoJuego, AltoJuego);

        //stage setting
        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);
        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(escena);
        primaryStage.show();
    }
}
