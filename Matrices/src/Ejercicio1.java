import java.util.Random;

public class Ejercicio1 {

	public static void main(String[] args) {

		int[][] menteros = new int[3][4];
		Random serie = new Random();

		for (int i = 0; i < menteros.length; i++) {
			for (int j = 0; j < menteros[i].length; j++) {
				menteros[i][j] = serie.nextInt(1000)+1;			
				System.out.printf("%5d", menteros[i][j]);
			}
			System.out.println();
		}
		
	}

}
