package edu.fiuba.algo3.modelo.pregunta;

import edu.fiuba.algo3.modelo.Opcion;

import java.util.ArrayList;

public class GroupChoice extends Pregunta{
    public GroupChoice(String enunciado, ArrayList<Opcion> opciones) {
        super(enunciado, opciones, 2, 5);
    }

    @Override
    public int evaluarRespuestas(ArrayList<Opcion> respuestas) {
        /*La respuesta debería tener algún parámetro o método
        para alguna correspondencia entre el grupo 1
        o el grupo 2, por el momento, tal que no hay una opción correcta
        o incorrecta en un group choice, sino una correspondencia correcta
        o incorrecta, tomaré como grupo correcto el valor mismísimo del booleano
        Es decir, True = 1, False = 0.
        por tanto una pregunta que fue asignada en orden 1 con valor "esCorrecta" = 1
        está en el lugar correcto del grupo.
        Esto debe cambiarse.
        Es para tener una idea del código ya armada
        */
        int puntosTotales = 1;
        for (Opcion respuesta : respuestas) {
            if (respuesta.getOrden() != (respuesta.esCorrecta() ? 1 : 0)) {
                puntosTotales = 0;
                break;
            }
        }
        return puntosTotales;
    }
}