package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DamaTest {

    @Test
    void testMovimientoValidoLineaRecta() {
        Dama dama = new Dama("blanco", 3, 3);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento horizontal
        assertTrue(dama.esMovimientoValido(3, 7, tablero));

        // Movimiento vertical
        assertTrue(dama.esMovimientoValido(0, 3, tablero));
    }

    @Test
    void testMovimientoValidoDiagonal() {
        Dama dama = new Dama("negro", 3, 3);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento diagonal
        assertTrue(dama.esMovimientoValido(6, 6, tablero));
        assertTrue(dama.esMovimientoValido(0, 0, tablero));
    }

    @Test
    void testMovimientoInvalido() {
        Dama dama = new Dama("blanco", 3, 3);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento en "L" (no permitido)
        assertFalse(dama.esMovimientoValido(5, 4, tablero));
    }

    @Test
    void testMovimientoInvalidoPorAliado() {
        Dama dama = new Dama("blanco", 3, 3);
        Pieza[][] tablero = new Pieza[8][8];
        tablero[3][5] = new Torre("blanco", 3, 5);

        // Movimiento hacia una casilla ocupada por una pieza aliada
        assertFalse(dama.esMovimientoValido(3, 5, tablero));
    }

    @Test
    void testMovimientoInvalidoPorFueraDelTablero() {
        Dama dama = new Dama("negro", 7, 7);
        Pieza[][] tablero = new Pieza[8][8];

        // Movimiento fuera del tablero
        assertFalse(dama.esMovimientoValido(8, 8, tablero));
    }
}
