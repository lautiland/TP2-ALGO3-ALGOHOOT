package edu.fiuba.algo3.model.excepciones;

public class NombreJugadorInvalido extends RuntimeException{
    public NombreJugadorInvalido(){
        super("El nombre del jugador no está en el juego");
    }
}
