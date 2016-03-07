import java.util.Random;

public class Ejercicio3 {

	public static void main(String[] args) {

		int[][] mentero = new int[4][4];
		Random serie = new Random();
		
		for (int i = 0; i < mentero.length; i++) {
			for (int j = 0; j < mentero[i].length; j++) {
				mentero[i][j] = serie.nextInt(100)+1;
				System.out.printf("%5d", mentero[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		
		int aux;
		
		for (int i = 0; i < mentero.length; i++) {
			for (int j = i; j < mentero[i].length; j++) {
				if (i != j){
					aux = mentero[i][j];
					mentero[i][j] = mentero[j][i];
					mentero[j][i] = aux;
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < mentero.length; i++) {
			for (int j = 0; j < mentero[i].length; j++) {
				System.out.printf("%5d", mentero[i][j]);
			}
			System.out.println();
		}

	}

}
