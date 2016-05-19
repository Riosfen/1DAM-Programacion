package Principal;

import java.util.Scanner;

import Clases.*;

public class Principal {

	public static final Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Club mClub = new Club();
		
		int opcion = 0;
		
		do {
			try {
				
				mostrarMenu();
				System.out.println("Introduce una opción: ");
				opcion = Integer.parseInt(teclado.nextLine());
				
				tratarMenu(opcion, mClub);
				
			} catch (Exception e) {
				System.out.println("Error!! intentelo de nuevo");
			}
		} while (opcion != 5);
			
	}

	private static void tratarMenu(int opcion, Club mClub) {
		
		switch (opcion) {
		case 1:
			Socio socioNuevo = new Socio(introducirString("DNI"), introducirString("NOMBRE"), introducirInt("TELEFONO"));
			if (mClub.altaSocio(socioNuevo)){
				System.out.println("Se ha introducido el socio correctamente.");
			}else{
					System.out.println("No se ha podidio dar de alta al socio.");
				}
			break;
			
		case 2:
			if(mClub.bajaSocio(introducirString("DNI"))){
				System.out.println("Se ha dado de baja correctamente al socio.");
			}else{
				System.out.println("No se ha dado de baja al socio.");
			}
				break;

		case 3:
			socioNuevo = new Socio(introducirString("DNI"), introducirString("NOMBRE"), introducirInt("TELEFONO"));
			if(mClub.modificarSocio(introducirString("DNI"), socioNuevo)){
				System.out.println("Se ha dado de baja correctamente al socio.");
			}else{
				System.out.println("No se ha dado de baja al socio.");
			}
			
			mClub.modificarSocio(introducirString("DNI"), socioNuevo);
			break;

		case 4:
			System.out.println(mClub.consultarSocio(introducirString("DNI")));
			break;

		case 5:
			System.out.println("Saliendo...");
			break;
		}
		
	}
	
	private static String introducirString(String msg){
		
		System.out.println("Introducir " + msg + " :");
		String resultado = teclado.nextLine();
		
		return resultado;
		
	}
	
	private static int introducirInt(String msg){
		
		System.out.println("Introducir " + msg + " :");
		int resultado = Integer.parseInt(teclado.nextLine());
		
		return resultado;
		
	}

	private static void mostrarMenu() {

		System.out.println("MENU");
		
		System.out.println("1. Alta de socio.");
		System.out.println("2. Baja de socio.");
		System.out.println("3. Modificar datos socios.");
		System.out.println("4. Consulta los datos de un socio.");
		System.out.println("5. Salir.");
		
	}
}
