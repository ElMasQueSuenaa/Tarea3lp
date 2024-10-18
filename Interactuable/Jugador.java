package Interactuable;

import java.util.concurrent.ThreadLocalRandom;

public class Jugador {
    private int cristalesRecolectado;
    private int floresRecolectada;
    private int platinoRecolectado;
    private int uranioRecolectado;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;
    private int numeroJugador;

    ////////////////////
    //Jugador()
    //------------------
    //Constructor de la clase Jugador, inicializa los atributos de la clase
    ///////////////////
    
    public Jugador() {
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.cristalesRecolectado = 0;
        this.floresRecolectada = 0;
        this.platinoRecolectado = 0;
        this.uranioRecolectado = 0;
        this.numeroJugador = ThreadLocalRandom.current().nextInt(1, 100001);
    }

    ////////////////////
    //setEnergia(float energia)
    //energia: cantidad de energía a setear
    //------------------
    //Método que setea la cantidad de energía del jugador con la cantidad de energía pasada por parámetro
    //------------------
    //No retorna nada
    ///////////////////

    public void setEnergia(float energia) {
        this.unidadesEnergiaProteccion += energia;
    }

    ////////////////////
    //setEficiencia(float eficiencia)
    //eficiencia: cantidad de eficiencia a setear
    //------------------
    //Método que setea la eficiencia del traje del jugador con la eficiencia pasada por parámetro
    //------------------
    //No retorna nada
    ///////////////////

    public void setEficiencia(float eficiencia) {
        this.eficienciaEnergiaProteccion += eficiencia;
    }

    ////////////////////
    //recolectarCristales(int cantidad)
    //cantidad: cantidad de cristales a recolectar
    //------------------
    //Método que recolecta cristales y los suma a la cantidad de cristales recolectados
    //------------------
    //No retorna nada
    ///////////////////

    public void recolectarCristales(int cantidad) {
        this.cristalesRecolectado += cantidad;
        //System.out.println("Cristales recolectados: " + this.cristalesRecolectado);
    }

    ////////////////////
    //recolectarFlores(int cantidad)
    //cantidad: cantidad de flores a recolectar
    //------------------
    //Método que recolecta flores y las suma a la cantidad de flores recolectadas
    //------------------
    //No retorna nada
    ///////////////////

    public void recolectarFlores(int cantidad) {
        this.floresRecolectada += cantidad;
        //System.out.println("Flores recolectadas: " + this.floresRecolectada);
    }

    ////////////////////
    //recolectarPlatino(int cantidad)
    //cantidad: cantidad de platino a recolectar
    //------------------
    //Método que recolecta platino y lo suma a la cantidad de platino recolectado
    //------------------
    //No retorna nada
    ///////////////////

    public void recolectarPlatino(int cantidad) {
        this.platinoRecolectado += cantidad;
        //System.out.println("Platino recolectado: " + this.platinoRecolectado);
    }

    ////////////////////
    //recolectarUranio(int cantidad)
    //cantidad: cantidad de uranio a recolectar
    //------------------
    //Método que recolecta uranio y lo suma a la cantidad de uranio recolectado
    //------------------
    //No retorna nada
    ///////////////////

    public void recolectarUranio(int cantidad) {
        this.uranioRecolectado += cantidad;
        //System.out.println("Uranio recolectado: " + this.uranioRecolectado);
    }

    ////////////////////
    //getCristalesHidrogeno()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de cristales de hidrógeno recolectados
    //------------------
    //Retorna la cantidad de cristales de hidrógeno recolectados
    ///////////////////

    public int getCristalesHidrogeno(){
        return cristalesRecolectado;
    }

    ////////////////////
    //getFloresDeSodio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de flores de sodio recolectadas
    //------------------
    //Retorna la cantidad de flores de sodio recolectadas
    ///////////////////

    public int getFloresDeSodio(){
        return floresRecolectada;
    }

    ////////////////////
    //getPlatino()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de platino recolectado
    //------------------
    //Retorna la cantidad de platino recolectado
    ///////////////////

    public int getPlatino(){
        return platinoRecolectado;
    }

    ////////////////////
    //getUranio()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de uranio recolectado
    //------------------
    //Retorna la cantidad de uranio recolectado
    ///////////////////

    public int getUranio(){
        return uranioRecolectado;
    }

    ////////////////////
    //tradeCristales(int cantidad)
    //cantidad: cantidad de cristales a intercambiar
    //------------------
    //Método que resta los cristales pasados por parámetro a la cantidad de cristales recolectados
    //------------------
    //No retorna nada
    ///////////////////

