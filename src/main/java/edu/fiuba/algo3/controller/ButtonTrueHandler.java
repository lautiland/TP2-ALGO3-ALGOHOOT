package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class ButtonTrueHandler implements EventHandler<ActionEvent>{
    private final ArrayList<Opcion> RESPUESTAS;
    private final Button CONFIRMAR;
    private final Button TRUE_BTN;
    private final Button FALSE_BTN;

    public ButtonTrueHandler(Button trueBtn, Button falseBtn, ArrayList<Opcion> respuestas, Button confirmar){
        this.RESPUESTAS = respuestas;
        this.CONFIRMAR = confirmar;
        this.TRUE_BTN = trueBtn;
        this.FALSE_BTN = falseBtn;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RESPUESTAS.clear();
        RESPUESTAS.add(new Opcion(TRUE_BTN.getText()));
        TRUE_BTN.setDisable(true);
        FALSE_BTN.setDisable(false);
        CONFIRMAR.setDisable(false);
    }
}

