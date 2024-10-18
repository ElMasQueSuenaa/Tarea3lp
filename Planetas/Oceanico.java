package Planetas;
import java.util.concurrent.ThreadLocalRandom;

import Interactuable.*;
import Interfaz.tieneAsentamientos;

public class Oceanico extends Planeta implements tieneAsentamientos {
    private int profundidad;
    private boolean asentamiento;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int cantidadExtraer;

    ////////////////////
    //Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad)
    //radio: radio del planeta
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //profundidad: profundidad del planeta
    //------------------
    //Constructor de la clase Oceanico, asigna los valores de los atributos
    //------------------
    //Retorna siempre true
    ///////////////////

    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.radio = radio;
        this.profundidad = profundidad;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }

    ////////////////////
    //visitar(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que permite al jugador visitar el planeta y conocer todos los recursos que posee y caracteristicas del planeta
    //------------------
    //Retorna siempre true
    ///////////////////

    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("Visitando planeta Oceanico con profundidad de: " + profundidad + "Metros");
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        setAsentamiento();
        if (getAsentamiento() == true) {
            System.out.println("Asentamiento: " + getAsentamiento());
        } else if (getAsentamiento() == false) {
            System.out.println("Asentamiento: " + getAsentamiento());
        }
        return true;
    }

    ////////////////////
    //getAsentamiento()
    //No recibe parámetros
    //------------------
    //Método que retorna el valor de la variable asentamiento
    //------------------
    //Retorna un booleano
    ///////////////////

    public boolean getAsentamiento() {
        return asentamiento;
    }

    ////////////////////
    //extraerRecursos(int tipo)
    //tipo: tipo de recurso a extraer
    //------------------
    //Método que permite extraer recursos del planeta, recibe el tipo de recurso a extraer y retorna la cantidad de recursos disponibles
    //------------------
    //Retorna la cantidad de recursos disponibles
    ///////////////////

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
        return cantidadDisponible - cantidadExtraer;
    }

    ////////////////////
    //setCantidadExtraer(int cantidadExtraer)
    //cantidadExtraer: cantidad de recursos a extraer
    //------------------
    //Método que asigna la cantidad de recursos a extraer
    //------------------
    //Retorna la cantidad de recursos a extraer
    ///////////////////

    public int setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
        return cantidadExtraer;
    }

    ////////////////////
    //getCristalesHidrogeno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrógeno en el planeta
    //------------------
    //Retorna la cantidad de cristales de hidrógeno
    ///////////////////

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio en el planeta
    //------------------
    //Retorna la cantidad de flores de sodio
    ///////////////////
    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    ////////////////////
    //salir()
    //No recibe parámetros
    //------------------
    //Método que permite salir del planeta
    //------------------
    //Retorna siempre true
    ///////////////////

    @Override
    public boolean salir() {
        System.out.println("Saliendo del planeta Oceánico...");
        return true;
    }

    ////////////////////
    //setAsentamiento()
    //No recibe parámetros
    //------------------
    //Método que asigna un valor aleatorio a la variable asentamiento
    //------------------
    //No retorna nada
    ///////////////////

    public void setAsentamiento() {
        int aux = ThreadLocalRandom.current().nextInt(0, 101);
        if (aux < 51) {
            this.asentamiento = true;
        } else {
            this.asentamiento = false;
        }
    }

    ////////////////////
    //visitarAsentamientos(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que permite al jugador visitar los asentamientos del planeta y se muestran las ofertas correspondientes
    //------------------
    //No retorna nada
    ///////////////////

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
        System.out.println("1. Mejora de eficiencia de traje: 10.0% de eficiencia por 1000 unidades de Platino");
        System.out.println("2. Comprar Cristales de Hidrógeno: 1000 cristales de hidrógeno por 25 unidades de Platino");
        System.out.println("3. Comprar Flores de Sodio: 200 flores de sodio por 50 unidades de Platino"); 
        System.out.println("4. Comprar Uranio: 80 unidades de Uranio por 40 unidades de Platino");
        System.out.println("El comerciante te mira esperando tu elección");
    }

    ////////////////////
    //asignarTrade(int opcion, Jugador jugador, Nave nave)
    //opcion: opción de comercio elegida por el jugador
    //jugador: jugador que comercia con el asentamiento
    //nave: nave del jugador
    //------------------
    //Método que asigna el comercio elegido por el jugador, recibe la opción de comercio, el jugador y la nave
    //Recibe al jugador y la nave para hacer las mejoras correspondientes y gastar los recursos necesarios
    //realiza el comercio y lo muestra
    //------------------
    //No retorna nada
    ///////////////////
    
    public void asignarTrade(int opcion, Jugador jugador, Nave nave) {
        int precio = 0;
        int cantidad = 0;
        float mejora = 0.0f;

        switch (opcion) {
            case 1:
                precio = 1000;
                mejora = 10.0f;
                System.out.println("Eficiencia de nave " + mejora + " unidades por " + precio + " unidades de Platino.");
                jugador.tradePlatino(precio);
                jugador.setEficiencia(jugador.getEficienciatraje() + mejora);
                break;

            case 2:
                precio = 25;
                cantidad = 1000;
                System.out.println("Has comprado " + cantidad + " Cristales de Hidrógeno por " + precio + " unidades de Platino.");
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
                System.out.println("Opción inválida. Elige un número entre 1 y 4.");
                break;
        }
    }
}
