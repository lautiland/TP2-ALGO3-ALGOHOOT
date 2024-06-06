package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PenaltyMCTest {
    @Test
    public void test01SeIntentaCrearPenalidadMCSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta penalidadMC = new PenaltyMC("Elegir las opciones que dicen Si", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearPenalidadMCConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Si", true);
            Opcion opcion2 = new Opcion("No", false);
            Opcion opcion3 = new Opcion("Si", true);
            Opcion opcion4 = new Opcion("Siuuuu", false);
            Opcion opcion5 = new Opcion("Si", true);
            Opcion opcion6 = new Opcion("Si", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            opciones.add(opcion4);
            opciones.add(opcion5);
            opciones.add(opcion6);
            
            Pregunta penalidadMC = new PenaltyMC("Elegir las opciones que dicen Si", opciones);
        });
    }
}

