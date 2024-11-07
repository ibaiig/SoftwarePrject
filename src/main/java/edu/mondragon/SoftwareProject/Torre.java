package edu.mondragon.softwareproject;

public class Torre extends Pieza{
    public Torre(int posx, int posy, boolean white) {
        super(white, posx, posy);
    }

    public boolean checkMovement(Movimiento movimiento){
        
        int destinoX = movimiento.getPosX();
        int destinoY = movimiento.getPosY();

        boolean esMovimientoHorizontalVertical = (this.posx == destinoX || this.posy == destinoY);

        boolean dentroDelTablero = (destinoX >= 1 && destinoX <= 8 && destinoY >= 1 && destinoY <= 8);

        return esMovimientoHorizontalVertical && dentroDelTablero;
    }
    @Override
    public String toString(){
        return "Torre";
    }
}
