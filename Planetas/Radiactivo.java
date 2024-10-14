package Planetas;

import Interactuable.*;
public class Radiactivo extends Planeta {
    private int radiacion;
    private int uranio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int cantidadExtraer;

    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.radiacion = radiacion;
        this.uranio = uranio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("Visitando planeta Helado con temperatura de: " + radiacion + "°C");
        return true;  // Solo retorna si la visita fue posible
    }

    @Override
    public boolean salir() {
        System.out.println("Saliendo del planeta...");
        return true;  // Solo retorna si la salida fue posible
    }

    @Override
    public int extraerRecursos(int tipo) {
        int cantidadDisponible = 0;

        if (tipo == 1) {
            cantidadDisponible = this.getCristalesHidrogeno();
        } else if (tipo == 2) {
            cantidadDisponible = this.getFloresDeSodio();
        } else {
            System.out.println("FCE: Tipo de recurso inválido.");
            return 0;
        }
        return cantidadDisponible - cantidadExtraer;  // Retorna los recursos disponibles para que el main lo maneje
    }

    public int setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
        return cantidadExtraer;
    }

    public void setUranio(int uranio){
        this.uranio = uranio;
    }
    
    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }
    
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    public int getUranio(){
        return uranio;
    }
}
