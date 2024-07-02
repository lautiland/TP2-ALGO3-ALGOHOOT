package edu.fiuba.algo3.model.excepciones;

public class CantidadJugadoresInvalido extends RuntimeException{
    public CantidadJugadoresInvalido(String mensaje){
        super(mensaje);
    }
}
