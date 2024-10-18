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

    ////////////////////
    //Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura)
    //radio: radio del planeta
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //temperatura: temperatura del planeta
    //------------------
    //Constructor de la clase Helado, asigna los valores de los atributos
    ///////////////////

    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.temperatura = temperatura;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
        this.radio = radio;
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
        if(aux < 51){
            this.asentamiento = true;
        }
        else{
            this.asentamiento = false;
        }
    }

    ////////////////////
    //getAsentamiento()
    //No recibe parámetros
    //------------------
    //Método que retorna el valor de la variable asentamiento
    //------------------
    //Retorna el valor de la variable asentamiento
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
    //Retorna la cantidad de recursos disponibles para que el main lo maneje
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
    //retorna la cantidad de recursos a extraer
    //------------------
    //Retorna la cantidad de recursos a extraer
    ///////////////////

    public int setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
        return cantidadExtraer;
    }

    ////////////////////
    //visitarAsentamientos(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que permite al jugador visitar los asentamientos del planeta y comerciar con los habitantes, muestra las opciones de comercio
    //------------------
    //No retorna nada
    ///////////////////

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

    ////////////////////
    //salir()
    //No recibe parámetros
    //------------------
    //Método que permite salir del planeta
    //------------------
    //Retorna siempre true
    ///////////////////
    
    @Override
    public boolean salir(){
        System.out.println("Saliendo del planeta Helado...");
        return true;
    }
    
    ////////////////////
    //getCristalesHidrogreno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrogeno en el planeta
    //------------------
    //Retorna la cantidad de cristales de hidrogeno en el planeta
    ///////////////////

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio en el planeta
    ///////////////////

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    ////////////////////
    //getRadio()
    //No recibe parámetros
    //------------------
    //Método que retorna el radio del planeta
    /////////////////// 

    public int getRadio() {
        return radio;
    }
}
