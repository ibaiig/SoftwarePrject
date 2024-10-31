package edu.mondragon.SoftwareProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaballoTest {

    private Caballo caballoBlanco;
    private Caballo caballoNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar los caballos en la posición (4,4)
        caballoBlanco = new Caballo(false, 4, 4);
        caballoNegro = new Caballo(true, 4, 4);
    }

    @Test
    public void testMovimientoValidoBlanco() {
        // Movimiento en "L" válido
        Movimiento movimientoValido = new Movimiento(6, 5);
        assertTrue(caballoBlanco.mover(movimientoValido), "El caballo blanco debería poder moverse a (6,5)");
        assertEquals(6, caballoBlanco.posx);
        assertEquals(5, caballoBlanco.posy);
    }

    @Test
    public void testMovimientoInvalidoBlanco() {
        // Movimiento no válido para un caballo
        Movimiento movimientoInvalido = new Movimiento(5, 5);
        assertFalse(caballoBlanco.mover(movimientoInvalido), "El caballo blanco no debería poder moverse a (5,5)");
        assertEquals(4, caballoBlanco.posx); // La posición no debe cambiar
        assertEquals(4, caballoBlanco.posy);
    }

    @Test
    public void testMovimientoValidoNegro() {
        // Movimiento en "L" válido
        Movimiento movimientoValido = new Movimiento(2, 3);
        assertTrue(caballoNegro.mover(movimientoValido), "El caballo negro debería poder moverse a (2,3)");
        assertEquals(2, caballoNegro.posx);
        assertEquals(3, caballoNegro.posy);
    }

    @Test
    public void testMovimientoInvalidoNegro() {
        // Movimiento no válido para un caballo
        Movimiento movimientoInvalido = new Movimiento(4, 5);
        assertFalse(caballoNegro.mover(movimientoInvalido), "El caballo negro no debería poder moverse a (4,5)");
        assertEquals(4, caballoNegro.posx); // La posición no debe cambiar
        assertEquals(4, caballoNegro.posy);
    }

    @Test
    public void testToString() {
        assertEquals("Caballo blanco", caballoBlanco.toString());
        assertEquals("Caballo negro", caballoNegro.toString());
    }
}