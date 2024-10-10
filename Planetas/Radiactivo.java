package Planetas;
import java.util.Scanner;

import Interactuable.*;
public class Radiactivo extends Planeta {
    private int radiacion;
    private int uranio;

    public Radiactivo(int radio, int cristalesHidrogeno, int floresDeSodio, int radiacion, int uranio) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.radiacion = radiacion;
        this.uranio = uranio;
    }

    @Override
    public boolean visitar(Jugador jugador) {
        int tipo_recurso, cantidad_recurso;
        float aux;
        Scanner scanner = new Scanner(System.in);
        float energiaConsumida = (float)(0.3 * radiacion);
        System.out.println("Visitando planeta Radiactivo con radiacion de: " + radiacion + "sieverts");
        System.out.println("Deseas extraer recursos del planeta? (true/false)");
        boolean extraer = scanner.nextBoolean();
        if (extraer == true){
            System.out.println("Que recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio, 3 para Uranio");
            tipo_recurso = scanner.nextInt();
            cantidad_recurso = extraerRecursos(tipo_recurso);

            if(tipo_recurso == 1){
                jugador.recolectarCristales(cantidad_recurso);
            }
            else if(tipo_recurso == 2){
                jugador.recolectarFlores(cantidad_recurso);
            }
            else if(tipo_recurso == 3){
                jugador.recolectarUranio(cantidad_recurso);
            }

            aux = (float)(0.5 * cantidad_recurso * (energiaConsumida/100)* (1 - jugador.getEficienciatraje()));
            if (jugador.getEnergia() <= aux){
                System.out.println("El jugador no tiene suficiente energía para explorar más.");
                System.out.println("Todo comienza de nuevo");
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
    public int extraerRecursos(int tipo){
        int cantidad_recurso = 0;
        if(tipo == 1){
            cantidad_recurso = this.getCristalesHidrogeno();
        }
        else if(tipo == 2){
            cantidad_recurso = this.getFloresDeSodio();
        }
        else if(tipo == 3){
            cantidad_recurso = this.getUranio();
        }
        return cantidad_recurso;
    }
    
    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }
    
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    public int getUranio(){
        return uranio;
    }
}
