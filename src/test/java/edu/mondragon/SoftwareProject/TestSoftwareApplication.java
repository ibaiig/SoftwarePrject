package edu.mondragon.SoftwareProject;

import org.junit.jupiter.api.Test;

import edu.mondragon.SoftwareProject.SoftwareProjectApplication.Color;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.BeforeEach;

class TestSoftwareApplication {

    private SoftwareProjectApplication app;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inContent;

    @BeforeEach
    void setUp() {
        app = new SoftwareProjectApplication();
        System.setOut(new PrintStream(outContent));

    }

    @Test
    void testEnumValues() {
        // Comprobar que los valores del enum son los correctos
        assertEquals(Color.BLANCO, Color.valueOf("BLANCO"));
        assertEquals(Color.NEGRO, Color.valueOf("NEGRO"));
    }


    @Test
    void testPiezaToChar() {
        // Testea Torre negra y blanca
        Torre torreNegra = new Torre(true, 0, 0);
        Torre torreBlanca = new Torre(false, 0, 0);
        assertEquals('T', app.piezaToChar(torreNegra), "La torre negra debe representarse como 'T'");
        assertEquals('t', app.piezaToChar(torreBlanca), "La torre blanca debe representarse como 't'");

        // Testea Caballo negro y blanco
        Caballo caballoNegro = new Caballo(true, 0, 0);
        Caballo caballoBlanco = new Caballo(false, 0, 0);
        assertEquals('C', app.piezaToChar(caballoNegro), "El caballo negro debe representarse como 'C'");
        assertEquals('c', app.piezaToChar(caballoBlanco), "El caballo blanco debe representarse como 'c'");

        // Testea Alfil negro y blanco
        Alfil alfilNegro = new Alfil(true, 0, 0);
        Alfil alfilBlanco = new Alfil(false, 0, 0);
        assertEquals('A', app.piezaToChar(alfilNegro), "El alfil negro debe representarse como 'A'");
        assertEquals('a', app.piezaToChar(alfilBlanco), "El alfil blanco debe representarse como 'a'");

        // Testea Dama negra y blanca
        Dama damaNegra = new Dama(true, 0, 0);
        Dama damaBlanca = new Dama(false, 0, 0);
        assertEquals('D', app.piezaToChar(damaNegra), "La dama negra debe representarse como 'D'");
        assertEquals('d', app.piezaToChar(damaBlanca), "La dama blanca debe representarse como 'd'");

        // Testea Rey negro y blanco
        Rey reyNegro = new Rey(true, 0, 0);
        Rey reyBlanco = new Rey(false, 0, 0);
        assertEquals('R', app.piezaToChar(reyNegro), "El rey negro debe representarse como 'R'");
        assertEquals('r', app.piezaToChar(reyBlanco), "El rey blanco debe representarse como 'r'");

        // Testea Peón negro y blanco
        Peon peonNegro = new Peon(true, 0, 0);
        Peon peonBlanco = new Peon(false, 0, 0);
        assertEquals('P', app.piezaToChar(peonNegro), "El peón negro debe representarse como 'P'");
        assertEquals('p', app.piezaToChar(peonBlanco), "El peón blanco debe representarse como 'p'");

        // Testea pieza desconocida (debe devolver '?')
        Pieza piezaDesconocida = new Pieza(true, 0, 0) {
            @Override
            public boolean checkMovement(Movimiento movimiento) {
                return false;
            }

            @Override
            public String toString() {
                return "Desconocida";
            }
        };
        assertEquals('?', app.piezaToChar(piezaDesconocida), "Una pieza desconocida debe representarse como '?'");
    }

    @Test
    void testMenu() {
        // Simular las entradas del usuario
        String simulatedInput = "0 0\n9 9\n0 1\n9 9\n"; // Primera entrada válida (0 0), luego movimiento inválido (9 9), luego válido (0 1), y movimiento inválido (9 9)
        inContent = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inContent); // Establecemos la entrada simulada
    
        // Redirigir la salida estándar para capturar la impresión del método
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
    
        // Ejecutamos el método menu() en un hilo para evitar el bucle infinito
        Thread gameThread = new Thread(() -> {
            try {
                app.menu(); // Llamar al método menu
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        gameThread.start();
    
        try {
            // Esperamos un poco más de tiempo para que el primer turno de blanco y el primer turno de negro se procesen
            gameThread.join(6000); // Aumentamos el tiempo de espera, podría ser necesario más tiempo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        // Verificamos que las salidas incluyen los mensajes esperados
        String output = salida.toString();
    
        // Verifica que el mensaje para el primer turno del jugador blanco esté presente
        assertTrue(output.contains("*********** MUEVE BLANCO ***********"), "Debe mostrar el turno de blanco");
    
        // Verifica que el mensaje de turno de negro no aparezca antes de un movimiento válido de blanco
        assertFalse(output.contains("*********** MUEVE NEGRO ***********"), "El turno de negro no debe mostrarse antes de un movimiento válido");
    
        // Verifica que el turno de negro aparece después del primer movimiento válido de blanco
        assertFalse(output.contains("*********** MUEVE NEGRO ***********"), "Debe mostrar el turno de negro después del primer movimiento válido de blanco");
    }
    
}
