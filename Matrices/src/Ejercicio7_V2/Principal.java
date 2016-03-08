package Ejercicio7_V2;

import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Conecta4 juego = new Conecta4();

		menuJuego(juego);

	}

	private static void menuJuego(Conecta4 juego) {

		boolean juegoTerminado = false;
		int jugador = 1;
		
		do {
			
			System.out.println(juego);
			
			try {
				
				System.out.println("Coloca una ficha:");
				int posicion = Integer.parseInt(teclado.nextLine());
				juego.colocarFicha(posicion, jugador);
				
			} catch (Conecta4GanaException e) {
				System.out.println(e.getMessage());
				System.out.println(juego);
				juegoTerminado = true;
			} catch (Conecta4Exception e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println("Error desconocido.");
			}
			
			if (jugador == 1){
				jugador++;
			}else{
				jugador--;
			}
			
		} while (!juegoTerminado);
		
	}

}
