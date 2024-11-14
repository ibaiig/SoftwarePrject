package edu.mondragon.SoftwareProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SoftwareProjectApplication {
   
    private static final Map<Class<?>, Character> piezasBlancas = new HashMap<>();
    private static final Map<Class<?>, Character> piezasNegras = new HashMap<>();


    public enum Color {
        BLANCO,
        NEGRO
    }

    static {
        piezasBlancas.put(Torre.class, 't');
        piezasBlancas.put(Caballo.class, 'c');
        piezasBlancas.put(Alfil.class, 'a');
        piezasBlancas.put(Dama.class, 'd');
        piezasBlancas.put(Rey.class, 'r');
        piezasBlancas.put(Peon.class, 'p');

        piezasNegras.put(Torre.class, 'T');
        piezasNegras.put(Caballo.class, 'C');
        piezasNegras.put(Alfil.class, 'A');
        piezasNegras.put(Dama.class, 'D');
        piezasNegras.put(Rey.class, 'R');
        piezasNegras.put(Peon.class, 'P');
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
        if (pieza == null) return '?';

        return pieza.isNegro() 
                ? piezasNegras.getOrDefault(pieza.getClass(), '?')
                : piezasBlancas.getOrDefault(pieza.getClass(), '?');
    }


    public void menu() {
        tablero = new Tablero();
        Scanner scanner = new Scanner(System.in);
        Boolean jugadorNegro = false;
        do {

            if (Boolean.FALSE.equals(jugadorNegro))
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

            if (tablero.moverPieza(jugadorNegro, xOrigen, yOrigen, new Movimiento(xDestino, yDestino))) {
                jugadorNegro = !jugadorNegro;
            } else
                System.out.println("******************MOVIMIENTO ERRONEO******************");

        } while (true);
    }

    public static void main(String[] args) {
        SpringApplication.run(SoftwareProjectApplication.class, args);
        SoftwareProjectApplication app = new SoftwareProjectApplication();
        app.menu();
    }

}