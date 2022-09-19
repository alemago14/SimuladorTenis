package Servicios;

import Clases.Jugador;

public interface ServicioTenis {

	public void primerSaque();
	
	public int calcularPunto();
	
	public int sumarPunto(int punto);
	
	public void mostrarPuntaje();
	
	public void esperar();
	
	public void cambiarSaque();
	
	public void sumarJuego(int juego);
	
	public void setearPuntajes();
	
	public int ganarSet();
	
	public void sumarSet();
	
	public void setearSet();
	
	public void mostrarSet();
	
	public int ganadorEs();
	
	public Jugador semifinal();
	
	public void partidoIndividual();
	
	public Jugador partidoSemifinal();
	
	
}
