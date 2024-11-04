package edu.mondragon.SoftwareProject;


public class Caballo extends Pieza {
    
    public Caballo(boolean negro, int posx, int posy) {
        super(negro, posx, posy);
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
        return esMovimientoValido(movimiento);
    }

    // Comprobación del movimiento para un caballo blanco
    public boolean checkMovementblanca(Movimiento movimiento) {
        return esMovimientoValido(movimiento);
    }

    // Método privado que valida el movimiento en "L"
    private boolean esMovimientoValido(Movimiento movimiento) {
        int dx = Math.abs(movimiento.getPosX() - this.posx);
        int dy = Math.abs(movimiento.getPosY() - this.posy);

        // Verificar la forma en "L"
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    @Override
    public String toString() {
        return "Caballo " + (negro ? "negro" : "blanco");
    }
    
}

