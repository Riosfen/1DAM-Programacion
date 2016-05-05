package clases;

import java.util.HashSet;
import java.util.Iterator;

public class Equipo {

	private String nombre;
	private HashSet<Alumno> cAlumno = new HashSet<Alumno>();

	public void aniadirAlumno(Alumno alumno) {
		if (cAlumno.add(alumno)) {
			System.out.println("Se ha agregado correctamente.");
		} else {
			System.out.println("Error! ya se encuentra en el equipo.");
		}
	}

	public void borrarAlumno(String dni) {
		Iterator<Alumno> itr = cAlumno.iterator();

		while (itr.hasNext()) {
			if (itr.next().equals(dni))
				itr.remove();
		}
	}

	public boolean esEquipo(String dni) {

		boolean resultado = false;

		return resultado;
	}

	public String toString() {

		return "";

	}

	public Equipo unirEquipo(Equipo otro) {

		Equipo resultado;

		return otro;

	}

	public Equipo insertarEquipo(Equipo otro) {

		Equipo resultado;

		return otro;

	}

}
