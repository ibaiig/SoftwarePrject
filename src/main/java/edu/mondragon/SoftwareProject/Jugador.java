package edu.mondragon.SoftwareProject;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    List<Pieza> piezas;
    List<Pieza> piezasComidas;
    boolean negro;

    public Jugador()
    {
        piezas = new ArrayList<>();
        piezasComidas = new ArrayList<>();
        inicializarPiezas();
    }

    public void inicializarPiezas(){
        if(negro == true)
        {
            piezas.add(new Pieza(negro, ));
        }else{

        }
    }

    public boolean moverPieza(Pieza pieza, Movimiento movimiento)
    {
        return pieza.checkMovement(movimiento);
    }

    public boolean haGanado(){
        if(piezasComidas.size() == ){
            return true;
        }else{
            return false;
        }
    }
}   
