package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<Opcion> opcionesGrupoA;

    public GroupChoice(String enunciado,
                       ArrayList<Opcion> opciones,
                       ArrayList<Opcion> opcionesCorrectasGrupoA,
                       ArrayList<Opcion> opcionesCorrectasGrupoB,
                       String categoria,
                       String descripcionRespuesta) {

        super(enunciado,
                opciones,
                2,
                6,
                opcionesCorrectasGrupoA,
                new EvaluadorTernario(),
                categoria,
                descripcionRespuesta,
                new ArrayList<>(){{add(new Anulador());add(new Exclusividad());}});

        this.opcionesGrupoA = opcionesCorrectasGrupoA;
    }

    @Override
    public String getTipoDePregunta(){
        return "Group Choice";
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas){

        int correctasGrupoB = 0;

        for(Opcion respuesta : opcionesGrupoA){
            if(!respuestas.contains(respuesta)){
                correctasGrupoB++;
            }
        }

        for(Opcion respuesta : respuestas){
            if(!opcionesGrupoA.contains(respuesta)){
                correctasGrupoB++;
            }
        }

        return calcularPuntaje(0, correctasGrupoB);
    }
}