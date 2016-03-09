
public class Tablero {

	private char[][] tablero;
	
	private static final int FILA = 10;
	private static final int COLUMNA = 10;
	

	private static final char VACIO = ' ';
	
	public Tablero(){
		tablero = new char[FILA][COLUMNA];
		cargarTablero();
	}

	private void cargarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
	}
	
	public String toString(){
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < tablero.length; i++) {
			resultado.append(" " + (char)(65+i) + " ");
		}
		
		resultado.append("\n");
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				resultado.append("[" + tablero[i][j] + "]");
			}
			resultado.append(" " + (i+1) + "\n");
		}
		return resultado.toString();
	}
	
	
}
