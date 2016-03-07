import java.util.Random;
import java.util.Scanner;

public class Ejercicio4Arrays {

	private static Scanner teclado = new Scanner(System.in);
	private static final int INTENTOS = 7;
	private static final char GUION = '_';

	public static void main(String[] args) {
		String palabraSecreta = elegirAleatoriamente().toUpperCase();
		jugarAhorcado(palabraSecreta);

	}

	private static String elegirAleatoriamente() {

		String[] palabra = { "Esternocleidomastoideo", "Persiana", "Proyector", "Guillotina", "Guitarra", "Whisky",
				"Movil", "Raton" };

		Random serie = new Random();

		int aleatoria = serie.nextInt(palabra.length);

		return palabra[aleatoria];

	}

	/**
	 * Metodo para jugar al ahorcado con una palabra
	 * 
	 * @param palabraSecreta
	 */
	private static void jugarAhorcado(String palabraSecreta) {

		boolean acierto = false;
		int intentosFallidos = 0;
		StringBuilder palabraJuego;
		StringBuilder letrasYaIntroducidas = new StringBuilder(30);
		char c;

		palabraJuego = construirPalabraJuego(palabraSecreta);

		do {
			mostrarPalabraJuego(palabraJuego);
			c = solicitarCaracter(letrasYaIntroducidas);

			if (sustituirCaracter(palabraJuego, palabraSecreta, c) == false) {
				System.out.println("El caracter " + c + " no esta en la palabra secreta");
				intentosFallidos++;
				System.out.println("Tienes " + intentosFallidos + " fallos");

			} else {
				if (palabraJuego.toString().equals(palabraSecreta)) {
					acierto = true;
				}
			}

		} while (!terminadoJuego(acierto, intentosFallidos));

		if (acierto == true)
			System.out.println("Enhorabuena. Has ganado. La palabra secreta era " + palabraSecreta);
		else
			System.out.println("Has perdido. La palabra secreta era: " + palabraSecreta);
	}

	private static boolean sustituirCaracter(StringBuilder palabraJuego, String palabraSecreta, char c) {

		boolean encontrado = false;

		for (int i = 0; i < palabraJuego.length(); i++) {
			if (palabraSecreta.charAt(i) == c) {
				encontrado = true;
				palabraJuego.setCharAt(i, c);

			}
		}

		return encontrado;
	}

	/**
	 * Metodo para mostrar la palabra separada por espacios
	 * 
	 * @param palabraJuego
	 */
	private static void mostrarPalabraJuego(StringBuilder palabraJuego) {

		System.out.println();
		for (int i = 0; i < palabraJuego.length(); i++) {
			System.out.print(palabraJuego.charAt(i) + " ");
		}
		System.out.println();
	}

	private static StringBuilder construirPalabraJuego(String palabraSecreta) {

		StringBuilder palabraJuego = new StringBuilder(palabraSecreta.length());
		int i;

		palabraJuego.append(palabraSecreta.charAt(0));

		for (i = 1; i < palabraSecreta.length(); i++) {
			palabraJuego.append(GUION);
		}
		return palabraJuego;
	}

	private static char solicitarCaracter(StringBuilder letrasYaIntroducidas) {
		char c;
		boolean correcto = false;
		do {
			pintar(letrasYaIntroducidas);
			System.out.println("Introduce un caracter :");
			c = teclado.nextLine().charAt(0);
			if (Character.isLetter(c)) {
				c = Character.toUpperCase(c);
				if (letrasYaIntroducidas.indexOf(Character.toString(c)) >= 0)
					System.out.println("Esta letra ya la habias introducido");
				else {
					letrasYaIntroducidas.append(c);
					correcto = true;
				}
			}

		} while (!correcto);

		return c;
	}

	private static void pintar(StringBuilder letrasYaIntroducidas) {

		if (letrasYaIntroducidas.length() > 0) {
			System.out.print("Letras ya introducidas: ");
			for (int i = 0; i < letrasYaIntroducidas.length(); i++) {
				System.out.print(letrasYaIntroducidas.charAt(i) + " ");
			}
		}
		System.out.println();

	}

	private static boolean terminadoJuego(boolean acierto, int intentosFallidos) {

		boolean terminado;
		if (acierto == true || intentosFallidos == INTENTOS)
			terminado = true;
		else
			terminado = false;
		return terminado;
	}

}