package edu.fiuba.algo3.modelo.excepciones;

public class MultiplicadorInvalido extends RuntimeException {
    public MultiplicadorInvalido() {
        super("El multiplicador no existe.");
    }
}
