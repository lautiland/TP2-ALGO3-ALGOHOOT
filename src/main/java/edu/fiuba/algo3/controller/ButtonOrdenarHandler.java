package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ButtonOrdenarHandler implements EventHandler<ActionEvent> {
    private final TextField TEXT_FIELD;
    private final ArrayList<Opcion> RESPUESTAS;
    private final ArrayList<Opcion> OPCIONES;
    private final Button CONFIRMAR;
    private final Button VALIDAR;

    public ButtonOrdenarHandler(TextField textField,ArrayList<Opcion> opciones, ArrayList<Opcion> respuestas, Button confirmar, Button validar){
        this.TEXT_FIELD = textField;
        this.RESPUESTAS = respuestas;
        this.OPCIONES = opciones;
        this.CONFIRMAR = confirmar;
        this.VALIDAR = validar;
    }

    @Override
    public void handle(ActionEvent event) {
        boolean validez = true;
        String texto = TEXT_FIELD.getText();
        texto = texto.replaceAll(" ", "");
        String[] seleccionadas = texto.split(",");
        for(String opcion : seleccionadas){
            if (!opcion.matches("[0-9]+")) {
                validez = false;
                break;
            }
            if (Integer.parseInt(opcion) > OPCIONES.size() || Integer.parseInt(opcion) < 1) {
                validez = false;
                break;
            }
        }
        if(seleccionadas.length == OPCIONES.size() && validez){
            for(String opcion : seleccionadas){
                RESPUESTAS.add(OPCIONES.get(Integer.parseInt(opcion) - 1));
            }
            CONFIRMAR.setDisable(false);
            VALIDAR.setDisable(true);
            TEXT_FIELD.setDisable(true);
        }
    }
}
