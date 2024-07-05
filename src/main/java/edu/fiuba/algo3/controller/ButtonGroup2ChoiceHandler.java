package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ButtonGroup2ChoiceHandler implements EventHandler<ActionEvent>{

    private final Button GRUPO_ACTUAL;
    private final Button GRUPO_EXCLUYENTE;
    private final ArrayList<Opcion> RESPUESTAS;
    private final Opcion OPCION;
    private final int CANTIDAD_DE_OPCIONES_TOTALES;
    private final ArrayList<Opcion> RESPUESTAS2;
    private final Button CONFIRMAR;

    public ButtonGroup2ChoiceHandler(Button grupoActual,
                                     Button grupoExcluyente,
                                     Opcion opcion,
                                     ArrayList<Opcion> respuestas,
                                     int cantidadDeOpcionesTotales,
                                     ArrayList<Opcion> respuestas2,
                                     Button confirmar){
        this.GRUPO_ACTUAL = grupoActual;
        this.GRUPO_EXCLUYENTE = grupoExcluyente;
        this.RESPUESTAS = respuestas;
        this.OPCION = opcion;
        this.CANTIDAD_DE_OPCIONES_TOTALES = cantidadDeOpcionesTotales;
        this.RESPUESTAS2 = respuestas2;
        this.CONFIRMAR = confirmar;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        GRUPO_ACTUAL.setDisable(true);
        GRUPO_EXCLUYENTE.setDisable(false);
        RESPUESTAS.remove(OPCION);
        RESPUESTAS2.add(OPCION);
        if(RESPUESTAS.size()+RESPUESTAS2.size() == CANTIDAD_DE_OPCIONES_TOTALES){
            CONFIRMAR.setDisable(false);
        }
    }
}
