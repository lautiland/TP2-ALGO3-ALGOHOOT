package edu.fiuba.algo3.model.excepciones;

public class JugadorNoEncontrado extends RuntimeException{
    public JugadorNoEncontrado(){
        super("El nombre del jugador no está en el juego");
    }
}
