package Interactuable;

public class Jugador {
    private float cantEnergiaProteccion;
    private float eficienciaEnergiaProteccion;

    public Jugador() {
        this.cantEnergiaProteccion = 100.0f;
        this.eficienciaEnergiaProteccion = 0.0f;
    }

    public void recargarEnergiaProteccion(int sodio) {
        if (sodio > 0) {
            float unidadesRecargadas = 0.65f * sodio * (1 + eficienciaEnergiaProteccion);
            cantEnergiaProteccion += unidadesRecargadas; 
            System.out.println("Energía recargada con " + sodio + " unidades de Sodio.");
            System.out.println("Energía de Protección actual: " + cantEnergiaProteccion + " unidades.");
        } else {
            System.out.println("No se puede recargar energía con una cantidad negativa o nula de Sodio.");
        }
    }

    public float getcantEnergiaProteccion() {
        return cantEnergiaProteccion;
    }

    public float getEficienciaEnergiaProteccion() {
        return eficienciaEnergiaProteccion;
    }

    public void setEficienciaEnergiaProteccion(float eficienciaEnergiaProteccion) {
        this.eficienciaEnergiaProteccion = eficienciaEnergiaProteccion;
    }

    public void setcantEnergiaProteccion(float cantEnergiaProteccion) {
        this.cantEnergiaProteccion = cantEnergiaProteccion;
    }

}
