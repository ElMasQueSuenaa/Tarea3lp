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
        System.out.println("FCE: Visitando planeta Radiactivo con radiacion de: " + radiacion + "sieverts");
        System.out.println("FCE: Deseas extraer recursos del planeta? (true/false)");
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
            System.out.println("FCE: Volviendo a la orbita...");
            scanner.close();
            return true;
        }
    }

    @Override
    public int extraerRecursos(int tipo) {
        int cantidadDisponible = 0;
        int cantidadExtraer = 0;
        Scanner scanner = new Scanner(System.in);

        if (tipo == 1) {
            cantidadDisponible = this.getCristalesHidrogeno();
        } else if (tipo == 2) {
            cantidadDisponible = this.getFloresDeSodio();
        } else if (tipo == 3) {
            cantidadDisponible = this.getUranio();
        } else {
            System.out.println("FCE: Tipo de recurso inválido.");
            scanner.close();
            return 0;
        }

        System.out.println("FCE: ¿Cuánta cantidad deseas extraer? (Disponible: " + cantidadDisponible + ")");
        cantidadExtraer = scanner.nextInt();

        if (cantidadExtraer > cantidadDisponible) {
            System.out.println("FCE: No hay suficiente recurso disponible. Solo hay " + cantidadDisponible + " unidades.");
            scanner.close();
            return 0;
        }

        if (tipo == 1) {
            this.setCristalesHidrogeno(cantidadDisponible - cantidadExtraer);
        } else if (tipo == 2) {
            this.setFloresDeSodio(cantidadDisponible - cantidadExtraer);
        } else if (tipo == 3) {
            this.setUranio(cantidadDisponible - cantidadExtraer);
        }
    
        scanner.close();
        return cantidadExtraer;
    }

    public void setUranio(int uranio){
        this.uranio = uranio;
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
