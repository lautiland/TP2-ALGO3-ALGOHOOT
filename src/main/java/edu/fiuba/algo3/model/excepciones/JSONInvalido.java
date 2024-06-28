package edu.fiuba.algo3.model.excepciones;

public class JSONInvalido extends RuntimeException{
    public JSONInvalido(String mensaje){
        super(mensaje);
    }
}
