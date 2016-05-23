package Clases;

import java.util.LinkedList;

public class ColaPedido {

	private LinkedList<Pedidos> cPedidos = new LinkedList<Pedidos>();
	
	public void aniadirPedido(Pedidos pedido){
		cPedidos.add(pedido);
	}
	
	public Pedidos atenderPedido(){
		return cPedidos.remove();
	}
	
	public int totalPedidos(){
		return cPedidos.size();
	}
			
}
