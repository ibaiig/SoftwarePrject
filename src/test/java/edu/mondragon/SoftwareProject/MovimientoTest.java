package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovimientoTest {

    private Movimiento movimiento;

    @BeforeEach
    public void setUp() {
        // Inicializar un objeto Movimiento con coordenadas iniciales
        movimiento = new Movimiento(3, 4);
    }

    @Test
    public void testConstructor() {
        // Verificar que el constructor asigna correctamente los valores
        assertEquals(3, movimiento.getPosX(), "El valor de posX debería ser 3");
        assertEquals(4, movimiento.getPosY(), "El valor de posY debería ser 4");
    }

    @Test
    public void testGetPosX() {
        // Verificar que getPosX devuelve el valor correcto
        assertEquals(3, movimiento.getPosX(), "getPosX debería devolver 3");
    }

    @Test
    public void testGetPosY() {
        // Verificar que getPosY devuelve el valor correcto
        assertEquals(4, movimiento.getPosY(), "getPosY debería devolver 4");
    }

    @Test
    public void testSetPosX() {
        // Probar el método setter para posX
        movimiento.setPosX(5);
        assertEquals(5, movimiento.getPosX(), "El valor de posX debería ser actualizado a 5");
    }

    @Test
    public void testSetPosY() {
        // Probar el método setter para posY
        movimiento.setPosY(6);
        assertEquals(6, movimiento.getPosY(), "El valor de posY debería ser actualizado a 6");
    }
}
