package Principal;

import java.util.Scanner;

import Clases.*;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Equipo equipo1 = new Equipo("Equipo 01");
		Equipo equipo2 = new Equipo("Equipo 02");
		
		try {

			equipo2.aniadirAlumno(new Alumno("Pepe", "123"));
			equipo2.aniadirAlumno(new Alumno("Felipe", "321"));
			equipo2.aniadirAlumno(new Alumno("Jorge", "132"));
			equipo2.aniadirAlumno(new Alumno("Lucia", "312"));
			equipo2.aniadirAlumno(new Alumno("Maria", "213"));
			
		} catch (Exception e) {
			System.out.println("Error, no se ha podido insertar el alimno.");
		}
		
		int opcion = 0;
		
		do {
			try {
				
				menu();
				opcion = Integer.parseInt(teclado.nextLine());
				tratarMenu(opcion, equipo1, equipo2);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} while (opcion != 7);
		
	}

	private static void tratarMenu(int opcion, Equipo equipo, Equipo equipo2) {

		switch (opcion) {
		case 1:
			if (equipo.aniadirAlumno(crearAlumno()))
				System.out.println("Se ha añadido correctamente.");
			else
				System.out.println("No se ha añadido el alumno.");
			break;
		case 2:
			if (equipo.borrarAlumno(crearAlumno()))
				System.out.println("Se ha borrado correctamente.");
			else
				System.out.println("No se ha borrado.");
			break;
		case 3:
			if (equipo.perteneceEquipo(crearAlumno()))
				System.out.println("Pertenece al equipo.");
			else
				System.out.println("No pertenece al equipo.");
			break;
		case 4:
			System.out.println(equipo.mostrarPersonasEquipo());
			break;
		case 5:
			System.out.println(equipo.unionEquipo(equipo2));
			break;
		case 6:
			System.out.println(equipo.amboEquipo(equipo2));
			break;
		}
		
	}

	private static Alumno crearAlumno() {

		Alumno alum;
		
		System.out.println("Introduce el dni del alumno: ");
		String dni = teclado.nextLine();
		
		System.out.println("Introduce el nombre del alumno: ");
		String nombre = teclado.nextLine();
		
		alum = new Alumno(nombre, dni);
		
		return alum;
	}

	private static void menu() {

		System.out.println("1- Añadir alumno");
		System.out.println("2- Borrar alumno");
		System.out.println("3- Pertenece el alumno a este equipo");
		System.out.println("4- Mostrar lista equipo");
		System.out.println("5- Unir dos equipos en uno");
		System.out.println("6- Insertar un equipo en otro");
		System.out.println("7- Salir");
		
	}
	
}
