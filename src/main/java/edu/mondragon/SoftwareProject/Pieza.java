package edu.mondragon.SoftwareProject;

// Clase abstracta Pieza en Java
public abstract class Pieza {

    protected boolean negro;  // Puede ser "blanco" o "negro"
    int posx, posy;

    public Pieza(boolean negro, int posX, int posy) {
        this.negro = negro;
        this.posx=posX;
        this.posy=posy;
    }
    
    @Override
    public abstract String toString();
}