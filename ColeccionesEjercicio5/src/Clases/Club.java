package Clases;

import java.util.HashMap;

public class Club {

	private HashMap<String, Socio> cClub;

	public Club() {
		cClub = new HashMap<String, Socio>();
	}

	public boolean altaSocio(Socio socioNuevo) {

		boolean resultado = cClub.containsKey(socioNuevo.getDni());

		if (!resultado)
			cClub.put(socioNuevo.getDni(), socioNuevo);

		return !resultado;
	}

	public boolean bajaSocio(String dni) {

		boolean resultado = cClub.containsKey(dni);

		if (resultado)
			cClub.remove(dni);

		return resultado;
	}

	public boolean modificarSocio(String dni, Socio socioNuevo) {

		boolean resultado = cClub.containsKey(dni);

		if (resultado)
			cClub.put(dni, socioNuevo);

		return resultado;
	}

	public String consultarSocio(String dni) {

		boolean socioEncontrado = cClub.containsKey(dni);
		String resultado;

		if (socioEncontrado) {
			resultado = cClub.get(dni).toString();
		} else {
			resultado = "No se ha encontrado el Socio con DNI: " + dni;
		}

		return resultado;
	}

}
