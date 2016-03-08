
public class Tablero {

	private char[][] tablero;
	private static final int FILA = 6;
	private static final int COLUMNA = 6;

	private static final int META_FILA = 2;
	private static final int META_COLUMNA = COLUMNA - 1;

	private static final char VACIO = ' ';
	private static final char META = '=';

	public Tablero() throws AutoMovilException, JuegoGanadoException {

		tablero = new char[FILA][COLUMNA];
		tablero[META_FILA][META_COLUMNA] = META;
		rellenarMatriz();
	}

	private void rellenarMatriz() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == 0) {
					tablero[i][j] = VACIO;
				}
			}
		}

	}

	public void colocarVehiculo(AutoMovil coche) throws JuegoGanadoException {

		int x = coche.getFila();
		int y = coche.getColumna();

		if (coche.getDireccion() == 'H') {
			for (int i = 0; i < coche.getCasillas(); i++) {
				tablero[x][y + i] = coche.getIcono();
			}
		} else {
			for (int j = 0; j < coche.getCasillas(); j++) {
				tablero[x + j][y] = coche.getIcono();
			}
		}
		if (coche.getIcono() == '=')
			throw new JuegoGanadoException("As completado el juego!!");

	}

	public void moverVehiculo(AutoMovil coche, int x, int y) throws TableroException, JuegoGanadoException {
		
		int fila = coche.getFila();
		int columna = coche.getColumna();

		if (coche.getDireccion() == 'H') {

			int cabe = coche.getCasillas() + y;

			if (cabe > META_FILA || y < 0)
				throw new TableroException("Error, no se puede colocar ahí.");

			for (int i = 0; i < cabe; i++) {
				if (tablero[fila][i + columna] != ' ' && tablero[fila][i + columna] == coche.getIcono())
					throw new TableroException("Error, no se puede mover el coche ahí.");
				
				coche.setColumna(columna + y);
				colocarVehiculo(coche);
			}

		} else {

			int cabe = coche.getCasillas() + x;

			if (cabe > META_FILA || x < 0)
				throw new TableroException("Error, no se puede colocar ahí.");

			for (int i = 0; i < cabe; i++) {
				if (tablero[fila + i][columna] != ' ' && tablero[fila][i + columna] == coche.getIcono())
					throw new TableroException("Error, no se puede mover el coche ahí.");
				
				coche.setColumna(fila + x);
				colocarVehiculo(coche);
			}

		}

	}

	public String toString() {

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
