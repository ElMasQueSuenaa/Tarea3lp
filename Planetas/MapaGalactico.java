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

    public MapaGalactico() {
        this.planetas = new ArrayList<>(); 
        this.random = new Random();    
        this.generadoCG = 0;
        this.posicionActual = 0;
        generarHastaPlaneta(posicionActual + 1); //siempre será 1
    }

    public void generarHastaPlaneta(int numPlanetas) {
        while (planetas.size() <= numPlanetas) {
            Planeta nuevoPlaneta = generadorPlaneta();  
            planetas.add(nuevoPlaneta);     
            //System.out.println("Planeta " + nuevoPlaneta.getClass().getSimpleName() + " creado.");   USADO PARA DEPURAR        
        }
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

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

    // Métodos para generar cada tipo de planeta con características específicas
    private Planeta generarHelado() {
        int radio = ThreadLocalRandom.current().nextInt(1000, 1000001);
        int temperatura = ThreadLocalRandom.current().nextInt(-120, -29);
        int cristalesDeHidrogeno = (int)(0.65 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.35 * 4 * Math.PI * Math.pow(radio, 2));
        return new Helado(radio, cristalesDeHidrogeno, floresDeSodio, temperatura);
    }

    private Planeta generarOceanico() {
        int radio = ThreadLocalRandom.current().nextInt(10000, 1000001);
        int profundidad = ThreadLocalRandom.current().nextInt(30, 1001);
        int cristalesDeHidrogeno = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.65 * 4 * Math.PI * Math.pow(radio, 2));
        return new Oceanico(radio, cristalesDeHidrogeno, floresDeSodio, profundidad);
    }

    private Planeta generarVolcanico() {
        int radio = ThreadLocalRandom.current().nextInt(1000, 100001);
        int temperatura = ThreadLocalRandom.current().nextInt(120, 256);
        int cristalesDeHidrogeno = (int)(0.3 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = 0;
        int platino = (int)(0.25 * 4 * Math.PI * Math.pow(radio, 2) - 20.5 * Math.pow(temperatura, 2));
        return new Volcanico(radio, cristalesDeHidrogeno, floresDeSodio, temperatura, platino);
    }

    private Planeta generarRadiactivo() {
        int radio = ThreadLocalRandom.current().nextInt(10000, 100001);
        int cristalesDeHidrogeno = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int floresDeSodio = (int)(0.2 * 4 * Math.PI * Math.pow(radio, 2));
        int radiacion = ThreadLocalRandom.current().nextInt(10, 51);
        int uranio = (int)(0.25 * 4 * Math.PI * Math.pow(radio, 2));
        return new Radiactivo(radio, cristalesDeHidrogeno, floresDeSodio, radiacion, uranio);
    }

    private Planeta generarCentroGalactico() {
        return new CentroGalactico();
    }

    public void setPosicion(int posicion){
        posicionActual = posicion;
    }

    public String getTipoPlanetaActual() {
        if (posicionActual >= 0 && posicionActual < planetas.size()) {
            Planeta planetaActual = planetas.get(posicionActual);  // Obtiene el planeta en la posición actual
            return planetaActual.getClass().getSimpleName();  // Retorna el nombre simple de la clase del planeta
        } else {
            return "No hay planetas en esta posición.";
        }
    }

    public Planeta getPlanetaActual() {
        if (posicionActual >= 0 && posicionActual < planetas.size()) {
            return planetas.get(posicionActual);  // Devuelve el planeta en la posición actual
        } else {
            System.out.println("Posición fuera de rango.");
            return null;  // Si no hay un planeta en esa posición, devuelve null
        }
    }

}

