package Controlador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Clases.Jugador;
import Clases.Torneo;
import Servicios.ServicioTenisImplementacion;
import Validaciones.Validar;

public class ControladorPrincipal {

	
	public void juego() {
	Scanner sc = new Scanner(System.in);
	Validar validar = new Validar();
	
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
		
		int probabilidadJ1 = validar.validarProbabilidad();
		
		System.out.println("Ingrese el nombre del segundo jugador");
		//sc.nextLine();
		String nombreJ2 = sc.nextLine();
		
		int probabilidadJ2 = validar.validarProbabilidad();
		
		j1.setNombre(nombreJ1);
		j1.setProbabilidad(probabilidadJ1);
		j2.setNombre(nombreJ2);
		j2.setProbabilidad(probabilidadJ2);
		
		System.out.println("Ingrese el nombre del torneo:");
		String nombreTorneo = sc.nextLine();

		int cantSets = validar.validarSets();
		do {
		Torneo torneo = new Torneo(nombreTorneo, cantSets, j1, j2 );
		
		ServicioTenisImplementacion s1 = new ServicioTenisImplementacion(torneo);
		
		s1.partidoIndividual();
		
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
		
		int probabilidadJT1 = validar.validarProbabilidad();
		jT1 = new Jugador(nombreJT1, probabilidadJT1, null);
		
		System.out.println("Ingrese el nombre del segundo jugador");
		String nombreJT2 = sc.nextLine();
		
		int probabilidadJT2 = validar.validarProbabilidad();
		jT2 = new Jugador(nombreJT2, probabilidadJT2, null);
		
		System.out.println("Ingrese el nombre del tercer jugador");
		String nombreJT3 = sc.nextLine();
		
		int probabilidadJT3 = validar.validarProbabilidad();
		jT3 = new Jugador(nombreJT3, probabilidadJT3, null);
		
		System.out.println("Ingrese el nombre del cuarto jugador");
		String nombreJT4 = sc.nextLine();
		 
		int probabilidadJT4 = validar.validarProbabilidad();
		jT4 = new Jugador(nombreJT4, probabilidadJT4, null);
		
		System.out.println("Ingrese el nombre del torneo:");
		String nombreTorneoT = sc.nextLine();
		
		int cantSetsT = validar.validarSets();
		Torneo tTorneo = new Torneo(nombreTorneoT, cantSetsT, jT1, jT2, jT3, jT4);
		
		//inicia el torneo
		//semifinal 1
		do {
		Torneo torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), tTorneo.getJugador1(), tTorneo.getJugador2());
		
		ServicioTenisImplementacion s1 = new ServicioTenisImplementacion(torneo);
		
		j1 = s1.partidoSemifinal();
		
		//Semifinal 2
		torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), tTorneo.getJugador3(), tTorneo.getJugador4());
		
		s1 = new ServicioTenisImplementacion(torneo);
		
		j2 = s1.partidoSemifinal();
		
		//Final
		torneo = new Torneo(tTorneo.getNombre(), tTorneo.getCantSets(), j1, j2);
		
		s1 = new ServicioTenisImplementacion(torneo);
		
		s1.partidoIndividual();
		
		repeticion = Integer.parseInt(sc.next());
		} while(repeticion == 1);
		System.out.println("Saliendo");
		
		break;
		
	case 3:
		System.out.println("Saliendo");

	default:
		break;
	}}
}
