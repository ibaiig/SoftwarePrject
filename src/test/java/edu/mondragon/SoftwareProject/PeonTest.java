package edu.mondragon.SoftwareProject;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mondragon.softwareproject.Movimiento;
import edu.mondragon.softwareproject.Peon;

class PeonTest {

    private Peon peonBlancoInicio;
    private Peon peonBlanco;
    private Peon peonNegroInicio;
    private Peon peonNegro;

    @BeforeEach
    void setUp() {
        peonBlancoInicio = new Peon(1, 2, false);
        peonBlanco = new Peon(1, 4, false);
        peonNegroInicio = new Peon(1, 7, true);
        peonNegro = new Peon(1, 5, true);
    }

    // ---------------- Tests para Peón Blanco ----------------

    @Test
    void testMoverMovimientoValidoBlancoInicioDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertFalse(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoInicioUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 3);
        assertTrue(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoInicioTresPosiciones() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertFalse(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertFalse(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 6);
        assertFalse(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaBlanco() {
        Movimiento movimiento = new Movimiento(2, 5);
        assertTrue(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaBlanco() {
        Movimiento movimiento = new Movimiento(3, 5);
        assertFalse(peonBlanco.mover(movimiento));
    }

    // ---------------- Tests para Peón Negro ----------------

    @Test
    void testMoverMovimientoValidoNegroInicioDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertFalse(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroInicioUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 6);
        assertTrue(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroInicioTresPosiciones() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertFalse(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertFalse(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 3);
        assertFalse(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaNegro() {
        Movimiento movimiento = new Movimiento(2, 4);
        assertTrue(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaNegro() {
        Movimiento movimiento = new Movimiento(3, 4);
        assertFalse(peonNegro.mover(movimiento));
    }

    @Test
    void testToStringBlanco() {
        assertEquals("Peon Blanco", peonBlancoInicio.toString());
    }

    @Test
    void testToStringNegro() {
        assertEquals("Peon Negro", peonNegroInicio.toString());
    }
}
