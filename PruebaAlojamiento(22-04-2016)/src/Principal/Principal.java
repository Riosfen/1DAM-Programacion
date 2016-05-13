package Principal;

import java.util.Scanner;

import Clases.Alojamiento;
import Clases.Alojamiento.Temporada;
import Clases.AlojamientoException;
import Clases.CasaRural;
import Clases.Hotel;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Alojamiento[] vAlojamiento = new Alojamiento[3];

		Hotel hotel1 = null;
		CasaRural rural1 = null;
		CasaRural rural2 = null;

		System.out.println("Creando 1 hotel y 2 casas rurales...");

		try {

			hotel1 = new Hotel("hotel1", "direccion1", 4, 150);
			rural1 = new CasaRural("casaR1", "direccion1", true, 34);
			rural2 = new CasaRural("casaR1", "direccion2", false, 120);

			vAlojamiento[0] = rural1;
			vAlojamiento[1] = rural2;
			vAlojamiento[2] = hotel1;
			
		} catch (AlojamientoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Se han añadido los siguientes alojamientos: \n");

		for (int i = 0; i < vAlojamiento.length; i++) {
			System.out.println(vAlojamiento[i]);
		}

		System.out.println("A continuación escribe el nombre de un alojamiento: ");
		
		String nombre;
		
		boolean encontrado;
		int contador;
		
		try {
	
			nombre = teclado.nextLine();

			encontrado = false;
			contador = 0;

			while (contador < vAlojamiento.length && encontrado == false) {
				if (vAlojamiento[contador].getNombre().equals(nombre)) {
					encontrado = true;
				} else {
					contador++;
				}
			}
			
			vAlojamiento[contador].darNota(8);
			vAlojamiento[contador].darNota(9);
			vAlojamiento[contador].darNota(9);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Si existe se le ha dado 3 opiniones de 8, 9 y 9 respectivamente");

		System.out.println("A continuación escribe el nombre de un alojamiento: ");

		try {
			
			nombre = teclado.nextLine();
			encontrado = false;
			contador = 0;

			while (contador < vAlojamiento.length && encontrado == false) {
				if (vAlojamiento[contador].getNombre().equals(nombre)) {
					encontrado = true;
				} else {
					contador++;
				}
			}

			System.out.println("Cuesta " + vAlojamiento[contador].calcularPrecio(5, Temporada.ALTA) + "€");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("A continuación escribe el nombre de un alojamiento: ");

		try {
			
			nombre = teclado.nextLine();
			encontrado = false;
			contador = 0;

			while (contador < vAlojamiento.length && encontrado == false) {
				if (vAlojamiento[contador].getNombre().equals(nombre)) {
					vAlojamiento[contador] = null;
					encontrado = true;
				} else {
					contador++;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Mostrando vector:\n");

		for (int i = 0; i < vAlojamiento.length; i++) {
			System.out.println(vAlojamiento[i]);
		}

	}

}
