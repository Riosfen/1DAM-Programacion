package Principal;

import java.util.Scanner;

import Clases.*;

public class Principal {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		Diccionario diccionario = new Diccionario("Multilingüe - español");
		
		int opcion = 0;
		
		do {
			try {
				
				menu();
				opcion = Integer.parseInt(teclado.nextLine());
				tratarMenu(opcion, diccionario);
				
			} catch (DiccionarioException e){
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error!! Inténtelo de nuevo.");
			}
		} while (opcion != 6);

	}

	private static void tratarMenu(int opcion, Diccionario diccionario) throws DiccionarioException {

		String idioma;
		String palabra;
		String traduccion;
		Palabra nPalabra;
		Idioma nIdioma;
		
		switch (opcion) {
		case 1:
			idioma = solicitarString("el idioma");
			diccionario.nuevoIdioma(idioma);
			break;
		case 2:
			idioma = solicitarString("el idioma");
			palabra = solicitarString("la palabra en " + idioma);
			traduccion = solicitarString("la traducción de la palabra " + palabra);
			
			nIdioma = diccionario.obtenerIdioma(idioma);
			nPalabra = new Palabra(palabra, traduccion);
			nIdioma.introducirPalabra(nPalabra);
			break;
		case 3:
			idioma = solicitarString("el idioma");
			
			nIdioma = diccionario.obtenerIdioma(idioma);
			System.out.println(nIdioma.listadoPalabras());
			break;
		case 4:
			idioma = solicitarString("el idioma");
			palabra = solicitarString("la palabra a borrar en " + idioma);
			
			nIdioma = diccionario.obtenerIdioma(idioma);
			if (nIdioma.eliminarPalabra(palabra))
				System.out.println("Se ha eliminado correctamente");
			else
				System.out.println("Esa palabra no existe");
			break;
		case 5:
			idioma = solicitarString("el idioma");
			palabra = solicitarString("la palabra en que se quiere modificar en " + idioma);
			traduccion = solicitarString("la traducción de la palabra " + palabra);
			
			nIdioma = diccionario.obtenerIdioma(idioma);
			nPalabra = new Palabra(palabra, traduccion);
			if (nIdioma.modificarTraduccion(nPalabra))
				System.out.println("Se ha modificado correctamente.");
			break;
		case 6:
				System.out.println("Saliendo...");
			break;
		}
		
	}

	private static String solicitarString(String msg) {

		System.out.println("Inserta " + msg + ": ");
		String resul = teclado.nextLine();
		
		return resul;
	}

	private static void menu() {

		System.out.println("MENÚ: \n");
		System.out.println("1. Crear idioma");
		System.out.println("2. Introducir palabra en diccionario");
		System.out.println("3. Listado de palabras de un idioma");
		System.out.println("4. Eliminar palabra");
		System.out.println("5. Modificar traducción");
		System.out.println("6. Salir...");
		
	}

}
