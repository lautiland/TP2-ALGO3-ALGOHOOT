package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Opcion {
    private final String texto;
    private final boolean esCorrecta;

    public Opcion(String texto, boolean esCorrecta){
        this.texto = texto;
        this.esCorrecta = esCorrecta;
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
}
