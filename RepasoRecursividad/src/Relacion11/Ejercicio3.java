package Relacion11;

import java.util.Scanner;

public class Ejercicio3 {

	public static Scanner tecaldo = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Inserta la base");
		int b = obtenerNumero();
		System.out.println("Inserta el multiplicador");
		int e = obtenerNumero();
		
		System.out.println(multiplicacion(b,e));
		
	}

	private static int multiplicacion(int b, int e) {
		
		if (e > 1){
			b = b + multiplicacion(b, e-1);
		}
		if (e == 0){
			b = 0;
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
