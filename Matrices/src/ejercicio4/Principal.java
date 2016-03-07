package ejercicio4;

public class Principal {
	public static void main(String[] args) throws MatrizMatematicaException {

		MatrizMatematica matriz = new MatrizMatematica(4, 4);
		matriz.rellenarMatriz();
		
		System.out.println(matriz.toString());
		
		System.out.println(matriz.multiplicarDiagonal());
	}
}
