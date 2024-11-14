package edu.mondragon.SoftwareProject;

public class Tablero {

    private Pieza[][] tablero;

    public Tablero() {
        tablero = new Pieza[8][8];
        // Inicializar un tablero de 8x8
        hasieratu();
    }

    public void hasieratu() {
        // Colocar las piezas blancas
        tablero[0][0] = new Torre(false, 0, 0);
        tablero[0][1] = new Caballo(false, 0, 1);
        tablero[0][2] = new Alfil(false, 0, 2);
        tablero[0][3] = new Dama(false, 0, 3);
        tablero[0][4] = new Rey(false, 0, 4);
        tablero[0][5] = new Alfil(false, 0, 5);
        tablero[0][6] = new Caballo(false, 0, 6);
        tablero[0][7] = new Torre(false, 0, 7);

        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(false, 1, i);
        }

        // Colocar las piezas negras
        tablero[7][0] = new Torre(true, 7, 0);
        tablero[7][1] = new Caballo(true, 7, 1);
        tablero[7][2] = new Alfil(true, 7, 2);
        tablero[7][3] = new Dama(true, 7, 3);
        tablero[7][4] = new Rey(true, 7, 4);
        tablero[7][5] = new Alfil(true, 7, 5);
        tablero[7][6] = new Caballo(true, 7, 6);
        tablero[7][7] = new Torre(true, 7, 7);

        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon(true, 6, i);
        }
    }

    public Pieza[][] getTablero() {
        return tablero;
    }

    public void setTablero(Pieza[][] tablero) {
        this.tablero = tablero;
    }

    public boolean moverPieza(Boolean jugadorNegro, int xOrigen, int yOrigen, Movimiento movimiento) {

        Pieza pieza = getPiezaEnPosicion(xOrigen, yOrigen);

        Pieza piezaDest = hayPiezaEnPosicion(movimiento.getPosX(), movimiento.getPosY());

        if (pieza != null && pieza.checkMovement(movimiento) && jugadorNegro == pieza.isNegro()
                && (piezaDest == null || piezaDest.isNegro() != jugadorNegro)
                && (peonComerDeFrente(pieza, piezaDest))) {

            pieza.setPosx(movimiento.getPosX());
            pieza.setPosy(movimiento.getPosY());
            tablero[xOrigen][yOrigen] = null;
            tablero[movimiento.getPosX()][movimiento.getPosY()] = pieza;
            return true;
        } else {
            return false;
        }
    }

    public Pieza getPiezaEnPosicion(int x, int y) {
        return tablero[x][y];
    }

    public Pieza hayPiezaEnPosicion(int x, int y) {
        return tablero[x][y];
    }

    public boolean peonComerDeFrente(Pieza pieza, Pieza piezaDest) {
        if (pieza instanceof Peon && piezaDest != null)
            return false;

        return true;
    }

}
