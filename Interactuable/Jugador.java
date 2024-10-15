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

    public Jugador() {
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.cristalesRecolectado = 0;
        this.floresRecolectada = 0;
        this.platinoRecolectado = 0;
        this.uranioRecolectado = 0;
        this.numeroJugador = ThreadLocalRandom.current().nextInt(1, 100001);
    }

    public void setEnergia(float energia) {
        this.unidadesEnergiaProteccion += energia;
    }

    public void bebidaEnergetica() {
        this.unidadesEnergiaProteccion = 100.0f;
    }

    public void setEficiencia(float eficiencia) {
        this.eficienciaEnergiaProteccion += eficiencia;
    }

    public void recolectarCristales(int cantidad) {
        this.cristalesRecolectado += cantidad;
        //System.out.println("Cristales recolectados: " + this.cristalesRecolectado);
    }

    public void recolectarFlores(int cantidad) {
        this.floresRecolectada += cantidad;
        //System.out.println("Flores recolectadas: " + this.floresRecolectada);
    }

    public void recolectarPlatino(int cantidad) {
        this.platinoRecolectado += cantidad;
        //System.out.println("Platino recolectado: " + this.platinoRecolectado);
    }

    public void recolectarUranio(int cantidad) {
        this.uranioRecolectado += cantidad;
        //System.out.println("Uranio recolectado: " + this.uranioRecolectado);
    }

    public int getCristalesHidrogeno(){
        return cristalesRecolectado;
    }

    public int getFloresDeSodio(){
        return floresRecolectada;
    }

    public int getPlatino(){
        return platinoRecolectado;
    }

    public int getUranio(){
        return uranioRecolectado;
    }

    public void tradeCristales(int cantidad) {
        this.cristalesRecolectado -= cantidad;
        //System.out.println("Cristales recolectados: " + this.cristalesRecolectado);
    }

    public void tradeFlores(int cantidad) {
        this.floresRecolectada -= cantidad;
        //System.out.println("Flores recolectadas: " + this.floresRecolectada);
    }

    public void tradePlatino(int cantidad) {
        this.platinoRecolectado -= cantidad;
        //System.out.println("Platino recolectado: " + this.platinoRecolectado);
    }

    public void tradeUranio(int cantidad) {
        this.uranioRecolectado -= cantidad;
        //System.out.println("Uranio recolectado: " + this.uranioRecolectado);
    }

    public float getEnergia() {
        return unidadesEnergiaProteccion;
    }

    public float getEficienciatraje(){
        return eficienciaEnergiaProteccion;
    }

    public void comercio(int tipo_trade){

    }

    public boolean CorroborarGastoEnergiaTraje(int cantidad_recurso_sacados){
        float aux = (float) (0.5 * cantidad_recurso_sacados * (this.unidadesEnergiaProteccion/100) * (1 - this.eficienciaEnergiaProteccion));
        if(aux > this.unidadesEnergiaProteccion){
            return false;
        }
        else{
            return true;
        }
    }

    public void gastarEnergiaTraje(int cantidad_recurso_sacados){
        float aux = (float) (0.5 * cantidad_recurso_sacados * (this.unidadesEnergiaProteccion/100) * (1 - this.eficienciaEnergiaProteccion));
        this.unidadesEnergiaProteccion -= aux;
    }

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

    public int getNumeroJugador(){
        return numeroJugador;
    }

}