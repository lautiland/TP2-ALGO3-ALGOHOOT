package edu.fiuba.algo3.model;

import java.util.Objects;

public class Opcion {
    private final String texto;

    public Opcion(String texto){
        this.texto = texto;
    }

    public boolean equals(Opcion objetoAIgualar) {
        return (Objects.equals(objetoAIgualar.texto, texto));
    }

}

