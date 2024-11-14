package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class TestDama {

    private Dama damaBlanca;
    private Dama damaNegra;

    @BeforeEach
    public void setUp() {
        // Inicializar las damas en la posición (4,4)
        damaBlanca = new Dama(false, 4, 4);
        damaNegra = new Dama(true, 4, 4);
    }

    @Test
    @Timeout(5)
    void testMovimientoValidoBlanco() {
        // Movimiento vertical válido
        Movimiento movimientoValidoVertical = new Movimiento(4, 7);
        assertTrue(damaBlanca.checkMovement(movimientoValidoVertical), "La dama blanca debería poder moverse a (4,7)");
        assertEquals(4, damaBlanca.getPosx());
        assertEquals(7, damaBlanca.getPosy());

        // Movimiento horizontal válido
        Movimiento movimientoValidoHorizontal = new Movimiento(7, 7);
        assertTrue(damaBlanca.checkMovement(movimientoValidoHorizontal),
                "La dama blanca debería poder moverse a (7,7)");
        assertEquals(7, damaBlanca.getPosx());
        assertEquals(7, damaBlanca.getPosy());

        // Movimiento diagonal válido
        Movimiento movimientoValidoDiagonal = new Movimiento(6, 6);
        assertTrue(damaBlanca.checkMovement(movimientoValidoDiagonal), "La dama blanca debería poder moverse a (5,6)");
        assertEquals(6, damaBlanca.getPosx());
        assertEquals(6, damaBlanca.getPosy());
    }

    @Test
    @Timeout(5)
    void testMovimientoInvalidoBlanco() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(5, 6);
        assertFalse(damaBlanca.checkMovement(movimientoInvalido), "La dama blanca no debería poder moverse a (5,6)");
        assertEquals(4, damaBlanca.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaBlanca.getPosy());
    }

    @Test
    @Timeout(5)
    void testMovimientoValidoNegro() {
        // Movimiento vertical válido
        Movimiento movimientoValidoVertical = new Movimiento(4, 7);
        assertTrue(damaNegra.checkMovement(movimientoValidoVertical), "La dama negra debería poder moverse a (4,7)");
        assertEquals(4, damaNegra.getPosx());
        assertEquals(7, damaNegra.getPosy());

        // Movimiento horizontal válido
        Movimiento movimientoValidoHorizontal = new Movimiento(7, 7);
        assertTrue(damaNegra.checkMovement(movimientoValidoHorizontal), "La dama negra debería poder moverse a (7,7)");
        assertEquals(7, damaNegra.getPosx());
        assertEquals(7, damaNegra.getPosy());

        // Movimiento diagonal válido
        Movimiento movimientoValidoDiagonal = new Movimiento(6, 6);
        assertTrue(damaNegra.checkMovement(movimientoValidoDiagonal), "La dama negra debería poder moverse a (5,6)");
        assertEquals(6, damaNegra.getPosx());
        assertEquals(6, damaNegra.getPosy());
    }

    @Test
    @Timeout(5)
    void testMovimientoInvalidoNegro() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(5, 6);
        assertFalse(damaNegra.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, damaNegra.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaNegra.getPosy());
    
   
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido2 = new Movimiento(9, 6);
        assertFalse(damaNegra.checkMovement(movimientoInvalido2), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, damaNegra.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaNegra.getPosy());
    

        // Movimiento no válido para una dama
        Movimiento movimientoInvalido3 = new Movimiento(6, 9);
        assertFalse(damaNegra.checkMovement(movimientoInvalido3), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, damaNegra.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaNegra.getPosy());
    }

    @Test
    @Timeout(5)
    void testMovimientoInvalidoNegro3() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(-5, 6);
        assertFalse(damaNegra.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, damaNegra.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaNegra.getPosy());
    }

    @Test
    @Timeout(5)
    void testMovimientoInvalidoNegro4() {
        // Movimiento no válido para una dama
        Movimiento movimientoInvalido = new Movimiento(6, -4);
        assertFalse(damaNegra.checkMovement(movimientoInvalido), "La dama negra no debería poder moverse a (5,6)");
        assertEquals(4, damaNegra.getPosx()); // La posición no debe cambiar
        assertEquals(4, damaNegra.getPosy());
    }



    @Test
    @Timeout(5)
    void testToString() {
        assertEquals("Dama blanco", damaBlanca.toString());
        assertEquals("Dama negro", damaNegra.toString());
    }
}