package Planetas;
import java.util.concurrent.ThreadLocalRandom;
import Interactuable.Jugador;
import Interfaz.tieneAsentamientos;

public class Helado extends Planeta implements tieneAsentamientos {
    private int temperatura;
    private boolean asentamiento;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int radio;
    private int cantidadExtraer;

    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.temperatura = temperatura;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.radio = radio;
    }

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("Visitando planeta Helado con temperatura de: " + temperatura + "°C");
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        setAsentamiento();
        if(getAsentamiento() == true){
            System.out.println("Asentamiento: " + getAsentamiento());
        }
        else if(getAsentamiento() == false){
            System.out.println("Asentamiento: " + getAsentamiento());
        }
        return true;
    }

    public void setAsentamiento() {
        int aux = ThreadLocalRandom.current().nextInt(0, 101);
        if(aux < 51){
            this.asentamiento = true;
        }
        else{
            this.asentamiento = false;
        }
    }

    public boolean getAsentamiento() {
        return asentamiento;
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

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        asentamiento = true;
        System.out.println("Visitando asentamientos en el planeta Helado.");
        System.out.println("Comunidad de nativos encontrada.");
    }	

    @Override
    public boolean salir(){
        System.out.println("Saliendo del planeta Helado...");
        return true;
    }
    

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public int getRadio() {
        return radio;
    }
}
