package Planetas;

import Interactuable.*;
public class Radiactivo extends Planeta {
    private int radiacion;
    private int uranio;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int cantidadExtraer;


    ////////////////////
    //Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio)
    //radio: radio del planeta
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //radiacion: radiación del planeta
    //uranio: cantidad de uranio en el planeta
    //------------------
    //Constructor de la clase Radiactivo, asigna los valores de los parámetros a los atributos de la clase, además de los atributos heredados de la clase Planeta
    //------------------
    //No retorna nada
    ///////////////////

    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        setRadiacion(radiacion);
        setUranio(uranio);
        setCristalesHidrogeno(cristalesHidrogeno);
        setFloresDeSodio(floresDeSodio);
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
        System.out.println("Visitando planeta Radiactivo con temperatura de: " + getRadiacion() + "Sieverts");
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        System.out.println("Uranio: " + getUranio());
        return true;
    }

    ////////////////////
    //salir()
    //No recibe parámetros
    //------------------    
    //Solo sirve para imprimir por consola que se está saliendo del planeta
    //retorna siempre true, pregunté en el foro por la función salir y me dijeron que usara el return si lo estimaba conveniente
    //le hice Override a la función salir de la clase Planeta ya que pensaba que se podía hacer algo más con la salida del planeta
    //pero no se me ocurrió nada, perdón por la confusión
    //------------------
    //Retorna siempre true
    ///////////////////

    @Override
    public boolean salir() {
        System.out.println("Saliendo del planeta...");
        return true;  // Solo retorna si la salida fue posible
    }

    ////////////////////
    //extraerRecursos(int tipo)
    //tipo: tipo de recurso a extraer
    //------------------
    //Método que se encarga de extraer recursos del planeta, recibe un tipo de recurso a extraer
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
        return cantidadDisponible - cantidadExtraer;  // Retorna los recursos disponibles para que el main lo maneje
    }

    ////////////////////
    //setCantidadExtraer(int cantidadExtraer)
    //cantidadExtraer: cantidad de recursos a extraer
    //------------------
    //Método que se encarga de asignar la cantidad de recursos a extraer
    //retorna la cantidad de recursos a extraer
    //------------------
    //Retorna la cantidad de recursos a extraer
    ///////////////////

    public int setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
        return cantidadExtraer;
    }

    ////////////////////
    //setUranio(int uranio)
    //uranio: cantidad de uranio en el planeta
    //------------------
    //Método que asigna la cantidad de uranio en el planeta
    //-----------------
    //No retorna nada
    ///////////////////

    public void setUranio(int uranio){
        this.uranio = uranio;
    }

    ////////////////////
    //setRadiacion(int radiacion)
    //radiacion: radiación del planeta
    //------------------
    //Método que asigna la radiación del planeta
    //------------------
    //No retorna nada
    ///////////////////

    public void setRadiacion(int radiacion){
        this.radiacion = radiacion;
    }

    ////////////////////
    //setCristalesHidrogeno(int cristalesHidrogeno)
    //cristalesHidrogeno: cantidad de cristales de hidrógeno en el planeta
    //------------------
    //Método que asigna la cantidad de cristales de hidrógeno en el planeta
    ///////////////////

    public void setCristalesHidrogeno(int cristalesHidrogeno){
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    ////////////////////
    //setFloresDeSodio(int floresDeSodio)
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //------------------
    //Método que asigna la cantidad de flores de sodio en el planeta
    ///----------------
    //No retorna nada
    ///////////////////

    public void setFloresDeSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }


    ////////////////////
    //getCristalesHidrogeno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrógeno en el planeta
    //------------------
    //Retorna la cantidad de cristales de hidrógeno en el planeta
    ///////////////////
    
    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio en el planeta
    //------------------
    //Retorna la cantidad de flores de sodio en el planeta
    ///////////////////
    
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    ////////////////////
    //getUranio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de uranio en el planeta
    //------------------
    //Retorna la cantidad de uranio en el planeta
    ///////////////////

    public int getUranio(){
        return uranio;
    }

    ////////////////////
    //getRadiacion()
    //No recibe parámetros
    //------------------
    //Método que retorna la radiación del planeta
    //------------------
    //Retorna la radiación del planeta
    ///////////////////

    public int getRadiacion(){
        return radiacion;
    }
}
