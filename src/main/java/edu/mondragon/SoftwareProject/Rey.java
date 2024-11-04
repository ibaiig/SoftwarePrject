package edu.mondragon.SoftwareProject;

public class Rey extends Pieza {

    public Rey(boolean negro, int posx, int posy) {
        super(negro, posx, posy);
    }

    // Método para mover el rey
    public boolean mover(Movimiento movimiento) {
        if (negro ? checkMovementnegro(movimiento) : checkMovementblanca(movimiento)) {
            this.posx = movimiento.getPosX();
            this.posy = movimiento.getPosY();
            return true;
        } else {
            return false;
        }
    }

    // Comprobación del movimiento para un rey negro
    public boolean checkMovementnegro(Movimiento movimiento) {
        return esMovimientoValido(movimiento);
    }

    // Comprobación del movimiento para un rey blanco
    public boolean checkMovementblanca(Movimiento movimiento) {
        return esMovimientoValido(movimiento);
    }

    // Método privado que valida el movimiento de un rey (una casilla en cualquier dirección)
    private boolean esMovimientoValido(Movimiento movimiento) {
        int dx = Math.abs(movimiento.getPosX() - this.posx);
        int dy = Math.abs(movimiento.getPosY() - this.posy);

        // Verificar que el rey se mueva una casilla en cualquier dirección
        return (dx <= 1 && dy <= 1) && (dx + dy > 0);
    }

    @Override
    public String toString() {
        return "Rey " + (negro ? "negro" : "blanco");
    }
    
    
}
