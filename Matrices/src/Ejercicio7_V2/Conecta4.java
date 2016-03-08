package Ejercicio7_V2;

public class Conecta4 {

	private char[][] tablero;

	private static final int FILA = 8;
	private static final int COLUMNA = 8;
	
	private static final char VACIO = ' ';	
	private char[] jugador = {'R','A'};
	
	private int[] indice = new int[COLUMNA];
	
	// Constructor
	public Conecta4(){
		
		tablero = new char[FILA][COLUMNA];
		rellenarTablero();
		
	}
	
	// Rellena el array con char vacios
	private void rellenarTablero() {
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
		
	}
	
	public void colocarFicha(int posicion, int jugador) throws Conecta4Exception{
		
		if(jugador < 1 || jugador > 2)
			throw new Conecta4Exception("Error, ese jugador no existe.");
			
		if(posicion < 1 || posicion > COLUMNA -1)
			throw new Conecta4Exception("Error, la ficha ha caido fuera ¬¬.");
		
		if(tablero[indice[posicion]][posicion] == VACIO){
			tablero[indice[posicion]][posicion] = this.jugador[jugador-1];
			comprobarFicha(indice[posicion],posicion);
		}
		
	}
	// Se comprueba que no se sale de los limites
	private void comprobarFicha(int fila, int columna){
		
		contarficha(1,0);
		contarficha(0,1);
		contarficha(1,1);
		contarficha(1,-1);
		
	}
	
	private int contarficha(int i, int j){
		
		while(){
			
		}
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				resultado.append("[" + tablero[i][j] + "]");
			}
			resultado.append("\n");
		}
		return resultado.toString();
	}
	
}
