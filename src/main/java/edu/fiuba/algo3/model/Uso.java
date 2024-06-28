package edu.fiuba.algo3.model;

import java.util.ArrayList;
import java.util.Objects;

public class Uso {
    private final Jugador jugador;

    public Uso(Jugador jugador) {
        this.jugador = jugador;
    }

    public Long contarMisEquivalentes(ArrayList<Uso> usos) {
        return usos.stream()
                .filter((e) -> e.equals(this))
                .count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uso uso = (Uso) o;
        return Objects.equals(jugador, uso.jugador);
    }
}
