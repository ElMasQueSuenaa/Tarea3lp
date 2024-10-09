package Planetas;
import Interactuable.*;
public class Radiactivo extends Planeta {
    private int radiacion;
    private int uranio;

    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.radiacion = radiacion;
        this.uranio = uranio;
    }

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha aterrizado en el planeta con un radio de " + radio + " metros.");
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
        System.out.println("Uranio: " + uranio);
        System.out.println("Flores de Sodio: " + floresDeSodio);
        System.out.println("Radiación: " + radiacion + " sievert.");
        return true;
    }
    public int calcularConsumoEnergia() {
        return (int) (0.3 * radiacion);
    }
    
    public int getRadiacion() {
        return radiacion;
    }

    public void setRadiacion(int radiacion) {
        this.radiacion = radiacion;
    }
}
