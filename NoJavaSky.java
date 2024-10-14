import Planetas.Helado;
import Planetas.MapaGalactico;
import Planetas.Volcanico;
import Planetas.Radiactivo;
import Planetas.Oceanico;

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
        int tipo_recurso, cantidad_recurso, extraer, recargarInventario, salir = 0;
        //PONER QUE SE GASTE ENERGIA NO SE TE OLVIDE
        //APLICAR PLANETA SALIR
        //HACER EL FINAL DEL JUEGO
        //HACER LA FUNCION DEL PUTO SALTO EN LA WEÁ DE NAVE Q PAJA CTM
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
            System.out.println("FCE: Te encuentras en el planeta " + mg.getPlanetaActual().getClass().getSimpleName());
            System.out.println("FCE: ¿Deseas visitar el planeta? (1 = sí, 0 = no)");
            int visitar = scanner.nextInt();

            if (visitar == 1) {
                switch (tipoPlaneta) {
                    case "Helado":
                        Helado planetaHelado = (Helado) mg.getPlanetaActual();
                        planetaHelado.visitar(jugador);
                        while(salir == 0){
                            System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                            extraer = scanner.nextInt();
                            if (extraer == 1) {
                                System.out.println("¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaHelado.setCantidadExtraer(extraer);
                                if (tipo_recurso == 1) {
                                    recargarInventario = planetaHelado.extraerRecursos(tipo_recurso);
                                    jugador.recolectarCristales(recargarInventario);
                                } else if (tipo_recurso == 2) {
                                    recargarInventario = planetaHelado.extraerRecursos(tipo_recurso);
                                    jugador.recolectarFlores(recargarInventario);
                                }
                            }
                            if(planetaHelado.getAsentamiento()){
                                System.out.println("FCE: ¿Deseas explorar asentamientos? (1 = sí, 0 = no)");
                                int explorarAsentamientos = scanner.nextInt();
                                if (explorarAsentamientos == 1) {
                                    planetaHelado.visitarAsentamientos(jugador);
                                }
                            }
                            System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                            salir = scanner.nextInt();
                            if(salir == 1){
                                
                                break;
                            }
                        }
                        break;

                    case "Radiactivo":
                        Radiactivo planetaRadiactivo = (Radiactivo) mg.getPlanetaActual();
                        planetaRadiactivo.visitar(jugador);
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while(salir == 0){
                            System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                            extraer = scanner.nextInt();
                            if (extraer == 1) {
                                System.out.println("¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio, 3 para Uranio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaRadiactivo.setCantidadExtraer(extraer);
                                if (tipo_recurso == 1) {
                                    recargarInventario = planetaRadiactivo.extraerRecursos(tipo_recurso);
                                    jugador.recolectarCristales(recargarInventario);
                                } else if (tipo_recurso == 2) {
                                    recargarInventario = planetaRadiactivo.extraerRecursos(tipo_recurso);
                                    jugador.recolectarFlores(recargarInventario);
                                } else if (tipo_recurso == 3) {
                                    recargarInventario = planetaRadiactivo.extraerRecursos(tipo_recurso);
                                    jugador.recolectarUranio(recargarInventario);
                                }
                            }
                            System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                            salir = scanner.nextInt();
                            if(salir == 1){
                                break;
                            }
                        }
                        break;

                    case "Oceanico":
                        Oceanico planetaOceanico = (Oceanico) mg.getPlanetaActual();
                        planetaOceanico.visitar(jugador);
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while(salir == 0){
                            System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                            extraer = scanner.nextInt();
                            if (extraer == 1) {
                                System.out.println("¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaOceanico.setCantidadExtraer(extraer);
                                if (tipo_recurso == 1) {
                                    recargarInventario = planetaOceanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarCristales(recargarInventario);
                                } else if (tipo_recurso == 2) {
                                    recargarInventario = planetaOceanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarFlores(recargarInventario);
                                } else if (tipo_recurso == 3) {
                                    recargarInventario = planetaOceanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarUranio(recargarInventario);
                                }
                            }
                            System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                            salir = scanner.nextInt();
                            if(salir == 1){
                                break;
                            }
                        }
                        break;

                    case "Volcanico":
                        Volcanico planetaVolcanico = (Volcanico) mg.getPlanetaActual();
                        planetaVolcanico.visitar(jugador);
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while(salir == 0){
                            System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                            extraer = scanner.nextInt();
                            if (extraer == 1) {
                                System.out.println("¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio, 3 para Uranio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaVolcanico.setCantidadExtraer(extraer);
                                if (tipo_recurso == 1) {
                                    recargarInventario = planetaVolcanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarCristales(recargarInventario);
                                } else if (tipo_recurso == 2) {
                                    recargarInventario = planetaVolcanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarFlores(recargarInventario);
                                } else if (tipo_recurso == 3) {
                                    recargarInventario = planetaVolcanico.extraerRecursos(tipo_recurso);
                                    jugador.recolectarUranio(recargarInventario);
                                }
                            }
                            System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                            salir = scanner.nextInt();
                            if(salir == 1){
                                break;
                            }
                        }
                        break;

                    default:
                        System.out.println("FCE: Tipo de planeta no reconocido.");
                        break;
                }
            } else {
                System.out.println("FCE: Volviendo a la órbita...");
            }
            System.out.println("FCE: En la orbita del planeta");
            System.out.println("FCE: ¿Deseas recargar tu traje? (1 = sí, 0 = no)");
            int recargar = scanner.nextInt();
            if (recargar == 1) {
                System.out.println("FCE: Quieres ver las flores de sodio en tu inventario? (1 = sí, 0 = no)");
                int verInventario = scanner.nextInt();
                if (verInventario == 1) {
                    System.out.println("FCE: Flores de sodio en tu inventario: " + jugador.getFloresDeSodio());
                }
                System.out.println("FCE: Cuanta cantidad deseas recargar? Para este se usan las flores de sodio");
                int cantRecarga = scanner.nextInt();
                jugador.recargarEnergiaProteccion(cantRecarga);
                System.out.println("FCE: Cantidad de energía actual: " + jugador.getEnergia());
            }
            System.out.println("FCE: ¿Deseas recargar tu nave? (1 = sí, 0 = no)");
            int recargarNave = scanner.nextInt();
            if (recargarNave == 1) {
                System.out.println("FCE: Cuanta cantidad deseas recargar? Para este se usan los cristales de hidrógeno");
                int cantRecargaNave = scanner.nextInt();
                nave.recargarPropulsores(cantRecargaNave);
                System.out.println("FCE: Cantidad de combustible actual: " + nave.getUnidadesCombustible());
            }

            System.out.println("FCE: ¿A qué planeta quieres ir? (ingresa el número del planeta)");
            int planeta = scanner.nextInt();
            while(true){
                if(nave.calcularConsumo(planeta) > nave.getUnidadesCombustible()){
                    System.out.println("FCE: No tienes suficiente combustible para llegar a ese planeta.");
                    System.out.println("FCE: Prueba con otro planeta.");
                }
                else{
                    break;
                }
            }
            mg.generarHastaPlaneta(planeta);
            System.out.println("FCE: Preparando salto...");
            nave.realizarSalto(planeta);

            if (nave.getUnidadesCombustible() <= 0) {
                System.out.println("FCE: No tienes suficiente combustible para realizar el salto.");
                System.out.println("FCE: Fin del juego.");
                break;
            }

            System.out.println("FCE: Has llegado al planeta " + planeta + ", tipo de planeta: " + mg.getTipoPlanetaActual());
        }

        scanner.close();
    }
}
