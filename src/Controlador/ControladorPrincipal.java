package Controlador;

import java.util.ArrayList;
import java.util.Random;

import Clases.Jugador;
import Clases.Torneo;

public class ControladorPrincipal {

	// atributos
	private Jugador j1;
	private Jugador j2;
	private Torneo torneo;

	private String puntajej1 = "0";
	private String puntajej2 = "0";

	private int juegoj1 = 0;
	private int juegoj2 = 0;
	
	private ArrayList<Integer> set1 = new ArrayList<>();
	private ArrayList<Integer> set2 = new ArrayList<>();

	// Constructor
	public ControladorPrincipal(Torneo torneo) {
		this.torneo = torneo;
		this.j1 = torneo.getJugador1();
		this.j2 = torneo.getJugador2();
	}
	

	// metodo que representaria la accion inicial de voltear raquetas para el saque
	public void primerSaque() {
		Random random = new Random();
		int pSaque = random.nextInt(j1.getProbabilidad() + j2.getProbabilidad());
		System.out.println(pSaque);

		if (j1.getProbabilidad() >= pSaque) {
			j1.setSaque(true);
			j2.setSaque(false);
			System.out.println("El saque es de " + j1.getNombre());

		} else {
			j1.setSaque(false);
			j2.setSaque(true);
			System.out.println("El saque es de " + j2.getNombre());
		}
	}

	// metodo que segun las probabilidades de cada jugador establece quien hace un
	// punto, devuelve el n de jugador que hizo el punto
	public int calcularPunto() {
		Random random = new Random();
		int punto = random.nextInt(j1.getProbabilidad() + j2.getProbabilidad());

		if (j1.getProbabilidad() >= punto) {
			return 1;
		} else {
			return 2;
		}
	}

	// metodo que segun lo que devuelve el metodo calcularPunto suma el puntaje de
	// cada juego
	public int sumarPunto(int punto) {
		int juego = 0;

		if(punto == 1) {
			if (puntajej1 == "0") {
				puntajej1 = "15";
			}else {
				if(puntajej1 == "15") {
					puntajej1 = "30";
				}else {
					if(puntajej1 == "30") {
						puntajej1 = "40";
					}else {
						if(puntajej1 == "40" && (puntajej2 == "0" || puntajej2 == "15" || puntajej2 == "30")) {
							puntajej1 = "Juego";
							juego = 1;
						}else {
							if(puntajej1 == "40" && puntajej2 == "40") {
								puntajej1 = "PJ";
							}else {
								if(puntajej1 == "40" && puntajej2 == "PJ") {
									puntajej2 = "40";
								}else {
									if(puntajej1 == "PJ" && puntajej2 == "40") {
										puntajej1 = "Juego";
										juego = 1;
									}
								}
							}
						}
					}
				}
			}
		}else {
			if (puntajej2 == "0") {
				puntajej2 = "15";
			}else {
				if(puntajej2 == "15") {
					puntajej2 = "30";
				}else {
					if(puntajej2 == "30") {
						puntajej2 = "40";
					}else {
						if(puntajej2 == "40" && (puntajej1 == "0" || puntajej1 == "15" || puntajej1 == "30")) {
							puntajej2 = "Juego";
							juego = 2;
						}else {
							if(puntajej2 == "40" && puntajej1 == "40") {
								puntajej2 = "PJ";
							}else {
								if(puntajej2 == "40" && puntajej1 == "PJ") {
									puntajej1 = "40";
								}else {
									if(puntajej2 == "PJ" && puntajej1 == "40") {
										puntajej2 = "Juego";
										juego = 2;
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(j1.getNombre() + " " + j1.mostrarSaque());
		System.out.println("J1 Puntaje: " + puntajej1 + "|| Set:  | "+ juegoj1+"|");
		System.out.println("J2 Puntaje: " + puntajej2 + "|| Set:  | "+ juegoj2+"|");
		System.out.println(j2.getNombre() + " " + j2.mostrarSaque());
		return juego;
	}

	// Metodo para esperar un segundo
	public void esperar() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	// Metodo para cambiar el saque
	public void cambiarSaque() {
		if (j1.getSaque()) {
			j1.setSaque(false);
			j2.setSaque(true);
		} else {
			j1.setSaque(true);
			j2.setSaque(false);
		}
	}

	// metodo para sumar un punto al juego
	public void sumarJuego(int juego) {
		if (juego == 1) {
			juegoj1 = juegoj1 + 1;
		} else {
			juegoj2 = juegoj2 + 1;
		}
	}

	// metodo para setear los puntajes
	public void setearPuntajes() {
		puntajej1 = "0";
		puntajej2 = "0";
	}

	// Metodo para comprobar quien gano el set
	public int ganarSet() {
		int gano = 0;

		if (juegoj1 == 6 && juegoj2 < 5) {
			gano = 1;
		} else {
			if (juegoj1 > 6 && (juegoj1 - juegoj2 == 2)) {
				gano = 1;
			} else {
				if (juegoj2 == 6 && juegoj1 < 5) {
					gano = 2;
				} else {
					if (juegoj2 > 6 && (juegoj2 - juegoj1 == 2)) {
						gano = 2;
					}
				}
			}
		}
		return gano;
	}
	
	//metodo para sumar los set
	public void sumarSet() {
		set1.add(juegoj1);
		set2.add(juegoj2);
	}
	
	//metodo para setear el set en juego
	public void setearSet() {
		juegoj1 = 0;
		juegoj2 = 0;
	}
	
	//mostrar los set actuales
	public void mostrarSet() {
		System.out.println("Finalizado			|Torneo: "+torneo.getNombre());
		
		int ganador = ganadorEs();
		
		System.out.print("J1: "+ j1.getNombre()+ " - ");
		for (Integer numero : set1) {
			System.out.print("|"+numero);
		}
		if(ganador == 1) {
			System.out.print(" Ganador.");
		}
		
		System.out.println("");
		
		System.out.print("J2: "+ j2.getNombre()+ " - ");
		for (Integer numero : set2) {
			System.out.print("|"+numero);
		}
		if(ganador == 2) {
			System.out.print(" Ganador.");
		}
	}
	
	//metodo que analiza los set y devuelve el ganador del juego
	public int ganadorEs() {
		int ganador = 0;
		int total1 = 0;
		int total2 = 0;
		
		for (int i = 0; i < set1.size(); i++) {
			if(set1.get(i) > set2.get(i)) {
				total1 = total1 + 1;
			}else {
				total2 = total2 + 1;
			}
		}
		
		if(total1 > total2) {
			ganador = 1;
		}else {
			ganador = 2;
		}
		
		return ganador;
	}
	
	//metodo para ver el resultado de la semifinal y devuelve el jugador ganador
	public Jugador semifinal() {
		Jugador pasa;
		System.out.println("Semifinal			|Torneo: "+torneo.getNombre());
		
		int ganador = ganadorEs();
		if(ganador == 1) {
			pasa = j1;
		}else {
			pasa = j2;
		}
		
		System.out.print("J1: "+ j1.getNombre()+ " - ");
		for (Integer numero : set1) {
			System.out.print("|"+numero);
		}
		if(ganador == 1) {
			System.out.print(" Ganador.");
		}
		
		System.out.println("");
		
		System.out.print("J2: "+ j2.getNombre()+ " - ");
		for (Integer numero : set2) {
			System.out.print("|"+numero);
		}
		if(ganador == 2) {
			System.out.print(" Ganador.");
		}
		
		return pasa;
	}
}
