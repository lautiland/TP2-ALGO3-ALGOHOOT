package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClassicTFTest {
    @Test
    public void test01SeIntentaCrearClassicTFSinSuficientesOpciones() {

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);

            Pregunta classicTF = new ClassicTF("Verdadero o Falso", opciones);
        });
    }


    @Test
    public void test02SeIntentaCrearClassicTFConDemasiadasOpciones(){

        assertThrows(CantidadOpcionesInvalida.class, () -> {
            Opcion opcion1 = new Opcion("Verdadero", true);
            Opcion opcion2 = new Opcion("Falso", false);
            Opcion opcion3 = new Opcion("Verdadero", true);
            ArrayList<Opcion> opciones = new ArrayList<>();
            opciones.add(opcion1);
            opciones.add(opcion2);
            opciones.add(opcion3);
            
            Pregunta classicTF = new ClassicTF("Verdadero o Falso", opciones);
        });
    }
}
