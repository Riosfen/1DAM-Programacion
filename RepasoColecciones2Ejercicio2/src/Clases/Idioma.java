package Clases;

import java.util.Iterator;
import java.util.LinkedList;

public class Idioma {

	private String idioma;
	public LinkedList<Palabra> palabras;

	public Idioma(String idioma) {
		this.idioma = idioma.toUpperCase();
		palabras = new LinkedList<Palabra>();
	}

	public String getIdioma() {
		return idioma;
	}

	public void modificarTraduccion(String palabra, String traduccion) throws DiccionarioExcepion {
		boolean modificada = false;
		Iterator<Palabra> itr = palabras.iterator();
		Palabra otra;
		palabra = palabra.toUpperCase();
		traduccion = traduccion.toUpperCase();

		while (itr.hasNext() && modificada == false) {
			otra = itr.next();
			if (otra.getPalabra().equals(palabra)) {
				otra.setTraduccion(traduccion);
				modificada = true;
			}
		}
		if (modificada == false)
			throw new DiccionarioExcepion("Error, no se ha encontrado la palabra " + palabra);
	}

	public void introducirPalabra(Palabra palabra) throws DiccionarioExcepion {

		int resul;

		if (palabras.contains(palabra))
			throw new DiccionarioExcepion("Error, esa palabra ya está en el diccionario.");

		resul = buscarPosicion(palabra);
		palabras.add(resul, palabra);
	}

	private int buscarPosicion(Palabra palabra) {
		int resul = 0;
		boolean encontrado = false;
		Iterator<Palabra> itr = palabras.iterator();
		Palabra otra;

		while (itr.hasNext() && encontrado == false) {
			otra = itr.next();
			if (otra.compareTo(palabra) > 0) {
				encontrado = true;
			} else {
				resul++;
			}
		}

		return resul;
	}

	public void eliminarPalabra(Palabra otra) throws DiccionarioExcepion {
		if (!palabras.contains(otra))
			throw new DiccionarioExcepion("Error, esa palabra no existe");
		palabras.remove(otra);
	}

	public boolean equals(Idioma otro) {
		boolean resul = false;

		if (idioma.equals(otro.idioma))
			resul = true;

		return resul;
	}

	public String toString() {
		return idioma;
	}

	public String listarPalabras() {
		StringBuilder resul = new StringBuilder();

		resul.append(idioma.toUpperCase() + " - ESPAÑOL\n");
		for (Palabra palabra : palabras) {
			resul.append(palabra + "\n");
		}
		return resul.toString();
	}

}
