package edu.fiuba.algo3.modelo.pregunta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    private final ArrayList<Opcion> opcionesCorrectas;
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, 2, 5);
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        for (Opcion opcionCorrecta : opcionesCorrectas) {
            if (!respuestas.contains(opcionCorrecta)) return PUNTOS_NO_RESPONDIDA;
        }
        return PUNTOS_BIEN_RESPONDIDA;
    }

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}
