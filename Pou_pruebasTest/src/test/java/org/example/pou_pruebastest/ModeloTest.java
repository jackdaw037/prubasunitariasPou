package org.example.pou_pruebastest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloTest {

    @Test
    void comerAumentaHambre() {
        Modelo m = new Modelo("Pou", 50, 50, 50, 50);

        m.aumentarHambre(20);

        assertEquals(70, m.getHambre());
    }

    @Test
    void hambreNoSupera100() {
        Modelo m = new Modelo("Pou", 90, 50, 50, 50);

        m.aumentarHambre(20);

        assertEquals(100, m.getHambre());
    }

    @Test
    void hambreNoBajaDe0() {
        Modelo m = new Modelo("Pou", 10, 50, 50, 50);

        m.reducirHambre(50);

        assertEquals(0, m.getHambre());
    }

    @Test
    void comprarComidaReduceDinero() {
        Modelo m = new Modelo("Pou", 50, 50, 50, 100);

        m.comprarComida("Hamburguesa", 20);

        assertEquals(80, m.getDinero());
    }

    @Test
    void comprarComidaAumentaInventario() {
        Modelo m = new Modelo("Pou", 50, 50, 50, 100);

        m.comprarComida("Hamburguesa", 20);

        assertEquals(1, m.getHamburguesa());
    }

    @Test
    void noCompraSinDinero() {
        Modelo m = new Modelo("Pou", 50, 50, 50, 10);

        m.comprarComida("Hamburguesa", 20);

        assertEquals(10, m.getDinero());
        assertEquals(0, m.getHamburguesa());
    }

    @Test
    void consumirComidaReduceInventario() {
        Modelo m = new Modelo("Pou", 50, 50, 50, 50);
        m.setHamburguesa(1);

        m.consumirComida("Hamburguesa");

        assertEquals(0, m.getHamburguesa());
    }

    @Test
    void estaVivoSiHambreMayorQue0() {
        Modelo m = new Modelo("Pou", 10, 50, 50, 50);

        assertTrue(m.estaVivo());
    }

    @Test
    void muereSiHambre0() {
        Modelo m = new Modelo("Pou", 0, 50, 50, 50);

        assertFalse(m.estaVivo());
    }
}