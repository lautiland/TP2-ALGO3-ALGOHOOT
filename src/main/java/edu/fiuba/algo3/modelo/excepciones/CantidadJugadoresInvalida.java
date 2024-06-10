package edu.fiuba.algo3.modelo.excepciones;

public class CantidadJugadoresInvalida extends RuntimeException{
    public CantidadJugadoresInvalida(String mensaje){
        super(mensaje);
    }
}
