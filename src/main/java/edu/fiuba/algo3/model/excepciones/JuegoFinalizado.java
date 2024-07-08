package edu.fiuba.algo3.model.excepciones;

public class JuegoFinalizado extends RuntimeException{
    public JuegoFinalizado(){
        super("El juego ya ha finalizado");
    }
}
