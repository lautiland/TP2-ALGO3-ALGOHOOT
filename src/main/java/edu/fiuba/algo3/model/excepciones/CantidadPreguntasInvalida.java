package edu.fiuba.algo3.model.excepciones;

public class CantidadPreguntasInvalida extends RuntimeException{
    public CantidadPreguntasInvalida(String mensaje){
        super(mensaje);
    }
}
