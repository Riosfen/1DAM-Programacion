package Clases;

public class Socio {

	private String dni;
	private String nombre;
	private int telefono;
	
	public Socio(String dni, String nombre, int telefono){
		
		setDni(dni);
		setNombre(nombre);
		setTelefono(telefono);
		
	}
	
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	
	private void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public boolean equals(Socio otro){
		
		boolean resultado = false;
		
		if (dni.equals(otro.dni)){
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public String toString(){
		return "Socio --> Dni:" + dni + "Nombre: " + nombre + ", Teléfono: " + telefono;
	}
	
}
