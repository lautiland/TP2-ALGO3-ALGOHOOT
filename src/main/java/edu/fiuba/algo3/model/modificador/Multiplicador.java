package edu.fiuba.algo3.model.modificador;

import edu.fiuba.algo3.model.Jugador;

import java.util.ArrayList;
import java.util.HashMap;

public class Multiplicador extends Modificador {
    private final int factor;
    private final ArrayList<Jugador> jugadoresQueUsaron;

    public Multiplicador(int factor){
        super(1);
        this.factor = factor;
        jugadoresQueUsaron = new ArrayList<>();
    }

    @Override
    protected void usarAbstracto(Jugador jugador) {
        jugadoresQueUsaron.add(jugador);
    }

    @Override
    public HashMap<Jugador, Integer> filtrarPuntos(HashMap<Jugador, Integer> puntajes) {
        puntajes.forEach((jugador, puntaje) -> {
            if (jugadoresQueUsaron.contains(jugador)){
                puntajes.put(jugador, puntaje * factor);
            }
        });

        return puntajes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Multiplicador that = (Multiplicador) o;
        return factor == that.factor;
    }

    @Override
    public void desactivar() {
        jugadoresQueUsaron.clear();
    }
}
