package Relacion11;

import java.util.Scanner;

public class Ejercicio1 {
	
	public static Scanner tecaldo = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Inserta la base");
		int b = obtenerNumero();
		System.out.println("Inserta el exponente");
		int e = obtenerNumero();
		
		System.out.println(potencia(b,e));
		
	}
	
	private static int potencia(int b, int e) {
		
		if (e > 1){
			b = b*potencia(b, e-1);
		}
		
		return b;
	}

	public static int obtenerNumero(){
		int num = 0;
		
		do {
			num = Integer.parseInt(tecaldo.nextLine());
		} while (num < 0);
		
		return num;
	}
}
