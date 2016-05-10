package Principal;

import java.util.Scanner;

import Clases.ListaDeNumeros;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		ListaDeNumeros lista1 = new ListaDeNumeros();

		int opcion = 0;

		do {

			opcion = menu();
			elegiropcion(opcion, lista1);

		} while (opcion != 7);

	}

	private static void elegiropcion(int opcion, ListaDeNumeros lista1) {

		switch (opcion) {
		case 1:
			lista1.aniadirNumero(pedirNumero());
			break;
		case 2:
			lista1.eliminarNumero(pedirNumero());
			break;
		case 3:
			System.out.println(lista1);
			break;
		case 4:
			System.out.println(lista1.mostarAPartir(pedirNumero()));
			break;
		case 5:
			System.out.println(lista1.ordenInverso());
			break;
		case 6:

			break;
		case 7:
			System.out.println("Saliendo...");
			break;
		}

	}

	private static int menu() {

		System.out.println("Elige una opción:\n");
		System.out.println("1- Insertar numero.");
		System.out.println("2- Borrar numero.");
		System.out.println("3- Imprimir.");
		System.out.println("4- Imprimir a partir de n posicion.");
		System.out.println("5- Imprimir inverso.");
		System.out.println("6- concatenar listas.");
		System.out.println("7- Sumar todo.");

		int resultado = pedirNumero();

		return resultado;

	}

	private static int pedirNumero() {

		int resultado = 0;
		boolean hayError = true;

		do {

			try {

				System.out.println("Introduce un número: \n");
				resultado = Integer.parseInt(teclado.nextLine());
				hayError = false;

			} catch (NumberFormatException e) {
				System.out.println("Dato incorrecto.");
			}

		} while (hayError);

		return resultado;
	}

}
