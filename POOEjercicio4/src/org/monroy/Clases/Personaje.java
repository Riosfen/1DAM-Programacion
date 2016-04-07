package org.monroy.Clases;

public abstract class Personaje {
	
	private String nombre;
	private Raza raza;
	private int fuerza;
	private int inteligencia;
	private int vidaMaxima;
	private int vidaActual;
	
	public Personaje(String nombre, Raza raza, int fuerza, 
			int inteligencia, int vidaMaxima) throws PersonajeException {
		
		setNombre(nombre);
		this.raza = raza;
		setFuerza(fuerza);
		setInteligencia(inteligencia);
		setVidaMaxima(vidaMaxima);
		this.vidaActual = vidaMaxima;
		
	}

	private void setVidaMaxima(int vidaMaxima) throws PersonajeException {
		if (vidaMaxima < 0 || vidaMaxima > 100)
			throw new PersonajeException("Error!! los puntos de vida tienen que estar entre 0 y 100.");
		
		this.vidaMaxima = vidaMaxima;
	}
	
	public int getVidaMaxima(){
		return vidaMaxima;
	}
	
	public void setFuerza(int fuerza) throws PersonajeException {
		if (fuerza < 0 || fuerza > 20)
			throw new PersonajeException("Error!! los puntos de fuerza tienen que estar entre 0 y 20.");
		
		this.fuerza = fuerza;
	}
	
	public int getFuerza(){
		return fuerza;
	}
	
	public void setInteligencia(int inteligencia) throws PersonajeException {
		if (inteligencia < 0 || inteligencia > 20)
			throw new PersonajeException("Error!! los puntos de inteligencia tienen que estar entre 0 y 20.");
		
		this.inteligencia = inteligencia;
	}
	
	public int getInteligencia(){
		return inteligencia;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setRaza(Raza raza){
		this.raza = raza;
	}
	
	public Raza getRaza(){
		return raza;
	}
	
	public void setVidaActual(int vidaSumar){
		this.vidaActual = vidaSumar;
	}
	
	public int getVidaActual(){
		return this.vidaActual;
	}
	
	public String toString(){
		return "Nombre: " + nombre + ", Raza: " + raza + ", Fuerza: " + fuerza +
				", Inteligencia: " + inteligencia + ", Vida: " + vidaActual +
				"/" + vidaMaxima;
	}
	
	public boolean equals(Personaje personaje){
		
		boolean iguales = false;
		
		if (nombre.equals(personaje.nombre)){
			iguales = true;
		}
		return iguales;
	}

}
