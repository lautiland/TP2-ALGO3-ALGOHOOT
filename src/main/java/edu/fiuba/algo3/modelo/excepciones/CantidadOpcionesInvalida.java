package edu.fiuba.algo3.modelo.excepciones;

public class CantidadOpcionesInvalida extends RuntimeException{
    public CantidadOpcionesInvalida(String mensaje){
        super((mensaje));
    }
}
