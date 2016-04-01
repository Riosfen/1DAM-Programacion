package org.monroy.principal;

import java.util.Arrays;
import java.util.Scanner;

import org.monroy.clases.Coche;
import org.monroy.clases.GamaVehiculo;
import org.monroy.clases.Vehiculo;

public class Principal {

	private static final int LIMITE_VEHICULOS = 200;
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Vehiculo[] v = new Vehiculo[LIMITE_VEHICULOS];

		int opcion = 0;

		do {

			opcion = menu();

			switch (opcion) {
			case 1:
				altaVehiculo(v);
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Error! opción incorrecta, intentalo de nuevo.");
				break;

			}

		} while (opcion != 3);

	}

	private static void altaVehiculo(Vehiculo[] v) {

		int contador = 0;
		int indice;
		boolean encontrado = false;
		

		while (contador < v.length && encontrado == false) {
			if (v[contador] == null) {
				encontrado = true;
			}
		}

		if (contador > v.length-1){
			System.out.println("Se ha alcanzado el límite de vehículos que se pueden introducir,");
		}else{
			
			System.out.println("¿Qué vehículo va a dar de alta?");
			System.out.println("1- Coche");
			System.out.println("2- Furgoneta");
			System.out.println("3- Microbus");
			
			int opcion = 0;
			
			do{
				opcion = elegirOpcion();
				
			}while(opcion < 1 || opcion > 3);
			
			agregarVehiculo(opcion, v, contador);
			
		}

	}

	private static void agregarVehiculo(int opcion, Vehiculo[] v, int contador) {

		switch(opcion){
		case 1:	v[contador] = new Coche(matricula(), gamaVehiculo(), tipoCombustible())
			break;
		case 2:
			break;
		case 3:
			break;
		}
		
	}

	private static String matricula() {

		System.out.println("Inserte la matrícula del vehículo:");
		
		String resultado = teclado.nextLine();
		
		comprobarMatricula(resultado);
		
		return null;
	}

	private static void comprobarMatricula(String resultado) {

		boolean correcto = false;
		
		if (resultado.length() != 7){
			System.out.println("La matricula debe contener 7 caracteres");
		}else{
			if (contieneDigitos(resultado.substring(0, 3))){
				
			}
		}
		
	}

	private static boolean contieneDigitos(String substring) {

		boolean resultado = true;
		
		for (int i = 0; i < substring.length(); i++) {
			char c = substring.charAt(i);
			
			if (!Character.isDigit(c)){
				resultado = false;
			}
			
		}
		
		return resultado;
	}

	private static int menu() {

		System.out.println("1- Alta de vehículo.");
		System.out.println("2- Calcular precio alquiler.");
		System.out.println("3- Salir.");

		int opcion = elegirOpcion();

		return opcion;

	}

	private static int elegirOpcion() {
		
		boolean error = true;
		int opcion = 0;
		
		do{
			try {
				
				System.out.println("\nIntroduce una opción:");
				opcion = Integer.parseInt(teclado.nextLine());
				error = false;
				
			} catch (Exception e) {
				System.out.println("Error! valor no válido, intentelo de nuevo:");
			}
		}while(error);
		
		return opcion;
	}

}
