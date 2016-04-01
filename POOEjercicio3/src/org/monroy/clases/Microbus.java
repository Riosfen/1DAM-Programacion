package org.monroy.clases;

public class Microbus extends Vehiculo {

	private static final double ANIADIDO = 5;
	
	private int numPlaza;
	
	public Microbus (String matricula, GamaVehiculo gamaVehiculo, int numPlaza){
		super(gamaVehiculo, matricula);
		this.numPlaza = numPlaza;
		//TODO Formatear matricula si me regañan.
		
	}
	
public double calcularPrecio() {
		
		double importePlaza = numPlaza * ANIADIDO;
		
		return this.precioBase + importePlaza;
	}

}
