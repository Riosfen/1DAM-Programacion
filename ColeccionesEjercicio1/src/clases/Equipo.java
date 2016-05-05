package clases;

import java.util.HashSet;
import java.util.Iterator;

public class Equipo {

	private String nombre;
	private HashSet<Alumno> cAlumno;

	public Equipo(String nombre){
		setNombre(nombre);
		cAlumno = new HashSet<Alumno>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public boolean aniadirAlumno(Alumno alumno) {
		return cAlumno.add(alumno);
	}
	
	public boolean borrarAlumno(Alumno alumno) {
		return cAlumno.remove(alumno);
	}

	public boolean esEquipo(Alumno alumno) {
		return cAlumno.contains(alumno);
	}

	public String toString() {

		StringBuilder resultado = new StringBuilder("Equipo: " + nombre + "\n");
		Iterator<Alumno> it = cAlumno.iterator();
		
		while (it.hasNext()) {
			resultado.append(it.next() + "\n");
		}
		
		return resultado.toString();
	}

	public Equipo unirEquipo(Equipo otro) {

		Equipo resultado = new Equipo("Union de " + nombre + " + " + otro.nombre);
		
//		for ( Alumno a : cAlumno ){
//			resultado.cAlumno.add(a);
//		}
//		for ( Alumno a : otro.cAlumno ){
//			resultado.cAlumno.add(a);
//		}
		
		resultado.cAlumno.addAll(cAlumno);
		resultado.cAlumno.addAll(otro.cAlumno);

		return resultado;

	}

	public Equipo insertarEquipo(Equipo otro) {

		Equipo resultado = new Equipo("Diferencia de " + nombre + " + " + otro.nombre);
		
		for ( Alumno a : cAlumno) {
			if (otro.cAlumno.contains(a)){
				resultado.cAlumno.add(a);
			}
		}

		return resultado;

	}

}
