package edu.fiuba.algo3.modelo.modificador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Uso;

import java.util.ArrayList;
import java.util.HashMap;

abstract public class Modificador {
    protected final ArrayList<Uso> usos;
    protected int maximo;

    public Modificador(int maximo) {
        this.usos = new ArrayList<>();
        this.maximo = maximo;
    }

    protected abstract void usarAbstracto(Jugador jugador);

    public void usar(Jugador jugador) {
        Uso u = new Uso(jugador);
        if (u.contarMisEquivalentes(usos) < maximo) {
            usos.add(u);
            usarAbstracto(jugador);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    public abstract HashMap<Jugador, Integer> filtrarPuntos(HashMap<Jugador, Integer> puntajes);

    public abstract void desactivar();
}
