package Planetas;
import Interactuable.*;
public class CentroGalactico extends Planeta {

    public CentroGalactico() {
        super(1000000, 0, 0); 
    }


    @Override
    public boolean visitar(Jugador jugador) {
        if (Nave.getEficienciaCombustible() > 0.5) {
            System.out.println("El jugador ha llegado al Centro Galáctico, el final de su travesía.");
            System.out.println("El lugar es hostil, con campos gravitatorios extremos y fenómenos estelares.");
            return true;
        } else {
            System.out.println("La nave no es lo suficientemente eficiente para alcanzar el Centro Galáctico.");
            return false;
        }
    }
    
    public int calcularConsumoEnergia() {
        System.out.println("El Centro Galáctico consume toda la energía restante del jugador.");
        return Integer.MAX_VALUE;
    }
}

