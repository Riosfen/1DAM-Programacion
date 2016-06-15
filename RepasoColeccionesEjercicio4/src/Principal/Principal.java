package Principal;

import java.util.Scanner;

import Clases.Agenda;
import Clases.Amigo;
import Clases.AmigoException;
import Clases.Fecha;
import Clases.FechaException;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		boolean salir = false;
		int opcion;

		do {
			opcion = mostrarMenu();
			salir = tratarMenu(agenda, opcion);

		} while (salir == false);

	}

	private static int mostrarMenu() {
		int opcion = 0;
		do {
			System.out.println("\t MENU:");
			System.out.println("1.- Nuevo cumpleannos.");
			System.out.println("2.- Eliminar cumpleannos.");
			System.out.println("3.- Cambiar fecha cumpleannos.");
			System.out.println("4.- Listar agenda cumplennos.");
			System.out.println("5.- Salir.");
			System.out.println("\t Introduzca una opcion:");
			try {
				opcion = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("No has introducido un n�mero");
			}
		} while (opcion < 1 || opcion > 5);
		return opcion;
	}

	/**
	 * Metodo que trata el men� seg�n la opcion elegida
	 * 
	 * @param agenda
	 * @param opcion
	 * @return si se sale o no.
	 * @throws AmigosException
	 */
	private static boolean tratarMenu(Agenda agenda, int opcion) {
		boolean salir = false;
		try {
			switch (opcion) {
			case 1:// Annadir amigo
			{
				nuevoAmigo(agenda);

				break;
			}
			case 2:// Eliminar amigo.
			{
				borrarAmigo(agenda);
				System.out.println("Se ha borrado al amigo de la agenda");
				break;
			}
			case 3:// Modificar cumplea�os.
			{
				modificarCumpleannos(agenda);
				System.out.println("Se ha modificado el cumpleannos de la agenda");
				break;
			}
			case 4:// Listar agenda.
			{
				System.out.println(agenda);
				break;
			}
			case 5:// Salir
			{
				salir = true;
				System.out.println("FIN");
				break;
			}
			}
		} catch (AmigoException e) {
			System.out.println(e.getMessage());
		} catch (FechaException e2) {
			System.out.println(e2.getMessage());
		}
		return salir;
	}

	private static void modificarCumpleannos(Agenda agenda) throws AmigoException, FechaException {
		String nombre;
		int mes, dia, hora;
		Amigo c;

		System.out.println("Introduce el nombre:");
		nombre = teclado.nextLine();

		System.out.println("Introduce el mes:(1-12)");
		mes = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce el dia:(1-31)");
		dia = Integer.parseInt(teclado.nextLine());
		System.out.println("Introduce la hora:(0-23)");
		hora = Integer.parseInt(teclado.nextLine());
		c = new Amigo(nombre, new Fecha(dia, mes), hora);
		agenda.cambiarFecha(c);

	}

	private static void borrarAmigo(Agenda a) throws AmigoException {
		String nombre;
		char resp;
		Amigo c;
		System.out.println("Introduce el nombre:");
		nombre = teclado.nextLine();
		c = new Amigo(nombre);
		System.out.println("Esta seguro que desea borrar a " + c.getNombre() + " de la agenenda(S/N)");
		resp = teclado.nextLine().toUpperCase().charAt(0);
		if (resp == 'S') {
			a.eliminarCumple(c);
		}
	}

	private static void nuevoAmigo(Agenda a) throws AmigoException, FechaException {
		String nombre;
		int mes, dia, hora;
		System.out.println("Introduce el nombre:");
		nombre = teclado.nextLine();
		try {
			System.out.println("Introduce el mes:(1-12)");
			mes = Integer.parseInt(teclado.nextLine());
			System.out.println("Introduce el dia:(1-31)");
			dia = Integer.parseInt(teclado.nextLine());
			System.out.println("Introduce la hora:(0-23)");
			hora = Integer.parseInt(teclado.nextLine());
			Amigo c = new Amigo(nombre, new Fecha(dia, mes), hora);
			a.aniadirAmigo(c);
		} catch (NumberFormatException e) {
			System.out.println("No has introducido un n�mero");
		}
	}

}
