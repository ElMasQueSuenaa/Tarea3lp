package Planetas;

public class Oceanico extends Planeta {
    private int profundidad;

    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad) {
        super(radio, cristalesHidrogeno, floresDeSodio);
    }

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha aterrizado en el planeta con un radio de " + radio + " metros.");
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
        System.out.println("Flores de Sodio: " + floresDeSodio);
        System.out.println("Profundidad: " + profundidad + " metros.");
        return true;
    }
    public int calcularConsumoEnergia() {
        return (int) (0.65 * Math.pow(profundidad, 2));
    }
    
    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
