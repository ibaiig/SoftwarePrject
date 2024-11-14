package edu.mondragon.SoftwareProject;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class TestMovimiento {
    Movimiento movimiento;

    @Test
    public void TestMovimient() {
        movimiento = new Movimiento(1, 2);
        movimiento.setPosX(movimiento.getPosY());
        movimiento.setPosY(movimiento.getPosX());
        assertEquals(2,movimiento.getPosY());
    }
}
