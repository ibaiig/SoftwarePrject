package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class TableroTest {

    private Tablero tablero;

    @BeforeEach
    public void setUp() {
        tablero = new Tablero();
    }

    @Test
    @Timeout(5)
    public void testInicializarTablero() {
        // Verifica que el tablero se inicialice correctamente
        assertTrue(tablero.getPiezaEnPosicion(0, 0) instanceof Torre);
        assertTrue(tablero.getPiezaEnPosicion(7, 0) instanceof Torre);
        assertTrue(tablero.getPiezaEnPosicion(0, 4) instanceof Rey);
        assertTrue(tablero.getPiezaEnPosicion(7, 4) instanceof Rey);
        assertTrue(tablero.getPiezaEnPosicion(1, 0) instanceof Peon);
        assertTrue(tablero.getPiezaEnPosicion(6, 0) instanceof Peon);
    }

    @Test
    @Timeout(5)
    public void testMoverPieza() {
        // Mueve un peón blanco adelante y verifica que el movimiento es válido
        Movimiento movimiento = new Movimiento(2, 2); // Mover el peón en (1,0) a (2,0)
        assertTrue(tablero.moverPieza(false, 0, 1, movimiento));
        assertNull(tablero.getPiezaEnPosicion(3, 3));
        assertTrue(tablero.getPiezaEnPosicion(2,2) instanceof Caballo);

        // Intenta mover una pieza del jugador negro en el turno blanco (debe fallar)
        movimiento = new Movimiento(5, 0); // Mover el peón negro en (6,0) a (5,0)
        assertFalse(tablero.moverPieza(false, 6, 0, movimiento));
    }

    @Test
    @Timeout(5)
    public void testIsCheck() {
        // Coloca las piezas en una situación de jaque (rey negro amenazado)
        tablero.hasieratu();
        Rey reyNegro = new Rey(true, 0, 0);
        Torre torreBlanca = new Torre(false, 1, 0);
        tablero.getTablero()[0][0] = reyNegro;
        tablero.getTablero()[1][0] = torreBlanca;

        assertTrue(tablero.isCheck(true), "Rey negro debería estar en jaque");
        assertFalse(tablero.isCheck(false), "Rey blanco no debería estar en jaque");
    }

    @Test
    @Timeout(5)
    public void testCheckMate() {
        // Coloca las piezas en una situación de jaque mate (rey negro sin opciones)
        Rey rey = new Rey(false, 0, 0);
        tablero.getTablero()[0][0] = rey;
    
        // Coloca una pieza enemiga que cause jaque
        Torre torreEnemiga = new Torre(true, 0, 7);
        tablero.getTablero()[0][7] = torreEnemiga;
    
        Torre torreEnemiga2 = new Torre(true, 1, 7);
        tablero.getTablero()[0][7] = torreEnemiga;
        // Llama a checkMate y verifica que la posición del rey no ha cambiado
        boolean esJaqueMate = tablero.checkMate(rey);
    
        // Verificar que la posición del rey sigue siendo (0,0) después de llamar a checkMate
        assertEquals(0, rey.getPosx(), "El rey debe permanecer en su posición original en x.");
        assertEquals(0, rey.getPosy(), "El rey debe permanecer en su posición original en y.");
    
        // Verificar el resultado esperado de jaque mate
        assertFalse(esJaqueMate, "Debería estar en jaque mate.");}

    @Test
    @Timeout(5)
    public void testGenerarMovimientos() {
        // Verifica que generarMovimientos() funcione correctamente para una torre
        Torre torre = new Torre(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(torre);

        // La torre debería tener 14 movimientos posibles en un tablero vacío (7 en cada dirección)
        assertEquals(14, movimientos.size());
    }

    @Test
    @Timeout(5)
    public void testPuedeBloquearOComer() {
        // Verifica que una pieza aliada pueda bloquear o capturar una amenaza
        tablero.setTablero(new Pieza[8][8]);
        Rey reyNegro = new Rey(true, 0, 0);
        Torre torreBlanca = new Torre(false, 1, 0);
        tablero.getTablero()[0][0] = reyNegro;
        tablero.getTablero()[1][0] = torreBlanca;

        Movimiento movimiento = new Movimiento(1, 0); // Movimiento de la torre blanca para capturar
        assertTrue(tablero.puedeBloquearOComer(reyNegro, movimiento), "La torre debería poder bloquear o capturar la amenaza");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosTorre() {
        Torre torre = new Torre(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(torre);

        // La torre debería tener 14 movimientos posibles en un tablero vacío (7 en cada dirección)
        assertEquals(14, movimientos.size(), "La torre debería tener 14 movimientos posibles en un tablero vacío.");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosCaballo() {
        Caballo caballo = new Caballo(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(caballo);

        // El caballo debería tener 8 movimientos posibles desde el centro del tablero
        assertEquals(8, movimientos.size(), "El caballo debería tener 8 movimientos posibles en un tablero vacío.");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosAlfil() {
        Alfil alfil = new Alfil(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(alfil);

        // El alfil debería tener 13 movimientos posibles en un tablero vacío (diagonales)
        assertEquals(13, movimientos.size(), "El alfil debería tener 13 movimientos posibles en un tablero vacío.");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosDama() {
        Dama dama = new Dama(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(dama);

        // La dama debería tener 27 movimientos posibles (combinación de torre y alfil)
        assertEquals(27, movimientos.size(), "La dama debería tener 27 movimientos posibles en un tablero vacío.");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosRey() {
        Rey rey = new Rey(false, 3, 3);
        List<Movimiento> movimientos = tablero.generarMovimientos(rey);

        // El rey debería tener 8 movimientos posibles desde el centro del tablero
        assertEquals(8, movimientos.size(), "El rey debería tener 8 movimientos posibles en un tablero vacío.");
    }

    @Test
    @Timeout(5)
    public void testGenerarMovimientosPeon() {
        Peon peonBlanco = new Peon(false, 1, 3); // Peón blanco en posición inicial
        List<Movimiento> movimientosBlanco = tablero.generarMovimientos(peonBlanco);

        // El peón blanco debería tener 2 movimientos posibles desde su posición inicial
        assertEquals(4, movimientosBlanco.size(), "El peón blanco debería tener 2 movimientos posibles desde la posición inicial.");

        Peon peonNegro = new Peon(true, 6, 3); // Peón negro en posición inicial
        List<Movimiento> movimientosNegro = tablero.generarMovimientos(peonNegro);

        // El peón negro debería tener 2 movimientos posibles desde su posición inicial
        assertEquals(4, movimientosNegro.size(), "El peón negro debería tener 2 movimientos posibles desde la posición inicial.");

        Peon peonBlancoAvanzado = new Peon(false, 3, 3); // Peón blanco en una posición avanzada
        List<Movimiento> movimientosBlancoAvanzado = tablero.generarMovimientos(peonBlancoAvanzado);

        // El peón blanco avanzado debería tener solo 1 movimiento posible hacia adelante
        assertEquals(3, movimientosBlancoAvanzado.size(), "El peón blanco avanzado debería tener 1 movimiento posible hacia adelante.");
    }
}
