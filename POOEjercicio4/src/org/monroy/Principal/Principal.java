package org.monroy.Principal;

import java.util.Arrays;
import java.util.Scanner;

import org.monroy.Clases.ArrayPersonaje;
import org.monroy.Clases.Clerigo;
import org.monroy.Clases.Mago;
import org.monroy.Clases.PersonajeException;
import org.monroy.Clases.Raza;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		ArrayPersonaje personaje = new ArrayPersonaje();

		int opcion = 0;

		do {
			try {

				menu();

				opcion = Integer.parseInt(teclado.nextLine());
				tratarMenu(personaje, opcion);

			} catch (PersonajeException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Error! entrada no válida");
			} catch (Exception e) {
				System.out.println("Error! error desconocido");
			}

		} while (opcion != 7);

	}

	private static void menu() {

		System.out.println("Selecciona una de las siguientes opciones:\n");

		System.out.println("1- Crear personaje.");
		System.out.println("2- Mago aperende hechizo.");
		System.out.println("3- Mago lanza hechizo.");
		System.out.println("4- Clérigo cura al mago.");
		System.out.println("5- Mostrar el listado de personajes.");
		System.out.println("6- Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor.");
		System.out.println("7- Salir.");

	}

	private static void tratarMenu(ArrayPersonaje personaje, int opcion) throws PersonajeException {

		switch (opcion) {
		case 1:

			System.out.println("Elige que se creará, un mago o un Clerigo [M/C]");
			char eleccion = teclado.nextLine().toUpperCase().charAt(0);
			crearPersonaje(personaje, eleccion);

			break;
		case 2:
			
			aprenderHechizo(personaje);
			
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			
			System.out.println("Listado de personajes:");
			System.out.println(personaje);
			System.out.println("Fin!!");
			
			break;
		case 6:
			break;
		case 7:
			break;
		}

	}

	private static void aprenderHechizo(ArrayPersonaje personaje) throws PersonajeException {
		
		System.out.println("Inserta el mago que aprenderá el hechizo: ");
		String nombreMago = teclado.nextLine();
		System.out.println("Inserta el hechizo que aprenderá el mago: ");
		String hechizo = teclado.nextLine();
		personaje.aprenderMagia(nombreMago, hechizo);
		
	}

	private static void crearPersonaje(ArrayPersonaje personaje, char eleccion) throws PersonajeException {

		String nombre, dios;
		Raza raza;
		int fuerza, inteligencia, vidaMaxima;

		nombre = solcitarString("nombre");
		raza = solicitarRaza();
		fuerza = solicitarNumero("fuerza");
		inteligencia = solicitarNumero("inteligencia");
		vidaMaxima = solicitarNumero("vidaMaxima");
		
		if (eleccion == 'C') {

			dios = solcitarString("dios");
			Clerigo nuevoClerigo = new Clerigo(nombre, raza, fuerza, inteligencia, vidaMaxima, dios);
			personaje.altaPersonaje(nuevoClerigo);

		}
		if (eleccion == 'M') {
			
			Mago nuevoClerigo = new Mago(nombre, raza, fuerza, inteligencia, vidaMaxima);
			personaje.altaPersonaje(nuevoClerigo);

		}

	}

	private static int solicitarNumero(String msg) {

		System.out.println("\nIngresar " + msg + ": ");
		int resultado = Integer.parseInt(teclado.nextLine());
		
		return resultado;
	}

	private static String solcitarString(String msg) {
		
		String resultado;
		
		do {
				
			System.out.println("\nIngresar " + msg + " (tiene que ser mayor de 3 caracteres): ");
			resultado = teclado.nextLine();
				
		} while (resultado.length() < 3);

		return resultado;

	}

	private static Raza solicitarRaza() {
		
		System.out.println("\nSelecciona una raza: ");

		System.out.println(Arrays.toString(Raza.values()));
		int resultado = Integer.parseInt(teclado.nextLine()) -1;

		Raza raza = Raza.values()[resultado];

		return raza;

	}

}