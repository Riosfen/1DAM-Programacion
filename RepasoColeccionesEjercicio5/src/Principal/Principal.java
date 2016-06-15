package Principal;

import java.util.Scanner;

import Clases.*;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		Club listaSocio = new Club();

		do {
			mostrarMenu();
			opcion = solicitarOpcion();
			tratarMenu(opcion, listaSocio);
		} while (opcion != 6);

	}

	private static void mostrarMenu() {
		System.out.println("\nMEN�\n");
		System.out.println("1. Alta de socio.");
		System.out.println("2. Baja de socio.");
		System.out.println("3. Modificar datos Socio.");
		System.out.println("4. Consulta los datos de un socio.");
		System.out.println("5. Consulta de todos los socios.");
		System.out.println("6. Salir.");

	}

	private static int solicitarOpcion() {
		int opcion = 0;

		try {
			System.out.println("Introduce la opci�n deseada: ");
			opcion = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Solo se pueden introducir n�meros.");
		}

		return opcion;
	}

	private static void tratarMenu(int opcion, Club listaSocio) {

		try {

			switch (opcion) {
			case 1: {

				altaSocio(listaSocio);

				break;
			}
			case 2: {
				bajaSocio(listaSocio);
				break;
			}
			case 3: {

				modificarSocio(listaSocio);
				break;
			}
			case 4: {
				consultaDatosSocio(listaSocio);
				break;
			}
			case 5: {
				consultarTodosLosSocios(listaSocio);
				break;
			}

			}

		} catch (SocioException e) {
			System.out.println(e.getMessage());

		}
	}

	private static void consultarTodosLosSocios(AlmacenSocios listaSocio) {

		System.out.println(listaSocio.consultaTodosLosSocios());

	}

	private static void altaSocio(Club listaSocio) throws SocioException {
		String DNI;
		String nombre;
		String telefono;

		try {
			System.out.println("Introduce el nombre de socio: ");
			nombre = teclado.nextLine();

			System.out.println("Introduce el DNI del socio: ");
			DNI = teclado.nextLine();

			System.out.println("Introduce el telefono del socio: ");
			telefono = teclado.nextLine();

			Socio socio = new Socio(DNI, nombre, telefono);
			listaSocio.insertarSocio(socio);
		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void bajaSocio(Club listaSocio) {
		String dni;

		System.out.println("Introduzca el DNI del socio a borrar: ");
		dni = teclado.nextLine();

		try {
			listaSocio.borrarSocio(dni);
			System.out.println("El socio con DNI " + dni + " ha sido borrado. ");

		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void modificarSocio(Club listaSocio) throws SocioException {
		String dni;
		String nombre;
		String telefono;
		String respuesta;

		try {
			System.out.println("Introduzca el DNI del socio a borrar: ");
			dni = teclado.nextLine();

			System.out.println("�Desea modificar el nombre (S,N)?");
			respuesta = teclado.nextLine().toUpperCase();

			if (respuesta.equals("S")) {
				System.out.println("Introduce el nombre de socio: ");
				nombre = teclado.nextLine();
				listaSocio.modificarNombre(dni, nombre);
				System.out.println("Nombre modificado correctamente.");
			}

			System.out.println("�Desea modificar el telefono (S,N)?");
			respuesta = teclado.nextLine().toUpperCase();
			if (respuesta.equals("S")) {
				System.out.println("Introduce el telefono del socio: ");
				telefono = teclado.nextLine();
				listaSocio.modificarTelefono(dni, telefono);
				System.out.println("Telefono modificado correctamente.");
			}

		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultaDatosSocio(Club listaSocio) {
		String dni;
		Socio socio;

		System.out.println("Introduzca el DNI del socio: ");
		dni = teclado.nextLine();

		try {
			socio = listaSocio.consultaSocio(dni);
			System.out.println(socio);
		} catch (SocioException e) {
			System.out.println(e.getMessage());
		}

	}

}
