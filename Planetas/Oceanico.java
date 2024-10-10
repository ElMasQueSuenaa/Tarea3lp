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
        float eficienciaTrade1 = 0.0f;
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
            System.out.println("Visitando asentamiento en planeta Helado");
            System.out.println("Hay comerciantes con pieles de animales que no conoces, todos te miran por vestir de distinta manera");
            System.out.println("Condiciones dificiles, generan gente dificil");
            System.out.println("Debería haber un comerciante en alguna cueva");
            System.out.println("La gente de este lugar debería tener las comunidades bajo tierra, para protegerse de las tormentas de hielo");
            System.out.println("Despues de recorrer el planeta, encuentras un cartel en un idioma que no entiendes");
            System.out.println("Decides seguir el camino que te lleva a una cueva");
            System.out.println("Dentro de la cueva hay una comunidad de seres nativos del planeta");
            System.out.println("Te ofrecen intercambiar recursos, pero no entiendes su idioma");
            System.out.println("Menos mal el trueque es un lenguaje universal");
            System.out.println("Te llevan a un tipo de taberna, donde el dueño del lugar te muestra 5 distintas ofertas");
            for(int i = 1; i < 6; i++){
                int precio = ThreadLocalRandom.current().nextInt(10, 51);
                int tradeoffer = ThreadLocalRandom.current().nextInt(8, 81);
                float eficienciatrade = 0.2f + ThreadLocalRandom.current().nextFloat() * (0.6f - 0.2f);
                if(i == 1){
                    System.out.println("1." + eficienciatrade + "de efiencia de traje por" + precio + "unidades de Platino");
                    precioTrade1 = precio;
                    eficienciaTrade1 = eficienciatrade;
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
            System.out.println("Elige el numero de la oferta que deseas realizar (1-5)(0 para no comprar nada)");
            Scanner scanner = new Scanner(System.in);
            int quiereTrade = scanner.nextInt();
            while(quiereTrade != 0){
                if(quiereTrade == 0){
                    System.out.println("El mercader se ríe de ti y te echa de la taberna");
                    System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                }
                else if(quiereTrade == 1){
                    if(jugador.getPlatino() < precioTrade1){
                        System.out.println("No tienes suficiente platino para realizar el trade");
                        System.out.println("El mercader se ofende y te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                    else{
                        jugador.setEficiencia(eficienciaTrade1);
                        jugador.tradePlatino(precioTrade1);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Tu eficiencia de traje ha aumentado a " + jugador.getEficienciatraje());
                        System.out.println("Platino restante: " + jugador.getPlatino());
                    }
                }
                else if(quiereTrade == 2){
                    if(jugador.getFloresDeSodio() < precioTrade2){
                        System.out.println("No tienes suficientes flores de sodio para realizar el trade");
                        System.out.println("El mercader se ofende y te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                    else{
                        jugador.recolectarFlores(precioTrade2);
                        jugador.tradeCristales(tradeoffer2);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Flores de sodio restantes: " + jugador.getFloresDeSodio());
                        System.out.println("Cristales de Hidrógeno restantes: " + tradeoffer2);
                    }
                }
                else if(quiereTrade == 3){
                    if(jugador.getFloresDeSodio() < precioTrade3){
                        System.out.println("No tienes suficientes flores de sodio para realizar el trade");
                        System.out.println("El mercader se ofende y te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                    else{
                        jugador.recolectarFlores(precioTrade3);
                        jugador.tradePlatino(tradeoffer3);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Flores de sodio restantes: " + jugador.getFloresDeSodio());
                        System.out.println("Platino restante: " + tradeoffer3);
                    }
                }
                else if(quiereTrade == 4){
                    if(jugador.getCristalesHidrogeno() < precioTrade4){
                        System.out.println("No tienes suficientes cristales de hidrógeno para realizar el trade");
                        System.out.println("El mercader se ofende y te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                    else{
                        jugador.recolectarCristales(precioTrade4);
                        jugador.traderUranio(tradeoffer4);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                        System.out.println("Uranio restante: " + tradeoffer4);
                    }
                }
                else if(quiereTrade == 5){
                    if(jugador.getCristalesHidrogeno() < precioTrade5){
                        System.out.println("No tienes suficientes cristales de hidrógeno para realizar el trade");
                        System.out.println("El mercader se ofende y te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                    else{
                        jugador.recolectarCristales(precioTrade5);
                        jugador.tradePlatino(tradeoffer5);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                        System.out.println("Platino restante: " + tradeoffer5);
                    }
                }
                else{
                    System.out.println("El mercader se sorprende de tu elección y te lleva al sotano de la taberna");
                    System.out.println("Entre todas sus cosas, este te ofrece una bebida de caracteristicas desconocidas");
                    System.out.println("Se la aceptas? (true/false)");
                    acepta = scanner.nextBoolean();
                    if(acepta){
                        System.out.println("La bebida te hace sentir extraño, pero te sientes con mas energia");
                        System.out.println("Tu energia se a restablecido 100%");
                        jugador.bebidaEnergetica();
                    }
                    else{
                        System.out.println("El mercader te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                    }
                }
                System.out.println("Elige el numero de la oferta que deseas realizar (1-5)(0 para no comprar nada)");
                scanner = new Scanner(System.in);
                quiereTrade = scanner.nextInt();
            }
        }
        else {
            System.out.println("No hay asentamientos en este planeta");
        }

    }
}
