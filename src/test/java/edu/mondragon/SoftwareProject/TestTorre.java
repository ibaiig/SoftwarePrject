package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTorre {

    @Test
    void testMovimientoValido() {
        //Test Moviemtno Horizontal
        Torre torre = new Torre(true, 4, 4);
        Movimiento movimiento = new Movimiento(4, 7); // Movimiento en la misma columna
        assertTrue(torre.checkMovement(movimiento));
        //Test Movimiento Vertical
        Torre torre2 = new Torre(true, 4, 4);
        Movimiento movimiento2 = new Movimiento(7, 4); // Movimiento en la misma fila
        assertTrue(torre2.checkMovement(movimiento2));
        //Test Moviemiento al mismo lugar
        Torre torre3 = new Torre(true, 4, 4);
        Movimiento movimiento3 = new Movimiento(4, 4); // Sin movimiento
        assertTrue(torre3.checkMovement(movimiento3));
    }

 
    @Test
    void testMovimientoInvalidoDiagonal() {
        Torre torre = new Torre(true, 4, 4);
        Movimiento movimiento = new Movimiento(5, 5); // Movimiento diagonal (no válido para torre)
        assertFalse(torre.checkMovement(movimiento));

    }

    @Test
    void testMovimientoInvalidoFueraDelTablero() {
        Torre torre = new Torre(true, 4, 4);
        Movimiento movimiento = new Movimiento(9, 4); // Fuera del tablero
        assertFalse(torre.checkMovement(new Movimiento(0, 6)));
        assertFalse(torre.checkMovement(new Movimiento(6, 0)));
        assertFalse(torre.checkMovement(new Movimiento(4, 9)));
        assertFalse(torre.checkMovement(movimiento));
    }

  

    @Test
    void testMovimientoLateralFueraDelTablero() {
        Torre torre = new Torre(true, 4, 4);
        Movimiento movimiento = new Movimiento(1, 9); // Lateral, fuera del tablero
        assertFalse(torre.checkMovement(movimiento));
    }

    @Test
    void testToString() {
        Torre torre = new Torre(true, 4, 4);
        assertEquals("Torre",torre.toString());
    }
}
