package Relacion11;

import java.util.Scanner;

public class Ejercicio2 {
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Introduce numero");
		int n = Integer.parseInt(teclado.nextLine());
		
		System.out.println(sumaNumeroNatural(n));
		
	}

	private static int sumaNumeroNatural(int n) {
		
		if (n != 1){
			n = n + sumaNumeroNatural(n-1);
		}
		
		return n;
	}
}
