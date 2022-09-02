package Clases;

import java.util.ArrayList;

public class Torneo {

	//atributos
	private String nombre;
	private int cantSets;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugador3;
	private Jugador jugador4;
	private ArrayList<String> setEnPartido;
	
	//constructores
	public Torneo(String nombre, int cantSets, Jugador jugador1, Jugador jugador2) {
		this.nombre = nombre;
		this.cantSets = cantSets;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	
	
	public Torneo(String nombre, int cantSets, Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4) {
		this.nombre = nombre;
		this.cantSets = cantSets;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.jugador3 = jugador3;
		this.jugador4 = jugador4;
	}



	public Torneo() {
	}
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantSets() {
		return cantSets;
	}

	public void setCantSets(int cantSets) {
		this.cantSets = cantSets;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}



	public Jugador getJugador3() {
		return jugador3;
	}



	public void setJugador3(Jugador jugador3) {
		this.jugador3 = jugador3;
	}



	public Jugador getJugador4() {
		return jugador4;
	}



	public void setJugador4(Jugador jugador4) {
		this.jugador4 = jugador4;
	}

	
	
}
