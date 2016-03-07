package Ejercicio10_11Arrays;

public class Club {

	private Socio[] listaSocio;
	private static int contSocio;

	public Club(int numSocio) throws ClubException, SocioException {
		if (numSocio < 2)
			throw new ClubException("Error, el minimo de socios tiene que ser mayor a 1.");
		listaSocio = new Socio[numSocio];
		contSocio = 0;
	}

	public void altaSocio(Socio socio) throws ClubException {

		boolean encontrado = false;

		if (buscarSocioPorDni(socio.getDni()) != null) {
			throw new ClubException("Error, este usuario ya está dado de alta.");
		}

		if (contSocio > listaSocio.length - 1) {
			throw new ClubException("Error, lista de socios llena.");
		}

		int i = 0;
		while (i < contSocio && encontrado == false) {
			if (listaSocio[i] == null) {
				listaSocio[i] = socio;
				socio.setNumSocio(i + 1);
				encontrado = true;
			}
			i++;
		}

		if (encontrado == false) {
			listaSocio[contSocio] = socio;
			contSocio++;
			socio.setNumSocio(contSocio);
		}

	}

	public void bajaSocio(int pos) throws ClubException {

		int posReal = pos - 1;

		if (listaSocio[posReal] == null && listaSocio.length - 1 < posReal) {
			throw new ClubException("Error, no existe un socio con ese numero asignado.");
		}

		listaSocio[posReal] = null;

	}

	public Socio buscarSocioPorDni(String dni) {

		int contador = 0;
		Socio socioEncontrado = null;

		while (contador < contSocio) {
			if (listaSocio[contador] != null && !listaSocio[contador].getDni().equals(dni)) {
				socioEncontrado = listaSocio[contador];
			}
			contador++;
		}
		return socioEncontrado;
	}

	public String listadoPorCodigo() {

		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < contSocio; i++) {
			if (listaSocio[i] != null) {
				resultado.append(listaSocio[i] + "\n");
			}
		}
		return resultado.toString();
	}

	public String listadoPorNombre() {

		StringBuilder resultado = new StringBuilder();
		Socio[] listaOrdenada = new Socio[contSocio];
		Socio aux;
		
		for (int i = 0; i < listaOrdenada.length; i++) {
			for (int j = 0; j < listaOrdenada.length; j++) {
				if(listaSocio[j] != null){
					listaOrdenada[i] = listaSocio[j];
				}
			}
		}

		for (int i = 0; i < listaOrdenada.length -1; i++) {
			for (int j = listaOrdenada.length -1; j > i+1; j--) {
				if (listaOrdenada[i] != null) {
					if(listaOrdenada[j].getNombre().compareTo(listaOrdenada[j-1].getNombre()) < 0){
						aux = listaOrdenada[j]; 
						listaOrdenada[j] = listaOrdenada[j-1]; 
						listaOrdenada[j-1] = aux;
					}
				}
			}
		}
		
		for (int i = 0; i < listaOrdenada.length; i++) {
			if (listaOrdenada[i] != null){
				resultado.append(listaSocio[i] + "\n");
			}
		}
		
		return resultado.toString();
	}

}
