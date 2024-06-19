package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private final String nombre;
    private int puntos;
    private ArrayList<Opcion> respuestasActuales;
    private ArrayList<Multiplicador> multiplicadores;
    private Multiplicador multiplicadorActual;

    public Jugador(String nombre){
        this.puntos = 0;
        this.nombre = nombre;
        this.multiplicadores = new ArrayList<>();

        Multiplicador multiplicadorBase = new Multiplicador(1);

        multiplicadores.add(new Multiplicador(2));
        multiplicadores.add(new Multiplicador(3));

        this.multiplicadorActual = multiplicadorBase;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public void responderPregunta(ArrayList<Opcion> respuestas){
        this.respuestasActuales = respuestas;
    }

    public void activarMultiplicador(int factor){
        multiplicadores.forEach(multiplicador -> {
            if (multiplicador.getFactor() == factor){
                this.multiplicadorActual = multiplicador;
            }
        });
    }

    public ArrayList<Opcion> obtenerRespuestas(){
        return respuestasActuales;
    }

    public void modificarPuntos(int puntos){
        // Multiplicador
        this.puntos += multiplicadorActual.usar(puntos);
        this.multiplicadorActual = new Multiplicador(1);
    }
}
