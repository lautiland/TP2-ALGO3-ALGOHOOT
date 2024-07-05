package edu.fiuba.algo3.model.modificador;

import edu.fiuba.algo3.model.Jugador;
import edu.fiuba.algo3.model.Uso;

import java.util.ArrayList;
import java.util.HashMap;

abstract public class Modificador {
    protected final ArrayList<Uso> usos;
    protected final int maximo;
    private int cantVecesUsadas;

    public Modificador(int maximo) {
        this.usos = new ArrayList<>();
        this.maximo = maximo;
        cantVecesUsadas = 0;
    }

    protected abstract void usarAbstracto(Jugador jugador);

    public void usar(Jugador jugador) {
        Uso u = new Uso(jugador);
        if (u.contarMisEquivalentes(usos) < maximo) {
            usos.add(u);
            cantVecesUsadas++;
            usarAbstracto(jugador);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    public boolean puedeUsar(Jugador jugador){
        Uso u = new Uso(jugador);
        return u.contarMisEquivalentes(usos) < maximo;
    }

    public int getUsadosEsteTurno() {
        return cantVecesUsadas;
    }

    public abstract String toString();

    public abstract HashMap<Jugador, Integer> filtrarPuntos(HashMap<Jugador, Integer> puntajes);

    public abstract void desactivar();
}
