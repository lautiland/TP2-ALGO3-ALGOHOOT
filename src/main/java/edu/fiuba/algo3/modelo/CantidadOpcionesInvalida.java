package edu.fiuba.algo3.modelo;

public class CantidadOpcionesInvalida extends RuntimeException{
    public CantidadOpcionesInvalida(String mensaje){
        super((mensaje));
    }
}
