package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas, String categoria, String descripcionRespuesta) {
        super(enunciado, opcionesOrdenadas, 2, 5,
                opcionesOrdenadas,new EvaluadorTernario(), categoria, descripcionRespuesta);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;

        for (int i = 0; i < respuestas.size(); i++) {
            if(opcionesCorrectas.get(i).equals(respuestas.get(i))){
                respuestasCorrectas++;
            }else{
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
