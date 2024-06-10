package edu.fiuba.algo3.modelo.pregunta;
import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    private final ArrayList<Opcion> opcionesCorrectas;
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas) {
        super(enunciado, opciones, 2,5);
        this.opcionesCorrectas = opcionesCorrectas;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        for (Opcion respuesta : respuestas) {
            if (!opcionesCorrectas.contains(respuesta)) return 0;
        }
        return 1;
    }
}
