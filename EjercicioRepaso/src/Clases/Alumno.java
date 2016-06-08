package Clases;

public class Alumno {

	private String nombre;
	private String dni;
	
	public Alumno(String nombre, String dni){
		setNombre(nombre);
		setDni(dni);
	}

	private void setDni(String dni) {
		// TODO Falta filtrar dni
		this.dni = dni;
	}

	private void setNombre(String nombre) {
		// TODO Falta filtrar nombre
		this.nombre = nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(Object otro) {
		boolean resul = false;
		
		Alumno alum = (Alumno) otro;
		
		if (dni.equals(alum.dni))
			resul = true;
		
		return resul;
	}
	
	public String toString(){
		return "Nombre: " + nombre + ", DNI: " + dni;
	}
	
}
