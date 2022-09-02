package Clases;

public class Jugador {

	//atributos
	private String nombre;
	private int probabilidad;
	private Boolean saque;
	
	
	//constructores
	public Jugador(String nombre, int probabilidad, Boolean saque) {
		this.nombre = nombre;
		this.probabilidad = probabilidad;
		this.saque = saque;
	}


	public Jugador() {
	}
	
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getProbabilidad() {
		return probabilidad;
	}


	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}


	public Boolean getSaque() {
		return saque;
	}


	public void setSaque(Boolean saque) {
		this.saque = saque;
	}
	
	//metodo para mostrar quien tiene el saque
	public String mostrarSaque() {
		if(saque) {
			return "Tiene el saque";
			}else {
				return "		 ";
			}
	}
}
