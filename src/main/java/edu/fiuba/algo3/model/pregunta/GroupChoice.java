package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
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
                opcionesCorrectasGrupoA, new EvaluadorTernario(), categoria, descripcionRespuesta, new ArrayList<>(){{
                    add(new Anulador());
                    add(new Exclusividad());
                }});
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
}