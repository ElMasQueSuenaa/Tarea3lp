package Planetas;

import java.util.Random;

public class Volcanico extends Planeta {
    private int temperatura;
    
    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura) {
        super(radio, cristalesHidrogeno, floresDeSodio);
    }
    

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha aterrizado en el planeta con un radio de " + radio + " metros.");
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
        System.out.println("Flores de Sodio: " + floresDeSodio);
        System.out.println("Temperatura: " + temperatura + " grados Celsius.");
        return true;
    }

    //revisar despues
    public int calcularConsumoEnergia() {
        return (int) (0.08 * temperatura); 
    }
    
    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
}
