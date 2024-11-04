package edu.mondragon.softwareproject;

import java.util.List;

// Clase abstracta Pieza en Java
public abstract class Pieza {

    protected boolean negro;  // Puede ser "blanco" o "negro"
    int posx, posy;

    public Pieza(boolean negro, int posX, int posy) {
        this.negro = negro;
        this.posx=posX;
        this.posy=posy;
    }
    
    public int getPosX() {
        return posx;
    }
    public void setPosX(int posX) {
        this.posx = posX;
    }
    public int getPosY() {
        return posy;
    }
    public void setPosY(int posY) {
        this.posy = posY;
    }

    public boolean isNegro() {
        return negro;
    }

    @Override
    public abstract String toString();
}