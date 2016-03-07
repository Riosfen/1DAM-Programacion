import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio5Arrays {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Random serie = new Random();
		int tamanio = tamVector();
		int[] vector1 = new int[tamanio]; 
		
		for (int i = 0; i < vector1.length; i++) {
			vector1[i] = serie.nextInt(100)+1;
		}
		
		System.out.println(Arrays.toString(vector1));
		
		int aux = vector1[vector1.length-1];
		int aux2;
		
		for (int i = 0; i < vector1.length; i++) {

			aux2 = vector1[i];
			vector1[i] = aux;
			aux = aux2;
			
		}
		
		System.out.println(Arrays.toString(vector1));

	}

	private static int tamVector() {
		int tamanio = 0;
		boolean hayError = true;

		do {
			try {
				System.out.println("Tamaño del vector:");
				tamanio = Integer.parseInt(teclado.nextLine());
				hayError = false;
			} catch (NumberFormatException e) {
				System.out.println("ERROR!! Se debe introducir un número.");
			}
		} while (tamanio < 2 || hayError);
		
		return tamanio;
	}

}
