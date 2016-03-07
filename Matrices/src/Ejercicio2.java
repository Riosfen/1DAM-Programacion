import java.util.Random;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		int[][] mnum = new int[5][3];
		Random serie = new Random();
		int sumaPares = 0;
		int contadorPares = 0;
		int mediaPares = 0;
		
		for (int i = 0; i < mnum.length; i++) {
			for (int j = 0; j < mnum[i].length; j++) {
				mnum[i][j] = serie.nextInt(100)+1;
				System.out.printf("%5d", mnum[i][j]);
				if (mnum[i][j] % 2 == 0){
					sumaPares += mnum[i][j];
					contadorPares++;
				}
			}
			System.out.println();
		}
		
		mediaPares = sumaPares / contadorPares;
		
		System.out.println("\nMedia de los elementos pares: " + mediaPares + "\n");
		
		int maximo;
		
		for (int i = 0; i < mnum.length; i++) {
			maximo = mnum[i][0];
			for (int j = 0; j < mnum[i].length; j++) {
				if (mnum[i][j] > maximo){
					maximo = mnum[i][j];
				}
			}
			System.out.println("El maximo de la fila "+(i+1)+" es: " + maximo);
		}
		
		System.out.println();
		
		int minimo;
		
		for (int i = 0; i < mnum[0].length; i++) {
			minimo = mnum[0][i];
			for (int j = 1; j < mnum.length; j++) {
				if (mnum[j][i] < minimo){
					minimo = mnum[j][i];
				}
			}
			System.out.println("El minimo de la columnna "+(i+1)+" es: " + minimo);
		}
		
	}
	
}
