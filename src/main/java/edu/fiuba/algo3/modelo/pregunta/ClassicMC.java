package edu.fiuba.algo3.modelo.pregunta;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    public ClassicMC(String enunciado, ArrayList<Opcion> opciones, ArrayList<Opcion> opcionesCorrectas, String categoria, String descripcionRespuesta) {
        super(enunciado, opciones, 2, 5, opcionesCorrectas, new evaluadorTernario(), categoria, descripcionRespuesta);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas){

        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;

        for (Opcion opcion : opciones) {
            if(opcionesCorrectas.contains(opcion) && respuestas.contains(opcion)){
                respuestasCorrectas++;
            }else if(opcionesCorrectas.contains(opcion)){
                respuestasIncorrectas++;
            }
        }
        return calcularPuntaje(respuestasCorrectas,respuestasIncorrectas);
    }

    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}
