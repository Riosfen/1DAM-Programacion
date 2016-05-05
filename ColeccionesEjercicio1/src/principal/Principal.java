package principal;

import clases.Alumno;
import clases.Equipo;

public class Principal {

	public static void main(String[] args) {

		Alumno alumno1 = new Alumno("4455H", "Alfonso");
		Alumno alumno2 = new Alumno("4875H", "Alfonso");
		Alumno alumno3 = new Alumno("6545H", "Alfonso");
		Alumno alumno4 = new Alumno("5655H", "Alfonso");
		Alumno alumno6 = new Alumno("2165H", "Alfonso");
		Alumno alumno7 = new Alumno("4423H", "Alfonso");

		Equipo equipo1 = new Equipo("Equipo - 1");
		Equipo equipo2 = new Equipo("Equipo - 2");
		Equipo equipo3;
		Equipo equipo4;

		equipo1.aniadirAlumno(alumno1);
		equipo1.aniadirAlumno(alumno7);
		equipo1.aniadirAlumno(alumno6);
		equipo1.aniadirAlumno(alumno2);

		System.out.println(equipo1);

		equipo2.aniadirAlumno(alumno1);
		equipo2.aniadirAlumno(alumno7);
		equipo2.aniadirAlumno(alumno4);
		equipo2.aniadirAlumno(alumno3);

		System.out.println(equipo2);

		equipo3 = equipo1.insertarEquipo(equipo2);

		System.out.println(equipo3);

		equipo4 = equipo1.unirEquipo(equipo2);

		System.out.println(equipo4);
	}

}
