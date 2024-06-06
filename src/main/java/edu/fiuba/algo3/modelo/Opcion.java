package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Opcion {
    private final String texto;
    private final boolean esCorrecta;
    private final int orden;

    public Opcion(String texto, boolean esCorrecta, int orden){
        this.texto = texto;
        this.esCorrecta = esCorrecta;
        this.orden = orden;
    }

    @Override
    public boolean equals(Object objetoAIgualar) {
        if (this == objetoAIgualar) return true;
        if (objetoAIgualar == null || getClass() != objetoAIgualar.getClass()) return false;
        Opcion opcion = (Opcion) objetoAIgualar;
        return esCorrecta == opcion.esCorrecta && Objects.equals(texto, opcion.texto);
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }

    public int getOrden(){
        return orden;
    }

}

