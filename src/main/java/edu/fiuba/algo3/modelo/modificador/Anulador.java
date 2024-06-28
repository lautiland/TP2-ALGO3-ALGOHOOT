package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.HashMap;

public class Anulador extends Modificador {
    private static final int USOS_POR_JUGADOR = 1;
    private boolean activo;
    private Jugador jugadorQueUso;
    private boolean nadieRecibePuntos;

    public Anulador() {
        super(USOS_POR_JUGADOR);
        activo = false;
    }

    @Override
    protected void usarAbstracto(Jugador jugador) {
        if(activo){
            nadieRecibePuntos = true;
        }

        jugadorQueUso = jugador;
        activo = true;
    }

    public HashMap<Jugador, Integer> filtrarPuntos(HashMap<Jugador, Integer> puntajes){
        puntajes.forEach((jugador, puntaje) -> {
            if((activo && !jugador.equals(jugadorQueUso) || nadieRecibePuntos )){
                puntajes.put(jugador, 0);
            }
        });

        return puntajes;
    }

    public void desactivar(){
        activo = false;
        nadieRecibePuntos = false;
    }
}
