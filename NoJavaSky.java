import Planetas.CentroGalactico;
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
        int seguirComprando = 1;
        int visitar;
        String tipoPlaneta = mg.getTipoPlanetaActual();
        System.out.println("FCE: Hola intento número " + jugador.getNumeroJugador());
        System.out.println("FCE: Tu nave está lista para despegar.");
        System.out.println("FCE: Te encuentras en el planeta " + mg.getPlanetaActual().getClass().getSimpleName());
        while (true) {
            if (indiceDeReiniciarJuego) {
                System.out.println("FCE: Has perdido. Alguna vez coincidiremos de nuevo...");
                jugador = new Jugador(); 
                nave = new Nave(); 
                mg = new MapaGalactico();
                mg.generarHastaPlaneta(1);
                mg.setPosicion(0); 
                indiceDeReiniciarJuego = false;
            }
            System.out.println(mg.getPosicionActual());
            tipoPlaneta = mg.getTipoPlanetaActual();
            if (tipoPlaneta != null) {
                // Aquí ingresas al planeta y puedes ejecutar la lógica correspondiente
                System.out.println(tipoPlaneta);
            } else {
                System.out.println("No puedes ingresar a este planeta.");
            }
            System.out.println("FCE: ¿Deseas visitar el planeta? (1 = sí, 0 = no)");
            visitar = scanner.nextInt();
            if (visitar == 1) {
                switch (tipoPlaneta) {
                    case "Helado":
                    Helado planetaHelado = (Helado) mg.getPlanetaActual();
                    planetaHelado.visitar(jugador);
                    while (salir == 0) {
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while (extraer == 1) {
                            if (extraer == 1) {
                                System.out.println("FCE: ¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("FCE: ¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaHelado.setCantidadExtraer(extraer);
                                System.out.println("FCE: Según la cantidad de recursos que deseas extraer, se gastará energía.");
                                if (jugador.CorroborarGastoEnergiaTraje(cantidad_recurso)) {
                                    if (tipo_recurso == 1) {
                                        recargarInventario = planetaHelado.extraerRecursos(tipo_recurso);
                                        jugador.recolectarCristales(recargarInventario);
                                    } else if (tipo_recurso == 2) {
                                        recargarInventario = planetaHelado.extraerRecursos(tipo_recurso);
                                        jugador.recolectarFlores(recargarInventario);
                                    }
                                    jugador.gastarEnergiaTraje(cantidad_recurso);
                                    System.out.println("FCE: Energia despues de extraer: " + jugador.getEnergia());
                                    System.out.println("FCE: ¿Deseas seguir extrayendo recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                } 
                                else {
                                    System.out.println("FCE: No tienes suficiente energía para extraer esa cantidad de recursos.");
                                    System.out.println("FCE: Escoges extraer menos recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                }
                            }
                        }
                        if (planetaHelado.getAsentamiento()) {
                            System.out.println("FCE: ¿Deseas explorar asentamientos? (1 = sí, 0 = no)");
                            int explorarAsentamientos = scanner.nextInt();
                            if (explorarAsentamientos == 1) {
                                while (seguirComprando != 0) {
                                    planetaHelado.visitarAsentamientos(jugador);
                                    int eleccion = scanner.nextInt();
                                    planetaHelado.asignarTrade(eleccion, jugador, nave);
                                    System.out.println("FCE: ¿Deseas seguir comerciando? (1 = sí, 0 = no)");
                                    seguirComprando = scanner.nextInt();
                                }
                            }
                        }
                        System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                        salir = scanner.nextInt();
                        if (salir == 1) {
                            planetaHelado.salir();
                            break;
                        }
                    }
                    break;

                    case "Radiactivo":
                    Radiactivo planetaRadiactivo = (Radiactivo) mg.getPlanetaActual();
                    planetaRadiactivo.visitar(jugador);
                    while (salir == 0) {
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while (extraer == 1) {
                            if (extraer == 1) {
                                System.out.println("FCE: ¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio, 3 para Uranio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("FCE: ¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaRadiactivo.setCantidadExtraer(extraer);
                                System.out.println("FCE: Según la cantidad de recursos que deseas extraer, se gastará energía.");
                                System.out.println("FCE: Quieres ver tu energia actual? (1 = sí, 0 = no)");

                                int verEnergia = scanner.nextInt();
                                if (verEnergia == 1) {
                                    System.out.println("FCE: Energía actual: " + jugador.getEnergia());
                                }

                                if (jugador.CorroborarGastoEnergiaTraje(cantidad_recurso)) {
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

                                    jugador.gastarEnergiaTraje(cantidad_recurso);
                                    System.out.println("FCE: ¿Deseas seguir extrayendo recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                } 
                                else {
                                    System.out.println("FCE: No tienes suficiente energía para extraer esa cantidad de recursos.");
                                    System.out.println("FCE: Escoges extraer menos recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                }
                            }
                        }
                        System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                        salir = scanner.nextInt();
                        if (salir == 1) {
                            planetaRadiactivo.salir();
                            break;
                        }
                    }
                    break;

                    case "Oceanico":
                    Oceanico planetaOceanico = (Oceanico) mg.getPlanetaActual();
                    planetaOceanico.visitar(jugador);
                    while (salir == 0) {
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while (extraer == 1) {
                            if (extraer == 1) {
                                System.out.println("FCE: ¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("FCE: ¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaOceanico.setCantidadExtraer(extraer);
                                System.out.println("FCE: Según la cantidad de recursos que deseas extraer, se gastará energía.");
                                System.out.println("FCE: Quieres ver tu energia actual? (1 = sí, 0 = no)");

                                int verEnergia = scanner.nextInt();
                                if (verEnergia == 1) {
                                    System.out.println("FCE: Energía actual: " + jugador.getEnergia());
                                }

                                if (jugador.CorroborarGastoEnergiaTraje(cantidad_recurso)) {
                                    if (tipo_recurso == 1) {
                                        recargarInventario = planetaOceanico.extraerRecursos(tipo_recurso);
                                        jugador.recolectarCristales(recargarInventario);
                                    } else if (tipo_recurso == 2) {
                                        recargarInventario = planetaOceanico.extraerRecursos(tipo_recurso);
                                        jugador.recolectarFlores(recargarInventario);
                                    }
                                    jugador.gastarEnergiaTraje(cantidad_recurso);
                                    System.out.println("FCE: ¿Deseas seguir extrayendo recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                } 
                                else {
                                    System.out.println("FCE: No tienes suficiente energía para extraer esa cantidad de recursos.");
                                    System.out.println("FCE: Escoges extraer menos recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                }
                            }
                        }
                        if (planetaOceanico.getAsentamiento()) {
                            System.out.println("FCE: ¿Deseas explorar asentamientos? (1 = sí, 0 = no)");
                            int explorarAsentamientos = scanner.nextInt();
                            if (explorarAsentamientos == 1) {
                                while (seguirComprando != 0) {
                                    planetaOceanico.visitarAsentamientos(jugador);
                                    int eleccion = scanner.nextInt();
                                    planetaOceanico.asignarTrade(eleccion, jugador, nave);
                                    System.out.println("FCE: ¿Deseas seguir comerciando? (1 = sí, 0 = no)");
                                    seguirComprando = scanner.nextInt();
                                }
                            }
                        }
                        System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                        salir = scanner.nextInt();
                        if (salir == 1) {
                            planetaOceanico.salir();
                            break;
                        }
                    }
                    break;

                    case "Volcanico":
                    Volcanico planetaVolcanico = (Volcanico) mg.getPlanetaActual();
                    planetaVolcanico.visitar(jugador);
                    System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                    extraer = scanner.nextInt();
                    while (salir == 0) {
                        System.out.println("FCE: ¿Deseas extraer recursos del planeta? (1 = sí, 0 = no)");
                        extraer = scanner.nextInt();
                        while (extraer == 1) {
                            if (extraer == 1) {
                                System.out.println("FCE: ¿Qué recurso deseas extraer? 1 para Cristales de Hidrógeno, 2 para Flores de Sodio");
                                tipo_recurso = scanner.nextInt();
                                System.out.println("FCE: ¿Cuántas unidades deseas extraer?");
                                cantidad_recurso = scanner.nextInt();
                                planetaVolcanico.setCantidadExtraer(extraer);
                                System.out.println("FCE: Según la cantidad de recursos que deseas extraer, se gastará energía.");
                                System.out.println("FCE: Quieres ver tu energia actual? (1 = sí, 0 = no)");

                                int verEnergia = scanner.nextInt();
                                if (verEnergia == 1) {
                                    System.out.println("FCE: Energía actual: " + jugador.getEnergia());
                                }

                                if (jugador.CorroborarGastoEnergiaTraje(cantidad_recurso)) {
                                    if (tipo_recurso == 1) {
                                        recargarInventario = planetaVolcanico.extraerRecursos(tipo_recurso);
                                        jugador.recolectarCristales(recargarInventario);
                                    } else if (tipo_recurso == 2) {
                                        recargarInventario = planetaVolcanico.extraerRecursos(tipo_recurso);
                                        jugador.recolectarFlores(recargarInventario);
                                    }
                                    jugador.gastarEnergiaTraje(cantidad_recurso);
                                    System.out.println("FCE: ¿Deseas seguir extrayendo recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                } 
                                else {
                                    System.out.println("FCE: No tienes suficiente energía para extraer esa cantidad de recursos.");
                                    System.out.println("FCE: Escoges extraer menos recursos? (1 = sí, 0 = no)");
                                    extraer = scanner.nextInt();
                                }
                            }
                        }
                        System.out.println("FCE: ¿Deseas salir del planeta? (1 = sí, 0 = no)");
                        salir = scanner.nextInt();
                        if (salir == 1) {
                            planetaVolcanico.salir();
                            break;
                        }
                    }
                    break;

                    case "CentroGalactico":
                    CentroGalactico planetaCentroGalactico = (CentroGalactico) mg.getPlanetaActual();
                    System.out.println("FCE: Se ha encontrado el centro galáctico.");
                    System.out.println("FCE: Se necesita 50.0% de eficiencia para visitarlo.");
                    if (jugador.getEficienciatraje() >= 0.5) {
                        System.out.println("FCE: Quieres terminar tu viaje? (1 = sí, 0 = no)");
                        int terminarViaje = scanner.nextInt();
                        if (terminarViaje == 1) {
                            planetaCentroGalactico.visitar(jugador);
                            break;
                        } 
                    } 
                    else {
                        System.out.println("FCE: No tienes la eficiencia necesaria para visitar el centro galáctico.");
                        break;
                    }

                    default:
                        System.out.println("FCE: Tipo de planeta no reconocido.");
                        break;
                }
                }
                extraer = 0;
                salir = 0;
                if (indiceDeReiniciarJuego) {
                    continue;
                } 
                else {
                    System.out.println("FCE: En la orbita del planeta");
                    System.out.println("FCE: ¿Deseas ver tu inventario? (1 = sí, 0 = no)");
                    int verInventario = scanner.nextInt();
                    if (verInventario == 1) {
                        mostrarInventario(jugador, nave);
                    }

                    System.out.println("FCE: ¿Deseas recargar tu traje? (1 = sí, 0 = no)");
                    int recargar = scanner.nextInt();
                    if (recargar == 1) {
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

                    System.out.println("FCE: ¿A qué planeta quieres ir? (ingresa el tamaño del salto)");
                    int planeta = scanner.nextInt();
                    while (true) {
                        if (nave.calcularConsumo(planeta) > nave.getUnidadesCombustible()) {
                            System.out.println("FCE: No tienes suficiente combustible para llegar a ese planeta.");
                            System.out.println("FCE: Prueba con otro planeta.");
                            planeta = scanner.nextInt();
                        } 
                        else{
                        break;
                        }
                    }
                    nave.viajarPlaneta(mg, planeta, planeta);
                    if (nave.getUnidadesCombustible() <= 0) {
                        System.out.println("FCE: No tienes suficiente combustible para realizar el salto.");
                        System.out.println("FCE: Fin del juego.");
                        break;
                    }

                    System.out.println("FCE: Has llegado a un planeta de tipo: " + mg.getTipoPlanetaActual());
                }
        }
        scanner.close();
    }

    public static void mostrarInventario(Jugador jugador, Nave nave){
        System.out.println("FCE: Cristales de Hidrógeno en tu inventario: " + jugador.getCristalesHidrogeno());
        System.out.println("FCE: Flores de Sodio en tu inventario: " + jugador.getFloresDeSodio());
        System.out.println("FCE: Platino en tu inventario: " + jugador.getPlatino());
        System.out.println("FCE: Uranio en tu inventario: " + jugador.getUranio());
        System.out.println("FCE: Energía en tu traje: " + jugador.getEnergia());
        System.out.println("FCE: Eficiencia de energía en tu traje: " + jugador.getEficienciatraje());
        System.out.println("FCE: Unidades de combustible en tu nave: " + nave.getUnidadesCombustible());
        System.out.println("FCE: Eficiencia de combustible en tu nave: " + nave.getEficienciaCombustible());
    }
}

