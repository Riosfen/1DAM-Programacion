package Clases;

import java.util.HashMap;

public class Club {

	private HashMap<String, Socio> cClub;

	public Club() {
		cClub = new HashMap<>();
	}

	public boolean altaSocio(Socio socioNuevo) {

		boolean resultado = cClub.containsKey(socioNuevo.getDni());

		if (resultado)
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
		String resultado = null;
		
		if(socioEncontrado)
			resultado = cClub.get(dni).toString();
		
		return resultado;
	}

}
