package Clases;

import java.util.ArrayList;

public class Pedidos {

	private ArrayList<Pizza> cPizza = new ArrayList<Pizza>();
	private String direccion;
	
	public Pedidos(String direccion){
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void aniadirPizza(Pizza pizza){
		cPizza.add(pizza);
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (Pizza o : cPizza) {
			resultado.append("\n" + o);
		}
		
		return "PEDIDO: \nDirección: " + direccion + "\nPizza: " + resultado;
	}
	
}
