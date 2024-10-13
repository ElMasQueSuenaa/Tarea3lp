import Planetas.Planeta;
import Planetas.Helado;
import Planetas.MapaGalactico;
import Planetas.CentroGalactico;
import Planetas.Volcanico;
import Planetas.Radiactivo;
import Planetas.Oceanico;
import Interfaz.tieneAsentamientos;

import java.util.Scanner;
import java.util.InputMismatchException;

import Interactuable.Jugador;
import Interactuable.Nave;

public class NoJavaSky {
    public static void main(String[] args) {
        MapaGalactico mg = new MapaGalactico();
        Jugador jugador = new Jugador();
        Nave nave = new Nave();
        Scanner scanner = new Scanner(System.in);
        boolean indiceDeReiniciarJuego = false;
        boolean posibleAsentamiento = false;

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
            System.out.println("FCE: ¿Deseas visitar el planeta? (1 = sí, 0 = no)");

            int visitar = -1;  
            try {
                if (scanner.hasNextInt()) {
                    visitar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()
                } else {
                    throw new InputMismatchException();
                }

                if (visitar != 0 && visitar != 1) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Se asumirá que no deseas visitar el planeta.");
                scanner.nextLine();  // Limpiar la entrada inválida
                continue;  // Volver a pedir la entrada
            }

            if (visitar == 1) {  
                switch (tipoPlaneta) {
                    case "Helado":
                        Helado planetaHelado = (Helado) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaHelado.visitar(jugador); 
                        posibleAsentamiento = true;
                        break;
                    case "Radiactivo":
                        Radiactivo planetaRadiactivo = (Radiactivo) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaRadiactivo.visitar(jugador);
                        break;
                    case "Oceanico":
                        Oceanico planetaOceanico = (Oceanico) mg.getPlanetaActual();
                        indiceDeReiniciarJuego = !planetaOceanico.visitar(jugador);
                        posibleAsentamiento = true;
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

            if (posibleAsentamiento) {
                System.out.println("FCE: Puede ser que haya un asentamiento en este planeta, ¿deseas explorar más? (1 = sí, 0 = no)");

                int aux = -1;
                try {
                    if (scanner.hasNextInt()) {
                        aux = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()
                    } else {
                        throw new InputMismatchException();
                    }

                    if (aux != 0 && aux != 1) {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, ingresa '0' o '1'.");
                    scanner.nextLine();  // Limpiar la entrada inválida
                    continue;
                }

                if (aux == 1) {  
                    switch (tipoPlaneta) {
                        case "Helado":
                            Helado planetaHelado = (Helado) mg.getPlanetaActual();
                            planetaHelado.visitarAsentamientos(jugador);
                            break;
                        case "Oceanico":
                            Oceanico planetaOceanico = (Oceanico) mg.getPlanetaActual();
                            planetaOceanico.visitarAsentamientos(jugador);
                            break;
                        default:
                            System.out.println("Tipo de planeta no soportado para asentamientos.");
                            break;
                    }
                }
            }

            System.out.println("FCE: ¿A qué planeta quieres ir? (ingresa el número del planeta)");
            int planeta = -1;
            try {
                if (scanner.hasNextInt()) {
                    planeta = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente después de nextInt()
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debes ingresar un número válido.");
                scanner.nextLine();  // Limpiar la entrada inválida
                continue;  // Volver a pedir la entrada
            }

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
