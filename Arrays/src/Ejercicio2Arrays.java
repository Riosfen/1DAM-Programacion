import java.util.Scanner;

public class Ejercicio2Arrays {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int cantNum = inicializarVnumero();

		int[] vNumero = new int[cantNum];

		boolean hayError = true;

		for (int i = 0; i < cantNum; i++) {

			do {

				try {

					System.out.println("Introduce un número " + (i + 1) + " de " + cantNum + ": ");
					vNumero[i] = Integer.parseInt(teclado.nextLine());
					hayError = false;

				} catch (NumberFormatException e) {
					System.out.println("ERROR!! formato incorrecto.");
				}

			} while (hayError);

		}

		int sumaPares = 0;
		int cantNumPares = 0;
		
		System.out.println("Numeros impares en posiciones pares:");
		
		for (int i = 0; i < vNumero.length; i++) {

			if ((i + 1) % 2 == 0 && vNumero[i] % 2 != 0) {
				
				System.out.println(vNumero[i]);
				
			}
			
			if (vNumero[i] % 2 == 0) {
				
				sumaPares += vNumero[i];
				cantNumPares++;
				
			}
		}
		
		int media;
		
		if(cantNumPares != 0){
			System.out.println("La media de los numeros pares es: ");
			media = sumaPares / cantNumPares;
			System.out.println(media);
		}

	}

	private static int inicializarVnumero() {

		int cantNum = 0;
		boolean hayError = true;

		do {

			try {

				System.out.println("Introduce la cantidad de números que deseas introducir: ");
				cantNum = Integer.parseInt(teclado.nextLine());
				hayError = false;

			} catch (NumberFormatException e) {
				System.out.println("ERROR!! Formato inválido: ");
			}

		} while (cantNum <= 0 || hayError);

		return cantNum;
	}
}
