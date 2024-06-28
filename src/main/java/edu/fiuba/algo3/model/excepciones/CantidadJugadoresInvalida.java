package edu.fiuba.algo3.model.excepciones;

public class CantidadJugadoresInvalida extends RuntimeException{
    public CantidadJugadoresInvalida(String mensaje){
        super(mensaje);
    }
}
