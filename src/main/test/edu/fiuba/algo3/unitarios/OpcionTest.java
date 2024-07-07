package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.model.Opcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class OpcionTest {
    @Test
    public void test01DosOpcionesSonEquivalentes(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion1");

        assertEquals(opcion1, opcion2);
        assertEquals("opcion1", opcion1.getTexto());
        assertEquals("opcion1", opcion2.getTexto());
    }

    @Test
    public void test02DosOpcionesNoSonEquivalentes(){
        Opcion opcion1 = new Opcion("opcion1");
        Opcion opcion2 = new Opcion("opcion2");

        assertNotEquals(opcion1, opcion2);
    }
}
