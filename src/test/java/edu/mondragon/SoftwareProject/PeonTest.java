package edu.mondragon.SoftwareProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeonTest {

    private Peon peonBlancoInicio;
    private Peon peonBlanco;
    private Peon peonNegroInicio;
    private Peon peonNegro;

    @BeforeEach
    void setUp() {
        peonBlancoInicio = new Peon(false, 1, 2);
        peonBlanco = new Peon(false, 1, 4);
        peonNegroInicio = new Peon(true, 1, 7);
        peonNegro = new Peon(true, 1, 5);
    }

    // ---------------- Tests para Peón Blanco ----------------

    @Test
    void testMoverMovimientoValidoBlancoInicioDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertTrue(peonBlancoInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoInicioUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 3);
        assertTrue(peonBlancoInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoInicioTresPosiciones() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertFalse(peonBlancoInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertTrue(peonBlanco.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 6);
        assertFalse(peonBlanco.checkMovement(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaBlanco() {
        Movimiento movimiento = new Movimiento(2, 5);
        assertTrue(peonBlanco.checkMovement(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaBlanco() {
        Movimiento movimiento = new Movimiento(3, 5);
        assertFalse(peonBlanco.checkMovement(movimiento));
    }

    // ---------------- Tests para Peón Negro ----------------

    @Test
    void testMoverMovimientoValidoNegroInicioDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 5);
        assertTrue(peonNegroInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroInicioUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 6);
        assertTrue(peonNegroInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroInicioTresPosiciones() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertFalse(peonNegroInicio.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroUnaPosicion() {
        Movimiento movimiento = new Movimiento(1, 4);
        assertTrue(peonNegro.checkMovement(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroDosPosiciones() {
        Movimiento movimiento = new Movimiento(1, 3);
        assertFalse(peonNegro.checkMovement(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaNegro() {
        Movimiento movimiento = new Movimiento(2, 4);
        assertTrue(peonNegro.checkMovement(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaNegro() {
        Movimiento movimiento = new Movimiento(3, 4);
        assertFalse(peonNegro.checkMovement(movimiento));
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
