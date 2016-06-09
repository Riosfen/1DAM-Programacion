package Relacion3;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		System.out.println("Tablas de multiplicar del 1 al 10");

		for (int i = 1; i < 11; i++) {

			System.out.println("Tabla del " + i + "\n");
			
			for (int j = 0 ; j < 11; j++) {
				System.out.println(i + " x " + j + " = " + i*j);
			}
			System.out.println();
		}
		
	}

}
