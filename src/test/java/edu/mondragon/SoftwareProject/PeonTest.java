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
        // Creamos peones en distintas posiciones iniciales para probar todos los casos
        peonBlancoInicio = new Peon(1, 2, false); // Peón blanco en posición inicial
        peonBlanco = new Peon(1, 4, false); // Peón blanco fuera de la posición inicial
        peonNegroInicio = new Peon(1, 7, true); // Peón negro en posición inicial
        peonNegro = new Peon(1, 5, true); // Peón negro fuera de la posición inicial
    }

    // ---------------- Tests para Peón Blanco ----------------

    @Test
    void testMoverMovimientoValidoBlancoInicioDosPosiciones() {
        // Movimiento válido de dos posiciones adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 4);
        assertTrue(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoInicioUnaPosicion() {
        // Movimiento válido de una posición adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 3);
        assertTrue(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoInicioTresPosiciones() {
        // Movimiento inválido de tres posiciones adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 5);
        assertFalse(peonBlancoInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoBlancoUnaPosicion() {
        // Movimiento válido de una posición hacia adelante fuera de la posición inicial
        Movimiento movimiento = new Movimiento(1, 5);
        assertTrue(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoBlancoDosPosiciones() {
        // Movimiento inválido de dos posiciones adelante fuera de la posición inicial
        Movimiento movimiento = new Movimiento(1, 6);
        assertFalse(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaBlanco() {
        // Movimiento de captura diagonal válido para peón blanco
        Movimiento movimiento = new Movimiento(2, 5);
        assertTrue(peonBlanco.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaBlanco() {
        // Movimiento de captura diagonal inválido (más de una casilla en diagonal)
        Movimiento movimiento = new Movimiento(3, 5);
        assertFalse(peonBlanco.mover(movimiento));
    }

    // ---------------- Tests para Peón Negro ----------------

    @Test
    void testMoverMovimientoValidoNegroInicioDosPosiciones() {
        // Movimiento válido de dos posiciones hacia adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 5);
        assertTrue(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroInicioUnaPosicion() {
        // Movimiento válido de una posición adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 6);
        assertTrue(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroInicioTresPosiciones() {
        // Movimiento inválido de tres posiciones adelante desde la posición inicial
        Movimiento movimiento = new Movimiento(1, 4);
        assertFalse(peonNegroInicio.mover(movimiento));
    }

    @Test
    void testMoverMovimientoValidoNegroUnaPosicion() {
        // Movimiento válido de una posición hacia adelante fuera de la posición inicial
        Movimiento movimiento = new Movimiento(1, 4);
        assertTrue(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverMovimientoInvalidoNegroDosPosiciones() {
        // Movimiento inválido de dos posiciones adelante fuera de la posición inicial
        Movimiento movimiento = new Movimiento(1, 3);
        assertFalse(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalValidaNegro() {
        // Movimiento de captura diagonal válido para peón negro
        Movimiento movimiento = new Movimiento(2, 4);
        assertTrue(peonNegro.mover(movimiento));
    }

    @Test
    void testMoverCapturaDiagonalInvalidaNegro() {
        // Movimiento de captura diagonal inválido (más de una casilla en diagonal)
        Movimiento movimiento = new Movimiento(3, 4);
        assertFalse(peonNegro.mover(movimiento));
    }

    // ---------------- Test para toString ----------------

    @Test
    void testToStringBlanco() {
        assertEquals("Peon Blanco", peonBlancoInicio.toString());
    }

    @Test
    void testToStringNegro() {
        assertEquals("Peon Negro", peonNegroInicio.toString());
    }
}
