package edu.fiuba.algo3.model.modificador;

import edu.fiuba.algo3.model.Jugador;

import java.util.HashMap;

public class Exclusividad extends Modificador {

    private int multiplicador;

    public Exclusividad(){
        super(2);
        multiplicador = 1;
    }

    private boolean unSoloJugadorRespondioBien(HashMap<Jugador, Integer> puntajes){
        int cantidadDeJugadoresQueRespondieronBien = 0;
        for (Integer puntaje : puntajes.values()){
            if (puntaje > 0){
                cantidadDeJugadoresQueRespondieronBien++;
            }
        }
        return cantidadDeJugadoresQueRespondieronBien == 1;
    }

    protected void usarAbstracto(Jugador jugador){
        multiplicador += 1;
    }

    public HashMap<Jugador, Integer> filtrarPuntos(HashMap<Jugador, Integer> puntajes){
        if (unSoloJugadorRespondioBien(puntajes)){
            puntajes.forEach((jugador, puntaje) -> puntajes.put(jugador, puntaje * multiplicador));
        }

        return puntajes;
    }

    public String toString(){
        return "Exclusividad";
    }

    public void desactivar(){
        multiplicador = 1;
        usadasEstaRonda = 0;
    }
}