package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorGroup;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<Opcion> opcionesGrupoA;
    private final ArrayList<Opcion> opcionesGrupoB;

    public GroupChoice(String enunciado, ArrayList<Opcion> opciones,
                       ArrayList<Opcion> opcionesCorrectasGrupoA,
                       ArrayList<Opcion> opcionesCorrectasGrupoB,
                       String categoria, String descripcionRespuesta) {

        super(enunciado, opciones, 2, 6,
                opcionesCorrectasGrupoA, new EvaluadorGroup(), categoria, descripcionRespuesta, new ArrayList<>(){{
                    add(new Anulador());
                    add(new Exclusividad());
                }});
        this.opcionesGrupoA = opcionesCorrectasGrupoA;
        this.opcionesGrupoB = opcionesCorrectasGrupoB;
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas){

        int correctasGrupoA = 0;
        int correctasGrupoB = 0;

        for(Opcion respuesta : respuestas){
            if(opcionesGrupoA.contains(respuesta)){
                correctasGrupoA++;
            }else{
                correctasGrupoB++;
            }
        }

        return calcularPuntaje(correctasGrupoA, correctasGrupoB);
    }
}