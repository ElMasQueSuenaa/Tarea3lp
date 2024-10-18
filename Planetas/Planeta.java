package Planetas;
import Interactuable.*;
public abstract class Planeta {
    protected int radio;                 
    protected int cristalesHidrogeno;     
    protected int floresDeSodio;         

    ////////////////////
    //Planeta(int radio, int cristalesHidrogeno, int floresDeSodio)
    //radio: radio del planeta
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //------------------
    //Constructor de la clase Planeta, asigna los valores de los atributos
    ///////////////////

    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }

    ////////////////////
    //visitar(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Abstracto que permite al jugador visitar el planeta y conocer todos los recursos que posee y caracteristicas del planeta dependiendo del tipo del planeta
    //------------------
    //Retorna siempre true
    ///////////////////

    public abstract boolean visitar(Jugador jugador);

    ////////////////////
    //salir(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que imprime por pantalla que el jugador está saliendo del planeta
    //------------------
    //Retorna siempre true
    ///////////////////

    public boolean salir(Jugador jugador){
        System.out.println("Saliendo del planeta...");
        return true;
    }
    
    ////////////////////
    //extraerRecursos(int tipo)
    //tipo: tipo de recurso a extraer
    //------------------
    //Abstracto que permite extraer recursos del planeta dependiendo del tipo del planeta
    //------------------
    //Retorna un entero
    ///////////////////

    public abstract int extraerRecursos(int tipo);

    ////////////////////
    //getRadio()
    //No recibe parámetros
    //------------------
    //Método que retorna el valor de la variable radio
    //------------------
    //Retorna un entero
    ///////////////////

    public int getRadio() {
        return radio;
    }

    ////////////////////
    //setRadio(int radio)
    //radio: radio del planeta
    //------------------
    //Método que asigna un valor a la variable radio
    //------------------
    //No retorna nada
    ///////////////////

    public void setRadio(int radio) {
        this.radio = radio;
    }

    ////////////////////
    //getCristalesHidrogeno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrógeno en el planeta
    //------------------
    //Retorna un entero
    ///////////////////

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    ////////////////////
    //setCristalesHidrogeno(int cristalesHidrogeno)
    //cristalesHidrogeno: cantidad de cristales de hidrogeno en el planeta
    //------------------
    //Método que asigna un valor a la variable cristalesHidrogeno
    //------------------
    //No retorna nada
    ///////////////////

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio en el planeta
    //------------------
    //Retorna un entero
    ///////////////////

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    ////////////////////
    //setFloresDeSodio(int floresDeSodio)
    //floresDeSodio: cantidad de flores de sodio en el planeta
    //------------------
    //Método que asigna un valor a la variable floresDeSodio
    //------------------
    //No retorna nada
    ///////////////////

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }

    ////////////////////
    //salir()
    //No recibe parámetros
    //------------------
    //Abstracto que permite salir del planeta
    //------------------
    //Retorna un booleano
    ///////////////////

    public abstract boolean salir();
}
