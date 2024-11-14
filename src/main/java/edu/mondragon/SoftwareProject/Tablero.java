package edu.mondragon.SoftwareProject;

public class Tablero {

    private Pieza[][] tableroregistro;

    public Tablero() {
        tableroregistro = new Pieza[8][8];
        // Inicializar un tablero de 8x8
        hasieratu();
    }

    public void hasieratu() {
        // Colocar las piezas blancas
        tableroregistro[0][0] = new Torre(false, 0, 0);
        tableroregistro[0][1] = new Caballo(false, 0, 1);
        tableroregistro[0][2] = new Alfil(false, 0, 2);
        tableroregistro[0][3] = new Dama(false, 0, 3);
        tableroregistro[0][4] = new Rey(false, 0, 4);
        tableroregistro[0][5] = new Alfil(false, 0, 5);
        tableroregistro[0][6] = new Caballo(false, 0, 6);
        tableroregistro[0][7] = new Torre(false, 0, 7);

        for (int i = 0; i < 8; i++) {
            tableroregistro[1][i] = new Peon(false, 1, i);
        }

        // Colocar las piezas negras
        tableroregistro[7][0] = new Torre(true, 7, 0);
        tableroregistro[7][1] = new Caballo(true, 7, 1);
        tableroregistro[7][2] = new Alfil(true, 7, 2);
        tableroregistro[7][3] = new Dama(true, 7, 3);
        tableroregistro[7][4] = new Rey(true, 7, 4);
        tableroregistro[7][5] = new Alfil(true, 7, 5);
        tableroregistro[7][6] = new Caballo(true, 7, 6);
        tableroregistro[7][7] = new Torre(true, 7, 7);

        for (int i = 0; i < 8; i++) {
            tableroregistro[6][i] = new Peon(true, 6, i);
        }
    }

    public Pieza[][] getTablero() {
        return tableroregistro;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tableroregistro = tablero;
    }

    public boolean moverPieza(Boolean jugadorNegro, int xOrigen, int yOrigen, Movimiento movimiento) {

        Pieza pieza = getPiezaEnPosicion(xOrigen, yOrigen);

        if (pieza != null && pieza.checkMovement(movimiento) && Boolean.TRUE.equals(Boolean.TRUE.equals(jugadorNegro) == pieza.isNegro())) {

            pieza.setPosx(movimiento.getPosX());
            pieza.setPosy(movimiento.getPosY());
            tableroregistro[xOrigen][yOrigen] = null;
            tableroregistro[movimiento.getPosX()][movimiento.getPosY()] = pieza;
            return true;
        } else {
            return false;
        }
    }

    public Pieza getPiezaEnPosicion(int x, int y) {
        return tableroregistro[x][y];
    }

}
