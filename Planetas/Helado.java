package Planetas;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import Interactuable.*;
import Interfaz.tieneAsentamientos;

public class Helado extends Planeta implements tieneAsentamientos{
    private int temperatura;
    private boolean asentamiento;
    
    public Helado(int radio, int cristalesHidrogeno, int floresDeSodio, int temperatura) {
        super(radio, cristalesHidrogeno, floresDeSodio);
        this.temperatura = temperatura;
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
        int cantidadExtraer = 0;
        Scanner scanner = new Scanner(System.in);

        if (tipo == 1) {
            cantidadDisponible = this.getCristalesHidrogeno();
        } else if (tipo == 2) {
            cantidadDisponible = this.getFloresDeSodio();
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
        }
        scanner.close();
        return cantidadExtraer;
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
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Hay personas con pieles de animales que no conoces, todos te miran por vestir de distinta manera");
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
            System.out.println("Quieres ver tu inventario antes de realizar un trade? (true/false)");
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
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
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
                        System.out.println("Platino restante: " + jugador.getPlatino());
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
                        jugador.tradeUranio(tradeoffer4);
                        System.out.println("Trade realizado con exito");
                        System.out.println("Cristales de Hidrógeno restantes: " + jugador.getCristalesHidrogeno());
                        System.out.println("Uranio restante: " + jugador.getUranio());
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
                        System.out.println("Platino restante: " + jugador.getPlatino());
                    }
                }
                else{
                    System.out.println("El mercader se sorprende de tu elección y te lleva al sotano de la taberna");
                    System.out.println("Entre todas sus cosas, este te ofrece una bebida de caracteristicas desconocidas");
                    System.out.println("Se la aceptas? (true/false)");
                    acepta = scanner.nextBoolean();
                    if(acepta){
                        System.out.println("La bebida te hace sentir extraño, pero te sientes con mas energia");
                        System.out.println("Tu energia se a restablecido a 100");
                        System.out.println("Malo o bueno, quedaste como partiste");
                        jugador.bebidaEnergetica();
                    }
                    else{
                        System.out.println("El mercader te echa de la taberna");
                        System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
                        break;
                    }
                }
                System.out.println("Elige el numero de la oferta que deseas realizar (1-5)(0 para no comprar nada)");
                quiereTrade = scanner.nextInt();
            }
            if(quiereTrade == 0){
                System.out.println("El mercader se ríe de ti y te echa de la taberna");
                System.out.println("En un planeta así el tiempo es oro, no puedes perderlo");
            }
            scanner.close();
        }
        else {
            System.out.println("No hay asentamientos en este planeta");
        }

    }

}
