package Interactuable;

import Planetas.MapaGalactico;

public class Nave {
    private float unidadesCombustible;           
    private float eficienciaCombustible;        

    public Nave() {
        this.unidadesCombustible = 100.0f;
        this.eficienciaCombustible = 0.0f;    
    }

    public void recargarPropulsores(int hidrogeno) {
        float unidadesRecargadas = 0.6f * hidrogeno * (1 + eficienciaCombustible);
        if (hidrogeno > 0) {
            System.out.println("FCE: Se ha recargado el tanque de combustible.");
            setUnidadesCombustible(unidadesRecargadas);
            return;
        }
        else {
            System.out.println("No se puede recargar combustible con una cantidad negativa o nula de Hidrógeno.");
        }
    }

    public float calcularConsumo(int salto) {
        float consumo = 0.75f * Math.abs(salto) * Math.abs(salto) * (1 - eficienciaCombustible);
            return consumo;
    }

    public boolean viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto){
        MG.generarHastaPlaneta(Math.abs(tamanoSalto));
        if(direccion < 0){
            MG.setPosicionActual(MG.getPosicionActual() - Math.abs(tamanoSalto));
        }
        else{
            MG.setPosicionActual(tamanoSalto);
        }
        float consumo = calcularConsumo(tamanoSalto);
        this.unidadesCombustible -= consumo;

        return true;
    }


    public float getUnidadesCombustible() {
        return unidadesCombustible;
    }

    public void setUnidadesCombustible(float unidadesCombustible) {
        this.unidadesCombustible = unidadesCombustible;
    }

    public float getEficienciaCombustible() {
        return eficienciaCombustible;
    }

    public void setEficienciaCombustible(float eficienciaCombustible) {
        this.eficienciaCombustible = eficienciaCombustible;
    }
}
