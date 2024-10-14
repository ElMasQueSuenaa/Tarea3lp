package Planetas;
import Interactuable.*;
public class CentroGalactico extends Planeta {

    public CentroGalactico() {
        super(1000000, 0, 0); 
    }


    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha llegado al Centro Galáctico.");
        return true;
    }
    
    public int calcularConsumoEnergia() {
        System.out.println("El Centro Galáctico consume toda la energía restante del jugador.");
        return Integer.MAX_VALUE;
    }

    public int extraerRecursos(int tipo) {
        System.out.println("El Centro Galáctico no tiene recursos para extraer, no tiene nada, solo nosotros y el tiempo.");
        System.out.println("Que es el tiempo sin que sea ciclico, que es el tiempo sin nosotros.");
        return 0;
    }

    @Override
    public boolean salir() {
        System.out.println("El jugador ha salido del Centro Galáctico.");
        return true;
    }
}