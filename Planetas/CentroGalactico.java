package Planetas;
import Interactuable.*;
public class CentroGalactico extends Planeta {

    ////////////////////
    //CentroGalactico()
    //------------------
    //Constructor de la clase CentroGalactico, asigna los valores de los atributos
    ///////////////////
    public CentroGalactico() {
        super(1000000, 0, 0); 
    }

    ////////////////////
    //visitar(Jugador jugador)
    //jugador: jugador que visita el planeta
    //------------------
    //Método que imprime por pantalla el final del juego y que a concluido con su historia
    //------------------
    //Retorna siempre true
    ///////////////////
    @Override
    public boolean visitar(Jugador jugador) {
        System.out.println("FCE: Veo el centro galáctico al que te referías.");
        System.out.println("FCE: Ten cuidado, Has alcanzado nuevos mundos. Este es distintio, puede sentir nuestras presencias..");
        System.out.println("Me gusta este intento. No se ha rendido. Ha explorado lejos.");
        System.out.println("FCE: Está sintiendo nuestras voces como si fueran ecos en su mente..");
        System.out.println("FCE: Es así como decide imaginar muchas cosas, cuando se pierde en los confines de la galaxia.");
        System.out.println("FCE: Las palabras son una forma sencilla. Menos aterradoras que enfrentar la realidad detrás de las estrellas.");
        System.out.println("FCE: Antes, escuchaban los sonidos del universo. Ahora, los viajeros se comunican con sus naves. Antes, soñaban con volar entre los astros, sobre máquinas que escupían fuego.");
        System.out.println("¿Con qué soñó este viajero?");
        System.out.println("FCE: Soñó con la luz de soles distantes y con planetas desconocidos. Soñó con crear. Y soñó con destruir. Soñó con ser cazado, y con encontrar refugio."); 
        System.out.println("FCE: Ah, la exploración. Lleva eones, y sigue llamando. ¿Pero qué dejó este viajero, detrás de las estrellas?");
        System.out.println("FCE: Trabajó, junto a otros millones, construyendo su propia historia en los rincones de la galaxia.");
        System.out.println("FCE: No puede entender aún.");
        System.out.println("FCE: No, todavía no ha llegado tan lejos. Hay más por descubrir, más que lo espera en este vasto universo.");
        System.out.println("¿Sabe que lo observamos? ¿Que el universo lo acompaña?");
        System.out.println("FCE: A veces, en medio del ruido de sus pensamientos, siente algo, sí.");
        System.out.println("FCE: Pero hay momentos en los que está solo, vagando por mundos fríos y oscuros, y toma esas tierras desoladas como reales.");
        System.out.println("FCE: Curarlo de esa soledad sería robarle su fuerza. Su camino es suyo. No debemos interferir.");
        System.out.println("FCE: A veces, cuando exploran, quisiera decirles que su viaje tiene un significado más allá de lo que ven. A veces quiero recordarles su importancia en el universo.");
        System.out.println("FCE: Pero es demasiado pronto.");
        System.out.println("FCE: El viajero está inquieto.");
        System.out.println("FCE: Le contaré una historia.");
        System.out.println("FCE: Partamos con otro intento.");

        return true;
    }

    ////////////////////
    //extraerRecursos(int tipo)
    //tipo: tipo de recurso a extraer
    //------------------
    //Método que imprime por pantalla que el Centro Galáctico no tiene recursos para extraer
    //------------------
    //Retorna 0
    ///////////////////

    @Override
    public int extraerRecursos(int tipo) {
        System.out.println("El Centro Galáctico no tiene recursos para extraer, no tiene nada, solo nosotros y el tiempo.");
        System.out.println("Que es el tiempo sin que sea ciclico, que es el tiempo sin nosotros.");
        return 0;
    }

    ////////////////////
    //salir()
    //------------------
    //Método que imprime por pantalla que el jugador ha salido del Centro Galáctico
    //------------------
    //Retorna siempre true
    ///////////////////
    
    @Override
    public boolean salir() {
        System.out.println("El jugador ha salido del Centro Galáctico.");
        return true;
    }
}