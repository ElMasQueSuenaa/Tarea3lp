package Planetas;

import Interactuable.*;

public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int cantidadExtraer;

    ////////////////////
    //Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura, int platino)
    //radio: radio del planeta
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //temperatura: temperatura del planeta
    //platino: cantidad de platino en el planeta
    //------------------
    //Constructor de la clase Volcanico, asigna los valores de los atributos
    ///////////////////

    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura, int platino) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        setTemperatura(temperatura);
        setPlatino(platino);
        setCristalesHidrogeno(cristalesHidrogeno);
        setFloresDeSodio(floresDeSodio);

    }

    ////////////////////
    //visitar(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que permite al jugador visitar el planeta y conocer todos los recursos que posee y caracteristicas del planeta
    ///////////////////
    
    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("Visitando planeta Volcanico con temperatura de: " + temperatura + "°C");
        System.out.println("Cristales de Hidrógeno: " + getCristalesHidrogeno());
        System.out.println("Flores de Sodio: " + getFloresDeSodio());
        System.out.println("Platino: " + getPlatino());
        return true;
    }

    ////////////////////
    //extraerRecursos(int tipo)
    //tipo: tipo de recurso a extraer
    //------------------
    //Método que permite extraer recursos del planeta, recibe el tipo de recurso a extraer y retorna la cantidad de recursos disponibles
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
    ///////////////////

    public void setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
    }

    ////////////////////
    //salir()
    //No recibe parámetros
    //------------------
    //Método que permite salir del planeta
    ///////////////////

    @Override
    public boolean salir(){
        System.out.println("Saliendo del planeta...");
        return true;
    }
    
    ////////////////////
    //setPlatino(int platino)
    //platino: cantidad de platino en el planeta
    //------------------
    //Método que asigna la cantidad de platino en el planeta
    ///////////////////

    public void setPlatino(int platino){
        this.platino = platino;
    }

    ////////////////////
    //getCristalesHidrogeno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrogeno en el planeta
    ///////////////////

    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio en el planeta
    ///////////////////
        
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    ////////////////////
    //getPlatino()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de platino en el planeta
    ///////////////////

    public int getPlatino(){
        return platino;
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
    ///////////////////

    public void setFloresDeSodio(int floresDeSodio){
        this.floresDeSodio = floresDeSodio;
    }

    ////////////////////
    //setTemperatura(int temperatura)
    //temperatura: temperatura del planeta
    //------------------
    //Método que asigna la temperatura del planeta
    ///////////////////

    public void setTemperatura(int temperatura){
        this.temperatura = temperatura;
    }

}