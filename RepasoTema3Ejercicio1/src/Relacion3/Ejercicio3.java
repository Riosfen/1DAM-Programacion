package Relacion3;

import java.util.Scanner;

public class Ejercicio3 {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int empiezaEstrella = 1;
		int altura = 0;
		
		System.out.println("Escribe el alto de la figura:");
		altura = Integer.parseInt(teclado.nextLine());
		
		for (int i = 1; i <= altura; i++) {
			for (empiezaEstrella = 0; empiezaEstrella < i; empiezaEstrella++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("Altura = " + altura);

	}

}
