package Planetas;
import java.util.Scanner;

import Interactuable.*;

public class Volcanico extends Planeta {
    private int temperatura;
    private int platino;
    private int cristalesHidrogeno;
    private int floresDeSodio;
    private int cantidadExtraer;

    public Volcanico(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura, int platino) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.temperatura = temperatura;
        this.platino = platino;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }
    
    @Override
    public boolean visitar(Jugador jugador) {
        int tipo_recurso, cantidad_recurso;
        float aux;
        Scanner scanner = new Scanner(System.in);
        float energiaConsumida = (float)(0.08 * temperatura);  // Consumo de energía 
        System.out.println("Visitando planeta Volcánico con temperatura de: " + temperatura + "°C");
        System.out.println("Deseas extraer recursos del planeta? 1 para si, 2 para no");
        int extraer = scanner.nextInt();
        if (extraer == 1){
            System.out.println("Que recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio, 3 para Platino");
            tipo_recurso = scanner.nextInt();
            cantidad_recurso = extraerRecursos(tipo_recurso);

            if(tipo_recurso == 1){
                jugador.recolectarCristales(cantidad_recurso);
            }
            else if(tipo_recurso == 2){
                jugador.recolectarFlores(cantidad_recurso);
            }
            else if(tipo_recurso == 3){
                jugador.recolectarPlatino(cantidad_recurso);
            }

            aux = (float)(0.5 * cantidad_recurso * (energiaConsumida/100)* (1 - jugador.getEficienciatraje()));
            if (jugador.getEnergia() <= aux){
                System.out.println("FCE: Oh no, insuficiente energía para explorar más.");
                System.out.println("FCE: Nos veremos otra vez número" + jugador.getNumeroJugador());
                scanner.close();
                return false;
            }
            else{
                jugador.setEnergia(jugador.getEnergia() - aux);
                scanner.close();
                return true;
            }
        }
        else{
            System.out.println("Volviendo a la orbita...");
            scanner.close();
            return true;
        }
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

    public void setCantidadExtraer(int cantidadExtraer) {
        this.cantidadExtraer = cantidadExtraer;
    }

    @Override
    public boolean salir(){
        System.out.println("Saliendo del planeta...");
        return true;
    }


    public void setPlatino(int platino){
        this.platino = platino;
    }

    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }
        
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    public int getPlatino(){
        return platino;
    }

}