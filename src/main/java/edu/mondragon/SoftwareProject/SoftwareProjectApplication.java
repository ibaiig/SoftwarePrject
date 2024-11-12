package edu.mondragon.SoftwareProject;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareProjectApplication {

    public enum Color {
        BLANCO,
        NEGRO
    }

    private Tablero tablero;

    public void imprimirTablero() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero.getTablero()[i][j];
                if (pieza == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(piezaToChar(pieza) + " ");
                }
            }
            System.out.println();
        }
    }

    private char piezaToChar(Pieza pieza) {
        if (pieza instanceof Torre) {
            return pieza.isNegro() ? 'T' : 't';
        } else if (pieza instanceof Caballo) {
            return pieza.isNegro() ? 'C' : 'c';
        } else if (pieza instanceof Alfil) {
            return pieza.isNegro() ? 'A' : 'a';
        } else if (pieza instanceof Dama) {
            return pieza.isNegro() ? 'D' : 'd';
        } else if (pieza instanceof Rey) {
            return pieza.isNegro() ? 'R' : 'r';
        } else if (pieza instanceof Peon) {
            return pieza.isNegro() ? 'P' : 'p';
        }
        return '?';
    }

    public void menu() {
        tablero = new Tablero();
        Scanner scanner = new Scanner(System.in);
        Boolean jugadorNegro = false;
        while (true) {
            if (!jugadorNegro)
                System.out.println("*********** MUEVE BLANCO ***********");
            else
                System.out.println("*********** MUEVE NEGRO ***********");

            imprimirTablero();
            System.out.println("Introduce las coordenadas de la pieza que quieres mover (formato: x y): ");
            int xOrigen = scanner.nextInt();
            int yOrigen = scanner.nextInt();
            System.out.println("Introduce las coordenadas de destino (formato: x y): ");
            int xDestino = scanner.nextInt();
            int yDestino = scanner.nextInt();

            if (!tablero.moverPieza(jugadorNegro, xOrigen, yOrigen, new Movimiento(xDestino, yDestino))) {

            }
            jugadorNegro = !jugadorNegro;

        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SoftwareProjectApplication.class, args);
        SoftwareProjectApplication app = new SoftwareProjectApplication();
        app.menu();
    }

}