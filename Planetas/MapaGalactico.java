package Planetas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MapaGalactico {
    private List<Planeta> planetas; 
    private Random random;
    private int generadoCG;
    private int posicionActual;

    ////////////////////
    //MapaGalactico()
    //------------------
    //Constructor de la clase MapaGalactico, inicializa los atributos de la clase
    ///////////////////

    public MapaGalactico() {
        this.planetas = new ArrayList<>(); 
        this.random = new Random();    
        this.generadoCG = 0;
        this.posicionActual = 0;
        generarHastaPlaneta(posicionActual + 1); //siempre será 1
    } 

    ////////////////////
    //generarHastaPlaneta(int numPlanetas)
    //numPlanetas: cantidad de planetas a generar
    //------------------
    //Método que genera planetas hasta llegar a la cantidad de planetas indicada
    //------------------
    //No retorna nada
    ///////////////////

    public void generarHastaPlaneta(int numPlanetas) {
        while (planetas.size() <= numPlanetas) {
            Planeta nuevoPlaneta = generadorPlaneta();  
            planetas.add(nuevoPlaneta);     
            //System.out.println("Planeta " + nuevoPlaneta.getClass().getSimpleName() + " creado.");   USADO PARA DEPURAR        
        }
    }

    ////////////////////
    //getPosicionActual()
    //------------------
    //Método que retorna la posición actual del jugador
    //------------------
    //Retorna un entero
    ///////////////////

    public int getPosicionActual() {
        return posicionActual;
    }

    ////////////////////
    //setPosicionActual(int posicionActual)
    //posicionActual: posición actual del jugador
    //------------------
    //Método que asigna un valor a la variable posicionActual
    //------------------
    //No retorna nada
    ///////////////////

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    ////////////////////
    //generadorPlaneta()
    //------------------
    //Método que genera un planeta aleatorio a base de probabilidades
    //------------------
    //Retorna un objeto de tipo Planeta
    ///////////////////

    private Planeta generadorPlaneta() {
        int probabilidad = random.nextInt(100);
        if (probabilidad < 30) {
            return generarHelado();
        }
        else if(probabilidad < 60){
            return generarOceanico();
        }
        else if(probabilidad < 80){
            return generarRadiactivo();
        }
        else if(probabilidad < 99){
            return generarVolcanico();
        }
        else{
            if (generadoCG == 0){
                generadoCG = 1;
                return generarCentroGalactico();
            }
            else {
                return generarVolcanico();
            }
        }
    }

    ////////////////////
    //generarHelado()
    //------------------
    //Método que genera un planeta de tipo Helado
    //------------------
    //Retorna un objeto de tipo Planeta Helado
    ///////////////////

    private Planeta generarHelado() {
        int radio = ThreadLocalRandom.current().nextInt(1000, 1000001);
        int temperatura = ThreadLocalRandom.current().nextInt(-120, -29);
        int cristalesDeHidrogeno = (int)(0.65 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.35 * 4 * Math.PI * Math.pow(radio, 2));
        return new Helado(radio, cristalesDeHidrogeno, floresDeSodio, temperatura);
    }

    ////////////////////
    //generarOceanico()
    //------------------
    //Método que genera un planeta de tipo Oceánico
    //------------------
    //Retorna un objeto de tipo Planeta Oceánico
    ///////////////////

    private Planeta generarOceanico() {
        int radio = ThreadLocalRandom.current().nextInt(10000, 1000001);
        int profundidad = ThreadLocalRandom.current().nextInt(30, 1001);
        int cristalesDeHidrogeno = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.65 * 4 * Math.PI * Math.pow(radio, 2));
        return new Oceanico(radio, cristalesDeHidrogeno, floresDeSodio, profundidad);
    }

    ////////////////////
    //generarVolcanico()
    //------------------
    //Método que genera un planeta de tipo Volcánico
    //------------------
    //Retorna un objeto de tipo Planeta Volcánico
    ///////////////////

    private Planeta generarVolcanico() {
        int radio = ThreadLocalRandom.current().nextInt(1000, 100001);
        int temperatura = ThreadLocalRandom.current().nextInt(120, 256);
        int cristalesDeHidrogeno = (int)(0.3 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = 0;
        int platino = (int)(0.25 * 4 * Math.PI * Math.pow(radio, 2) - 20.5 * Math.pow(temperatura, 2));
        return new Volcanico(radio, cristalesDeHidrogeno, floresDeSodio, temperatura, platino);
    }

    ////////////////////
    //generarRadiactivo()
    //------------------
    //Método que genera un planeta de tipo Radiactivo
    //------------------
    //Retorna un objeto de tipo Planeta Radiactivo
    ///////////////////

    private Planeta generarRadiactivo() {
        int radio = ThreadLocalRandom.current().nextInt(10000, 100001);
        int cristalesDeHidrogeno = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int radiacion = ThreadLocalRandom.current().nextInt(10, 51);
        int uranio = (int)(0.25 * 4 * Math.PI * Math.pow(radio, 2));
        return new Radiactivo(radio, cristalesDeHidrogeno, floresDeSodio, radiacion, uranio);
    }

    ////////////////////
    //generarCentroGalactico()
    //------------------
    //Método que genera un planeta de tipo CentroGalactico
    //------------------
    //Retorna un objeto de tipo Planeta CentroGalactico
    ///////////////////

    private Planeta generarCentroGalactico() {
        return new CentroGalactico();
    }
    
    ////////////////////
    //getTipoPlanetaActual()
    //------------------
    //Método que retorna el tipo de planeta en la posición actual
    //------------------
    //Retorna un String
    ///////////////////

    public String getTipoPlanetaActual() {
        if (posicionActual >= 0 && posicionActual < planetas.size()) {
            Planeta planetaActual = planetas.get(posicionActual); 
            return planetaActual.getClass().getSimpleName();
        } else {
            return "No hay planetas en esta posición.";
        }
    }

    ////////////////////
    //getPlanetaActual()
    //------------------
    //Método que retorna el planeta en la posición actual
    //------------------
    //Retorna un objeto de tipo Planeta
    ///////////////////
    
    public Planeta getPlanetaActual() {
        if (posicionActual >= 0 && posicionActual < planetas.size()) {
            return planetas.get(posicionActual);  
        } else {
            System.out.println("Posición fuera de rango.");
            return null; 
        }
    }

}

