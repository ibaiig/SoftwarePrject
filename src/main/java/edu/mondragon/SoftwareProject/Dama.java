package edu.mondragon.SoftwareProject;

public class Dama extends Pieza {

    public Dama(String color, int fila, int columna) {
        super(color, fila, columna);
    }

    @Override
    public boolean esMovimientoValido(int filaDestino, int columnaDestino, Pieza[][] tablero) {
        if (!estaDentroDelTablero(filaDestino, columnaDestino)) {
            return false;
        }

        // La Dama se mueve en línea recta o en diagonal
        int deltaFila = Math.abs(getFila() - filaDestino);
        int deltaColumna = Math.abs(getColumna() - columnaDestino);

        if ((getFila() == filaDestino || getColumna() == columnaDestino || deltaFila == deltaColumna)
                && !esDestinoOcupadoPorAliado(filaDestino, columnaDestino, tablero)) {
            return true;
        }
        return false;
    }
}
