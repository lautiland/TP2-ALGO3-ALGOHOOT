package edu.fiuba.algo3.model.excepciones;

public class MultiplicadorNoEncontrado extends RuntimeException {
    public MultiplicadorNoEncontrado() {
        super("El multiplicador no existe.");
    }
}
