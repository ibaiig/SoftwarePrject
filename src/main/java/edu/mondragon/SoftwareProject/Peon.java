package edu.mondragon.SoftwareProject;

public class Peon extends Pieza {
    public Peon(boolean white, int posx, int posy) {
        super(white, posx, posy);
    }

    // Método para mover el caballo
    public boolean checkMovement(Movimiento movimiento) {
        if (negro ? checkMovementnegra(movimiento) : checkMovementblanca(movimiento)) {
            this.posx = movimiento.getPosX();
            this.posy = movimiento.getPosY();
            return true;
        } else {
            return false;
        }
    }

    // Comprobación del movimiento para un caballo negro
    public boolean checkMovementnegra(Movimiento movimiento) {
        return esMovimientoValidoNegro(movimiento);
    }

    // Comprobación del movimiento para un caballo blanco
    public boolean checkMovementblanca(Movimiento movimiento) {
        return esMovimientoValidoBlanco(movimiento);
    }

    // Método privado que valida el movimiento de un peón negro
    private boolean esMovimientoValidoNegro(Movimiento movimiento) {
        int dx = movimiento.getPosX() - this.posx;
        int dy = movimiento.getPosY() - this.posy;

        // Movimiento hacia adelante
        if (dx == -1 && dy == 0) {
            return true;
        }

        // Movimiento inicial de dos casillas
        if (this.posx == 6 && dx == -2 && dy == 0) {
            return true;
        }

        return false;
    }

    // Método privado que valida el movimiento de un peón blanco
    private boolean esMovimientoValidoBlanco(Movimiento movimiento) {
        int dx = movimiento.getPosX() - this.posx;
        int dy = movimiento.getPosY() - this.posy;

        // Movimiento hacia adelante
        if (dx == 1 && dy == 0) {
            return true;
        }

        // Movimiento inicial de dos casillas
        if (this.posx == 1 && dx == 2 && dy == 0) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return isNegro() ? "Peon Negro" : "Peon Blanco";
    }
}
