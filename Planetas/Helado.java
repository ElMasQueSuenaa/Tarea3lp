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
        System.out.println("Visitando asentamiento en planeta Helado");
        System.out.println("Hay personas con pieles de animales que no conoces, todos te miran por vestir de distinta manera");
        System.out.println("Condiciones dificiles, generan gente dificil");
        System.out.println("Debería haber un comerciante en alguna cueva");
        System.out.println("La gente de este lugar debería tener las comunidades bajo tierra, para protegerse de las tormentas de hielo");
        System.out.println("Despues de recorrer el planeta, encuentras un cartel en un idioma que no entiendes");
        System.out.println("Decides seguir el camino que te lleva a una cueva");
        System.out.println("Dentro de la cueva hay una comunidad de seres nativos del planeta");
        System.out.println("Te ofrecen intercambiar recursos, pero no entiendes su idioma");
        System.out.println("Menos mal el trueque es un lenguaje universal");
        System.out.println("Te llevan a un tipo de taberna, donde el dueño del lugar te muestra 5 distintas ofertas");
        System.out.println("1. Mejora de eficiencia de nave: 15.0% de eficiencia por 1050 unidades de Platino");
        System.out.println("2. Mejora de eficiencia de traje: 10.0% de eficiencia por 850 unidades de Cristales de Hidrógeno");
        System.out.println("3. Comprar Flores de Sodio: 200 flores de sodio por 50 unidades de Platino"); 
        System.out.println("4. Comprar Uranio: 80 unidades de Uranio por 40 unidades de Platino");
        System.out.println("El comerciante te mira esperando tu elección");
    }

    public void asignarTrade(int opcion, Jugador jugador, Nave nave) {
        int precio = 0;
        int cantidad = 0;
        float mejora = 0.0f;

        switch (opcion) {
            case 1:
                precio = 1050;
                mejora = 15.0f;
                System.out.println("Eficiencia de nave " + mejora + "% por " + precio + " unidades de Platino.");
                jugador.tradePlatino(precio);
                nave.setEficienciaCombustible(nave.getEficienciaCombustible() + mejora);
                break;

            case 2:
                precio = 850;
                mejora = 10.0f;
                System.out.println("Eficiencia de traje " + mejora + "% por " + precio + " unidades de Platino.");
                jugador.tradePlatino(precio);
                jugador.recolectarCristales(cantidad);
                break;

            case 3:
                precio = 200;
                cantidad = 50;
                System.out.println("Has comprado " + cantidad + " Flores de Sodio por " + precio + " unidades.");
                jugador.tradePlatino(precio);
                jugador.recolectarFlores(cantidad);
                break;

            case 4:
                precio = 40;
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
