package Interactuable;

import Planetas.MapaGalactico;

public class Nave {
    private float unidadesCombustible;           
    private float eficienciaCombustible;        

    ////////////////////
    //Nave()
    //------------------
    //Constructor de la clase Nave, inicializa los atributos de la clase
    ///////////////////

    public Nave() {
        this.unidadesCombustible = 100.0f;
        this.eficienciaCombustible = 0.0f;    
    }

    ////////////////////
    //recargarPropulsores(int hidrogeno)
    //hidrogeno: cantidad de hidrógeno a recargar
    //------------------
    //Método que recarga los propulsores de la nave con la cantidad de hidrógeno pasada por parámetro
    //------------------
    //No retorna nada
    ///////////////////

    public void recargarPropulsores(int hidrogeno) {
        float unidadesRecargadas = (float)(0.6f * hidrogeno * (1 + eficienciaCombustible));
        if (hidrogeno > 0) {
            System.out.println("FCE: Se ha recargado el tanque de combustible.");
            setUnidadesCombustible(unidadesRecargadas);
            return;
        }
        else {
            System.out.println("No se puede recargar combustible con una cantidad negativa o nula de Hidrógeno.");
        }
    }

    ////////////////////
    //calcularConsumo(int salto)
    //salto: cantidad de salto a calcular
    //------------------
    //Método que calcula el consumo de combustible dependiendo del tamaño del salto
    //------------------
    //Retorna un flotante que representa el consumo de combustible
    ///////////////////

    public float calcularConsumo(int salto) {
        float consumo = 0.75f * Math.abs(salto) * Math.abs(salto) * (1 - eficienciaCombustible);
            return consumo;
    }

    ////////////////////
    //viajarPlaneta(MapaGalactico MG, int direccion, int tamanoSalto)
    //MG: mapa galáctico
    //direccion
    //tamanoSalto: tamaño del salto
    //------------------
    //Método que permite a la nave viajar a un planeta
    //------------------
    //Retorna true si se pudo realizar el viaje
    ///////////////////

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

    ////////////////////
    //getUnidadesCombustible()
    //No recibe parámetros
    //------------------
    //Método que retorna la cantidad de unidades de combustible de la nave
    //------------------
    //Retorna un flotante
    ///////////////////

    public float getUnidadesCombustible() {
        return unidadesCombustible;
    }

    ////////////////////
    //setUnidadesCombustible(float unidadesCombustible)
    //unidadesCombustible: cantidad de unidades de combustible
    //------------------
    //Método que asigna un valor a la variable unidadesCombustible
    //------------------
    //No retorna nada
    ///////////////////

    public void setUnidadesCombustible(float unidadesCombustible) {
        this.unidadesCombustible = unidadesCombustible;
    }
    
    ////////////////////
    //getEficienciaCombustible()
    //No recibe parámetros
    //------------------
    //Método que retorna la eficiencia del combustible de la nave
    //------------------
    //Retorna un flotante
    ///////////////////

    public float getEficienciaCombustible() {
        return eficienciaCombustible;
    }

    ////////////////////
    //setEficienciaCombustible(float eficienciaCombustible)
    //eficienciaCombustible: eficiencia del combustible
    //------------------
    //Método que asigna un valor a la variable eficienciaCombustible
    //------------------
    //No retorna nada
    ///////////////////
    
    public void setEficienciaCombustible(float eficienciaCombustible) {
        this.eficienciaCombustible = eficienciaCombustible;
    }
}
