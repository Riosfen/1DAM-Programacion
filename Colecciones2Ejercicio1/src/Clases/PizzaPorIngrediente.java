package Clases;

import java.util.HashSet;

public class PizzaPorIngrediente extends Pizza {
	
	private enum Ingrediente{ TOMATE,QUESO,POLLO,CHORIZO,JAMON,YORCK,ACEITUNA,SALCHICHAS };
	
	private HashSet<Ingrediente> cIngrediente = new HashSet<Ingrediente>();
	
	public PizzaPorIngrediente(Tamanio tamanio) {
		super(tamanio);
	}
	
	public HashSet<Ingrediente> getcIngrediente() {
		return cIngrediente;
	}

	public boolean aniadirIngrediente(Ingrediente ingrediente){
		
		boolean resultado = cIngrediente.add(ingrediente);
		
		return resultado;
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		int indice = 1;
		
		for (Ingrediente o : cIngrediente) {
			
			resultado.append("\n" + indice + ". " + o.toString());
			
			indice++;
		}
		
		return super.toString() + "\nINGREDIENTES:" + resultado;
	}
	
}
