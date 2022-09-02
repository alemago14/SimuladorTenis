package PartidoTenis;

import java.util.Scanner;

import Clases.Jugador;
import Clases.Torneo;
import Controlador.ControladorPrincipal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido al simulador de tennis");
		
		System.out.println("Simulador de marcador de tenis");
		System.out.println("Ingrese 1: Para partido individual");
		System.out.println("Ingrese 2: Para torneo de 4 jugadores");
		System.out.println("Ingrese 3: Para salir");
		int opcion = Integer.parseInt(sc.next());
		int repeticion = 0;
		
		switch (opcion) {
		case 1:
			System.out.println("Partido individual");
			
			Jugador j1 = new Jugador();
			Jugador j2 = new Jugador();
			
			System.out.println("Ingrese el nombre del primer jugador");
			sc.nextLine();
			String nombreJ1 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJ1 = Integer.parseInt(sc.next());
			
			System.out.println("Ingrese el nombre del segundo jugador");
			sc.nextLine();
			String nombreJ2 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJ2 = Integer.parseInt(sc.next());
			
			j1.setNombre(nombreJ1);
			j1.setProbabilidad(probabilidadJ1);
			j2.setNombre(nombreJ2);
			j2.setProbabilidad(probabilidadJ2);
			
			System.out.println("Ingrese el nombre del torneo:");
			sc.nextLine();
			String nombreTorneo = sc.next();
			System.out.println("Ingrese la cantidad de sets a jugar");
			int cantSets = Integer.parseInt(sc.next());
			do {
			Torneo torneo = new Torneo(nombreTorneo, cantSets, j1, j2 );
			
			ControladorPrincipal c1 = new ControladorPrincipal(torneo);
			
			c1.primerSaque();
			int juego = 0;
			int set = 0;
			
			for (int i = 0; i < cantSets; i++) {
				do {
					do {
						juego = c1.sumarPunto(c1.calcularPunto());
						c1.esperar();
					} while (juego == 0);
					c1.cambiarSaque();
					c1.sumarJuego(juego);
					c1.setearPuntajes();
					set = c1.ganarSet();
					c1.esperar();
					c1.esperar();
					
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
					
				} while (set == 0);
				c1.sumarSet();
				c1.setearSet();
			}
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			c1.mostrarSet();
			c1.esperar();
			c1.esperar();
			
			System.out.println("Ingrese 1 para repetir el partido");
			System.out.println("O Ingrese cualquier otro numero para salir");
			repeticion = Integer.parseInt(sc.next());
			} while (repeticion == 1);
			System.out.println("Saliendo");
			
			break;
			
		case 2:
			System.out.println("Torneo de 4 jugadores");
			
			Jugador jT1 = new Jugador();
			Jugador jT2 = new Jugador();
			Jugador jT3 = new Jugador();
			Jugador jT4 = new Jugador();
			
			System.out.println("Ingrese el nombre del primer jugador");
			sc.nextLine();
			String nombreJT1 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJT1 = Integer.parseInt(sc.next());
			jT1 = new Jugador(nombreJT1, probabilidadJT1, null);
			
			System.out.println("Ingrese el nombre del segundo jugador");
			sc.nextLine();
			String nombreJT2 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJT2 = Integer.parseInt(sc.next());
			jT2 = new Jugador(nombreJT2, probabilidadJT2, null);
			
			System.out.println("Ingrese el nombre del tercer jugador");
			sc.nextLine();
			String nombreJT3 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJT3 = Integer.parseInt(sc.next());
			jT3 = new Jugador(nombreJT3, probabilidadJT3, null);
			
			System.out.println("Ingrese el nombre del cuarto jugador");
			sc.nextLine();
			String nombreJT4 = sc.nextLine();
			System.out.println("Ingrese sus posibilidad de ganar");
			int probabilidadJT4 = Integer.parseInt(sc.next());
			jT4 = new Jugador(nombreJT4, probabilidadJT4, null);
			
			System.out.println("Ingrese el nombre del torneo:");
			sc.nextLine();
			String nombreTorneoT = sc.nextLine();
			System.out.println("Ingrese la cantidad de sets a jugar");
			int cantSetsT = Integer.parseInt(sc.next());
			Torneo tTorneo = new Torneo(nombreTorneoT, cantSetsT, jT1, jT2, jT3, jT4);
			
			//inicia el torneo
			//semifinal 1
			do {
			Torneo torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), tTorneo.getJugador1(), tTorneo.getJugador2());
			
			ControladorPrincipal c1 = new ControladorPrincipal(torneo);
			
			c1.primerSaque();
			int juego = 0;
			int set = 0;
			
			for (int i = 0; i < torneo.getCantSets(); i++) {
				do {
					do {
						juego = c1.sumarPunto(c1.calcularPunto());
						c1.esperar();
					} while (juego == 0);
					c1.cambiarSaque();
					c1.sumarJuego(juego);
					c1.setearPuntajes();
					set = c1.ganarSet();
					c1.esperar();
					c1.esperar();
					
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
					
				} while (set == 0);
				c1.sumarSet();
				c1.setearSet();
			}
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			j1 = c1.semifinal();
			c1.esperar();
			c1.esperar();
			
			//Semifinal 2
			torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), tTorneo.getJugador3(), tTorneo.getJugador4());
			
			c1 = new ControladorPrincipal(torneo);
			
			c1.primerSaque();
			 juego = 0;
			set = 0;
			
			for (int i = 0; i < torneo.getCantSets(); i++) {
				do {
					do {
						juego = c1.sumarPunto(c1.calcularPunto());
						c1.esperar();
					} while (juego == 0);
					c1.cambiarSaque();
					c1.sumarJuego(juego);
					c1.setearPuntajes();
					set = c1.ganarSet();
					c1.esperar();
					c1.esperar();
					
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
					
				} while (set == 0);
				c1.sumarSet();
				c1.setearSet();
			}
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			j2 = c1.semifinal();
			c1.esperar();
			c1.esperar();
			
			//Final
			torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), j1, j2);
			
			c1 = new ControladorPrincipal(torneo);
			
			c1.primerSaque();
			 juego = 0;
			set = 0;
			
			for (int i = 0; i < torneo.getCantSets(); i++) {
				do {
					do {
						juego = c1.sumarPunto(c1.calcularPunto());
						c1.esperar();
					} while (juego == 0);
					c1.cambiarSaque();
					c1.sumarJuego(juego);
					c1.setearPuntajes();
					set = c1.ganarSet();
					c1.esperar();
					c1.esperar();
					
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
					
				} while (set == 0);
				c1.sumarSet();
				c1.setearSet();
			}
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
			c1.mostrarSet();
			c1.esperar();
			c1.esperar();
			
			System.out.println("Ingrese 1 para repetir el torneo");
			System.out.println("O Ingrese cualquier otro numero para salir");
			repeticion = Integer.parseInt(sc.next());
			} while(repeticion == 1);
			System.out.println("Saliendo");
			
			break;
			
		case 3:
			System.out.println("Saliendo");

		default:
			break;
		}
	}
}
