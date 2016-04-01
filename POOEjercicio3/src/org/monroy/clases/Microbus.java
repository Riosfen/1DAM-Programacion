package org.monroy.clases;

public class Microbus extends Vehiculo {

	private static final double ANIADIDO = 5;
	
	private int numPlaza;
	
	public Microbus (String matricula, GamaVehiculo gamaVehiculo, TipoCombustible tipoCombustible, int numPlaza){
		super(gamaVehiculo, tipoCombustible);
		this.numPlaza = numPlaza;
		this.matricula = matricula;
		//TODO Formatear matricula si me regañan.
		
	}
	
public double calcularPrecio() {
		
		double importePlaza = numPlaza * ANIADIDO;
		
		return this.precioBase + this.combustible + importePlaza;
	}

}
