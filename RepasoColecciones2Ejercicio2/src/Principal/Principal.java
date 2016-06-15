package Principal;

import java.util.Scanner;

import Clases.Diccionario;
import Clases.DiccionarioExcepion;
import Clases.Idioma;
import Clases.Palabra;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc;
		Diccionario diccionario;

		diccionario = new Diccionario();

		do {
			opc = mostrarMenu();
			tratarMenu(opc, diccionario);
		} while (opc != 6);

	}

	private static void tratarMenu(int opc, Diccionario diccionario) {

		Idioma di;
		Palabra p;
		String idioma;

		try {
			switch (opc) {
			case 1: {
				idioma = introducirCadena("Introduzca el idioma nuevo:");
				di = new Idioma(idioma);
				diccionario.crearNuevoIdioma(di);
				break;
			}
			case 2: {

				idioma = introducirCadena("Introduzca el idioma: ");
				p = new Palabra(introducirCadena("Introduzca la palabra en " + idioma + " : "),
						introducirCadena("Introduzca la palabra al espanol: "));
				diccionario.introducirPalabraDiccionario(idioma, p);
				break;
			}
			case 3: {
				idioma = introducirCadena("Introduzca el idioma del diccionario: ");
				System.out.println(diccionario.listadoPalabraIdioma(idioma));
				break;
			}
			case 4: {

				idioma = introducirCadena("Introduzca el idioma de la palabra que desea eliminar: ");
				diccionario.eliminarPalabraIdioma(idioma, introducirCadena("Introduzca la palabra a eliminar: "));
				break;
			}
			case 5: {
				idioma = introducirCadena("Introduzca el idioma de la palabra a modificar: ");
				diccionario.modificarTraducuionIdioma(idioma, introducirCadena("Introduzca la palabra a modificar: "),
						introducirCadena("Introduzca la nueva traducción: "));
				break;
			}
			case 6: {
				System.out.println("FIN DEL PROGRAMA");
				break;
			}
			}
		} catch (DiccionarioExcepion ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static String introducirCadena(String enunciado) {

		String cadena;

		System.out.print(enunciado);
		cadena = teclado.nextLine();

		return cadena;
	}

	private static int mostrarMenu() {

		int opc;

		do {
			System.out.println("1. Crear nuevo idioma");
			System.out.println("2. Introducir palabra en diccionario");
			System.out.println("3. Listado de palabras de un idioma");
			System.out.println("4. Eliminar palabra");
			System.out.println("5. Modificar traduccion");
			System.out.println("6. Salir");
			System.out.print("Introduce la opcion:");
			opc = elegirOpcion();
		} while (opc <= 0 || opc > 6);

		return opc;
	}

	private static int elegirOpcion() {

		int opc = 0;
		boolean hayFallo;
		do {
			try {
				opc = Integer.parseInt(teclado.nextLine());
				hayFallo = false;
			} catch (NumberFormatException ex) {
				hayFallo = true;
				System.out.println("ERROR. Solo se puede introducir numeros");
			}
		} while (hayFallo);

		return opc;
	}

}
