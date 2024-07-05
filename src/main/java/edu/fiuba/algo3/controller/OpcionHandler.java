package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class OpcionHandler implements EventHandler<ActionEvent> {
    private final ArrayList<Opcion> respuestas;
    private final String seleccion;
    private final Button confirmar;

    public OpcionHandler(ArrayList<Opcion> respuestas, String seleccion, Button confirmar) {
        this.respuestas = respuestas;
        this.seleccion = seleccion;
        this.confirmar = confirmar;
    }

    @Override
    public void handle(ActionEvent event) {
        Opcion opcion = new Opcion(seleccion);
        if(respuestas.contains(opcion)){
            respuestas.remove(opcion);
        }else{
            respuestas.add(opcion);
        }
        confirmar.setDisable(respuestas.isEmpty());
    }
}
