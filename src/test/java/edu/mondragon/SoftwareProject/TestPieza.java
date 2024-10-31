package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPieza {
    
        private Caballo caballoBlanco;
        private Caballo caballoNegro;
    
        @BeforeEach
        public void setUp() {
            // Inicializar caballos en posiciones específicas
            caballoBlanco = new Caballo(false, 4, 4);  // Caballo blanco en (4,4)
            caballoNegro = new Caballo(true, 5, 5);    // Caballo negro en (5,5)
        }
    
        @Test
        public void testConstructorCaballoBlanco() {
            // Verificar que el caballo blanco se inicializa correctamente
            assertFalse(caballoBlanco.negro, "El caballo debe ser blanco");
            assertEquals(4, caballoBlanco.posx, "La posición x debe ser 4");
            assertEquals(4, caballoBlanco.posy, "La posición y debe ser 4");
        }
    
        @Test
        public void testConstructorCaballoNegro() {
            // Verificar que el caballo negro se inicializa correctamente
            assertTrue(caballoNegro.negro, "El caballo debe ser negro");
            assertEquals(5, caballoNegro.posx, "La posición x debe ser 5");
            assertEquals(5, caballoNegro.posy, "La posición y debe ser 5");
        }
    
        @Test
        public void testToString() {
            // Verificar la representación en cadena de los caballos
            assertEquals("Caballo blanco", caballoBlanco.toString(), "La representación en cadena debe ser 'Caballo blanco'");
            assertEquals("Caballo negro", caballoNegro.toString(), "La representación en cadena debe ser 'Caballo negro'");
        }
}
    
    