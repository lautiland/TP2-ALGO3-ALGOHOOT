package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre){
        this.nombre = nombre;
        this.puntos = 0;
    }

    public int puntos(){
        return this.puntos;
    }

    public ArrayList<Opcion> obtenerRespuestas(Pregunta pregunta){
        //TODO: CAMBIAR EN PRODUCCION
        ArrayList<Opcion> respuestas = new ArrayList<>();
        Opcion opcionElegida = pregunta.seleccionarOpcion(0);
        respuestas.add(opcionElegida);
        return respuestas;
    }

    public void sumarPuntos(int puntos){
        this.puntos += puntos;
    }
}
