package edu.mondragon.softwareproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mondragon.softwareproject.Caballo;

import static org.junit.jupiter.api.Assertions.*;

class TestPieza {

    private Caballo caballoBlanco;
    private Caballo caballoNegro;

    @BeforeEach
    public void setUp() {
        // Inicializar caballos en posiciones específicas
        caballoBlanco = new Caballo(false, 4, 4); // Caballo blanco en (4,4)
        caballoNegro = new Caballo(true, 5, 5); // Caballo negro en (5,5)
    }

    @Test
    void testConstructorCaballoBlanco() {
        // Verificar que el caballo blanco se inicializa correctamente
        assertFalse(caballoBlanco.isNegro(), "El caballo debe ser blanco");
        assertEquals(4, caballoBlanco.getPosx(), "La posición x debe ser 4");
        assertEquals(4, caballoBlanco.getPosy(), "La posición y debe ser 4");
    }

    @Test
    void testConstructorCaballoNegro() {
        // Verificar que el caballo negro se inicializa correctamente
        assertTrue(caballoNegro.isNegro(), "El caballo debe ser negro");
        assertEquals(5, caballoNegro.getPosx(), "La posición x debe ser 5");
        assertEquals(5, caballoNegro.getPosy(), "La posición y debe ser 5");
    }

    @Test
    void testToString() {
        // Verificar la representación en cadena de los caballos
        assertEquals("Caballo blanco", caballoBlanco.toString(),
                "La representación en cadena debe ser 'Caballo blanco'");
        assertEquals("Caballo negro", caballoNegro.toString(), "La representación en cadena debe ser 'Caballo negro'");
    }

    @Test
    void testSettersAndGetters() {
        // Verificar los métodos setter y getter para la posición
        caballoBlanco.setPosx(6);
        caballoBlanco.setPosy(7);
        assertEquals(6, caballoBlanco.getPosx(), "La posición x debe ser 6");
        assertEquals(7, caballoBlanco.getPosy(), "La posición y debe ser 7");
    }
}
