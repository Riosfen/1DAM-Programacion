package Clases;

public abstract class Pizza {
	
	public enum Tamanio{ PEQUENIA,MEDIANA,GRANDE}
	private Tamanio tamanio;
	
	public Pizza(Tamanio tamanio){
		this.tamanio = tamanio;
	}
	
	public Tamanio getTamanio() {
		return tamanio;
	}
	
	public String toString(){
		return "PIZZA: \nTamaño pizza: " + tamanio;
	}
	
}
