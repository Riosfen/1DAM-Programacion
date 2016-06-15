package Clases;

public abstract class Pizza {

	public enum Tamanio { PEQUENIO,MEDIANO,GRANDE };
	
	private Tamanio tamanio;
	
	public Pizza (Tamanio tamanio) throws PizzaException{
		this.tamanio = tamanio;
	}
	
	public Tamanio getTamanio() {
		return tamanio;
	}
	
	public String toString(){
		return "Pizza ";
	}
	
}
