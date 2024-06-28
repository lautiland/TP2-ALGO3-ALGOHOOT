package edu.fiuba.algo3.model.excepciones;

public class CantidadOpcionesInvalida extends RuntimeException{
    public CantidadOpcionesInvalida(String mensaje){
        super((mensaje));
    }
}
