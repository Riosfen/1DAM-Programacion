package Principal;

import java.util.Scanner;

import Clases.*;

public class Principal {
	
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Historial historial = new Historial();
		
		int opcion = 0;
		
		do {
			
			try {
				
				menu();
				opcion = Integer.parseInt(teclado.nextLine());
				tratarMenu(opcion, historial);
				
			} catch (HoraException e) {
				System.out.println(e.getMessage());
			}catch (FechaException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				e.printStackTrace(System.out);
			}
			
		} while (opcion != 5);
		
	}

	private static void tratarMenu(int opcion, Historial historial) throws FechaException, HoraException {

		Fecha fecha;
		
		switch(opcion){
		case 1:
			String nombre = introducirString("el nombre");
			fecha = new Fecha(introducirInt("el dia"), introducirInt("el mes"), introducirInt("el anio"));
			Hora hora = new Hora(introducirInt("los segundos"), introducirInt("los minutos"), introducirInt("las horas"));
			
			Pagina  pagina = new Pagina(nombre, fecha, hora);
			historial.aniadirPagina(pagina);
			break;
		case 2:
			System.out.println(historial.toString());
			break;
		case 3:
			fecha = new Fecha(introducirInt("el dia"), introducirInt("el mes"), introducirInt("el anio"));
			System.out.println(historial.historialDia(fecha));
			break;
		case 4:
			historial.borrarHistorial();
			break;
		}
		
	}

	private static int introducirInt(String msg) {

		System.out.println("Introduce " + msg + ": ");
		
		return Integer.parseInt(teclado.nextLine());
	}

	private static String introducirString(String msg) {
		
		System.out.println("Introduce " + msg + ": ");
		
		return teclado.nextLine();
	}

	private static void menu() {

		System.out.println("\nMENÚ: ");
		
		System.out.println("1- Nueva página consultada");
		System.out.println("2- Consultar historial completo");
		System.out.println("3- Consultar historial de un día");
		System.out.println("4- Borrar historial completo");
		System.out.println("5- Salir\n");
		
	}
}
