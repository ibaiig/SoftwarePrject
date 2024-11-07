package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestAlfil {

    private Alfil alfilBlanco;
    private Alfil alfilNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar los alfiles en la posición (4,4)
        alfilBlanco = new Alfil(false, 4, 4);
        alfilNegro = new Alfil(true, 4, 4);
    }

    @Test
    void testMovimientoValidoBlanco() {
        // Movimiento diagonal válido
        Movimiento movimientoValidoDiagonal1 = new Movimiento(6, 6);
        assertTrue(alfilBlanco.checkMovement(movimientoValidoDiagonal1),
                "El alfil blanco debería poder moverse a (6,6)");
        assertEquals(6, alfilBlanco.getPosx());
        assertEquals(6, alfilBlanco.getPosy());

        Movimiento movimientoValidoDiagonal2 = new Movimiento(2, 2);
        assertTrue(alfilBlanco.checkMovement(movimientoValidoDiagonal2),
                "El alfil blanco debería poder moverse a (2,2)");
        assertEquals(2, alfilBlanco.getPosx());
        assertEquals(2, alfilBlanco.getPosy());
    }

    @Test
    void testMovimientoInvalidoBlanco() {
        // Movimiento no válido para un alfil
        Movimiento movimientoInvalido = new Movimiento(5, 6);
        assertFalse(alfilBlanco.checkMovement(movimientoInvalido), "El alfil blanco no debería poder moverse a (5,6)");
        assertEquals(4, alfilBlanco.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilBlanco.getPosy());
    }

    @Test
    void testMovimientoValidoNegro() {
        // Movimiento diagonal válido
        Movimiento movimientoValidoDiagonal1 = new Movimiento(6, 6);
        assertTrue(alfilNegro.checkMovement(movimientoValidoDiagonal1), "El alfil negro debería poder moverse a (6,6)");
        assertEquals(6, alfilNegro.getPosx());
        assertEquals(6, alfilNegro.getPosy());

        Movimiento movimientoValidoDiagonal2 = new Movimiento(2, 2);
        assertTrue(alfilNegro.checkMovement(movimientoValidoDiagonal2), "El alfil negro debería poder moverse a (2,2)");
        assertEquals(2, alfilNegro.getPosx());
        assertEquals(2, alfilNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro() {
        // Movimiento no válido para un alfil
        Movimiento movimientoInvalido = new Movimiento(5, 6);
        assertFalse(alfilNegro.checkMovement(movimientoInvalido), "El alfil negro no debería poder moverse a (5,6)");
        assertEquals(4, alfilNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro2() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(9, 6);
        assertFalse(alfilNegro.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, alfilNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro3() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(-5, 6);
        assertFalse(alfilNegro.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, alfilNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro4() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(6, -4);
        assertFalse(alfilNegro.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, alfilNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilNegro.getPosy());
    }

    @Test
    void testMovimientoInvalidoNegro5() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(6, 9);
        assertFalse(alfilNegro.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, alfilNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, alfilNegro.getPosy());
    }

    @Test
    void testToString() {
        assertEquals("Alfil blanco", alfilBlanco.toString());
        assertEquals("Alfil negro", alfilNegro.toString());
    }
}
