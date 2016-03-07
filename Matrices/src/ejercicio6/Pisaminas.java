package ejercicio6;

import java.util.Random;

public class Pisaminas {

	private char[][] tablero;
	private static final int FILAS = 8;
	private static final int COLUMNAS = 8;
	private static final int MINAS = 10;

	private static final int FILA_INICIAL = 0;
	private static final int COLUMNA_INICIAL = 0;
	
	private static final int FILA_FINAL = FILAS - 1;
	private static final int COLUMNA_FINAL = COLUMNAS -1;
	
	private int jugadorFila,jugadorColumna;
	
	private static final char JUGADOR = 'J', META = 'M', BOMBA = '*', VACIO = ' ';
	
	public Pisaminas(){
		tablero = new char[FILAS][COLUMNAS];
		jugadorFila = 0;
		jugadorColumna = 0;
		cargarMatrizVacia();
		colocarFichas();
		colocarMinas();
		
	}
	
	// movimiento:
	
	public boolean moverArriba() throws ExceptionPisaminas{
		
		boolean pisadoMina;
		
		if (jugadorFila == 0)
			throw new ExceptionPisaminas("No puedes moverte hacia arriba");
		
		tablero[jugadorFila][jugadorColumna] = VACIO;
		jugadorFila--;
		pisadoMina = terminarMovimiento();
		
		return pisadoMina;
		
	}
	
	public boolean moverAbajo() throws ExceptionPisaminas{
		
		boolean pisadoMina;
		
		if (jugadorFila == FILA_FINAL)
			throw new ExceptionPisaminas("No puedes moverte hacia abajo");
		
		tablero[jugadorFila][jugadorColumna] = VACIO;
		jugadorFila++;
		pisadoMina = terminarMovimiento();
		
		return pisadoMina;
		
	}
	public boolean moverDerecha() throws ExceptionPisaminas{
		
		boolean pisadoMina;
		
		if (jugadorColumna == COLUMNA_FINAL)
			throw new ExceptionPisaminas("No puedes moverte hacia la derecha");
		
		tablero[jugadorFila][jugadorColumna] = VACIO;
		jugadorColumna++;
		pisadoMina = terminarMovimiento();
		
		return pisadoMina;
		
	}
	
	public boolean moverIzquierda() throws ExceptionPisaminas{
		
		boolean pisadoMina;
		
		if (jugadorColumna == 0)
			throw new ExceptionPisaminas("No puedes moverte hacia la izquierda");
		
		tablero[jugadorFila][jugadorColumna] = VACIO;
		jugadorColumna--;
		pisadoMina = terminarMovimiento();
		
		return pisadoMina;
		
	}
	
	// fin movimiento
	
	@SuppressWarnings("unused")
	public boolean mtaAlcanzada(){
		
		boolean resultado = false;
		
		if (jugadorFila == FILA_FINAL && jugadorColumna == COLUMNA_FINAL){
			resultado = true;
		}
		
		return resultado;
	}
	
	private boolean terminarMovimiento() {
		boolean pisadoMina = false;
		
		if (tablero[jugadorFila][jugadorColumna] == BOMBA){
			pisadoMina = true;
		}else{
			tablero[jugadorFila][jugadorColumna] = JUGADOR;
		}
		
		return pisadoMina;
	}
	
	private void cargarMatrizVacia() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = VACIO;
			}
		}
		
	}

	private void colocarFichas(){
		
		tablero[FILA_INICIAL][COLUMNA_INICIAL] = JUGADOR;
		tablero[FILA_FINAL][COLUMNA_FINAL] = META;
		
	}
	
	private void colocarMinas(){
		
		int i = 1, filaAleatoria, columnaAleatoria;
		Random serie = new Random();
		
		while(i < MINAS){
			
			filaAleatoria = serie.nextInt(FILAS);
			columnaAleatoria = serie.nextInt(COLUMNAS);
			
			if (tablero[filaAleatoria][columnaAleatoria] == VACIO){
				tablero[filaAleatoria][columnaAleatoria] = BOMBA;
				i++;
			}
			
		}
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == BOMBA){
					resultado.append("[" + VACIO + "]");
				}else{
					resultado.append("[" + tablero[i][j] + "]");
				}
			}
			resultado.append("\n");
		}
		
		return resultado.toString(); 
		
	}
	
}