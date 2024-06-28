package edu.fiuba.algo3.model.excepciones;

public class MultiplicadorInvalido extends RuntimeException {
    public MultiplicadorInvalido() {
        super("El multiplicador no existe.");
    }
}
