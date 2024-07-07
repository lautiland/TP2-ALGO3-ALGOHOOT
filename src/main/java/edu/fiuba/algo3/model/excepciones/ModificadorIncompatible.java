package edu.fiuba.algo3.model.excepciones;

public class ModificadorIncompatible extends RuntimeException{
    public ModificadorIncompatible(){
        super("No se puede usar el modificador en esta pregunta");
    }
}
