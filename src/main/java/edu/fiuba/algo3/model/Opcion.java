package edu.fiuba.algo3.model;

import java.util.Objects;

public class Opcion {
    private final String texto;

    public Opcion(String texto){
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcion opcion = (Opcion) o;
        return Objects.equals(texto, opcion.texto);
    }

    public String getTexto(){
        return texto;
    }
}

