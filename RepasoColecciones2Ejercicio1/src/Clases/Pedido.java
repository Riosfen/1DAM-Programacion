package Clases;

import java.util.ArrayList;

public class Pedido {
	
	private Cliente direccion;
	private ArrayList<Pizza> pizzas;
	
	public Pedido(String direccion){
		this.direccion = new Cliente(direccion);
		pizzas = new ArrayList<Pizza>();
	}
	
	public void nuevoPedido(Pizza pizza){
		pizzas.add(pizza);
	}
	
	public String toString(){
		StringBuilder resul = new StringBuilder();
		
		for (Pizza pizza : pizzas) {
			resul.append("\n" + pizza + "\n");
		}
		return resul.toString();
	}
	
}
