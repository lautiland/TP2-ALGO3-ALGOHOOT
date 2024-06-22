package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.modelo.modificador.Modificador;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{

    private final ArrayList<Opcion> opcionesGrupoA;

    private final ArrayList<Opcion> opcionesGrupoB;

    public GroupChoice(String enunciado, ArrayList<Opcion> opciones,
                       ArrayList<Opcion> opcionesCorrectasGrupoA,
                       ArrayList<Opcion> opcionesCorrectasGrupoB,
                       String categoria, String descripcionRespuesta) {

        super(enunciado, opciones, 2, 6,
                opcionesCorrectasGrupoA, new EvaluadorTernario(), categoria, descripcionRespuesta);
        this.opcionesGrupoA = opcionesCorrectasGrupoA;
        this.opcionesGrupoB = opcionesCorrectasGrupoB;

    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas){

        int respuestasCorrectas = 0;
        int respuestasIncorrectas = 0;

        for(int i = 0; i < opcionesGrupoA.size(); i++) {
            if (opcionesGrupoA.contains(respuestas.get(i))) {
                respuestasCorrectas++;
            } else{
                respuestasIncorrectas++;
            }
        }
        for(int j = opcionesGrupoA.size(); j < opcionesGrupoB.size(); j++){
            if(opcionesGrupoB.contains(respuestas.get(j))){
                respuestasCorrectas++;
            }else{
                respuestasIncorrectas++;
            }
        }return calcularPuntaje(respuestasCorrectas,respuestasIncorrectas);
    }



    @Override
    public boolean esCompatibleCon(Modificador modificadorActual) {
        return (!modificadorActual.getClass().getSimpleName().equals("Multiplicador"));
    }
}