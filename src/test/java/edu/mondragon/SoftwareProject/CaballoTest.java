package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class CaballoTest {

    private Caballo caballoBlanco;
    private Caballo caballoNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar los caballos en la posición (4,4)
        caballoBlanco = new Caballo(false, 4, 4);
        caballoNegro = new Caballo(true, 4, 4);
    }

    @Test()
    @Timeout(3000)
    void testMovimientoValidoBlanco() {
        // Movimiento en "L" válido
        Movimiento movimientoValido = new Movimiento(6, 5);
        assertTrue(caballoBlanco.checkMovement(movimientoValido), "El caballo blanco debería poder moverse a (6,5)");
        assertEquals(6, caballoBlanco.getPosx());
        assertEquals(5, caballoBlanco.getPosy());

        Movimiento movimientoValido2 = new Movimiento(7, 7);
        assertTrue(caballoBlanco.checkMovement(movimientoValido2), "El caballo blanco debería poder moverse a (6,5)");
        assertEquals(7, caballoBlanco.getPosx());
        assertEquals(7, caballoBlanco.getPosy());
    }

    @Test
    @Timeout(3000)
    void testMovimientoInvalidoBlanco() {
        // Movimiento no válido para un caballo
        Movimiento movimientoInvalido = new Movimiento(5, 5);
        assertFalse(caballoBlanco.checkMovement(movimientoInvalido),
                "El caballo blanco no debería poder moverse a (5,5)");
        assertEquals(4, caballoBlanco.getPosx()); // La posición no debe cambiar
        assertEquals(4, caballoBlanco.getPosy());

    }

    @Test
    @Timeout(3000)

    void testMovimientoValidoNegro() {
        // Movimiento en "L" válido
        Movimiento movimientoValido = new Movimiento(2, 3);
        assertTrue(caballoNegro.checkMovement(movimientoValido), "El caballo negro debería poder moverse a (2,3)");
        assertEquals(2, caballoNegro.getPosx());
        assertEquals(3, caballoNegro.getPosy());
    }

    @Test
    @Timeout(3000)

    void testMovimientoInvalidoNegro() {
        // Movimiento no válido para un caballo
        Movimiento movimientoInvalido = new Movimiento(4, 5);
        assertFalse(caballoNegro.checkMovement(movimientoInvalido),
                "El caballo negro no debería poder moverse a (4,5)");
        assertEquals(4, caballoNegro.getPosx()); // La posición no debe cambiar
        assertEquals(4, caballoNegro.getPosy());
    }

    @Test
    @Timeout(3000)

    void testToString() {
        assertEquals("Caballo blanco", caballoBlanco.toString());
        assertEquals("Caballo negro", caballoNegro.toString());
    }
}