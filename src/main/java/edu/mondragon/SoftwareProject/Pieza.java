package edu.mondragon.SoftwareProject;

// Clase abstracta Pieza en Java
public abstract class Pieza {

    protected boolean negro;  // Puede ser "blanco" o "negro"
    int posx;
    int posy;

    protected Pieza(boolean negro, int posX, int posy) {
        this.negro = negro;
        this.posx = posX;
        this.posy = posy;
    }

    public boolean isNegro() {
        return negro;
    }

    public void setNegro(boolean negro) {
        this.negro = negro;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public abstract boolean checkMovement(Movimiento movimiento);

    @Override
    public abstract String toString();
}