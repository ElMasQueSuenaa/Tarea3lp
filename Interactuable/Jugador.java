package Interactuable;

public class Jugador {
    private int cristalesRecolectado;
    private int floresRecolectada;
    private int platinoRecolectado;
    private int uranioRecolectado;
    private float unidadesEnergiaProteccion;
    private float eficienciaEnergiaProteccion;

    public Jugador() {
        this.unidadesEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
        this.cristalesRecolectado = 0;
        this.floresRecolectada = 0;
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

    //crear recarga de traje
    public void recargarEnergiaProteccion(int sodio){
        if(this.unidadesEnergiaProteccion + sodio > 100.0f && this.floresRecolectada > 0){
            this.unidadesEnergiaProteccion = 100.0f;
            this.floresRecolectada = (int)(this.unidadesEnergiaProteccion - sodio);
            System.out.println("Traje recargado al 100%");  
            System.out.println("Flores de sodio restantes: " + this.floresRecolectada);
        }
        else if(this.unidadesEnergiaProteccion + sodio <= 100.0f && this.floresRecolectada > 0){
            this.unidadesEnergiaProteccion += sodio;
            this.floresRecolectada = (int)(this.unidadesEnergiaProteccion - sodio);
            System.out.println("Traje recargado al " + this.unidadesEnergiaProteccion + "%");
            System.out.println("Flores de sodio restantes: " + this.floresRecolectada);
        }
        else{
            System.out.println("No tienes suficientes flores de sodio para recargar el traje");
        }	
    }

}