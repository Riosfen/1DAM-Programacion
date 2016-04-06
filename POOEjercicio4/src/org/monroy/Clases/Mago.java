package org.monroy.Clases;

public class Mago extends Personaje {

	private static final int INTELIGENCIA_MINIMA = 17;

	private static final int FUERZA_MAXIMA = 15;

	private static final int MAXIMO_HECHIZO = 4;

	private String[] hechizoMemorizado;

	public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int vidaMaxima) throws PersonajeException {

		super(nombre, raza, fuerza, inteligencia, vidaMaxima);

		setFuerza(fuerza);
		setInteligencia(inteligencia);
		hechizoMemorizado = new String[MAXIMO_HECHIZO];

	}

	public void setFuerza(int fuerza) throws PersonajeException {

		if (fuerza > FUERZA_MAXIMA)
			throw new PersonajeException("Error!! los puntos de fuerza tienen que estar entre 0 y 15.");

		super.setFuerza(fuerza);

	}

	public void setInteligencia(int inteligencia) throws PersonajeException {

		if (inteligencia < INTELIGENCIA_MINIMA)
			throw new PersonajeException("Error!! los puntos de inteligencia tienen que estar entre 17 y 20.");

		super.setInteligencia(inteligencia);

	}

	public boolean aprendeHechizo(String hechizo) throws PersonajeException {

		boolean aprendido = false;
		int contador = 0;

		while (contador < hechizoMemorizado.length && aprendido == false) {
			if (hechizoMemorizado[contador] == null) {
				hechizoMemorizado[contador] = hechizo.toUpperCase();
				aprendido = true;
			}
			contador++;
		}
		
		if (aprendido == false)
			throw new PersonajeException("Error! no hay hueco");

		return aprendido;

	}

	public boolean lanzaHechizo(Personaje personaje, String hechizo) {

		hechizo = hechizo.toUpperCase();
		boolean hechizoLanzado = false;
		int contador = 0;

		while (contador < hechizoMemorizado.length && hechizoLanzado == false) {

			if (hechizoMemorizado[contador] != null) {
				if (hechizoMemorizado[contador].equals(hechizo)) {
					personaje.setVidaActual(personaje.getVidaActual()-10);
					hechizoMemorizado[contador] = null;
					hechizoLanzado = true;
				}
			}

			contador++;
		}

		return hechizoLanzado;
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		
		for (int i = 0; i < hechizoMemorizado.length; i++) {
			if (hechizoMemorizado[i] != null){
				resultado.append(hechizoMemorizado[i]);
				if (i != hechizoMemorizado.length-1){
					resultado.append(", ");
				}
			}
		}
		
		if(resultado.toString().equals("")){
			resultado.append("No tengo hechizos  para lanzar (T.T)");
		}
		
		return super.toString() + "\nHechizos: " + resultado;
	}

}
