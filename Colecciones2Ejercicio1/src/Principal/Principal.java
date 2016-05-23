package Principal;

import java.util.Scanner;

import Clases.ColaPedido;
import Clases.Pedidos;
import Clases.Pizza;
import Clases.PizzaElaborada;
import Clases.PizzaException;
import Clases.PizzaPorIngrediente;
import Clases.Pizza.Tamanio;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ColaPedido cPedido = null;
		
		System.out.println("PROGRAMA PARA PEDIDOS DE PIZZA: ");
		
		int opcion = 0;
		
		do {
			try {
				
				menu();
				opcion = Integer.parseInt(teclado.nextLine());
				tratarMenu(opcion, cPedido);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opcion != 4);
		
		
	}

	private static void tratarMenu(int opcion, ColaPedido cPedido) {

		switch(opcion){
		case 1:
			Pedidos pedido = new Pedidos(insertarString("direccion"));
			Pizza pizza = tratarPizza();
			
			pedido.aniadirPizza(pizza);
			cPedido.aniadirPedido(pedido);
			break;

		case 2:
			break;

		case 3:
			break;

		case 4:
			break;
		
		}
		
	}

	private static Pizza tratarPizza() {

		int opcion = 0;
		
		Pizza pizza = null;
		
		do {
			try {
				
				menuPizza();
				opcion = Integer.parseInt(teclado.nextLine());
				pizza = crearPizza(opcion);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opcion != 3);
		
		return pizza;
	}

	private static Pizza crearPizza(int opcion) throws PizzaException {
		
		Pizza pizza = null;		
		Tamanio tamanio = seleccionarTamanio();
		
		switch (opcion) {
		case 1:
			PizzaElaborada pizzaElaborada = new PizzaElaborada(tamanio, IngreasarInt("una pizza de 1 a 20"));
			pizza = pizzaElaborada;
			break;

		case 2:
			PizzaPorIngrediente pizzaPorIngrediente = new PizzaPorIngrediente(tamanio);
			menuIngrediente();
			//TODO voy por aqui, introducir ingredientes.
			pizza = pizzaPorIngrediente;
			break;

		case 3:
			System.out.println("Saliendo...");
			break;
		}
		
		return pizza;
		
	}

	private static void menuIngrediente() {

		
		
	}

	private static int IngreasarInt(String msg) {
		
		System.out.println("Introduce " + msg + ": ");
		
		int resul = Integer.parseInt(teclado.nextLine());
		
		return resul;
	}

	private static Tamanio seleccionarTamanio() {
		
		Tamanio tamanio = null;
		
		System.out.println("Selecciona el tamaño de la pizza: ");
		System.out.println("1. Pequeña \n2. Mediana \n3. Grande");

		int opcion = Integer.parseInt(teclado.nextLine());
		
		switch (opcion) {
		case 1:
			tamanio = Tamanio.PEQUENIA;
			break;

		case 2:
			tamanio = Tamanio.MEDIANA;
			break;
			
		case 3:
			tamanio = Tamanio.GRANDE;
			break;

		default:
			System.out.println("Error! se necesita introducir un tamaño para continuar.");
			seleccionarTamanio();
			break;
		}
		
		return tamanio;
	}

	private static void menuPizza() {

		System.out.println("CREAR PIZZA: ");
		System.out.println("1. Tamaño de la pizza");
		System.out.println("2. Pizza elaborada");
		System.out.println("3. Pizza por ingredientes");
		System.out.println("4. Terminar");
		
	}

	private static String insertarString(String msg) {

		System.out.println("Insertar " + msg + ": ");
		
		String resul = teclado.nextLine();
		
		return resul;
	}

	private static void menu() {

		System.out.println("MENÚ: \n");
		System.out.println("1. Nuevo pedido");
		System.out.println("2. Atender pedido");
		System.out.println("3. Mostrar el número de pedidos pendientes");
		System.out.println("4. Salir");
		
	}
}
