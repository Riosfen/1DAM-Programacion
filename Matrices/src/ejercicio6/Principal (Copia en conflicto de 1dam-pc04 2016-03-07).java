package ejercicio6;

import java.util.Arrays;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {

		int tamanio = 8;
		Pisaminas juego = new Pisaminas(tamanio);
		
		juego.colocarBombas();
		juego.posicionarJugador();
		
		
	}
}
