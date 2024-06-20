package edu.fiuba.algo3.modelo.excepciones;

public class JSONInvalido extends RuntimeException{
    public JSONInvalido(String mensaje){
        super(mensaje);
    }
}
