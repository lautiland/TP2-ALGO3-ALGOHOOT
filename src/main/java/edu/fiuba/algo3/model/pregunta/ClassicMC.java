package edu.fiuba.algo3.model.pregunta;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;

public class ClassicMC extends Pregunta{
    public ClassicMC(String enunciado,
                     ArrayList<Opcion> opciones,
                     ArrayList<Opcion> opcionesCorrectas,
                     String categoria,
                     String descripcionRespuesta) {
        super(enunciado,
                opciones,
                2,
                5,
                opcionesCorrectas,
                new EvaluadorTernario(),
                categoria,
                descripcionRespuesta,
                new ArrayList<>(){{add(new Anulador());add(new Exclusividad());}});
    }

    @Override
    public String getTipoDePregunta(){
        return "Multiple Choice Clasico";
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
}
