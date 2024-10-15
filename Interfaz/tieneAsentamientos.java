package Interfaz;

import Interactuable.Jugador;
import Interactuable.Nave;

    
public interface tieneAsentamientos {

    void visitarAsentamientos(Jugador jugador);

    void asignarTrade(int opcion, Jugador jugador, Nave nave);
}

