package Ejercicio8Arrays;

public class Alumno {
	
	private String nombre;
	private double nota;
	
	public Alumno(String nombre, double nota) throws AlumnoException{
		
		setNombre(nombre);
		setNota(nota);
		
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		//TODO hacer que solo sean letras y la primera mayuscula y solo un espacio.
		this.nombre = nombre;
	}

	public double getNota() {
		return nota;
	}

	private void setNota(double nota) throws AlumnoException {
		
		if(nota < 0 || nota > 10)
			throw new AlumnoException("Error, la nota no puede ser menor a 0 ni mayor de 10.");
		
		this.nota = nota;
	}
	
	public String toString(){
		return "Alumno: " + nombre + ", Nota: " + nota;
	}
	
	public boolean equals(Alumno alumno){
		boolean resultado = false;
		if (nombre.equals(alumno.nombre)){
			resultado = true;
		}
		return resultado;
	}
	
	

}
