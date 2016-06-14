package Clases;

import java.util.Iterator;
import java.util.LinkedList;

public class Agenda {

	public LinkedList<Amigo> cAmigo;

	public Agenda() {
		cAmigo = new LinkedList<Amigo>();
	}

	public void aniadirAmigo(Amigo amigoNuevo) throws AmigoException {

		int posicion = encontrarPosicion(amigoNuevo);

		if (cAmigo.contains(amigoNuevo))
			throw new AmigoException("Error, ese amigo ya existe");

		cAmigo.add(posicion, amigoNuevo);

	}

	private int encontrarPosicion(Amigo amigoNuevo) {

		boolean encontrado = false;
		int resul = 0;

		Iterator<Amigo> itr = cAmigo.iterator();
		Amigo otro;

		if (cAmigo.isEmpty()) {
			encontrado = true;
		} else {
			while (itr.hasNext() && encontrado == false) {
				otro = itr.next();

				if (otro.compareTo(amigoNuevo) > 0) {
					encontrado = true;
				} else {
					resul++;
				}

			}
		}

		return resul;
	}

	public void eliminarCumple(Amigo otro) {

		if (cAmigo.contains(otro)) {
			cAmigo.remove(cAmigo.indexOf(otro));
		}

	}

	public void cambiarCumpleaño(String nombre) {

	}

}
