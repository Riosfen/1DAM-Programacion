package Clases;

import java.util.HashSet;

public class PizzaPorIngrediente extends Pizza {

	public enum Ingrediente { TOMATE,ANCHOAS,BACON,POLLO,BERENGENAS,ALGO_DIVERTIDO };
	
	private HashSet<Ingrediente> ingre;
	
	public PizzaPorIngrediente(Tamanio tamanio) throws PizzaException {
		super(tamanio);
		ingre = new HashSet<Ingrediente>();
	}
	
	public void AgregarIngrediente(Ingrediente ingre){
		this.ingre.add(ingre);
	}
	
	public String ingredientes(){
		StringBuilder resul = new StringBuilder();
		
		resul.append("Ingredientes: \n");
		
		for (Ingrediente ingrediente : ingre) {
			resul.append(ingrediente + "\n");
		}
		
		return resul.toString();
	}
	
	public String toString(){
		return super.toString() + "por ingrediente: Tamaño: " + this.getTamanio() + ", ingrediente/s: \n" + ingredientes();
	}
	
}
