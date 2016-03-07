package ejercicio6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Pisaminas juego = new Pisaminas();
		boolean pisadoMina = false;
		boolean ganaste = false;
		char movimiento;

		System.out.println(juego);

		do {

			movimiento = mostrarMenu();
			pisadoMina = solicitarYTratarMovimiento(juego, movimiento);

			if (!pisadoMina)
				ganaste = juego.mtaAlcanzada();

			System.out.println(juego);

		} while (!pisadoMina && !ganaste);

		if (pisadoMina == true) {
			System.out.println("Perdiste, pisaste una mina.");
		} else {
			System.out.println("Enhorabuena has llegado.");
		}

	}

	private static boolean solicitarYTratarMovimiento(Pisaminas juego, char movimiento) {

		boolean pisadoMina = false;

		switch (movimiento) {

		case 'w':

			try {

				pisadoMina = juego.moverArriba();

			} catch (ExceptionPisaminas e) {
				System.out.println(e.getMessage());
			}

			break;

		case 's':

			try {

				pisadoMina = juego.moverAbajo();

			} catch (ExceptionPisaminas e) {
				System.out.println(e.getMessage());
			}

			break;

		case 'a':

			try {

				pisadoMina = juego.moverIzquierda();

			} catch (ExceptionPisaminas e) {
				System.out.println(e.getMessage());
			}

			break;

		case 'd':
			try {

				pisadoMina = juego.moverDerecha();

			} catch (ExceptionPisaminas e) {
				System.out.println(e.getMessage());
			}

			break;

		}

		return pisadoMina;
	}

	private static char mostrarMenu() {

		System.out.println("Introduce una opcion:");
		System.out.println("w- Mover hacia arriba");
		System.out.println("s- Mover hacia abajo");
		System.out.println("a- Mover hacia la izquierda");
		System.out.println("d- Mover hacia la derecha");

		return Character.toLowerCase(teclado.nextLine().charAt(0));
	}
}
