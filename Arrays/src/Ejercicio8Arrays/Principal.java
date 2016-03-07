package Ejercicio8Arrays;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int tamanio = pedirNumeroAlumnos("Introduce el número de alumnos: ");

		Alumno[] clase = new Alumno[tamanio];

		introducirAlumnos(clase);

		elegirOpcion(clase);

	}

	private static void elegirOpcion(Alumno[] clase) {

		menuPrincipal();
		char opcion = elejirLetra();

		switch (opcion) {
		case 'A':
			alumnosAprobados(clase);
			break;
		case 'B':
			alumnosSuspensos(clase);
			break;
		case 'C':
			notaMediaClase(clase);
			break;
		case 'D':
			masDeXNota(clase);
			break;
		case 'E':
			buscarMaximoMinimo(clase);
			break;
		case 'F':
			decrecienteNota(clase);
			break;
		}
		
		elegirOpcion(clase);
	}

	private static char elejirLetra() {
		
		boolean hayError = true;
		char[] opcionValida = {'A', 'B', 'C', 'D', 'E', 'F'};
		char opcion = ' ';
		
		do {
			try {
				
				opcion = teclado.nextLine().toUpperCase().charAt(0);
				
				int i = 0;
				boolean encontrado = false;
				
				while (i < opcionValida.length && !(encontrado)) {
					if (opcion == opcionValida[i]){
						hayError = false;
						encontrado = true;
					}
					i++;
				}
		
			}catch(Exception e){
				System.out.println("Error, formato inválido.");
			}
		}while(hayError);
		
		return opcion;

	}

	private static void decrecienteNota(Alumno[] clase) {

		Alumno alumnoGuardado = clase[1];
		int i, j, mayor;

		for (i = 0; i < clase.length - 1; i++) {
			mayor = i;
			for (j = i + 1; j < clase.length; j++) {
				if (clase[j].getNota() > clase[mayor].getNota()) {
					mayor = j;
				}
			}
			alumnoGuardado = clase[i];
			clase[i] = clase[mayor];
			clase[mayor] = alumnoGuardado;
		}
		
		for (int k = 0; k < clase.length; k++) {
			System.out.println(clase[k]);
		}
		
	}

	private static void buscarMaximoMinimo(Alumno[] clase) {

		Alumno alumnoGuardado = clase[1];
		int i, j, mayor;

		for (i = 0; i < clase.length - 1; i++) {
			mayor = i;
			for (j = i + 1; j < clase.length; j++) {
				if (clase[j].getNota() > clase[mayor].getNota()) {
					mayor = j;
				}
			}
			alumnoGuardado = clase[i];
			clase[i] = clase[mayor];
			clase[mayor] = alumnoGuardado;
		}
		

		System.out.println("Nota mas alta: " + clase[0].getNombre());
		System.out.println("Nota mas baja: " + clase[clase.length-1].getNombre());

	}

	private static void masDeXNota(Alumno[] clase) {

		double opcion = 0;
		boolean hayError = true;

		do {
			try {
				
				System.out.println("Introduce la nota para buscar una mas alta: ");
				opcion = Double.parseDouble(teclado.nextLine());
				hayError = false;

			} catch (Exception e) {
				System.out.println("Error, formato no válido.");
			}
		} while (opcion < 0 || opcion > 10 || hayError);

		for (int i = 0; i < clase.length; i++) {
			if (clase[i].getNota() >= opcion)
				System.out.println(clase[i]);
		}

	}

	private static void notaMediaClase(Alumno[] clase) {

		double suma = 0;
		double resultado;

		for (int i = 0; i < clase.length; i++) {
			suma += clase[i].getNota();
		}

		resultado = suma / clase.length;

		System.out.println("Nota media: " + resultado);

	}

	private static void alumnosSuspensos(Alumno[] clase) {

		for (int i = 0; i < clase.length; i++) {
			if (clase[i].getNota() < 5)
				System.out.println(clase[i]);
		}

	}

	private static void alumnosAprobados(Alumno[] clase) {

		for (int i = 0; i < clase.length; i++) {
			if (!(clase[i].getNota() < 5))
				System.out.println(clase[i]);
		}

	}

	private static void menuPrincipal() {

		System.out.println("\nMenú Principal: ");
		System.out.println("A) Mostrar los alumnos aprobados");
		System.out.println("B) Mostrar los alumnos suspensos");
		System.out.println("C) Mostrar la nota media de la clase");
		System.out.println("D) Mostrar los alumnos que tienen más de una nota X");
		System.out.println("E) Mostrar el alumno con la nota máxima y mínima");
		System.out.println("F) Mostrar un listado ordenado de forma decreciente por la nota");

	}

	private static void introducirAlumnos(Alumno[] clase) {

		String nombre;
		double nota;
		boolean hayError = true;

		for (int i = 0; i < clase.length; i++) {

			do {
				try {

					System.out.println("Datos del alumno (" + (i + 1) + " de " + clase.length + ")");

					nombre = pedirNombre("Introduce el nombre del alumno: ");
					nota = pedirNota("Introduce la nota del alumno: ");

					clase[i] = new Alumno(nombre, nota);

					hayError = false;

				} catch (AlumnoException e) {
					System.out.println(e.getMessage());
				}
			} while (hayError);

		}
	}

	private static double pedirNota(String msg) {

		boolean hayError = true;
		double resultado = 0;

		do {
			try {
				System.out.println(msg);
				resultado = Double.parseDouble(teclado.nextLine());
				hayError = false;
			} catch (Exception e) {
				System.out.println("ERROR!! formato no válido.");
			}

		} while (hayError);

		return resultado;
	}

	private static String pedirNombre(String msg) {

		boolean hayError = true;
		String resultado = "";

		do {

			System.out.println(msg);
			resultado = teclado.nextLine();
			hayError = false;

		} while (hayError);

		return resultado;
	}

	private static int pedirNumeroAlumnos(String msg) {

		boolean hayError = true;
		int tamanio = 0;

		do {
			try {

				System.out.println(msg);
				tamanio = Integer.parseInt(teclado.nextLine());
				hayError = false;

			} catch (Exception e) {
				System.out.println("ERROR!! formato no válido.");
			}

		} while (hayError || tamanio < 2);

		return tamanio;
	}

}
