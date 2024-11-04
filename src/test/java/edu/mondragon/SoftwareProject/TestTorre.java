package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/*
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TorreTest {

    @Test
    void testMovimientoValidoHorizontal() {
        Torre torre = new Torre("negro", 0, 0);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento horizontal
        assertTrue(torre.esMovimientoValido(0, 5, tablero));
    }

    @Test
    void testMovimientoValidoVertical() {
        Torre torre = new Torre("blanco", 4, 4);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento vertical
        assertTrue(torre.esMovimientoValido(7, 4, tablero));
    }

    @Test
    void testMovimientoInvalido() {
        Torre torre = new Torre("blanco", 4, 4);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento en diagonal (no permitido)
        assertFalse(torre.esMovimientoValido(6, 6, tablero));
    }

    @Test
    void testMovimientoInvalidoPorAliado() {
        Torre torre = new Torre("blanco", 0, 0);
        Pieza[][] tablero = new Pieza[8][8];
        tablero[0][3] = new Dama("blanco", 0, 3);

        // Movimiento hacia una casilla ocupada por una pieza aliada
        assertFalse(torre.esMovimientoValido(0, 3, tablero));
    }

    @Test
    void testMovimientoInvalidoPorFueraDelTablero() {
        Torre torre = new Torre("blanco", 7, 7);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento fuera del tablero
        assertFalse(torre.esMovimientoValido(7, 8, tablero));
    }
}
 */