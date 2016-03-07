package ejercicio5;

import java.util.Arrays;
import java.util.Random;

/**	Realizar un programa que lea las calificaciones obtenidas por los alumnos de
*	1º de DAM (30 alumnos) en las 5 asignaturas y saque por pantalla lo siguiente:
*	a. Número de alumnos con 5 asignaturas suspensas, con 4, con 3, con 2,
*	con 1 y con 0.
*	b. Nota media de cada una de las asignaturas
*	(Para simplificar, cargar las notas aleatoriamente)
*/

public class Principal {
	
	public static void main(String[] args) {

		int alumnos = 5;
		int asignaturas = 5;
		
		int[][] calificaciones = new int[alumnos][asignaturas];
		int[] asigSuspensas = new int[asignaturas+1];
		int[] media = new int[asignaturas];
		String[] asignatura = {"PRO", "BD", "LM", "ENDES", "SIS"};
		
		introducirNotas(calificaciones);
		mostrarMatriz(calificaciones);
		mostrarSuspensos(calificaciones, asigSuspensas);
		mostrarMedia(alumnos, calificaciones, asignatura);
		
	}

	private static void mostrarMedia(int alumnos, int[][] calificaciones, String[] asignatura) {
		int mediaAsign = 0;
		
		for (int i = 0; i < calificaciones[0].length; i++) {
			for (int j = 0; j < calificaciones.length; j++) {
				mediaAsign += calificaciones[j][i];
			}
			System.out.println("Media de " + asignatura[i] + ": " + mediaAsign/alumnos);
		}
	}

	private static void mostrarSuspensos(int[][] calificaciones, int[] asigSuspensas) {
		int asigsus = 0;
		
		for (int i = 0; i < calificaciones.length; i++) {
			for (int j = 0; j < calificaciones[i].length; j++) {
				if (calificaciones[i][j] < 5){
					asigsus++;
				}
			}
			asigSuspensas[asigsus]++;
			asigsus = 0;
		}
		
		for (int i = 0; i < asigSuspensas.length; i++) {
			System.out.println("Número de alumnos con " + i + " asignaturas suspensas: " + asigSuspensas[i]);
		}
	}

	private static void introducirNotas(int[][] calificaciones) {
		Random notas = new Random();
		
		for (int i = 0; i < calificaciones.length; i++) {
			for (int j = 0; j < calificaciones[i].length; j++) {
				calificaciones[i][j] = notas.nextInt(11);
			}
		}
	}
	
	private static void mostrarMatriz(int[][] calificaciones){
		
		for (int i = 0; i < calificaciones.length; i++) {
			for (int j = 0; j < calificaciones[i].length; j++) {
				System.out.printf("%5d", calificaciones[i][j]);
			}
			System.out.println("\n");
		}
		
	}
}
