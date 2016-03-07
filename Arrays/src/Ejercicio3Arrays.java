import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3Arrays {

	private static final int MAXIMO = 1000;
	private static final int MINIMO = 1;
	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int[] vNumero = new int[15];
		
		boolean hayError = true;
		int contador;
		int maximo = 0;
		int minimo = 1001;
		
		for (int i = 0; i < vNumero.length; i++) {
			System.out.println("vuelta " + (i+1));
			
			do{
				try{
				System.out.println("Introduce un número del 1 al 1000 (" + (i+1) + " de " + vNumero.length + "): " );
				vNumero[i] = Integer.parseInt(teclado.nextLine());
				hayError = false;
				
				}catch (NumberFormatException e){
					System.out.println("ERROR!! Formato no válido");
				}
				contador = i;
				while (contador > 0) {
					contador--;
					if (vNumero[i] == vNumero[contador]){
						hayError = true;
						contador = 0;
					}
				}
				
			}while(vNumero[i] < MINIMO || vNumero[i] > MAXIMO || hayError);
			
			if(vNumero[i] < minimo){
				minimo = vNumero[i];
			}
			if(vNumero[i] > maximo){
				maximo = vNumero[i];
			}
			
		}
		
		System.out.println(Arrays.toString(vNumero));
		System.out.println("Valor maximo: " + maximo);
		System.out.println("Valor minimo: " + minimo);

	}

}
