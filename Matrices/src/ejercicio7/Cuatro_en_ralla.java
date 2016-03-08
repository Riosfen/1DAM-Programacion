package ejercicio7;

public class Cuatro_en_ralla {

	private char[][] tablero;
	
	private static final int FILAS = 8;
	private static final int COLUMNAS = 8;
	
	private int[] indice = new int[FILAS];
	private static final int FILAS_FIN = FILAS -1;
	
	private static final char VACIO = ' ', JUGADOR_1 = 'R', JUGADOR_2 = 'A';
	
	private int turno = 1;
	
	public Cuatro_en_ralla() {

		tablero = new char[FILAS][COLUMNAS];
		rellenarTablero();
		inicializarIndice();
		
	}
	
	private void inicializarIndice() {

		for (int i = 0; i < indice.length; i++) {
			indice[i] = FILAS_FIN;
		}
		
	}

	public boolean turno(int posicion) throws Cuatro_en_rallaException{
		
		boolean ganaste;
		
		if (posicion < 0 || posicion > indice.length)
			throw new Cuatro_en_rallaException("La posición introducida no está dentro de los límites");
		
		if (turno == 0){
			ganaste = colocarFicha(JUGADOR_1, posicion);
			indice[posicion]--;
			turno++;
		}
		else{
			ganaste = colocarFicha(JUGADOR_2, posicion);
			indice[posicion]--;
			turno--;
		}
		
		return ganaste;
		
	}

	private void rellenarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
		
	}
	
	private boolean colocarFicha(char jugador, int posicion) throws Cuatro_en_rallaException{
		
		if (indice[posicion] < 0)
			throw new Cuatro_en_rallaException("Esta fila ya está llena");
		
		tablero[indice[posicion]][posicion] = jugador;
		
		return comprobarLinea(indice[posicion], posicion, jugador);
		
	}

	private boolean comprobarLinea(int fila, int columna, char jugador) {
		int contadorColumna = 0;
		int contadorFila = 0;
		int i = columna;
		int j = fila;
		boolean ganaste = false;
		boolean error = false;

		while (i < tablero[columna].length && contadorColumna < 4 && !error) {
			if (tablero[fila][columna] == jugador){
				contadorColumna++;
			}
			else{error = true;}
			i++;
		}
		while (j < tablero.length && contadorColumna < 4 && !error) {
			if (tablero[fila][columna] == jugador){
				contadorFila++;
			}
			else{error = true;}
			j++;
		}
		while (j > 0 && contadorColumna < 4 && !error) {
			if (tablero[fila][columna] == jugador){
				contadorFila++;
			}
			else{error = true;}
			j--;
		}
		
		if (contadorColumna == 4 || contadorFila == 4){
			ganaste = true;
		}
		
		return ganaste;
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				resultado.append("[" + tablero[i][j] + "]");
			}
			resultado.append("\n");
		}
		
		return resultado.toString();
		
	}

}
