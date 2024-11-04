package edu.mondragon.SoftwareProject;

public class Peon extends Pieza {
    public Peon(int posx, int posy, boolean white) {
        super(white, posx, posy);
    }

    public boolean mover(Movimiento movimiento) {
        if (checkMovement(movimiento)) {
            this.posx = movimiento.getPosX();
            this.posy = movimiento.getPosY();
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMovement(Movimiento movimiento) {
        // Obtener posición de destino
        int destinoX = movimiento.getPosX();
        int destinoY = movimiento.getPosY();
        
        if (this.negro == false) {  // Si el peón es blanco
            return checkWhiteMovement(destinoX, destinoY);
        } else {  // Si el peón es negro
            return checkBlackMovement(destinoX, destinoY);
        }
    }

    private boolean checkWhiteMovement(int destinoX, int destinoY) {
        if (this.posx == destinoX) {  // Movimiento vertical
            if (this.posy == 2 && (destinoY == 3 || destinoY == 4)) {  // Desde posición inicial
                return true;
            } else if (destinoY == this.posy + 1) {  // Movimiento de una casilla adelante
                return true;
            }
        } else if (Math.abs(this.posx - destinoX) == 1 && destinoY == this.posy + 1) {  // Movimiento de captura diagonal
            return true;
        }
        return false;
    }

    private boolean checkBlackMovement(int destinoX, int destinoY) {
        if (this.posx == destinoX) {  // Movimiento vertical
            if (this.posy == 7 && (destinoY == 6 || destinoY == 5)) {  // Desde posición inicial
                return true;
            } else if (destinoY == this.posy - 1) {  // Movimiento de una casilla adelante
                return true;
            }
        } else if (Math.abs(this.posx - destinoX) == 1 && destinoY == this.posy - 1) {  // Movimiento de captura diagonal
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.negro ? "Peon Negro" : "Peon Blanco";
    }
}
