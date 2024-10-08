package Planetas;

public abstract class Planeta {
    protected int radio;                 
    protected int cristalesHidrogeno;     
    protected int floresDeSodio;         

    // Constructor
    public Planeta(int radio, int cristalesHidrogeno, int floresDeSodio) {
        this.radio = radio;
        this.cristalesHidrogeno = cristalesHidrogeno;
        this.floresDeSodio = floresDeSodio;
    }

    // Método para visitar el planeta
    public boolean visitar(Jugador jugador) {
        System.out.println("El jugador ha aterrizado en el planeta con un radio de " + radio + " metros.");
        System.out.println("Recursos disponibles:");
        System.out.println("Cristales de Hidrógeno: " + cristalesHidrogeno);
        System.out.println("Flores de Sodio: " + floresDeSodio);
        return true;
    }

    // Método para extraer recursos
    public int extraerRecursos(int tipo, int cantidad) {
        if (tipo == 1) {  // 1 para Cristales de Hidrógeno
            if (cantidad <= cristalesHidrogeno) {
                cristalesHidrogeno -= cantidad;
                System.out.println("Se han extraído " + cantidad + " unidades de Cristales de Hidrógeno.");
                return cantidad;
            } else {
                System.out.println("No hay suficientes Cristales de Hidrógeno para extraer.");
                return 0;
            }
        } else if (tipo == 2) {  // 2 para Flores de Sodio
            if (cantidad <= floresDeSodio) {
                floresDeSodio -= cantidad;
                System.out.println("Se han extraído " + cantidad + " unidades de Flores de Sodio.");
                return cantidad;
            } else {
                System.out.println("No hay suficientes Flores de Sodio para extraer.");
                return 0;
            }
        } else {
            System.out.println("Tipo de recurso no válido.");
            return 0;
        }
    }

    // Método para salir del planeta
    public boolean salir() {
        System.out.println("El jugador ha abandonado el planeta.");
        return true;
    }

    // Getters y Setters para los atributos
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getCristalesHidrogeno() {
        return cristalesHidrogeno;
    }

    public void setCristalesHidrogeno(int cristalesHidrogeno) {
        this.cristalesHidrogeno = cristalesHidrogeno;
    }

    public int getFloresDeSodio() {
        return floresDeSodio;
    }

    public void setFloresDeSodio(int floresDeSodio) {
        this.floresDeSodio = floresDeSodio;
    }
}

