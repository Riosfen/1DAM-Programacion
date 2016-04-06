package org.monroy.Clases;

public class Clerigo extends Personaje{
	
	private static final int INTELIGENCIA_MAXIMA = 16;
	private static final int INTELIGENCIA_MINIMA = 12;
	private static final int FUERZA_MINIMA = 18;
	private String dios;
	
	public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int vidaMaxima, String dios) throws PersonajeException {
		super(nombre, raza, fuerza, inteligencia, vidaMaxima);

		this.dios = dios.toUpperCase();
		setFuerza(fuerza);
		setInteligencia(inteligencia);
		
	}
	
	public void setFuerza(int fuerza) throws PersonajeException {

		if (fuerza < FUERZA_MINIMA)
			throw new PersonajeException("Error!! los puntos de fuerza tienen que estar entre " + FUERZA_MINIMA + " y 20.");

		super.setFuerza(fuerza);

	}

	public void setInteligencia(int inteligencia) throws PersonajeException {

		if (inteligencia < INTELIGENCIA_MINIMA || inteligencia > INTELIGENCIA_MAXIMA)
			throw new PersonajeException("Error!! los puntos de inteligencia tienen que estar entre " + INTELIGENCIA_MINIMA + " y " + INTELIGENCIA_MAXIMA + ".");

		super.setInteligencia(inteligencia);

	}
	
	public void curar(Personaje personaje){
		
		if (personaje.getVidaActual()+10 > personaje.getVidaMaxima()){
			personaje.setVidaActual(personaje.getVidaMaxima());
		}
		
		personaje.setVidaActual(personaje.getVidaActual()+10);
		
	}
	
	public String toString(){
		return super.toString() + "\n Dios: " + this.dios;
	}

}
