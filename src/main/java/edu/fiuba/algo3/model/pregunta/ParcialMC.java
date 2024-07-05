package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.modificador.Multiplicador;
import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernarioAcumulativo;
import edu.fiuba.algo3.model.modificador.Anulador;

import java.util.ArrayList;

public class ParcialMC extends Pregunta{
    public ParcialMC(String enunciado,
                     ArrayList<Opcion> opciones,
                     ArrayList<Opcion> opcionesCorrectas,
                     String categoria,
                     String descripcionRespuesta) {
        super(enunciado,
                opciones,
                2,
                5,
                opcionesCorrectas,
                new EvaluadorTernarioAcumulativo(),
                categoria,
                descripcionRespuesta,
                new ArrayList<>(){{add(new Anulador());add(new Multiplicador(2));add(new Multiplicador(3));}});
    }

    @Override
    public String getTipoDePregunta(){
        return "Multiple Choice Parcial";
    }
}
