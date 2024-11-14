package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeonTest {

    private Peon peonBlanco;
    private Peon peonNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar los peones en sus posiciones iniciales
        peonBlanco = new Peon(false, 1, 1);
        peonNegro = new Peon(true, 6, 1);
    }

    @Test
    void testMovimientoValidoBlanco() {
        // Movimiento hacia adelante válido
        Movimiento movimientoValido = new Movimiento(2, 1);
        assertTrue(peonBlanco.checkMovement(movimientoValido), "El peón blanco debería poder moverse a (2,1)");
        assertEquals(2, peonBlanco.getPosx());
        assertEquals(1, peonBlanco.getPosy());

        // Movimiento inicial de dos casillas válido
        peonBlanco = new Peon(false, 1, 1);
        Movimiento movimientoInicial = new Movimiento(3, 1);
        assertTrue(peonBlanco.checkMovement(movimientoInicial), "El peón blanco debería poder moverse a (3,1)");
        assertEquals(3, peonBlanco.getPosx());
        assertEquals(1, peonBlanco.getPosy());

        // Movimiento inicial de dos casillas inválido
        peonNegro = new Peon(false, 5, 1);
        Movimiento movimientoInicial2 = new Movimiento(3, 1);
        assertFalse(peonNegro.checkMovement(movimientoInicial2), "El peón blanco debería poder moverse a (4,1)");
        assertEquals(5, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());

        // Movimiento inicial de dos casillas inválido
        peonNegro = new Peon(false, 1, 1);
        Movimiento movimientoInicial3 = new Movimiento(4, 2);
        assertFalse(peonNegro.checkMovement(movimientoInicial3), "El peón blanco debería poder moverse a (4,1)");
        assertEquals(1, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());

        peonBlanco = new Peon(false, 2, 1);
        Movimiento movimientoInicial4 = new Movimiento(6, 1);
        assertFalse(peonBlanco.checkMovement(movimientoInicial4), "El peón blanco debería poder moverse a (3,1)");
        assertEquals(2, peonBlanco.getPosx());
        assertEquals(1, peonBlanco.getPosy());
    }

    @Test
    void testMovimientoInvalidoBlanco() {
        // Movimiento no válido para un peón
        peonBlanco = new Peon(false, 1, 1);
        Movimiento movimientoInvalido = new Movimiento(2, 2);
        assertFalse(peonBlanco.checkMovement(movimientoInvalido), "El peón blanco no debería poder moverse a (1,2)");
        assertEquals(1, peonBlanco.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonBlanco.getPosy());

        Movimiento movimientoInvalido2 = new Movimiento(2, 2);
        assertFalse(peonBlanco.checkMovement(movimientoInvalido2), "El peón blanco no debería poder moverse a (1,2)");
        assertEquals(1, peonBlanco.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonBlanco.getPosy());
    }

    @Test
    void testMovimientoInvalido2Blanco() {
        // Movimiento no válido para un peón
        Movimiento movimientoInvalido = new Movimiento(2, 2);
        assertFalse(peonBlanco.checkMovement(movimientoInvalido), "El peón blanco no debería poder moverse a (1,2)");
        assertEquals(1, peonBlanco.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonBlanco.getPosy());
    }

    @Test
    void testMovimientoValidoNegro() {
        // Movimiento hacia adelante válido
        Movimiento movimientoValido = new Movimiento(5, 1);
        assertTrue(peonNegro.checkMovement(movimientoValido), "El peón negro debería poder moverse a (5,1)");
        assertEquals(5, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());

        // Movimiento inicial de dos casillas válido
        peonNegro = new Peon(true, 6, 1);
        Movimiento movimientoInicial = new Movimiento(4, 1);
        assertTrue(peonNegro.checkMovement(movimientoInicial), "El peón negro debería poder moverse a (4,1)");
        assertEquals(4, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());

        // Movimiento inicial de dos casillas inválido
        peonNegro = new Peon(true, 5, 1);
        Movimiento movimientoInicial2 = new Movimiento(3, 1);
        assertFalse(peonNegro.checkMovement(movimientoInicial2), "El peón negro debería poder moverse a (4,1)");
        assertEquals(5, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());

        // Movimiento inicial de dos casillas inválido
        peonNegro = new Peon(true, 6, 1);
        Movimiento movimientoInicial3 = new Movimiento(4, 2);
        assertFalse(peonNegro.checkMovement(movimientoInicial3), "El peón negro debería poder moverse a (4,1)");
        assertEquals(6, peonNegro.getPosx());
        assertEquals(1, peonNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro() {
        // Movimiento no válido para un peón
        peonNegro = new Peon(true, 6, 1);

        Movimiento movimientoInvalido = new Movimiento(6, 2);
        assertFalse(peonNegro.checkMovement(movimientoInvalido), "El peón negro no debería poder moverse a (6,2)");
        assertEquals(6, peonNegro.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonNegro.getPosy());

        Movimiento movimientoInvalido2 = new Movimiento(3, 1);
        assertFalse(peonNegro.checkMovement(movimientoInvalido2), "El peón negro no debería poder moverse a (6,2)");
        assertEquals(6, peonNegro.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonNegro.getPosy());
    }

    @Test
    void testMovimientoInvalido2Negro() {
        // Movimiento no válido para un peón
        Movimiento movimientoInvalido = new Movimiento(3, 1);
        assertFalse(peonNegro.checkMovement(movimientoInvalido), "El peón negro no debería poder moverse a (6,2)");
        assertEquals(6, peonNegro.getPosx()); // La posición no debe cambiar
        assertEquals(1, peonNegro.getPosy());
    }

    @Test
    void testToString() {
        assertEquals("Peon Blanco", peonBlanco.toString());
        assertEquals("Peon Negro", peonNegro.toString());
    }
}
