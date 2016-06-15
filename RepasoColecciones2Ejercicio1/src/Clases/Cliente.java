package Clases;

public class Cliente {
	
	private String direccion;

	public Cliente (String direccion){
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String toString(){
		return "Dirección: " + direccion;
	}
	
}
