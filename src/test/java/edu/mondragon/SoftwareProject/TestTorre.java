package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTorre {

    @Test
    void testMovimientoValidoHorizontal() {
        Torre torre = new Torre(4, 4, true);
        Movimiento movimiento = new Movimiento(4, 7); // Movimiento en la misma columna
        assertTrue(torre.checkMovement(movimiento));

        Torre torre2 = new Torre(4, 4, true);
        Movimiento movimiento2 = new Movimiento(7, 4);  // Movimiento en la misma fila
        assertTrue(torre2.checkMovement(movimiento2));

        Torre torre3 = new Torre(4, 4, true);
        Movimiento movimiento3 = new Movimiento(5, 5);  // Movimiento diagonal (no válido para torre)
        assertFalse(torre3.checkMovement(movimiento3));
    }


    @Test
    void testMovimientoInvalidoFueraDelTablero() {
        Torre torre = new Torre(4, 4, true);
        Movimiento movimiento = new Movimiento(9, 4); // Fuera del tablero
        assertFalse(torre.checkMovement(new Movimiento(0, 6)));
        assertFalse(torre.checkMovement(new Movimiento(6, 0)));
        assertFalse(torre.checkMovement(new Movimiento(4, 9)));
        assertFalse(torre.checkMovement(movimiento));
    }

    @Test
    void testMovimientoEnElMismoLugar() {
        Torre torre = new Torre(4, 4, true);
        Movimiento movimiento = new Movimiento(4, 4); // Sin movimiento
        assertTrue(torre.checkMovement(movimiento));
    }

    @Test
    void testMovimientoLateralFueraDelTablero() {
        Torre torre = new Torre(1, 8, true);
        Movimiento movimiento = new Movimiento(1, 9); // Lateral, fuera del tablero
        assertFalse(torre.checkMovement(movimiento));
    }

    @Test
    void testToString(){
        Torre torre = new Torre(1,2, true);
        assertEquals("Torre",torre.toString());
    }
}
