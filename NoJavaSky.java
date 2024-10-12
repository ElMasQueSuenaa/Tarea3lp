import Planetas.Planeta;
import Planetas.Helado;
import Planetas.MapaGalactico;
import Planetas.CentroGalactico;
import Planetas.Volcanico;
import Planetas.Radiactivo;
import Planetas.Oceanico;
import Interfaz.tieneAsentamientos;

import java.util.Scanner;

import Interactuable.Jugador;
import Interactuable.Nave;

public class NoJavaSky {
    public static void main(String[] args) {
        MapaGalactico mg = new MapaGalactico();
        Jugador jugador = new Jugador();
        Nave nave = new Nave();
        Scanner scanner = new Scanner(System.in);
        boolean indiceDeReiniciarJuego = false;

        while (true) {
            if (indiceDeReiniciarJuego) {
                System.out.println("FCE: Has perdido. Reiniciando desde el principio...");
                jugador = new Jugador(); 
                nave = new Nave(); 
                mg = new MapaGalactico();
                mg.generarHastaPlaneta(1);
                mg.setPosicion(0); 
                indiceDeReiniciarJuego = false;
            }
            String tipoPlaneta = mg.getTipoPlanetaActual();
            System.out.println("FCE: Hola intento número " + jugador.getNumeroJugador());
            System.out.println("FCE: Tu nave está lista para despegar.");
            System.out.println("FCE: Te encuentras en el planeta 0.");
            System.out.println("FCE: Tipo de planeta actual: " + tipoPlaneta);
            System.out.println("FCE: ¿Deseas visitar el planeta? (true/false)");
            boolean visitar = scanner.nextBoolean();
            if (visitar) {
                switch (tipoPlaneta) {
                    case "Helado":
                        Helado planetaHelado = (Helado) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaHelado.visitar(jugador); 
                        break;
                    case "Radiactivo":
                        Radiactivo planetaRadiactivo = (Radiactivo) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaRadiactivo.visitar(jugador);
                        break;
                    case "Volcanico":
                        Volcanico planetaVolcanico = (Volcanico) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaVolcanico.visitar(jugador);
                        break;
                    default:
                        System.out.println("FCE: Tipo de planeta no reconocido.");
                        break;
                }
            } else {
                System.out.println("FCE: Volviendo a la órbita...");
            }

            if (indiceDeReiniciarJuego) {
                continue; 
            }

            System.out.println("FCE: ¿A qué planeta quieres ir? (desde el 1 hasta donde quieras ir)");
            int planeta = scanner.nextInt();
            mg.generarHastaPlaneta(planeta);
            System.out.println("FCE: Preparando salto...");
            nave.realizarSalto(planeta);
            if (nave.getUnidadesCombustible() <= 0) {
                System.out.println("FCE: No tienes suficiente combustible para realizar el salto.");
                System.out.println("FCE: Fin del juego.");
                break;
            }
            tipoPlaneta = mg.getTipoPlanetaActual();
            System.out.println("FCE: Has llegado al planeta " + planeta + ", tipo de planeta: " + tipoPlaneta);
        }

        scanner.close();
    }
}
