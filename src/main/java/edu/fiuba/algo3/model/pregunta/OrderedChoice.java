package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta{
    public static final int CANTIDAD_OPCIONES_MIN = 2;
    public static final int CANTIDAD_OPCIONES_MAX = 6;  //distinto a consigna por necesidad de JSON

    public OrderedChoice(String enunciado,
                         ArrayList<Opcion> opciones,
                         ArrayList<Opcion> opcionesOrdenadas,
                         String categoria,
                         String descripcionRespuesta) {
        super(enunciado,
                opciones,
                CANTIDAD_OPCIONES_MIN,
                CANTIDAD_OPCIONES_MAX,
                opcionesOrdenadas,
                new EvaluadorTernario(),
                categoria,
                descripcionRespuesta,
                new ArrayList<>(){{add(new Anulador());add(new Exclusividad());}});
    }

    @Override
    public String getTipoDePregunta(){
        return "Ordered Choice";
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
}
