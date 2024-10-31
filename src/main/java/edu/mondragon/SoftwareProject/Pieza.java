package edu.mondragon.SoftwareProject;

import java.util.List;

// Clase abstracta Pieza en Java
public abstract class Pieza {

    protected boolean negro;  // Puede ser "blanco" o "negro"
    int posx, posy;

    public Pieza(boolean negro, int posX, int posy) {
        this.negro = negro;
        this.posx=posx;
        this.posy=posy;
    }
    
    @Override
    public abstract String toString();
}