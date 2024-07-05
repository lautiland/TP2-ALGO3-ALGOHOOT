package edu.fiuba.algo3.model.excepciones;

public class JuegoFinalizadoError extends RuntimeException{
    public JuegoFinalizadoError(){
        super("El juego ya ha finalizado");
    }
}
