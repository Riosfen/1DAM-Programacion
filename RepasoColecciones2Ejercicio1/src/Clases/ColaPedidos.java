package Clases;

import java.util.LinkedList;

public class ColaPedidos {

	private LinkedList<Pedido> pedidos;
	
	public ColaPedidos(){
		pedidos = new LinkedList<Pedido>();
	}
	
	public void agregarPedido(Pedido pedido){
		pedidos.add(pedido);
	}
	
	public Pedido atenderPedido() throws PizzaException{
		Pedido pedido;
		
		if (pedidos.size() == 0)
			throw new PizzaException("Error, no hay ningun pedido en cola");
		
		pedido = pedidos.poll();
		
		return pedido;
	}
	
	public int numeroDePedidosEnCola(){
		return pedidos.size();
	}
	
}
