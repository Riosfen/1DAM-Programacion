package org.monroy.Clases;

public class ArrayPersonaje {

	private static final int MAX_PERSONAJE = 100;

	private Personaje[] vPersonaje;

	public ArrayPersonaje() {
		vPersonaje = new Personaje[MAX_PERSONAJE];
	}

	public void aprenderMagia(String nombre, String magia) throws PersonajeException {
		
		int posicion = estaRepetido(nombre);
		
		if (posicion == -1)
			throw new PersonajeException("Error! ese personaje no existe.");
			
		if (vPersonaje[posicion] instanceof Mago){
			Mago m = (Mago) vPersonaje[posicion];
			m.aprendeHechizo(magia);
		}
			
	}

	public void altaPersonaje(Personaje otro) throws PersonajeException {

		int contador = 0;
		int posicion = -1;

		if (estaRepetido(otro.getNombre()) != -1)
			throw new PersonajeException("Error! ese personaje ya existe.");

		while (contador < vPersonaje.length && posicion == -1) {

			if (vPersonaje[contador] == null) {
				posicion = contador;
			}

			contador++;
		}
		if (posicion == -1)
			throw new PersonajeException("Error! ese personaje ya existe.");

		vPersonaje[posicion] = otro;

	}

	private int estaRepetido(String otro) {

		int contador = 0;
		int posicion = -1;

		while (contador < vPersonaje.length && posicion == -1) {
			if (vPersonaje[contador] != null) {
				if (vPersonaje[contador].getNombre().equals(otro))
					posicion = contador;
			}
			contador++;
		}
		
		return posicion;
	}

	public String toString() {

		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < vPersonaje.length; i++) {
			if (vPersonaje[i] != null)
				resultado.append(vPersonaje[i] + "\n");
		}

		return resultado.toString();
	}

}
