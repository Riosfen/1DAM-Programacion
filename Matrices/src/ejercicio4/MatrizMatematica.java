package ejercicio4;

import java.util.Random;

public class MatrizMatematica {
	
	private int rangoRellenaMatriz = 10;
	private static final int RESTA = 2;
	private static final int SUMA = 1;
	private int[][] matriz;
	
	public MatrizMatematica(int fila, int columna) throws MatrizMatematicaException{
		
		if (fila < 0 || columna < 0)
			throw new MatrizMatematicaException("Error, error al crear la matriz de datos");
		
		matriz = new int[fila][columna];
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				resultado.append(matriz[i][j] + "\t");
			}
			resultado.append("\n\n");
		}
		
		return resultado.toString();
	}
	
	public boolean equals(MatrizMatematica matriz2) throws MatrizMatematicaException{
		
		if (matriz.length != matriz2.matriz.length || matriz[0].length != matriz2.matriz[0].length)
			throw new MatrizMatematicaException("Error, no se pueden comprobar 2 matrices que tengan distintas dimensiones");
		
		boolean resultado = false;
		int i = 0;
		
		while (i < matriz.length && resultado == false) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == matriz2.matriz[i][j])
					resultado = true;
			}
			i++;
		}
		
		return resultado;
		
	}
	
	public boolean buscarElemento(int elemento){
		
		boolean resultado = false;
		int i = 0;
				
		while ( i < matriz.length && resultado == false ) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == elemento){
					resultado = true;
				}
			}
			i++;
		}
		
		return resultado;	
	}
	
	public MatrizMatematica sumarMatriz(MatrizMatematica objeto) throws MatrizMatematicaException{
		
		if (matriz.length != objeto.matriz.length || matriz[0].length != objeto.matriz[0].length)
			throw new MatrizMatematicaException("Error, no se pueden sumar 2 matrices que tengan distintas dimensiones");
		
		MatrizMatematica resultado = operacionesBasicas(objeto, SUMA);
		
		return resultado;
		
	}
	
public MatrizMatematica restarMatriz(MatrizMatematica objeto) throws MatrizMatematicaException{
		
		if (matriz.length != objeto.matriz.length || matriz[0].length != objeto.matriz[0].length)
			throw new MatrizMatematicaException("Error, no se pueden sumar 2 matrices que tengan distintas dimensiones");
		
		MatrizMatematica resultado = operacionesBasicas(objeto, RESTA);
		
		return resultado;
		
	}

	private MatrizMatematica operacionesBasicas(MatrizMatematica objeto, int operacion) throws MatrizMatematicaException {
		MatrizMatematica resultado = new MatrizMatematica(matriz.length, matriz[0].length) ;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (operacion == SUMA)
					resultado.matriz[i][j] = matriz[i][j] + objeto.matriz[i][j];
				if (operacion == RESTA)
					resultado.matriz[i][j] = matriz[i][j] - objeto.matriz[i][j];
			}
		}
		return resultado;
	}
	
	public void multiplicarPor(int num){
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] *= num;
			}
		}
		
	}
	
	public int multiplicarDiagonal(){
		
		int resultado = 1;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = i; j < i+1; j++) {
				resultado *= matriz[i][j];
			}
		}
		
		return resultado;
	}
	
	public void rellenarMatriz(){
		
		Random serie = new Random();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = serie.nextInt(rangoRellenaMatriz);
			}
		}
		
	}
	
}