package edu.mondragon.SoftwareProject;
/*
 * public class Peon extends Pieza{

 */
/*   private boolean white;

    public Peon(int posX, int posy, boolean white){
        this.posX = posX;
        this.posy = posy;
        this.white = white;
    }

    public boolean mover(Movimiento movimiento){
        if(checkMovement(movimiento)){
            this.posX = movimiento.getPosX();
            this.posy = movimiento.getPosY();
            return true;
        }
        else{
            return false;
        }
    }   
    
    public boolean checkMovement(Movimiento movimiento){
        boolean legal = false;
        
        if(white && this.posy == 2)
        {
            legal = checkWhite(movimiento);
            
        }else if(white && this.posy != 2)
        {
            if(this.posX == movimiento.getPosX())
            {
                if((movimiento.getPosY() == (this.posy -1))){
                    legal = true;
                }else{
                    legal = false;
                }
            }else{
                legal = false;
            }
        }
        return legal;
    }

    public boolean checkWhite(Movimiento movimiento){
        if(this.posy == 2)
        {
            if(this.posX == movimiento.getPosX())
            {
                if((movimiento.getPosY() == (this.posy - 2)) || (movimiento.getPosY() == (this.PosY -1))){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        }else if(this.posY != 2)
        {
            if(this.posX == movimiento.getPosX())
            {
                if((movimiento.getPosY() == (this.posY -1))){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }
 */ 
}
