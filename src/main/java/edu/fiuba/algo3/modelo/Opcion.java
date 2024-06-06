package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class Opcion {
    private String texto;
    private boolean esCorrecta;

    public Opcion(String texto, boolean esCorrecta){
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opcion opcion = (Opcion) o;
        return esCorrecta == opcion.esCorrecta && Objects.equals(texto, opcion.texto);
    }

    public void mostrarOpciones(){
        System.out.println(this.texto);
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }
}
