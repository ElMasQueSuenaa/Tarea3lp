package Planetas;
import java.util.concurrent.ThreadLocalRandom;
import Interactuable.Jugador;
import Interactuable.Nave;
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
        System.out.println("Visitando asentamiento en planeta Oceánico");
        System.out.println("Hay entidades parecidas a humanos, pero con branquias en el cuello");
        System.out.println("Hay que adaptarse para sobrevivir");
        System.out.println("Debería haber un comerciante en alguna ciudad sobre el agua");
        System.out.println("Decides seguir un puente de coral que te lleva a una cueva");
        System.out.println("Hay que protegerse del sol, piel seca no es buena señal");
        System.out.println("Al final del puente, encuentras una criatura con una tienda de campaña");
        System.out.println("Ves un cartel que dice '╮ɟ⌈∀⊲ə╭'");
        System.out.println("Probablemente sea el nombre del comerciante");
        System.out.println("Entras a la tienda, hay un tipo de tiburón humanoide y en la mesa hay 4 ofertas");
        System.out.println("El comerciante te mira a los ojos y apunta a las ofertas");
        System.out.println("1. Mejora de eficiencia de traje: 10.0% de eficiencia por 10000 unidades de Platino");
        System.out.println("2. Comprar Cristales de Hidrógeno: 1000 cristales de hidrógeno por 3000 unidades de Platino");
        System.out.println("3. Comprar Flores de Sodio: 2000 flores de sodio por 50 unidades de Platino"); 
        System.out.println("4. Comprar Uranio: 80 unidades de Uranio por 40000 unidades de Platino");
        System.out.println("El comerciante te mira esperando tu elección");
    }

    public void asignarTrade(int opcion, Jugador jugador, Nave nave) {
        int precio = 0;
        int cantidad = 0;
        float mejora = 0.0f;

        switch (opcion) {
            case 1:
                precio = 10000;
                mejora = 10.0f;
                System.out.println("Eficiencia de nave " + mejora + " unidades por " + precio + " unidades de Platino.");
                jugador.tradePlatino(precio);
                nave.setEficienciaCombustible(nave.getEficienciaCombustible() + mejora);
                break;

            case 2:
                precio = 3000;
                cantidad = 1000;
                System.out.println("Has comprado " + cantidad + " Cristales de Hidrógeno por " + precio + " unidades de Platino.");
                jugador.tradePlatino(precio);
                jugador.recolectarCristales(cantidad);
                break;

            case 3:
                precio = 2000;
                cantidad = 50;
                System.out.println("Has comprado " + cantidad + " Flores de Sodio por " + precio + " unidades.");
                jugador.tradePlatino(precio);
                jugador.recolectarFlores(cantidad);
                break;

            case 4:
                precio = 40000;
                cantidad = 80;
                System.out.println("Has comprado " + cantidad + " unidades de Uranio por " + precio + " unidades.");
                jugador.tradePlatino(precio);
                jugador.recolectarUranio(cantidad);
                break;

            default:
                System.out.println("Decidiste no intercambiar nada.");
                break;
        }
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
