package ejercicio6;

import java.util.Random;

import javax.swing.SingleSelectionModel;

public class Pisaminas {

	private int bombas = 20;
	private char[] icono = { 'J', '*', ' ' };
	private char[][] tablero;
	private char[][] tableroVacio;

	public Pisaminas(int tamanio){
		tablero = new char[tamanio][tamanio];
		tableroVacio = new char[tamanio][tamanio];
	}
	
	public void colocarBombas() {
		Random bomba = new Random();
		int colBomba = 0;
		
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (colBomba < bombas){
					tablero[i][j] = Character.forDigit(bomba.nextInt(3), 10);
					if (tablero[i][j] == '1')
						colBomba++;
					if (tablero[i][j] == '2')
						tablero[i][j] = Character.forDigit(0, 10);
				}else{
					tablero[i][j] = Character.forDigit(0, 10);
				}
				System.out.print("[" + tablero[i][j] + "]");
			}
			System.out.println();
		}
		
		posicionJugador();
		tableroVacio = tablero.clone();
		
	}
	
	public void posicionJugador(){
		tablero[0][0] = icono[0];
		actualizarPisaminas();
	}
	
	private void actualizarPisaminas(){
		
		for (int i = 0; i < tableroVacio.length; i++) {
			for (int j = 0; j < tableroVacio[i].length; j++) {
				if (tableroVacio[i][j] == 'J')
					System.out.print("[" + icono[0] + "]");
				if (tableroVacio[i][j] == '0')
					System.out.print("[" + icono[2] + "]");
				if (tableroVacio[i][j] == '1')
					System.out.print("[" + icono[1] + "]");
			}
			System.out.println();
		}
		
	}
	public void moverArriba(){
		if ()
	}

}