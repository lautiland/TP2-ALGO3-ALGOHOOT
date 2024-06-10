package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Opcion {
    private final String texto;

    public Opcion(String texto, boolean esCorrecta, int orden){
        this.texto = texto;
    }

    public String getTexto(){
        return texto;
    }

    public boolean equals(Opcion objetoAIgualar) {
        return (Objects.equals(objetoAIgualar.getTexto(), getTexto()));
    }

}

