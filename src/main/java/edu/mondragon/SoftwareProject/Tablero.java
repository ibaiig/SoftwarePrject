package edu.mondragon.SoftwareProject;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isCheck(boolean jugadorNegro){
        Pieza rey = findKing(jugadorNegro);

        boolean enJaque = isThreatened(rey.getPosx(), rey.getPosy(), !jugadorNegro);

        if (enJaque) {
            boolean jaqueMate = checkMate(rey);
            if (jaqueMate) {
                System.out.println("Jaque mate al jugador " + (jugadorNegro ? "negro" : "blanco"));
            } else {
                System.out.println("Jaque al jugador " + (jugadorNegro ? "negro" : "blanco"));
            }
            return true;
        }
        return false;
    }

    private Pieza findKing(boolean jugadorNegro) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tableroregistro[i][j];
                if (pieza instanceof Rey && pieza.isNegro() == jugadorNegro) {
                    return pieza;
                }
            }
        }
        return null;
    }

    private boolean isThreatened(int x, int y, boolean enemigoNegro) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tableroregistro[i][j];
                if (pieza != null && pieza.isNegro() == enemigoNegro) {
                    // Si cualquier pieza enemiga puede moverse a la posición del rey, el rey está en jaque
                    Movimiento movimiento = new Movimiento(x, y);
                    if (pieza.checkMovement(movimiento)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkMate(Pieza rey) {
        // Intenta mover el rey a cualquier posición válida alrededor
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (int i = 0; i < 8; i++) {
            int newX = rey.getPosx() + dx[i];
            int newY = rey.getPosy() + dy[i];
            
            if (isPositionValid(newX, newY)) {
                Movimiento movimiento = new Movimiento(newX, newY);
                
                // Verifica si mover el rey aquí evitaría el jaque
                if (!isThreatened(newX, newY, !rey.isNegro())) {
                    return false; // Hay un movimiento válido que previene el jaque mate
                }
            }
        }

        // Si el rey no puede moverse, verifica si alguna pieza puede bloquear o capturar al atacante
        List<Pieza> piezasAliadas = getPiezasAliadas(rey.isNegro());
        for (Pieza pieza : piezasAliadas) {
            List<Movimiento> movimientos = generarMovimientos(pieza);
            for (Movimiento mov : movimientos) {
                if (pieza.checkMovement(mov) && puedeBloquearOComer(rey, mov)) {
                    return false; // Existe una pieza aliada que puede evitar el jaque mate
                }
            }
        }
        
        // Si no se encontró movimiento para el rey ni para bloquear, es jaque mate
        return true;
    }

    
    public List<Movimiento> generarMovimientos(Pieza pieza){
        List<Movimiento> movimientos = new ArrayList<>();
        int x = pieza.getPosx();
        int y = pieza.getPosy();

        // Generar movimientos para la Torre (horizontal y vertical)
        if (pieza instanceof Torre) {
            for (int i = 0; i < 8; i++) {
                if (i != x) movimientos.add(new Movimiento(i, y)); // Movimiento en la fila
                if (i != y) movimientos.add(new Movimiento(x, i)); // Movimiento en la columna
            }
        }

        // Generar movimientos para el Caballo (en "L")
        else if (pieza instanceof Caballo) {
            int[][] saltos = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
            for (int[] salto : saltos) {
                int nuevoX = x + salto[0];
                int nuevoY = y + salto[1];
                if (isPositionValid(nuevoX, nuevoY)) {
                    movimientos.add(new Movimiento(nuevoX, nuevoY));
                }
            }
        }

        // Generar movimientos para el Alfil (diagonales)
        else if (pieza instanceof Alfil) {
            for (int i = 1; i < 8; i++) {
                if (isPositionValid(x + i, y + i)) movimientos.add(new Movimiento(x + i, y + i)); // Diagonal abajo derecha
                if (isPositionValid(x + i, y - i)) movimientos.add(new Movimiento(x + i, y - i)); // Diagonal abajo izquierda
                if (isPositionValid(x - i, y + i)) movimientos.add(new Movimiento(x - i, y + i)); // Diagonal arriba derecha
                if (isPositionValid(x - i, y - i)) movimientos.add(new Movimiento(x - i, y - i)); // Diagonal arriba izquierda
            }
        }

        // Generar movimientos para la Dama (combinación de Torre y Alfil)
        else if (pieza instanceof Dama) {
            // Movimientos de Torre
            for (int i = 0; i < 8; i++) {
                if (i != x) movimientos.add(new Movimiento(i, y));
                if (i != y) movimientos.add(new Movimiento(x, i));
            }
            // Movimientos de Alfil
            for (int i = 1; i < 8; i++) {
                if (isPositionValid(x + i, y + i)) movimientos.add(new Movimiento(x + i, y + i));
                if (isPositionValid(x + i, y - i)) movimientos.add(new Movimiento(x + i, y - i));
                if (isPositionValid(x - i, y + i)) movimientos.add(new Movimiento(x - i, y + i));
                if (isPositionValid(x - i, y - i)) movimientos.add(new Movimiento(x - i, y - i));
            }
        }

        // Generar movimientos para el Rey (una casilla en cualquier dirección)
        else if (pieza instanceof Rey) {
            int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
            int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
            for (int i = 0; i < 8; i++) {
                int nuevoX = x + dx[i];
                int nuevoY = y + dy[i];
                if (isPositionValid(nuevoX, nuevoY)) {
                    movimientos.add(new Movimiento(nuevoX, nuevoY));
                }
            }
        }

        // Generar movimientos para el Peón (un o dos pasos adelante y captura diagonal)
        else if (pieza instanceof Peon) {
            int direccion = pieza.isNegro() ? -1 : 1; // Dirección hacia arriba para negros, abajo para blancos

            // Movimiento adelante (una casilla)
            int nuevoX = x + direccion;
            if (isPositionValid(nuevoX, y)) {
                movimientos.add(new Movimiento(nuevoX, y));
            }

            // Movimiento inicial (dos casillas adelante)
            if ((pieza.isNegro() && x == 6) || (!pieza.isNegro() && x == 1)) {
                nuevoX = x + 2 * direccion;
                if (isPositionValid(nuevoX, y)) {
                    movimientos.add(new Movimiento(nuevoX, y));
                }
            }

            // Captura en diagonal
            if (isPositionValid(x + direccion, y + 1)) {
                movimientos.add(new Movimiento(x + direccion, y + 1));
            }
            if (isPositionValid(x + direccion, y - 1)) {
                movimientos.add(new Movimiento(x + direccion, y - 1));
            }
        }

        return movimientos;
    }

    public boolean puedeBloquearOComer(Pieza rey, Movimiento mov) {
        Pieza piezaEnPos = getPiezaEnPosicion(mov.getPosX(), mov.getPosY());
        if (piezaEnPos != null && piezaEnPos.isNegro() != rey.isNegro()) {
            return true;
        }
        return false;
    }

    private List<Pieza> getPiezasAliadas(boolean jugadorNegro) {
        List<Pieza> piezasAliadas = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tableroregistro[i][j];
                if (pieza != null && pieza.isNegro() == jugadorNegro) {
                    piezasAliadas.add(pieza);
                }
            }
        }
        return piezasAliadas;
    }

    private boolean isPositionValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public Pieza getPiezaEnPosicion(int x, int y) {
        return tableroregistro[x][y];
    }

}
