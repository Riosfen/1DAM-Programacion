package ejercicio7;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Cuatro_en_ralla juego = new Cuatro_en_ralla();
		boolean ganaste = false;

		do {

			System.out.println(juego);

			try {

				ganaste = juego.turno(menu(juego));

			} catch (Cuatro_en_rallaException e) {
				System.out.println(e.getMessage());
			}

		} while (!ganaste);

	}

	private static int menu(Cuatro_en_ralla juego) {

		System.out.println("Introduce una fila: ");
		int indice = Integer.parseInt(teclado.nextLine());

		return indice;

	}

}
