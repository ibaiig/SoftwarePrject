package edu.mondragon.SoftwareProject;

public class Peon extends Pieza {
    public Peon(boolean white, int posx, int posy) {
        super(white, posx, posy);
    }

    @Override
    public boolean checkMovement(Movimiento movimiento) {
        // Obtener posición de destino
        int destinoX = movimiento.getPosX();
        int destinoY = movimiento.getPosY();

        if (!isNegro()) {
            return checkWhiteMovement(destinoX, destinoY);
        } else {
            return checkBlackMovement(destinoX, destinoY);
        }
    }

    private boolean checkWhiteMovement(int destinoX, int destinoY) {
        if (this.posx == destinoX) {
            if (this.posy == 2 && (destinoY == 3 || destinoY == 4)) {
                return true;
            } else if (destinoY == this.posy + 1) {
                return true;
            }
        } else if (Math.abs(this.posx - destinoX) == 1 && destinoY == this.posy + 1) {
            return true;
        }
        return false;
    }

    private boolean checkBlackMovement(int destinoX, int destinoY) {
        if (this.posx == destinoX) {
            if (this.posy == 7 && (destinoY == 6 || destinoY == 5)) {
                return true;
            } else if (destinoY == this.posy - 1) {
                return true;
            }
        } else if (Math.abs(this.posx - destinoX) == 1 && destinoY == this.posy - 1) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return isNegro() ? "Peon Negro" : "Peon Blanco";
    }
}
