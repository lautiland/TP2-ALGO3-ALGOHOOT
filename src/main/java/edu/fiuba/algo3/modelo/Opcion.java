package edu.fiuba.algo3.modelo;

public class Opcion {
    private String texto;
    private boolean esCorrecta;

    public Opcion(String texto, boolean esCorrecta){
        this.texto = texto;
        this.esCorrecta = esCorrecta;
    }

    public void mostrarOpciones(){
        System.out.println(this.texto);
    }

    public boolean esCorrecta() {
        return esCorrecta;
    }
}
