package Interactuable;

import Planetas.MapaGalactico;

public class Nave {
    private static float unidadesCombustible;           
    private static float eficienciaCombustible;         

    public Nave() {
        Nave.unidadesCombustible = 100.0f;
        Nave.eficienciaCombustible = 0.0f;       
    }

    public void recargarPropulsores(int hidrogeno) {
        if (hidrogeno> 0) {
            float unidadesRecargadas = 0.6f * hidrogeno * (1 + eficienciaCombustible);
            unidadesCombustible += unidadesRecargadas;
            System.out.println("Combustible recargado con " + hidrogeno + " unidades de Hidrógeno.");
            System.out.println("Combustible actual: " + unidadesCombustible + " unidades.");
        } else {
            System.out.println("No se puede recargar combustible con una cantidad negativa o nula de Hidrógeno.");
        }
    }

    public float calcularConsumo(int salto) {
        if (salto > 0) {
            float consumo = 0.75f * salto * salto * (1 - eficienciaCombustible);
            return consumo;
        } else {
            System.out.println("El tamaño del salto debe ser mayor que 0.");
            return 0.0f;
        }
    }

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        return true;
    }

    public boolean realizarSalto(int salto) {
        float consumo = calcularConsumo(salto);
        if (unidadesCombustible >= consumo) {
            unidadesCombustible -= consumo;
            System.out.println("Salto realizado de tamaño " + salto + ".");
            System.out.println("Combustible restante: " + unidadesCombustible + " unidades.");
            return true;
        } else {
            System.out.println("No hay suficiente combustible para realizar el salto.");
            return false;
        }
    } 

    public float getUnidadesCombustible() {
        return unidadesCombustible;
    }

    public void setUnidadesCombustible(float unidadesCombustible) {
        Nave.unidadesCombustible = unidadesCombustible;
    }

    public static float getEficienciaCombustible() {
        return eficienciaCombustible;
    }

    public void setEficienciaCombustible(float eficienciaCombustible) {
        Nave.eficienciaCombustible = eficienciaCombustible;
    }
}
