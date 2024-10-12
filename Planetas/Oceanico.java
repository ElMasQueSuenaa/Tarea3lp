package Planetas;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Interactuable.*;
import Interfaz.tieneAsentamientos;

public class Oceanico extends Planeta implements tieneAsentamientos{
    private int profundidad;
    private boolean asentamiento;

    public Oceanico(int radio, int cristalesHidrogeno, int floresDeSodio, int profundidad) {
        super(radio, cristalesHidrogeno, floresDeSodio);
    }

    @Override
    public boolean visitar(Jugador jugador) {
        int tipo_recurso, cantidad_recurso;
        float aux;
        Scanner scanner = new Scanner(System.in);
        float energiaConsumida = (float)(0.002 * Math.pow(profundidad, 2));
        System.out.println("Visitando planeta Oceánico con profundidad de: " + profundidad + "Metros");
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
        int precioTrade1 = 0, precioTrade2 = 0, precioTrade3 = 0, precioTrade4 = 0, precioTrade5 = 0;
        float eficiencianaveTrade1 = 0.0f;
        boolean acepta = false;
        int tradeoffer2 = 0, tradeoffer3 = 0, tradeoffer4 = 0, tradeoffer5 = 0;
        int probabilidad = (int)(Math.random()*100);
        if(probabilidad > 70){
            this.asentamiento = true;
        }
        else{
            this.asentamiento = false;
        }
        if(this.asentamiento){
            System.out.println("Visitando asentamiento en planeta Oceánico");
            System.out.println("Hay entidades parecidas a humanos, pero con branquias en el cuello");
            System.out.println("Hay que adaptarse para sobrevivir");
            System.out.println("Debería haber un comerciante en alguna ciudad sobre el agua");
            System.out.println("Decides seguir un puente de coral que te lleva a una cueva");
            System.out.println("Hay que protegerse del sol, piel seca no es buena señal");
            System.out.println("Al final del puente, encuentras una criatura con una tienda de campaña");
            System.out.println("Ves un cartel que dice '╮ɟ⌈∀⊲ə╭'");
            System.out.println("Probablemente sea el nombre del comerciante");
            System.out.println("Entras a la tienda, hay un tipo de tiburón humanoide y en la mesa hay 5 ofertas");
            System.out.println("El comerciante te mira a los ojos y apunta a las ofertas");
            for(int i = 1; i < 6; i++){
                int precio = ThreadLocalRandom.current().nextInt(10, 51);
                int tradeoffer = ThreadLocalRandom.current().nextInt(8, 81);
                float eficiencianavetrade = 0.2f + ThreadLocalRandom.current().nextFloat() * (0.6f - 0.2f);
                if(i == 1){
                    System.out.println("1." + eficiencianavetrade + "de efiencia de nave por" + precio + "unidades de Uranio");
                    precioTrade1 = precio;
                    eficiencianaveTrade1 = eficiencianavetrade;
                }
                else if(i == 2){
                    System.out.println("2." + tradeoffer + "Flores de Sodio por" + precio + "Cristales de Hidrógeno");
                    precioTrade2 = precio;
                    tradeoffer2 = tradeoffer;
                }
                else if(i == 3){
                    System.out.println("3." + tradeoffer + "Flores de Sodio por" + precio + "Platino");
                    precioTrade3 = precio;
                    tradeoffer3 = tradeoffer;
                }
                else if(i == 4){
                    System.out.println("4." + tradeoffer + "Cristales de Hidrógeno por" + precio + "Uranio");
                    precioTrade4 = precio;
                    tradeoffer4 = tradeoffer;
                }
                else if(i == 5){
                    System.out.println("5." + tradeoffer + "Cristales de Hidrógeno por" + precio + "Platino");
                    precioTrade5 = precio;
                    tradeoffer5 = tradeoffer;
                }
            }
            System.out.println("Quieres ver tu inventario antes de realizar un trade? (true/false)");
            Scanner scanner = new Scanner(System.in);
            boolean verInventario = scanner.nextBoolean();
            if(verInventario){
                System.out.println("Cristales de Hidrógeno:" + jugador.getCristalesHidrogeno());
                System.out.println("Flores de Sodio:" + jugador.getFloresDeSodio());
                System.out.println("Platino:" + jugador.getPlatino());
                System.out.println("Uranio:" + jugador.getUranio());
            }
            System.out.println("Elige el numero de la oferta que deseas realizar (1-5)(0 para no comprar nada)");
            int quiereTrade = scanner.nextInt();
            while(quiereTrade != 0){
                if(quiereTrade == 1){
                    if(jugador.getUranio() < precioTrade1){
                        System.out.println("No tienes suficiente uranio para realizar el trade");
                        System.out.println("El mercader se ofende y salta a morderte");
                        System.out.println("Sales corriendo para volver a tu nave");
                        break;
                    }
                    else{
                        jugador.setEficiencia(eficiencianaveTrade1);
                        jugador.tradeUranio(precioTrade1);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Tu eficiencia de traje ha aumentado a " + jugador.getEficienciatraje());
                        System.out.println("Platino restante: " + jugador.getUranio());
                    }
                }
                else if(quiereTrade == 2){
                    if(jugador.getFloresDeSodio() < precioTrade2){
                        System.out.println("No tienes suficiente flores de sodio para realizar el trade");
                        System.out.println("El mercader se ofende y salta a morderte");
                        System.out.println("Sales corriendo para volver a tu nave");
                        break;
                    }
                    else{
                        jugador.recolectarFlores(precioTrade2);
                        jugador.tradeCristales(tradeoffer2);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Flores de sodio restantes: " + jugador.getFloresDeSodio());
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                    }
                }
                else if(quiereTrade == 3){
                    if(jugador.getFloresDeSodio() < precioTrade3){
                        System.out.println("No tienes suficiente flores de sodio para realizar el trade");
                        System.out.println("El mercader se ofende y salta a morderte");
                        System.out.println("Sales corriendo para volver a tu nave");
                        break;
                    }
                    else{
                        jugador.recolectarFlores(precioTrade3);
                        jugador.tradePlatino(tradeoffer3);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Flores de sodio restantes: " + jugador.getFloresDeSodio());
                        System.out.println("Platino restante: " + jugador.getPlatino());
                    }
                }
                else if(quiereTrade == 4){
                    if(jugador.getCristalesHidrogeno() < precioTrade4){
                        System.out.println("No tienes suficiente cristales de hidrógeno para realizar el trade");
                        System.out.println("El mercader se ofende y salta a morderte");
                        System.out.println("Sales corriendo para volver a tu nave");
                        break;
                    }
                    else{
                        jugador.recolectarCristales(precioTrade4);
                        jugador.tradeUranio(tradeoffer4);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                        System.out.println("Uranio restante: " + jugador.getUranio());
                    }
                }
                else if(quiereTrade == 5){
                    if(jugador.getCristalesHidrogeno() < precioTrade5){
                        System.out.println("No tienes suficiente cristales de hidrógeno para realizar el trade");
                        System.out.println("El mercader se ofende y salta a morderte");
                        System.out.println("Sales corriendo para volver a tu nave");
                        break;
                    }
                    else{
                        jugador.recolectarCristales(precioTrade5);
                        jugador.tradePlatino(tradeoffer5);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                        System.out.println("Platino restante: " + jugador.getPlatino());
                    }
                }
                else{
                    System.out.println("El tiburón se agacha y saca una bandeja de sushi exótico");
                    System.out.println("Se la aceptas? (true/false)");
                    acepta = scanner.nextBoolean();
                    if(acepta){
                        System.out.println("El sushi te revitaliza");
                        System.out.println("Tu energia se a restablecido a 100");
                        jugador.bebidaEnergetica();
                    }
                    else{
                        System.out.println("El comerciante se lanza al ataque");
                        System.out.println("Las faltas de respeto son universales");
                        break;
                    }
                }
                System.out.println("Elige el numero de la oferta que deseas realizar (1-5)(0 para no comprar nada)");
                scanner = new Scanner(System.in);
                quiereTrade = scanner.nextInt();
            }
            scanner.close();
        }
        else {
            System.out.println("No hay asentamientos en este planeta");
        }

    }
}
