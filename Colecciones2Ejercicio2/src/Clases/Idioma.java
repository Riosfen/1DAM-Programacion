package Clases;

import java.util.Iterator;
import java.util.LinkedList;

public class Idioma {

	private String idioma;
	private LinkedList<Palabra> palabra;

	public Idioma(String idioma) {
		this.idioma = idioma;
		palabra = new LinkedList<Palabra>();
	}
	
	public String getIdioma() {
		return idioma;
	}

	public void introducirPalabra(Palabra nuevaPalabra) {
		
		int pos = buscarSuSitio(nuevaPalabra);
		palabra.add(pos, nuevaPalabra);
	}

	private int buscarSuSitio(Palabra nuevaPalabra) {

		boolean posicionEncontrada = false;
		int pos = 0;
		Iterator<Palabra> itr = palabra.iterator();
		Palabra otro;

		while (itr.hasNext() && posicionEncontrada == false) {
			otro = itr.next();

			if (nuevaPalabra.compareTo(otro) < 0)
				posicionEncontrada = true;
			else
				pos++;
		}

		return pos;
	}

	public String listadoPalabras() {

		StringBuilder resul = new StringBuilder("Idioma: " + idioma + "\n");

		for (Palabra o : palabra) {
			if (o != null)
				resul.append(o + "\n");
		}

		return resul.toString();

	}

	public boolean eliminarPalabra(String eliminarPalabra) {

		Iterator<Palabra> itr = palabra.iterator();
		Palabra otro;

		boolean resul = false;

		while (itr.hasNext() && resul == false) {
			otro = itr.next();

			if (eliminarPalabra.equals(otro.getNativa())) {
				palabra.remove(otro);
				resul = true;
			}

		}
		return resul;
	}

	public boolean consultarPalabra(String consulPalabra) {

		Iterator<Palabra> itr = palabra.iterator();
		boolean palabraEncontrada = false;
		Palabra otra;

		while (itr.hasNext() && palabraEncontrada == false) {
			otra = itr.next();

			if (otra.getNativa().equals(consulPalabra))
				palabraEncontrada = true;
		}

		return palabraEncontrada;
	}

	public boolean modificarTraduccion(Palabra nuevaPalabra) throws DiccionarioException {

		Iterator<Palabra> itr = palabra.iterator();
		Palabra otro;

		boolean resul = false;

		while (itr.hasNext() && resul == false) {
			otro = itr.next();

			if (otro.equals(nuevaPalabra)) {
				palabra.set(palabra.indexOf(otro), nuevaPalabra);
				resul = true;
			}

		}
		
		if (resul == false)
			throw new DiccionarioException("Error!! esa palabra no existe");
			
		return true;
	}
	
	public boolean equals(Idioma otro) {

		boolean resul = false;

		if (idioma.equals(otro.idioma)){
			resul = true;
		}

		return resul;
	}

}
