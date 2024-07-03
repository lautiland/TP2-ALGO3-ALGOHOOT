package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class OpcionHandler implements EventHandler<ActionEvent> {
    private final ArrayList<Opcion> respuestas;
    private final String seleccion;

    public OpcionHandler(ArrayList<Opcion> respuestas, String seleccion) {
        this.respuestas = respuestas;
        this.seleccion = seleccion;
    }

    @Override
    public void handle(ActionEvent event) {
        Opcion opcion = new Opcion(seleccion);
        if(respuestas.contains(opcion)){
            respuestas.remove(opcion);
        }else{
            respuestas.add(opcion);
        }
    }
}
