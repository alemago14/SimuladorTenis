package Validaciones;

import java.util.Scanner;

public class Validar {

	Scanner sc = new Scanner(System.in);
	int probabilidad = 0;
	int set = 0;

	public Validar() {
	}
	
	public int validarProbabilidad() {
		do {
		System.out.println("Ingrese sus posibilidad de ganar (del 0 al 100)");
		probabilidad = sc.nextInt();
		}while(!(probabilidad > 0 && probabilidad <= 100));
		return probabilidad;
	}
	
	public int validarSets() {
		do {
		System.out.println("Ingrese la cantidad de sets a jugar");
		set = Integer.parseInt(sc.next());
		}while(!(set == 3 || set == 5));
		return set;
	}
	
}
