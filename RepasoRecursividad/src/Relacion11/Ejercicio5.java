package Relacion11;

import java.util.Scanner;

public class Ejercicio5 {

	public static Scanner tecaldo = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Introduce un numero decimal");
		int n = Integer.parseInt(tecaldo.nextLine());
		
		StringBuilder resul = new StringBuilder();
		
		calcularBinario(n, resul);
		
		System.out.println(resul.toString());
	}

	private static void calcularBinario(int n, StringBuilder resul) {

		if(n > 0){
			calcularBinario(n/2, resul);
			resul.append(n%2);
		}
		
	}
	
}
