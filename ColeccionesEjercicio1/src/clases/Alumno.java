package clases;

public class Alumno {

	private String dni;
	private String nombre;
	
	public Alumno(String dni, String nombre){
		setDni(dni);
		setNombre(nombre);
	}
	
	
	
	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public boolean equals(Alumno otro){
		
		boolean resultado = false;
		
		if (dni.equals(otro.dni)){
			resultado = true;
		}
		
		return resultado;
		
	}
	
	public String toString(){
		
		return "DNI: " + dni + ", Nombre: " + nombre;
		
	}
	
}
