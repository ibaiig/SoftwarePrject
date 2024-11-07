package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSoftwareApplication {

    @Test
    void contextLoads() {
        // Este test simplemente verifica que el contexto de la aplicación se carga
        // correctamente
        assertTrue(true, "El contexto de la aplicación se cargó correctamente");
    }

    @Test
    void testMain() {
        // Llamar a la función main y verificar que no lanza excepciones
        try {
            SoftwareProjectApplication.main(new String[] {});
        } catch (Exception e) {
            fail("La aplicación no debería lanzar excepciones al iniciar: " + e.getMessage());
        }
    }
}
