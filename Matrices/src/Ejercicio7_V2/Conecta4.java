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
		rellenar();
		
	}
	
	// Rellena la matriz con char vacios y el array con numeros igual al lo que ocupa el array -1
	private void rellenar() {
		
		for (int i = 0; i < indice.length; i++) {
			indice[i] = COLUMNA-1;
		}
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
		
	}
	
	// Se le pasa desde la clase principal la posicion donde se quiere meter 
	// y al jugador que le toca jugar (posicion 1 al tablero.length -1( 8 en este caso))
	// (jugador 1 o 2)
	public void colocarFicha(int posicion, int jugador) throws Conecta4Exception, Conecta4GanaException{
		
		posicion--;
		jugador--;
		
		if(jugador < 0 || jugador > 1)
			throw new Conecta4Exception("Error, ese jugador no existe.");
			
		if(posicion < 0 || posicion > COLUMNA)
			throw new Conecta4Exception("Error, la ficha ha caido fuera ¬¬.");
		
		if(indice[posicion] < 0)
			throw new Conecta4Exception("Error, esa columna ya está llena.");
		
		if(tablero[indice[posicion]][posicion] == VACIO){
			tablero[indice[posicion]][posicion] = this.jugador[jugador];
			comprobarFicha(indice[posicion],posicion,jugador);
			indice[posicion]--;
		}
		
	}
	
	// Se comprueba que no se sale de los limites
	private void comprobarFicha(int fila, int columna, int jugador) throws Conecta4GanaException{
		
		if (contarficha(fila, columna, 1, 0, jugador) == 4)
			throw new Conecta4GanaException("El jugador " + this.jugador[jugador] + " ha ganado");
		
		if (contarficha(fila, columna, 0, 1, jugador) == 4)
			throw new Conecta4GanaException("El jugador " + this.jugador[jugador] + " ha ganado");
//		contarficha(fila, columna, 0,1);
//		contarficha(fila, columna, 1,1);
//		contarficha(fila, columna, 1,-1);
		
	}
	
	private int contarficha(int fila, int columna, int i, int j, int jugador){
		
		int ficha = 0;
		boolean buscando = true;
		
		while(fila < COLUMNA && ficha < 4 && buscando && fila < FILA){
			
			if (tablero[fila][columna] == this.jugador[jugador]){
				ficha++;
			}else{
				buscando = false;
			}
			
			fila+=i;
			columna+=j;
		}
		
		return ficha;
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
