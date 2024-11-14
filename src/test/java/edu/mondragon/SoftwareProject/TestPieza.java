package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class TestPieza {

    private Caballo caballoBlanco, caballoBlanco2;
    private Caballo caballoNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar caballos en posiciones específicas
        caballoBlanco = new Caballo(false, 4, 4); // Caballo blanco en (4,4)
        caballoNegro = new Caballo(true, 5, 5); // Caballo negro en (5,5)
    }

    @Test
    @Timeout(5)
    void testConstructorCaballoBlanco() {
        // Verificar que el caballo blanco se inicializa correctamente
        assertFalse(caballoBlanco.isNegro(), "El caballo debe ser blanco");
        assertEquals(4, caballoBlanco.getPosx(), "La posición x debe ser 4");
        assertEquals(4, caballoBlanco.getPosy(), "La posición y debe ser 4");
    }

    @Test
    @Timeout(5)
    void testConstructorCaballoNegro() {
        // Verificar que el caballo negro se inicializa correctamente
        assertTrue(caballoNegro.isNegro(), "El caballo debe ser negro");
        assertEquals(5, caballoNegro.getPosx(), "La posición x debe ser 5");
        assertEquals(5, caballoNegro.getPosy(), "La posición y debe ser 5");
    }

    @Test
    @Timeout(5)
    void testToString() {
        // Verificar la representación en cadena de los caballos
        assertEquals("Caballo blanco", caballoBlanco.toString(),
                "La representación en cadena debe ser 'Caballo blanco'");
        assertEquals("Caballo negro", caballoNegro.toString(), "La representación en cadena debe ser 'Caballo negro'");
    }

    @Test
    @Timeout(5)
    void testSettersAndGetters() {
        // Verificar los métodos setter y getter para la posición
        caballoBlanco.setPosx(6);
        caballoBlanco.setPosy(7);
        assertEquals(6, caballoBlanco.getPosx(), "La posición x debe ser 6");
        assertEquals(7, caballoBlanco.getPosy(), "La posición y debe ser 7");
    }

    @Test
    @Timeout(5)
    void testSetNegro() {
        caballoBlanco2 = new Caballo(false, 4, 4);
        // Verificar el valor inicial
        assertFalse(caballoBlanco2.isNegro(), "Inicialmente, la pieza debería ser blanca");

        // Cambiar el valor a negro
        caballoBlanco2.setNegro(true);
        assertTrue(caballoBlanco2.isNegro(), "La pieza debería ser negra después de llamar a setNegro(true)");

        // Cambiar el valor a blanco
        caballoBlanco2.setNegro(false);
        assertFalse(caballoBlanco2.isNegro(), "La pieza debería ser blanca después de llamar a setNegro(false)");
    }
}
