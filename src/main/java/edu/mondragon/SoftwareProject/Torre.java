package edu.mondragon.SoftwareProject;

public class Torre extends Pieza {

    public Torre(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int filaDestino, int columnaDestino, Pieza[][] tablero) {
        if (!estaDentroDelTablero(filaDestino, columnaDestino)) {
            return false;
        }

        // La Torre se mueve en línea recta horizontal o vertical
        if ((getFila() == filaDestino || getColumna() == columnaDestino)
                && !esDestinoOcupadoPorAliado(filaDestino, columnaDestino, tablero)) {
            return true;
        }
        return false;
    }
}