package edu.mondragon.SoftwareProject;

public class Dama extends Pieza {

    public Dama(boolean negro, int posx, int posy) {
        super(negro, posx, posy);
    }

    // Método para mover la dama
    public boolean checkMovement(Movimiento movimiento) {
        if (negro ? checkMovementnegra(movimiento) : checkMovementblanca(movimiento)) {
            this.posx = movimiento.getPosX();
            this.posy = movimiento.getPosY();
            return true;
        } else {
            return false;
        }
    }

    // Comprobación del movimiento para mover dama negra
    public boolean checkMovementnegra(Movimiento movimiento) {
        return esMovimientoValido(movimiento);
    }

    // Comprobación del movimiento para mover dama blanca
    public boolean checkMovementblanca(Movimiento movimiento) {
        return esMovimientoValido(movimiento);
    }

    // Método privado que valida el movimiento de dama
    private boolean esMovimientoValido(Movimiento movimiento) {
        int dx = Math.abs(movimiento.getPosX() - this.posx);
        int dy = Math.abs(movimiento.getPosY() - this.posy);

        if (movimiento.getPosX() < 0 || movimiento.getPosX() > 7 || movimiento.getPosY() < 0
                || movimiento.getPosY() > 7) {
            return false;
        }
        // Verificar movimiento horizontal, vertical o diagonal
        return dx == dy || dx == 0 || dy == 0;
    }

    @Override
    public String toString() {
        return "Dama " + (negro ? "negro" : "blanco");
    }
}
