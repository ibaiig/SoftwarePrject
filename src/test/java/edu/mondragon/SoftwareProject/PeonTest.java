package edu.mondragon.SoftwareProject;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class PeonTest {
    Peon peon;

    @Before
    public void setPeon(){
        peon = new Peon(1,2,true);
    }

    @Test(timeout = 3000)
    public void whitePeonMovesTwo()
    {
        boolean check = peon.checkMovement(new Movimiento(1, 4));
        assertEquals(check, true);
    }

    @Test(timeout = 3000)
    public void whitePeonMovesRight()
    {
        boolean check = peon.mover(new Movimiento(2, 4));
        assertEquals(check, false);
    }

    @Test(timeout = 3000)
    public void whitePeonMovesForwardOne(){
        boolean check = peon.mover(new Movimiento(1, 3));
        assertEquals(true, check);
    }

    @Test(timeout = 3000)
    public void whitePeonMovesForwadsExcessive(){
        boolean check = peon.mover(new Movimiento(1, 5));
        assertEquals(check, true);
    }

    @Test(timeout = 3000)
    public void movementSetters(){
        Movimiento movimiento = new Movimiento(1, 2);
        assertEquals(1, movimiento.getPosX());
        assertEquals(2, movimiento.getPosY());
    }
}
