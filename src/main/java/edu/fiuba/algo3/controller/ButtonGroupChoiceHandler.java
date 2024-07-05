package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonGroupChoiceHandler implements EventHandler<ActionEvent>{

    private final Button GRUPO_ACTUAL;
    private final Button GRUPO_EXCLUYENTE;
    private final ArrayList<Opcion> RESPUESTAS;

    public ButtonGroupChoiceHandler(Button grupoActual, Button grupoExcluyente, ArrayList<Opcion> respuestas){
        this.GRUPO_ACTUAL = grupoActual;
        this.GRUPO_EXCLUYENTE = grupoExcluyente;
        this.RESPUESTAS = respuestas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        GRUPO_ACTUAL.setDisable(true);
        GRUPO_EXCLUYENTE.setDisable(false);

    }
}
