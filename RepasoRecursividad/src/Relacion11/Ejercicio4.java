package Relacion11;

import java.util.Scanner;

public class Ejercicio4 {

	public static Scanner tecaldo = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Numeros naturales al reves.");
		int n = Integer.parseInt(tecaldo.nextLine());

		StringBuilder resul = new StringBuilder();

		numerosNaturalesReves(n, resul);

		System.out.println(resul.toString());

	}

	private static void numerosNaturalesReves(int n, StringBuilder resul) {

		if(n > 0){
			resul.append(n + ",");
			numerosNaturalesReves(n-1, resul);
		}
			
	}

}
