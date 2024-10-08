package Planetas;

public class Oceanico extends Planeta {
    private int radiacion;

    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio) {
        super(radio, cristalesHidrogeno, floresDeSodio);
    }

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha aterrizado en el planeta con un radio de " + radio + " metros.");
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
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
