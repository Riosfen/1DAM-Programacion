import java.util.Scanner;

public class Ejercicio1Arrays {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {

		int numero[] = new int[10];
		int contador = 0;
		
		int negativos = 0;
		int positivos = 0;
		int ceros = 0;
		
		for (int i = 0; i < numero.length; i++) {
			System.out.println("Inserta un número (" + (i+1) +" de " + numero.length + ")");
			numero[i] = Integer.parseInt(teclado.nextLine());
		}
		
		while(contador < numero.length){
			
			if (numero[contador] < 0){
				negativos++;
			} else{
				if(numero[contador] > 0){
					positivos++;
				}else{
					ceros++;
				}
			}
			contador++;
		}
		
		System.out.println("Hay " + ceros + " ceros.");
		System.out.println("Hay " + positivos + " positivos.");
		System.out.println("Hay " + negativos + " negativos.");

	}

}