    public void tradeCristales(int cantidad) {
        this.cristalesRecolectado -= cantidad;
        //System.out.println("Cristales recolectados: " + this.cristalesRecolectado);
    }

    ////////////////////
    //tradeFlores(int cantidad)
    //cantidad: cantidad de flores a intercambiar
    //------------------
    //Método que resta las flores pasadas por parámetro a la cantidad de flores recolectadas
    //------------------
    //No retorna nada
    ///////////////////

    public void tradeFlores(int cantidad) {
        this.floresRecolectada -= cantidad;
        //System.out.println("Flores recolectadas: " + this.floresRecolectada);
    }

    ////////////////////
    //tradePlatino(int cantidad)
    //cantidad: cantidad de platino a intercambiar
    //------------------
    //Método que resta el platino pasado por parámetro a la cantidad de platino recolectado
    //------------------
    //No retorna nada  
    ///////////////////

    public void tradePlatino(int cantidad) {
        this.platinoRecolectado -= cantidad;
        //System.out.println("Platino recolectado: " + this.platinoRecolectado);
    }

    ////////////////////
    //tradeUranio(int cantidad)
    //cantidad: cantidad de uranio a intercambiar
    //------------------
    //Método que resta el uranio pasado por parámetro a la cantidad de uranio recolectado
    //------------------
    //No retorna nada
    ///////////////////

    public void tradeUranio(int cantidad) {
        this.uranioRecolectado -= cantidad;
        //System.out.println("Uranio recolectado: " + this.uranioRecolectado);
    }

    ////////////////////
    //getEnergia()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de energía del jugador
    //------------------
    //Retorna la cantidad de energía del jugador
    ///////////////////

    public float getEnergia() {
        return unidadesEnergiaProteccion;
    }

    ////////////////////
    //getEficienciaTraje()
    //No recibe parámetros
    //------------------
    //Método que retorna la eficiencia del traje del jugador
    //------------------
    //Retorna la eficiencia del traje del jugador
    ///////////////////

    public float getEficienciatraje(){
        return eficienciaEnergiaProteccion;
    }

    ////////////////////
    //CorroborarGastoEnergiaTraje(int cantidad_recurso_sacados)
    //cantidad_recurso_sacados: cantidad de recursos extraídos
    //------------------
    //Método que corrobora si se puede gastar la energía del traje
    //------------------
    //Retorna false si no se puede gastar la energía, true si se puede gastar la energía
    ///////////////////

    public boolean CorroborarGastoEnergiaTraje(int cantidad_recurso_sacados){
        float aux = (float) (0.5 * cantidad_recurso_sacados * (this.unidadesEnergiaProteccion/100) * (1 - this.eficienciaEnergiaProteccion));
        if(aux > this.unidadesEnergiaProteccion){
            return false;
        }
        else{
            return true;
        }
    }

    ////////////////////
    //gastarEnergiaTraje(int cantidad_recurso_sacados)
    //cantidad_recurso_sacados: cantidad de recursos extraídos
    //------------------
    //Método que gasta la energía del traje dependiendo de la cantidad de recursos extraídos
    //------------------
    //No retorna nada
    ///////////////////

    public void gastarEnergiaTraje(int cantidad_recurso_sacados){
        float aux = (float) (0.5 * cantidad_recurso_sacados * (this.unidadesEnergiaProteccion/100) * (1 - this.eficienciaEnergiaProteccion));
        this.unidadesEnergiaProteccion -= aux;
    }

    ////////////////////
    //recargarEnergiaProteccion(int sodio)
    //sodio: cantidad de sodio a recargar
    //------------------
    //Método que recarga la energía del traje dependiendo de la cantidad de sodio
    //------------------
    //No retorna nada
    ///////////////////

    public void recargarEnergiaProteccion(int sodio){
        float unidadesRecargadas = 0.65f * sodio * (1 + eficienciaEnergiaProteccion);
        if (sodio > 0) {
            System.out.println("FCE: Se ha recargado el tanque de combustible.");
            setEnergia(unidadesRecargadas);
            return;
        }
        else {
            System.out.println("FCE: No se puede recargar combustible con una cantidad negativa o nula de Sodio.");
        }
    }

    ////////////////////
    //getNumeroJugador()
    //No recibe parámetros
    //------------------
    //Método que retorna el número del jugador
    //------------------
    //Retorna el número del jugador
    ///////////////////
    
    public int getNumeroJugador(){
        return numeroJugador;
    }

}