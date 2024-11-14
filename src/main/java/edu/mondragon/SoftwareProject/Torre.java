package edu.mondragon.SoftwareProject;

public class Torre extends Pieza {
    public Torre( boolean white,int posx, int posy) {
        super(white, posx, posy);
    }

    public boolean checkMovement(Movimiento movimiento) {

        int destinoX = movimiento.getPosX();
        int destinoY = movimiento.getPosY();

        boolean esMovimientoHorizontalVertical = (this.posx == destinoX || this.posy == destinoY);

        boolean dentroDelTablero = (destinoX >= 0 && destinoX <= 7 && destinoY >= 0 && destinoY <= 7);

        return esMovimientoHorizontalVertical && dentroDelTablero;
    }

    @Override
    public String toString() {
        return "Torre";
    }
}
