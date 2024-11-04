package edu.mondragon.SoftwareProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRey {
    private Rey reyNegro;
    private Rey reyBlanco;

    @BeforeEach
    public void setUp() {
        reyNegro = new Rey(true, 0, 0);
        reyBlanco = new Rey(false, 4, 4);
    }

    @Test
    public void testMovimientoValido() {
        assertTrue(reyBlanco.mover(new Movimiento(5, 5))); 
        assertTrue(reyBlanco.mover(new Movimiento(5, 4))); 
        assertTrue(reyBlanco.mover(new Movimiento(4, 4))); 
        assertTrue(reyBlanco.mover(new Movimiento(3, 3))); 

        assertTrue(reyNegro.mover(new Movimiento(1, 0))); 
        assertTrue(reyNegro.mover(new Movimiento(1, 1))); 
    }

    @Test
    public void testMovimientoInvalido() {
        assertFalse(reyBlanco.mover(new Movimiento(6, 6))); 
        assertFalse(reyBlanco.mover(new Movimiento(4, 6))); 
        assertFalse(reyBlanco.mover(new Movimiento(2, 4))); 

        assertFalse(reyNegro.mover(new Movimiento(2, 2))); 
        assertFalse(reyNegro.mover(new Movimiento(0, 2))); 
    }

    @Test
    public void testToString() {
        assertEquals("Rey negro", reyNegro.toString());
        assertEquals("Rey blanco", reyBlanco.toString());
    }
}
