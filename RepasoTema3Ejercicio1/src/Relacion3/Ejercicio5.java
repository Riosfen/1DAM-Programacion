package Relacion3;

import java.util.Scanner;

public class Ejercicio5 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String estrella = "*";
		int altura = 0;
		int repetir = 0;
		
		System.out.println("Escribe el alto de la figura:");
		altura = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Numero de veces que se repite la figura:");
		repetir = Integer.parseInt(teclado.nextLine());
		
		
		
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < repetir; j++) {
				System.out.print(estrella);
				for (int j2 = altura-i; j2 > 0; j2--) {
					System.out.print(" ");
				}
			}
			estrella = estrella + "*";
			System.out.println();
		}
	}

}
