package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PenaltyTFTest {
    @Test
    public void test01SeIntentaCrearPenalidadTFSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearPenalidadTFConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            Opcion opcion2 = new Opcion("Falso", false);
            Opcion opcion3 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            
            Pregunta penalidadTF = new PenaltyTF("Verdadero o Falso", opciones);
        });
    }
}
