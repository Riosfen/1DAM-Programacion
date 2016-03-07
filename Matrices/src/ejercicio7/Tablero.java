package ejercicio7;

public class Tablero {

	private char[][] tablero;
	private char[] iconos = {'R', 'A', ' '};
	
	public Tablero(int tamanio) {

		tablero = new char[tamanio][tamanio];

	}
	
	private void rellenarTablero(){
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = iconos[2];
			}
		}
		
	}

	public void actualizar() {

		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				resultado.append("[" + tablero[i][j] + "]");
			}
			resultado.append("\n");
		}

	}
	
	public void introducirFicha(int jugador, int posicion) throws ExceptionTablero{
		
		if (jugador < 0 || jugador > 1)
			throw new ExceptionTablero("Error, no puede haber mas de 2 jugadores.");
		
		if (tablero[posicion][0] != iconos[2])
			throw new ExceptionTablero("Error, esa columna ya está llena.");
		
		for (int j = 0; j < tablero[posicion].length; j++) {
			if (tablero[posicion][j] == iconos[2]){
				tablero[posicion][j] = iconos[jugador];
			}
		}
		
	}

}
