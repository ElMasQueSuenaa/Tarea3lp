package Planetas;
import java.time.temporal.JulianFields;
import java.util.Scanner;

import Interactuable.*;
import Interfaz.tieneAsentamientos;

public class Helado extends Planeta implements tieneAsentamientos{
    private int temperatura;
    private boolean asentamiento;
    
    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura) {
        super(radio, cristalesHidrogeno, floresDeSodio);
    }
    

    @Override
    public boolean visitar(Jugador jugador) {
        int tipo_recurso, cantidad_recurso;
        float aux;
        Scanner scanner = new Scanner(System.in);
        float energiaConsumida = (float)(0.15 * Math.abs(temperatura));
        System.out.println("Visitando planeta Helado con temperatura de: " + temperatura + "°C");
        System.out.println("Deseas extraer recursos del planeta? (true/false)");
        boolean extraer = scanner.nextBoolean();
        if (extraer == true){
            System.out.println("Que recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
            tipo_recurso = scanner.nextInt();
            cantidad_recurso = extraerRecursos(tipo_recurso);

            if(tipo_recurso == 1){
                jugador.recolectarCristales(cantidad_recurso);
            }
            else if(tipo_recurso == 2){
                jugador.recolectarFlores(cantidad_recurso);
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
        return cantidad_recurso;
    }
    
    public int getCristalesHidrogeno(){
        return cristalesHidrogeno;
    }
    
    public int getFloresDeSodio(){
        return floresDeSodio;
    }

    @Override
    public void visitarAsentamientos(Jugador jugador) {
        int probabilidad = (int)(Math.random()*100);
        if(probabilidad > 50){
            this.asentamiento = true;
        }
        else{
            this.asentamiento = false;
        }
        if(this.asentamiento){
            System.out.println("Visitando asentamiento en planeta Helado");
            System.out.println("Deseas extraer recursos del asentamiento? (true/false)");
            Scanner scanner = new Scanner(System.in);
            boolean extraer = scanner.nextBoolean();
            if (extraer == true){
                System.out.println("Que recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                int tipo_recurso = scanner.nextInt();
                int cantidad_recurso = extraerRecursos(tipo_recurso);
    
                if(tipo_recurso == 1){
                    jugador.recolectarCristales(cantidad_recurso);
                }
                else if(tipo_recurso == 2){
                    jugador.recolectarFlores(cantidad_recurso);
                }
                scanner.close();
            }
            else{
                System.out.println("Volviendo a la orbita...");
                scanner.close();
            }
        }
        else{
            System.out.println("No hay asentamiento en este planeta");
        }

    }

}
