package ejercicio6_V2;

import java.util.Random;

public class Tablero {

	private int numeroMinas;
	private int[] jugador;
	private int[] meta;
	private char[][] tablero;
	private char[] icono = {'J', '*', 'M', ' ', '#'};

	public Tablero(int tamanio, int numeroMinas) {

		tablero = new char[tamanio][tamanio];
		this.numeroMinas = numeroMinas;
		crearTabla();
		colocarMinas();
		
	}
	
	public Tablero(int tamanio, int numeroMinas, int jugadorX, int jugadorY, int metaX, int metaY) {

		tablero = new char[tamanio][tamanio];
		this.numeroMinas = numeroMinas;
		this.jugador = new int[]{jugadorX,jugadorY};
		this.meta = new int[]{metaX, metaY};
		crearTabla();
		colocarMinas();
		
	}
	
	private void crearTabla(){
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] == 0){
					tablero[i][j] = icono[3];
				}
			}
		
		}
	}

	public void colocarMinas(){
		
		int contador = 0;
		Random aleatorio = new Random();
		
		while(contador < numeroMinas){
			
			int columna = aleatorio.nextInt(tablero.length);
			int fila = aleatorio.nextInt(tablero.length);
			
			if (tablero[fila][columna] == 0){
				tablero[fila][columna] = icono[1];
				contador++;
			}
		}
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == icono[1]){
					resultado.append("[" + icono[3] + "]");
				}else{
					resultado.append("[" + tablero[i][j] + "]");
				}
			}
			resultado.append("\n");
		}
		
		return resultado.toString();
		
	}

}