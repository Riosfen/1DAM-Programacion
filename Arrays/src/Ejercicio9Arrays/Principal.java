package Ejercicio9Arrays;

import java.util.Scanner;

public class Principal {
	
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean hayError = true;
		
		do{
			try {
				
				int numMax = pedirNumero("Inserta el maximo de refranes que se van a permitir:");
				Refranes lista = new Refranes(numMax);
				elegirOpcion(lista);
				hayError = false;
		
			} catch (RefranesException e) {
				System.out.println(e.getMessage());
			}
		}while(hayError);

	}

	private static void elegirOpcion(Refranes lista) {

		int opcion = 0;
		
		do{
			try {
				
				menuPrincipal();
				
				opcion = pedirNumero("Elegir opción:");
				
				switch(opcion){
				case 1: lista.guardarRefran(new Refran(pedirRefran("Inserta un refran: ")));
					break;
				case 2: lista.buscarRefranPorPalabra(pedirRefran("Inserta la palabra a buscar: "));
					break;
				case 3: System.out.println(lista.listarRefranes());
					break;
				case 4: System.out.println("Saliendo...");
					break;
				}
				
			} catch(RefranException e){
				System.out.println(e.getMessage());
			} catch(RefranesException e){
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Error!!");
			}
		}while(opcion != 4);
		
		
	}

	private static void menuPrincipal() {

		System.out.println("Menú principal:\n");
		System.out.println("1- Guardar refrán");
		System.out.println("2- Buscar un refrán que contenga una palabra");
		System.out.println("3- Listado de refránes");
		System.out.println("4- Salir");
		
	}

	private static int pedirNumero(String msg) {

		int resultado = 0;
		boolean hayError = true;
		
		
		do{
			try {
				
				System.out.println(msg);
				resultado = Integer.parseInt(teclado.nextLine());
				hayError = false;
				
			} catch (NumberFormatException e) {
				System.out.println("Error, formato incorrecto.");
			}
		}while(hayError);
		
		return resultado;
	}
	
	private static String pedirRefran(String msg) {

		String resultado;
		boolean hayError = true;
		
		do{
				
				System.out.println(msg);
				resultado = teclado.nextLine();
				hayError = false;
				
		}while(hayError);
		
		return resultado;
	}

}
