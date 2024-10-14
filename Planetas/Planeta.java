package Planetas;
import Interactuable.*;
public abstract class Planeta {
    protected int radio;                 
    protected int cristalesHidrogeno;     
    protected int floresDeSodio;         

    // Constructor
    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }

    // Método para visitar el planeta
    public abstract boolean visitar(Jugador jugador);

    // Método para salir del planeta
    public boolean salir(Jugador jugador){
        System.out.println("Saliendo del planeta...");
        return true;
    }

    public abstract int extraerRecursos(int tipo);


    // Getters y Setters para los atributos
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    public abstract boolean salir();
}
