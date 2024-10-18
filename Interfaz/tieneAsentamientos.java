package Interfaz;

import Interactuable.Jugador;
import Interactuable.Nave;

    
public interface tieneAsentamientos {

    ////////////////////
    //visitarAsentamientos(Jugador jugador)
    //jugador: jugador que visita los asentamientos
    //------------------
    //Método abstracto que permite al jugador visitar los asentamientos del planeta
    //------------------
    //No retorna nada
    ///////////////////
    
    void visitarAsentamientos(Jugador jugador);

    ////////////////////
    //asignarTrade(int opcion, Jugador jugador, Nave nave)
    //opcion: opción de comercio seleccionada
    //jugador: jugador que realiza el comercio
    //nave: nave del jugador
    //------------------
    //Método abstracto que permite al jugador realizar un comercio con los asentamientos del planeta
    //------------------
    //No retorna nada
    ///////////////////

    void asignarTrade(int opcion, Jugador jugador, Nave nave);
}

