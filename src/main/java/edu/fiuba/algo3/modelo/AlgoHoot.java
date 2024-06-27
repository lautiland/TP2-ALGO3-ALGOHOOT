package edu.fiuba.algo3.modelo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import java.util.ArrayList;


public class AlgoHoot extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    //constantes
    String colorPrimario = "#fecea8";
    String colorFondoPrimario = "#99b898";
    String colorFondoSecundario = "#2a363b";
    String colorSecundario = "#ff847c";
    String colorTerciario = "#e84a5f";
    int sizeTextoTitulo = 20;
    int AnchoJuego = 800;
    int AltoJuego = 600;
    Font customFont = Font.loadFont(getClass().getResourceAsStream("modelo/Virgil.ttf"), 12);
    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Button salir = new Button("Salir");
        Button comenzar = new Button("Comenzar");
        Label bienvenida = new Label("Bienvenido al Algo Hoot");
        Label realizadoPor = new Label("Realizado Por");
        Label integrante1 = new Label("XXXX");
        Label integrante2 = new Label("XXXX");
        Label integrante3 = new Label("XXXX");
        Label integrante4 = new Label("XXXX");
        Label integrante5 = new Label("XXXX");




        bienvenida.setTranslateX(0);
        bienvenida.setTranslateY(-200);
        realizadoPor.setTranslateX(-250);
        realizadoPor.setTranslateY(-100);

        integrante1.setTranslateX(0);
        integrante1.setTranslateY(-70);
        integrante2.setTranslateX(0);
        integrante2.setTranslateY(-40);
        integrante3.setTranslateX(0);
        integrante3.setTranslateY(-10);
        integrante4.setTranslateX(0);
        integrante4.setTranslateY(20);
        integrante5.setTranslateX(0);
        integrante5.setTranslateY(50);

        comenzar.setTranslateX(400-100);
        comenzar.setTranslateY(300-100);
        salir.setTranslateX(-400+100);
        salir.setTranslateY(300-100);


        bienvenida.setStyle("-fx-font-size: 24px;");
        realizadoPor.setStyle("-fx-font-size: 18px;");
        integrante1.setStyle("-fx-font-size: 18px;");
        integrante2.setStyle("-fx-font-size: 18px;");
        integrante3.setStyle("-fx-font-size: 18px;");
        integrante4.setStyle("-fx-font-size: 18px;");
        integrante5.setStyle("-fx-font-size: 18px;");



        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(comenzar,salir,bienvenida,realizadoPor,integrante1,integrante2,integrante3,integrante4,integrante5);
        Scene escena = new Scene(contenedor, 800, 600);


        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(escena);
        primaryStage.show();
    }*/

    /*public void start(Stage primaryStage) {
        TextField nameInput = new TextField();
        nameInput.setPromptText("Ingresa el nombre del jugador");
        Button addButton = new Button("Agregar Jugador");
        Label accionLabel = new Label("Ingresa el nombre del jugador:");
        Label playersList = new Label("Jugadores Agregados:");
        Label addPlayer = new Label("");

        accionLabel.setTranslateY(100);
        accionLabel.setTranslateX(10);
        nameInput.setMaxHeight(30);
        nameInput.setMaxWidth(300);
        nameInput.setTranslateX(200);
        nameInput.setTranslateY(100);
        addButton.setTranslateX(550);
        addButton.setTranslateY(100);
        playersList.setTranslateY(200);
        playersList.setTranslateX(100);
        addPlayer.setTranslateY(250);
        addPlayer.setTranslateX(200);
        addButton.setOnAction(e -> {
            String playerName = nameInput.getText();
            if (!playerName.isEmpty()) {
                addPlayer.setText(addPlayer.getText() + "\n" + playerName);
                nameInput.clear();
            }
        });

        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(accionLabel,addPlayer,nameInput, addButton, playersList);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    /*public void start(Stage primaryStage) {
        Button buttonContinuar = new Button("Continuar");
        Label labelScreen = new Label("Turno del jugador: ");
        Label player = new Label("Jugador X");

        labelScreen.setTranslateY(200);
        labelScreen.setTranslateX(200);

        player.setTranslateY(200);
        player.setTranslateX(450);

        buttonContinuar.setTranslateY(350);
        buttonContinuar.setTranslateX(350);


        player.setStyle("-fx-font-size: 24px;");
        labelScreen.setStyle("-fx-font-size: 24px;");
        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(player, labelScreen, buttonContinuar);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    /*
    public void start(Stage primaryStage) {

        Button x2 = new Button("x2");
        Button x3 = new Button("x3");
        Button exclusividad = new Button("Exclusividad");
        Button anulador = new Button("Anulador");
        Button ninguno = new Button("Ninguno");

        Label labelScreen = new Label("Que modificador vas a utilizar?");

        labelScreen.setTranslateY(100);
        labelScreen.setTranslateX(200);
        labelScreen.setStyle("-fx-font-size: 32px;");

        x2.setTranslateY(300);
        x2.setTranslateX(200);

        x3.setTranslateY(300);
        x3.setTranslateX(500);

        exclusividad.setTranslateY(400);
        exclusividad.setTranslateX(200);

        anulador.setTranslateY(400);
        anulador.setTranslateX(500);

        ninguno.setTranslateY(500);
        ninguno.setTranslateX(350);

        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        root.getChildren().addAll(anulador, ninguno, x2, x3, exclusividad,labelScreen);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    /*
    public void start(Stage primaryStage) {

        Label labelScreen = new Label("Pregunta:");
        Label pregunta = new Label("Esta es una pregunta de prueba");

        Button falseBtn = new Button("False");
        Button trueBtn = new Button("True");

        CheckBox opcion1 = new CheckBox("Opcion 1");
        CheckBox opcion2 = new CheckBox("Opcion 2");
        CheckBox opcion3 = new CheckBox("Opcion 3");

        ObservableList<CheckBox> opciones = FXCollections.observableArrayList(
                new CheckBox("Opción 1"),
                new CheckBox("Opción 2"),
                new CheckBox("Opción 3")
        );

        ListView<CheckBox> listView = new ListView<>(opciones);
        listView.setCellFactory(CheckBoxListCell.forListView(checkBox -> checkBox.selectedProperty()));


        // Eventos para el arrastre y la caída
        listView.setOnDragDetected(event -> {
            CheckBox draggedItem = listView.getSelectionModel().getSelectedItem();
            if (draggedItem != null) {
                Dragboard dragboard = listView.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();
                content.putString(draggedItem.getText());
                dragboard.setContent(content);
            }
        });

        listView.setOnDragOver(event -> {
            if (event.getGestureSource() != listView && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        listView.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                String text = dragboard.getString();
                CheckBox targetItem = new CheckBox(text);
                listView.getItems().add(targetItem);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        listView.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                String text = dragboard.getString();
                CheckBox targetItem = new CheckBox(text);
                listView.getItems().add(targetItem);
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });


        opcion1.setTranslateY(200);
        opcion1.setTranslateX(50);
        opcion1.setStyle("-fx-font-size: 18px;");

        opcion2.setTranslateY(250);
        opcion2.setTranslateX(50);
        opcion2.setStyle("-fx-font-size: 18px;");

        opcion3.setTranslateY(300);
        opcion3.setTranslateX(50);
        opcion3.setStyle("-fx-font-size: 18px;");

        labelScreen.setTranslateY(50);
        labelScreen.setTranslateX(50);
        labelScreen.setStyle("-fx-font-size: 36px;");


        pregunta.setTranslateY(150);
        pregunta.setTranslateX(50);
        pregunta.setStyle("-fx-font-size: 24px;");

        falseBtn.setTranslateY(300);
        falseBtn.setTranslateX(200);

        trueBtn.setTranslateY(300);
        trueBtn.setTranslateX(500);

        StackPane  root = new StackPane();
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_LEFT);

        //root.getChildren().addAll(labelScreen,falseBtn,trueBtn,pregunta);
        //root.getChildren().addAll(labelScreen,pregunta,opcion1,opcion2,opcion3);
        root.getChildren().addAll(labelScreen, pregunta, listView);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/

    //a partir de aquí test franco/dani

    public void iniciarPartida(String Jugadores){

    }

    public void iniciarPantallaInicial(Stage primaryStage) throws Exception {

        //creacion de Botones
        Label bienvenida = new Label("Bienvenido a AlgoHoot");
        bienvenida.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black; -fx-font-size: %spx ;",colorPrimario,40));
        bienvenida.setPrefSize(600,200);
        bienvenida.setTextAlignment(TextAlignment.CENTER);

        Button iniciarJuego = new Button();
        iniciarJuego.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorSecundario,sizeTextoTitulo));
        iniciarJuego.setText("Iniciar Juego");
        iniciarJuego.setMinSize(400, 50);
        iniciarJuego.setOnAction(e-> {
            try {
                iniciarPantallaDeConsultaJugadores(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Button creditos = new Button();
        creditos.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorSecundario,sizeTextoTitulo));
        creditos.setText("Créditos");
        creditos.setMinSize(400, 50);
        creditos.setOnAction(e-> {
            try {
                iniciarPantallaDeCreditos(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        Button salir = new Button();
        salir.setStyle(String.format("-fx-background-color: %s ;" +
                " -fx-text-fill: black; -fx-font-size: %spx ;",colorSecundario,sizeTextoTitulo));
        salir.setText("Salir");
        salir.setMinSize(200, 40);
        salir.setOnAction(e-> {
            try {
                primaryStage.close();
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
        botonesBox.getChildren().addAll(bienvenida,iniciarJuego,creditos,salir);
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

    public void iniciarPantallaDeConsultaJugadores(Stage primaryStage) throws Exception {

        //Creacion de botones pantalla principal

        TextField preguntaJugadores = new TextField();
        preguntaJugadores.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorPrimario,sizeTextoTitulo));
        preguntaJugadores.setPromptText("Mi nombre");
        preguntaJugadores.setMaxWidth(450);

        Button addButton = new Button("Agregar Jugador");
        addButton.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorSecundario,15));
        addButton.setMaxSize(120,60);

        Label accionLabel = new Label("Ingresa el nombre del jugador:");
        accionLabel.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorPrimario,15));
        accionLabel.setPrefSize(320,60);


        Label playersList = new Label("Jugadores Agregados:");
        playersList.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorTerciario,15));
        playersList.setMaxSize(200,70);

        Label addPlayer = new Label("");
        addPlayer.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: white;" +
                " -fx-font-size: %spx ;",colorFondoSecundario,11));
        addPlayer.setMaxSize(300,500);
        addButton.setOnAction(e -> {
            String playerName = preguntaJugadores.getText();
            if (!playerName.isEmpty()) {
                addPlayer.setText(addPlayer.getText() + "\n" + playerName);
                preguntaJugadores.clear();
            }
        });

        Button iniciarPartida = new Button();
        iniciarPartida.setStyle(String.format("-fx-background-color: %s ; -fx-text-fill: black;" +
                " -fx-font-size: %spx ;",colorPrimario,sizeTextoTitulo));
        iniciarPartida.setText("Iniciar Partida");
        iniciarPartida.setMinSize(300, 50);
        iniciarPartida.setOnAction(e-> {
            try {
                iniciarPartida(addButton.getText());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });


        //creación de contenedor fondo

        StackPane contenedorBotones = new StackPane();
        contenedorBotones.setStyle(String.format("-fx-background-color: %s;",colorFondoPrimario));
        contenedorBotones.setMinSize(600,800);
        contenedorBotones.setMaxSize(700,900);

        //creacion contenedor de items
        VBox botonesBox = new VBox();
        botonesBox.setSpacing(10);
        botonesBox.getChildren().addAll(accionLabel,preguntaJugadores, addButton, playersList, addPlayer);
        botonesBox.setAlignment(Pos.CENTER);

        //Contenedor del juego que tiene al organizador
        StackPane contenedorJuego = new StackPane();
        contenedorJuego.setStyle(String.format("-fx-background-color: %s;",colorFondoSecundario));
        contenedorJuego.getChildren().addAll(contenedorBotones, botonesBox);
        Scene escena = new Scene(contenedorJuego, AnchoJuego, AltoJuego);

        contenedorJuego.setLayoutX((contenedorJuego.getWidth() - contenedorJuego.getWidth()) / 2);

        primaryStage.setTitle("Algo Hoot");
        primaryStage.setScene(escena);
        primaryStage.show();
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
                iniciarPantallaInicial(primaryStage);
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



    @Override
    public void start(Stage stage) throws Exception {
        iniciarPantallaInicial(stage);
    }
}
