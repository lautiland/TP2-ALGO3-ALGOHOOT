package edu.fiuba.algo3.modelo.pregunta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, 2, 5, opcionesCorrectas, new evaluadorTernario());
    }

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}
