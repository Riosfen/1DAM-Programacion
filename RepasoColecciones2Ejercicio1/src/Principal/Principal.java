package Principal;

import java.util.Arrays;
import java.util.Scanner;

import Clases.*;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		ColaPedidos cola = new ColaPedidos();
		do {
			opcion = mostrarMenu();
			try {
				tratarMenu(opcion, cola);
			} catch (PizzaException e) {
				System.out.println(e.getMessage());
			}
		} while (opcion != 4);

	}

	private static void tratarMenu(int opcion, ColaPedidos cola) throws PizzaException {
		Pedido pedido;
		switch (opcion) {
		case 1: {
			nuevoPedido(cola);
			break;
		}
		case 2: {

			try {
				pedido = cola.atenderPedido();
				System.out.println("\n----------\nPedido a atender: ");
				System.out.println(pedido);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			break;
		}
		case 3: {
			System.out.println("\n-----------\nNúmero de pedidos:"
					+ cola.numeroDePedidosEnCola());
			break;
		}
		case 4: {
			System.out.println("\nFIN DEL PROGRAMA");
			break;
		}
		}

	}

	private static void nuevoPedido(ColaPedidos cola) throws PizzaException {
		String direccion;
		Pedido pedido1;
		int eleccion;
		Pizza nueva;
		char c = 'N';

		direccion = pedirDireccion();

		pedido1 = new Pedido(direccion);

		System.out.println(pedido1 + "\n");

		do {
			eleccion = solicitarTipoPizza(); // 1 pizza normal, 2 pizza por
												// ingrediente
			nueva = crearPizza(eleccion);
			pedido1.nuevoPedido(nueva);
			c = solicitarRespuesta("¿Quieres alguna pizza más? (S/N)");

		} while (c == 'S');

		System.out.println("----------\n" + pedido1.toString());

		cola.agregarPedido(pedido1);

	}

	public static String pedirDireccion() {
		String direccion;
		System.out.println("\nIntroduce la dirección del pedido:");
		direccion = teclado.nextLine();
		return direccion;
	}

	public static int solicitarTipoPizza() {
		int eleccion;
		do {
			System.out
					.println("1. Pizza de la carta\n2. Pizza por ingredientes");
			System.out.print("Elige una Opción: ");
			eleccion = Integer.parseInt(teclado.nextLine());
		} while (eleccion != 1 && eleccion != 2);
		return eleccion;
	}

	private static Pizza crearPizza(int eleccion) throws PizzaException {
		Pizza p1 = null;
		switch (eleccion) {
		case 1: { // pizza normal
			try {
				p1 = new PizzaPrehecha(solicitarTamanho(), solicitarNumeroPizza());
			} catch (PizzaException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 2: { // pizza por ingrediente
			p1 = new PizzaPorIngrediente(solicitarTamanho());
			agregarIngredientes(p1);
			break;
		}
		}
		return p1;
	}

	private static void agregarIngredientes(Pizza p1) {
		char c = 'N';
		PizzaPorIngrediente.Ingrediente ingrediente;
		do {

			ingrediente = solicitarIngrediente();

			// Para añadir ingrediente tengo que hacer el casting ya que
			// la pizza normal no tiene el método agregarIngrediente

			((PizzaPorIngrediente) p1).AgregarIngrediente(ingrediente);

			c = solicitarRespuesta("¿Quieres algún ingrediente más (S/N)?");
		} while (c == 'S');

	}

	private static char solicitarRespuesta(String pregunta) {
		char c;
		do {
			System.out.println(pregunta);
			c = Character.toUpperCase(teclado.nextLine().charAt(0));
		} while (!((c == 'S') || (c == 'N')));
		return c;
	}

	private static PizzaPorIngrediente.Ingrediente solicitarIngrediente() {
		PizzaPorIngrediente.Ingrediente ing = null;
		boolean error = false;
		String cadena;

		do {
			try {

				System.out.println("Elige un ingrediente: "
						+ Arrays.toString(PizzaPorIngrediente.Ingrediente.values()));
				cadena = teclado.nextLine().toUpperCase();
				ing = PizzaPorIngrediente.Ingrediente.valueOf(cadena);
				error = false;

			} catch (IllegalArgumentException e) {
				System.out.println("ERROR. Elige una opción de la lista.");
				error = true;
			}
		} while (error);
		return ing;
	}

	private static int solicitarNumeroPizza() {
		int numPizza = 0;
		try {
			System.out.println("¿Que pizza quieres? del 1 al "
					+ PizzaPrehecha.TOTAL_PIZZAS_PREPARADAS);
			numPizza = Integer.parseInt(teclado.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("ERROR. Elige un número válido.");
		}
		return numPizza;
	}

	private static Pizza.Tamanio solicitarTamanho() {
		Pizza.Tamanio tam = null;
		boolean error = false;

		do {
			try {
				System.out.println("\n¿Que tamaño quieres de pizza?"
						+ Arrays.toString(Pizza.Tamanio.values()));
				tam = Pizza.Tamanio.valueOf(teclado.nextLine().toUpperCase());
				error = false;

			} catch (IllegalArgumentException e) {
				System.out.println("ERROR. Elige una opción de la lista.");
				error = true;
			}
		} while (error);
		return tam;
	}

	private static int mostrarMenu() {
		int opcion = 0;
		do {
			System.out.println("MENU:\n----------");
			System.out.println("1. Nuevo pedido");
			System.out.println("2. Atender pedido");
			System.out.println("3. Mostrar numero de pedidos pendientes");
			System.out.println("4. Salir");
			System.out.print("Elige una opción de la lista: ");
			try {
				opcion = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("ERROR. Introduce un número de la lista.");
			}
		} while (opcion < 1 || opcion > 4);

		return opcion;
	}

}
