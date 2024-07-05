package edu.fiuba.algo3.model.pregunta;

import edu.fiuba.algo3.model.Opcion;
import edu.fiuba.algo3.model.evaluadores.EvaluadorTernario;
import edu.fiuba.algo3.model.modificador.Anulador;
import edu.fiuba.algo3.model.modificador.Exclusividad;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    private final ArrayList<Opcion> opcionesGrupoA;
    private final String descripcionGrupoA;
    private final String descripcionGrupoB;

    public GroupChoice(String enunciado,
                       ArrayList<Opcion> opciones,
                       ArrayList<Opcion> opcionesCorrectasGrupoA,
                       String categoria,
                       String descripcionRespuesta, String descripcionGrupoA, String descripcionGrupoB) {

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
        this.descripcionGrupoA = descripcionGrupoA;
        this.descripcionGrupoB = descripcionGrupoB;
    }

    @Override
    public String getTipoDePregunta(){
        return "Group Choice";
    }

    public String getDescripcionGrupoA(){
        return descripcionGrupoA;
    }

    public String getDescripcionGrupoB(){
        return descripcionGrupoB;
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